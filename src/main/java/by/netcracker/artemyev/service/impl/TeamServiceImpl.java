package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.dao.EmployeeDao;
import by.netcracker.artemyev.dao.TeamDao;
import by.netcracker.artemyev.dto.TeamDto;
import by.netcracker.artemyev.entity.impl.Employee;
import by.netcracker.artemyev.entity.impl.Team;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
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
 * @autor Artemyev Artoym
 */
@Service
public class TeamServiceImpl extends GenericService<Team> implements TeamService {
    private static Logger logger = LogManager.getLogger(TeamServiceImpl.class);

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    @Override
    public void createTeam(List<Long> listId) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_CREATE_TEAM);
        Team team = new Team(Converter.convertToLine(listId));
        try {
            this.teamDao.add(team);
        } catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public List<TeamDto> getTeamDto() throws ServiceException {
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
            logger.debug(e);
            throw new ServiceException(e.getMessage());
        }
        return teamDtoList;
    }

}
