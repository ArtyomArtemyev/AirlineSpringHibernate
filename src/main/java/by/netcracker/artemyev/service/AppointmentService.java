package by.netcracker.artemyev.service;


import by.netcracker.artemyev.entity.Appointment;
import by.netcracker.artemyev.exception.ServiceException;

import java.util.List;

public interface AppointmentService extends GeneralService<Appointment> {
    void add(Appointment object) throws ServiceException;
    void update(Appointment object) throws ServiceException;
    void remove(Appointment object) throws ServiceException;
    Appointment getById(int id) throws ServiceException;
    List<Appointment> getAll() throws ServiceException;
}
