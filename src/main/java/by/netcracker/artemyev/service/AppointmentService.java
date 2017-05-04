package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.AppointmentDao;
import by.netcracker.artemyev.entity.Appointment;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("appointmentService")
public class AppointmentService implements GeneralService<Appointment> {

    @Autowired
    private AppointmentDao appointmentDao;

    @Transactional
    @Override
    public void add(Appointment object) throws ServiceException {
        try {
            appointmentDao.add(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void update(Appointment object) throws ServiceException {
        try {
        appointmentDao.update(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void remove(Appointment object) throws ServiceException {
        try {
            appointmentDao.remove(object);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Appointment getById(int id) throws ServiceException {
        try {
            return appointmentDao.getById(id);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Appointment> getAll() throws ServiceException {
        try {
            return appointmentDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
