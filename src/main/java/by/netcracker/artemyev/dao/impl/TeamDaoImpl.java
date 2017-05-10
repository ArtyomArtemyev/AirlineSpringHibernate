package by.netcracker.artemyev.dao.impl;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.constant.Statement;
import by.netcracker.artemyev.dao.GenericDao;
import by.netcracker.artemyev.dao.TeamDao;
import by.netcracker.artemyev.entity.impl.Team;
import by.netcracker.artemyev.exception.DaoException;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class describes dao for Team
 * @autor Artemyev Artoym
 */
@Repository
public class TeamDaoImpl extends GenericDao<Team> implements TeamDao {

    private TeamDaoImpl() {
        super(Team.class);
    }

    @Override
    public List<Team> getAll() {
        List<Team> teamList;
        try {
            teamList = getEntityManager().createQuery(Statement.GET_ALL_TEAMS).getResultList();
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.GET_ALL_ENTITY_FAIL, e);
        }
        return teamList;
    }

}
