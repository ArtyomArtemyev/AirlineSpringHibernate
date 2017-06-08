package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.entity.impl.Role;
import by.netcracker.artemyev.exception.DaoException;

import java.util.List;

/**
 * Interface describes dao layer for entity Role
 *
 * @autor Artemyev Artoym
 */
public interface RoleDao extends GeneralDao<Role> {
    List<Role> getAll() throws DaoException;
}
