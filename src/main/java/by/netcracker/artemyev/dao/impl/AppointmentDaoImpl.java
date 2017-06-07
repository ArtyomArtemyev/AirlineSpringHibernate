package by.netcracker.artemyev.dao.impl;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.constant.Statement;
import by.netcracker.artemyev.dao.AppointmentDao;
import by.netcracker.artemyev.dao.GenericDao;
import by.netcracker.artemyev.entity.impl.Appointment;
import by.netcracker.artemyev.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class describes concrete implementation of the AppointmentDao
 *
 * @autor Artemyev Artoym
 */
@Repository
public class AppointmentDaoImpl extends GenericDao<Appointment> implements AppointmentDao {
    private static Logger logger = LogManager.getLogger(AppointmentDaoImpl.class);

    private AppointmentDaoImpl() {
        super(Appointment.class);
    }

    /**
     * Returns all appointment from database
     *
     * @return list with appointments from database
     * @throws DaoException If something fails at database layer
     */
    @Override
    public List<Appointment> getAll() throws DaoException {
        logger.debug(LoggingName.DAO_FUNCTION_GET_ALL_APPOINTMENTS);
        List<Appointment> appointmentList;
        try {
            appointmentList = getEntityManager().createQuery(Statement.GET_ALL_APPOINTMENTS).getResultList();
        } catch (HibernateException e) {
            logger.debug(e);
            throw new DaoException(ErrorMessage.GET_ALL_ENTITY_FAIL, e);
        }
        return appointmentList;
    }

}
