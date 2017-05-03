package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Appointment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentDao extends GenericDao<Appointment> {

    @Override
    public Appointment getById(int id) {
        return getEntityManager().find(Appointment.class, id);
    }

    @Override
    public List<Appointment> getAll() {
        List<Appointment> appointmentList = getEntityManager().createQuery(Statement.GET_ALL_APPOINTMENTS).getResultList();
        return appointmentList;
    }

}
