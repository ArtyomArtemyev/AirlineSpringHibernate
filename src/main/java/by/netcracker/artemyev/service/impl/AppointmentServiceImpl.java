package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.dao.AppointmentDao;
import by.netcracker.artemyev.entity.impl.Appointment;
import by.netcracker.artemyev.service.AppointmentService;
import by.netcracker.artemyev.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @autor Artemyev Artoym
 */
@Service
public class AppointmentServiceImpl extends GenericService<Appointment> implements AppointmentService {

    @Autowired
    private AppointmentDao appointmentDao;

}
