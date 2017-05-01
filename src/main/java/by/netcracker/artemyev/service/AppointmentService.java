package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.AppointmentDao;
import by.netcracker.artemyev.entity.Appointment;
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
    public void add(Appointment object) {
        appointmentDao.add(object);
    }

    @Transactional
    @Override
    public void update(Appointment object) {
        appointmentDao.update(object);
    }

    @Transactional
    @Override
    public void remove(Appointment object) {
        appointmentDao.remove(object);
    }

    @Transactional(readOnly = true)
    @Override
    public Appointment getById(int id) {
        return appointmentDao.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Appointment> getAll() {
        return appointmentDao.getAll();
    }

}
