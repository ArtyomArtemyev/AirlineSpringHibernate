package by.netcracker.artemyev.dao;


import by.netcracker.artemyev.entity.impl.Appointment;
import by.netcracker.artemyev.exception.DaoException;

public interface AppointmentDao extends GeneralDao<Appointment> {
    void add(Appointment object) throws DaoException;
    void update(Appointment object) throws DaoException;
    void remove(Appointment object) throws DaoException;
    Appointment getById(int id) throws DaoException;
}
