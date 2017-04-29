package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Flight;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FlightDao implements GeneralDao<Flight> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Flight object) {
        entityManager.persist(object);
    }

    @Override
    public void update(Flight object) {
        entityManager.merge(object);
    }

    @Override
    public void remove(Flight object) {
        entityManager.remove(object);
    }

    @Override
    public Flight getById(int id) {
        return entityManager.find(Flight.class, id);
    }

    @Override
    public List<Flight> getAll() {
        List<Flight> flightList = entityManager.createQuery(Statement.GET_ALL_FLIGHTS).getResultList();
        return flightList;
    }

}
