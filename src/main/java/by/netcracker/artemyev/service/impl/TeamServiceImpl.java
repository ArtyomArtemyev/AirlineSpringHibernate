package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.dao.EmployeeDao;
import by.netcracker.artemyev.dao.TeamDao;
import by.netcracker.artemyev.dto.TeamDto;
import by.netcracker.artemyev.entity.impl.Employee;
import by.netcracker.artemyev.entity.impl.Flight;
import by.netcracker.artemyev.entity.impl.Team;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.FlightService;
import by.netcracker.artemyev.service.GenericService;
import by.netcracker.artemyev.service.TeamService;
import by.netcracker.artemyev.util.Converter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Class describes concrete implementation of the TeamService
 *
 * @autor Artemyev Artoym
 */
@Service
public class TeamServiceImpl extends GenericService<Team> implements TeamService {
    private static Logger logger = LogManager.getLogger(TeamServiceImpl.class);

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private FlightService flightService;

    /**
     * Creates new team
     *
     * @param listId - list with employees id
     * @throws ServiceException - if something fails at service layer
     */
    @Transactional
    @Override
    public void createTeam(List<Long> listId) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_CREATE_TEAM);
        Team team = new Team(Converter.convertToLine(listId));
        try {
            this.teamDao.add(team);
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * Returns dto team
     *
     * @return - list with dto team
     * @throws ServiceException - if something fails at service layer
     */
    @Transactional
    @Override
    public List<TeamDto> getTeamDto() throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_GET_TEAM_DTO);
        List<TeamDto> teamDtoList = new ArrayList<>();
        try {
            List<Team> listTeam = teamDao.getAll();
            for (int i = 0; i < listTeam.size(); i++) {
                TeamDto teamDto = new TeamDto();
                teamDto.setIdTeam(listTeam.get(i).getId());
                List<Long> idEmployee = Converter.convertToList(listTeam.get(i).getIdMembers());
                List<Employee> listEmployee = new ArrayList<>();
                for (int j = 0; j < idEmployee.size(); j++) {
                    Employee employee = employeeDao.getById(idEmployee.get(j));
                    listEmployee.add(employee);
                }
                teamDto.setTeamMembers(listEmployee);
                teamDtoList.add(teamDto);
            }
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(e.getMessage());
        }
        return teamDtoList;
    }

    /**
     * Deletes team
     *
     * @param id - id team for deleting
     * @throws ServiceException - if something fails at service layer
     */
    @Transactional
    @Override
    public void deleteTeam(Long id) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_DELETE_TEAM);
        Team team = this.getById(id);
        this.remove(team);
    }

    /**
     * Checks appointing team to flight
     *
     * @param id - id team for checking
     * @return - result of checking
     * @throws ServiceException  - if something fails at service layer
     */
    @Override
    public boolean checkAppointingTeamToFlight(Long id) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_CHECK_APPOINT_TEAM);
        boolean isAppoint = false;
        try {
            List<Flight> flightList = flightService.getAll();
            isAppoint = findTeamId(flightList, id);
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(e.getMessage());
        }
        return isAppoint;
    }

    /**
     * Checks appointing team to flight
     *
     * @param idFlight - id flight for appointing team
     * @param teamId - list with team id
     * @throws ServiceException - if something fails at service layer
     */
    @Transactional
    @Override
    public void appointTeamToFlight(Long idFlight, List<Long> teamId) throws ServiceException {
        try {
            List<Team> teamList = teamDao.getAll();
            Long idTeam = 0L;
            for (int i = 0; i < teamList.size(); i++) {
                List<Long> checkList = Converter.convertToList(teamList.get(i).getIdMembers());
                if (teamId.containsAll(checkList)) {
                    idTeam = teamList.get(i).getId();
                    break;
                }
            }
            flightService.appointTeam(idFlight, idTeam);
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(e.getMessage());
        }
    }

    private boolean findTeamId(List<Flight> flightList, Long id) {
        logger.debug(LoggingName.SERVICE_FUNCTION_FIND_TEAM_IN_FLIGHTS);
        boolean isFind = false;
        for(int i = 0; i< flightList.size(); i++) {
            if(flightList.get(i).getTeam() != null) {
                if(flightList.get(i).getTeam().getId() == id) {
                    isFind = true;
                    break;
                }
            }
        }
        return isFind;
    }

}
