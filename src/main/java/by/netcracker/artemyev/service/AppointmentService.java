package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.AppointmentDao;
import by.netcracker.artemyev.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService extends GenericService<Appointment> {

    @Autowired
    private AppointmentDao appointmentDao;

}
