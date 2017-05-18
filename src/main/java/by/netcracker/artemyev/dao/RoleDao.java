package by.netcracker.artemyev.dao;

import by.netcracker.artemyev.entity.impl.Role;

import java.util.List;

/**
 * @autor Artemyev Artoym
 */
public interface RoleDao extends GeneralDao<Role> {
    List<Role> getAll();
}
