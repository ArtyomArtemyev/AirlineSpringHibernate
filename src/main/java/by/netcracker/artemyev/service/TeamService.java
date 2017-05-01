package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.TeamDao;
import by.netcracker.artemyev.entity.Team;
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
    public void add(Team object) {
        teamDao.add(object);
    }

    @Transactional
    @Override
    public void update(Team object) {
        teamDao.update(object);
    }

    @Transactional
    @Override
    public void remove(Team object) {
        teamDao.update(object);
    }

    @Transactional(readOnly = true)
    @Override
    public Team getById(int id) {
        return teamDao.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Team> getAll() {
        return teamDao.getAll();
    }

}
