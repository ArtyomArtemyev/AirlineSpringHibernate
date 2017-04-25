package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Appointment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AppointmentDao implements GeneralDao<Appointment> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Appointment object) {
        entityManager.persist(object);
    }

    @Override
    public void update(Appointment object) { entityManager.merge(object); }

    @Override
    public void remove(Appointment object) { entityManager.remove(object); }

    @Override
    public Appointment getById(int id) {
        return entityManager.find(Appointment.class, id);
    }

    @Override
    public List<Appointment> getAll() {
        List<Appointment> appointmentList = entityManager.createQuery(Statement.GET_ALL_APPOINTMENTS).getResultList();
        return appointmentList;
    }

}
