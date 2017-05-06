package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.ErrorMessage;
import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Flight;
import by.netcracker.artemyev.exception.DaoException;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class describes dao for Flight
 * @autor Artemyev Artoym
 */
@Repository
public class FlightDao extends GenericDao<Flight> {

    @Autowired
    private FlightDao() {
        super(Flight.class);
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
