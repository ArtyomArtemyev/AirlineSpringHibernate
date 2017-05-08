package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.RoleDao;
import by.netcracker.artemyev.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends GenericService<Role> {

    @Autowired
    private RoleDao roleDao;

}
