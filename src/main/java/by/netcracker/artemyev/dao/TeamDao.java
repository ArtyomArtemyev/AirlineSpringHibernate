package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDao extends GenericDao<Team>{

    @Override
    public Team getById(int id) {
        return getEntityManager().find(Team.class, id);
    }

    @Override
    public List<Team> getAll() {
        List<Team> teamList = getEntityManager().createQuery(Statement.GET_ALL_TEAMS).getResultList();
        return teamList;
    }

}
