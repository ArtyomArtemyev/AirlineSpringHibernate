package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.ErrorMessage;
import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Team;
import by.netcracker.artemyev.exception.DaoException;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDao extends GenericDao<Team>{

    @Autowired
    private TeamDao() {
        super(Team.class);
    }

    @Override
    public List<Team> getAll() {
        List<Team> teamList;
        try {
            teamList = getEntityManager().createQuery(Statement.GET_ALL_TEAMS).getResultList();
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.MESSAGE_GET_ALL_ENTITY_FAIL, e);
        }
        return teamList;
    }

}
