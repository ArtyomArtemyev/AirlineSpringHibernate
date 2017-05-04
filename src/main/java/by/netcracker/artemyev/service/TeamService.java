package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.TeamDao;
import by.netcracker.artemyev.entity.Team;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("teamService")
public class TeamService implements GeneralService<Team>{
    @Autowired
    private TeamDao teamDao;

    @Transactional
    @Override
    public void add(Team object) throws ServiceException {
        try {
            teamDao.add(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void update(Team object) throws ServiceException {
        try {
            teamDao.update(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void remove(Team object) throws ServiceException {
        try {
            teamDao.update(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Team getById(int id) throws ServiceException {
        try {
            return teamDao.getById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Team> getAll() throws ServiceException {
        try {
            return teamDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
