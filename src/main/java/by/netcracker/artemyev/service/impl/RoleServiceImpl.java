package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.dao.RoleDao;
import by.netcracker.artemyev.entity.impl.Role;
import by.netcracker.artemyev.service.GenericService;
import by.netcracker.artemyev.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends GenericService<Role> implements RoleService {

    @Autowired
    private RoleDao roleDao;

}
