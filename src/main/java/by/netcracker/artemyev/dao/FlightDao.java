package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Flight;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlightDao extends GenericDao<Flight> {

    @Override
    public Flight getById(int id) {
        return getEntityManager().find(Flight.class, id);
    }

    @Override
    public List<Flight> getAll() {
        List<Flight> flightList = getEntityManager().createQuery(Statement.GET_ALL_FLIGHTS).getResultList();
        return flightList;
    }

}
