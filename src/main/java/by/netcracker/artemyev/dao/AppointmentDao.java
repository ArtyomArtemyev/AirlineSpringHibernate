package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.dao.constant.ErrorMessage;
import by.netcracker.artemyev.dao.constant.Statement;
import by.netcracker.artemyev.entity.Appointment;
import by.netcracker.artemyev.exception.DaoException;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentDao extends GenericDao<Appointment> {

    @Autowired
    private AppointmentDao() {
        super(Appointment.class);
    }

    @Override
    public List<Appointment> getAll() {
        List<Appointment> appointmentList;
        try {
            appointmentList = getEntityManager().createQuery(Statement.GET_ALL_APPOINTMENTS).getResultList();
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.MESSAGE_GET_ALL_ENTITY_FAIL, e);
        }
        return appointmentList;
    }

}
