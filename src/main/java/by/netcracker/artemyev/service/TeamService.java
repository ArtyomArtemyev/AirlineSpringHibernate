package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dto.TeamDto;
import by.netcracker.artemyev.entity.impl.Team;
import by.netcracker.artemyev.exception.ServiceException;

import java.util.List;

/**
 * @autor Artemyev Artoym
 */
public interface TeamService extends GeneralService<Team> {
    void createTeam(List<Long> lisId) throws ServiceException;
    List<TeamDto> getTeamDto() throws ServiceException;
    void deleteTeam(Long id) throws ServiceException;
    boolean checkAppointingTeamToFlight(Long id) throws ServiceException;
    void appointTeamToFlight(Long idFlight,List<Long> teamId) throws ServiceException;
}
