package by.netcracker.artemyev.service;

import by.netcracker.artemyev.entity.impl.Role;
import by.netcracker.artemyev.exception.ServiceException;

import java.util.List;

public interface RoleService extends GeneralService<Role> {
    void add(Role object) throws ServiceException;
    void update(Role object) throws ServiceException;
    void remove(Role object) throws ServiceException;
    Role getById(int id) throws ServiceException;
    List<Role> getAll() throws ServiceException;
}
