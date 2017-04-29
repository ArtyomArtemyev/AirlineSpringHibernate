package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Team;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TeamDao implements GeneralDao<Team>{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Team object) {
        entityManager.persist(object);
    }

    @Override
    public void update(Team object) {
        entityManager.merge(object);
    }

    @Override
    public void remove(Team object) {
        entityManager.remove(object);
    }

    @Override
    public Team getById(int id) {
        return entityManager.find(Team.class, id);
    }

    @Override
    public List<Team> getAll() {
        List<Team> teamList = entityManager.createQuery(Statement.GET_ALL_TEAMS).getResultList();
        return teamList;
    }
}
