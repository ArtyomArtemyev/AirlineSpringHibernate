package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.ErrorMessage;
import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Flight;
import by.netcracker.artemyev.exception.DaoException;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightDao extends GenericDao<Flight> {

    @Override
    public Flight getById(int id) {
        try {
            return getEntityManager().find(Flight.class, id);
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.MESSAGE_GET_BY_ID_ENTITY_FAIL, e);
        }
    }

    @Override
    public List<Flight> getAll() {
        List<Flight> flightList;
        try {
            flightList = getEntityManager().createQuery(Statement.GET_ALL_FLIGHTS).getResultList();
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.MESSAGE_GET_ALL_ENTITY_FAIL, e);
        }
        return flightList;
    }

}
