package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.entity.Role;
import by.netcracker.artemyev.exception.DaoException;

public interface RoleDao extends GeneralDao<Role> {
    void add(Role object) throws DaoException;
    void update(Role object) throws DaoException;
    void remove(Role object) throws DaoException;
    Role getById(int id) throws DaoException;
}
