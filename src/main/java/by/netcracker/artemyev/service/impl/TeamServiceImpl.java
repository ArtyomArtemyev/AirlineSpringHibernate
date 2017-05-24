package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.dao.TeamDao;
import by.netcracker.artemyev.entity.impl.Team;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.GenericService;
import by.netcracker.artemyev.service.TeamService;
import by.netcracker.artemyev.util.Converter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @autor Artemyev Artoym
 */
@Service
public class TeamServiceImpl extends GenericService<Team> implements TeamService {
    private static Logger logger = LogManager.getLogger(TeamServiceImpl.class);

    @Autowired
    private TeamDao teamDao;

    @Transactional
    @Override
    public void createTeam(List<Long> listId) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_CREATE_TEAM);
        Team team = new Team(Converter.convertToLine(listId));
        this.teamDao.add(team);
    }

}
