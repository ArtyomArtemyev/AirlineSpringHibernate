package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.RoleDao;
import by.netcracker.artemyev.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
public class RoleService implements GeneralService<Role>{

    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public void add(Role object) {
        roleDao.add(object);
    }

    @Transactional
    @Override
    public void update(Role object) {
        roleDao.update(object);
    }

    @Transactional
    @Override
    public void remove(Role object) {
        roleDao.remove(object);
    }

    @Transactional(readOnly = true)
    @Override
    public Role getById(int id) {
        return roleDao.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> getAll() {
        return roleDao.getAll();
    }

}
