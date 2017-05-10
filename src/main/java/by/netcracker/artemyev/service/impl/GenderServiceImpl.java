package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.dao.GenderDao;
import by.netcracker.artemyev.entity.impl.Gender;
import by.netcracker.artemyev.service.GenderService;
import by.netcracker.artemyev.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl extends GenericService<Gender> implements GenderService {

    @Autowired
    private GenderDao genderDao;

}
