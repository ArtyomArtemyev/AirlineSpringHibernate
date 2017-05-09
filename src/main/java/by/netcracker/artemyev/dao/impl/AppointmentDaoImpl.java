package by.netcracker.artemyev.dao.impl;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.constant.Statement;
import by.netcracker.artemyev.dao.AppointmentDao;
import by.netcracker.artemyev.dao.GenericDao;
import by.netcracker.artemyev.entity.Appointment;
import by.netcracker.artemyev.exception.DaoException;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class describes dao for Appointment
 * @autor Artemyev Artoym
 */
@Repository
public class AppointmentDaoImpl extends GenericDao<Appointment> implements AppointmentDao {

    private AppointmentDaoImpl() {
        super(Appointment.class);
    }

    @Override
    public List<Appointment> getAll() {
        List<Appointment> appointmentList;
        try {
            appointmentList = getEntityManager().createQuery(Statement.GET_ALL_APPOINTMENTS).getResultList();
        } catch (HibernateException e) {
            throw new DaoException(ErrorMessage.GET_ALL_ENTITY_FAIL, e);
        }
        return appointmentList;
    }

}
