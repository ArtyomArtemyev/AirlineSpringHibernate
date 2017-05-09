package by.netcracker.artemyev.dao.impl;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.constant.Statement;
import by.netcracker.artemyev.dao.FlightDao;
import by.netcracker.artemyev.dao.GenericDao;
import by.netcracker.artemyev.entity.Flight;
import by.netcracker.artemyev.exception.DaoException;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class describes dao for Flight
 * @autor Artemyev Artoym
 */
@Repository
public class FlightDaoImpl extends GenericDao<Flight> implements FlightDao {

    private FlightDaoImpl() {
        super(Flight.class);
    }

    @Override
    public List<Flight> getAll() {
        List<Flight> flightList;
        try {
            flightList = getEntityManager().createQuery(Statement.GET_ALL_FLIGHTS).getResultList();
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.GET_ALL_ENTITY_FAIL, e);
        }
        return flightList;
    }

}
