package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dto.TeamDto;
import by.netcracker.artemyev.entity.impl.Team;
import by.netcracker.artemyev.exception.ServiceException;

import java.util.List;

/**
 * @autor Artemyev Artoym
 */
public interface TeamService extends GeneralService<Team> {
    void add(Team object) throws ServiceException;
    void update(Team object) throws ServiceException;
    void remove(Team object) throws ServiceException;
    Team getById(Long id) throws ServiceException;
    List<Team> getAll() throws ServiceException;
    void createTeam(List<Long> lisId) throws ServiceException;
    List<TeamDto> getTeamDto() throws ServiceException;
    void deleteTeam(Long id) throws ServiceException;
    boolean checkAppointingTeamToFlight(Long id) throws ServiceException;
}
