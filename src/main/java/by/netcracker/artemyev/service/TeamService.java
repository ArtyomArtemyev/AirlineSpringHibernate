package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.TeamDao;
import by.netcracker.artemyev.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teamService")
public class TeamService implements GeneralService<Team>{
    @Autowired
    private TeamDao teamDao;

    @Override
    public void add(Team object) {
        teamDao.add(object);
    }

    @Override
    public void update(Team object) {
        teamDao.update(object);
    }

    @Override
    public void remove(Team object) {
        teamDao.update(object);
    }

    @Override
    public Team getById(int id) {
        return teamDao.getById(id);
    }

    @Override
    public List<Team> getAll() {
        return teamDao.getAll();
    }
}
