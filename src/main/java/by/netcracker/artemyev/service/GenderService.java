package by.netcracker.artemyev.service;

import by.netcracker.artemyev.dao.GenderDao;
import by.netcracker.artemyev.entity.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderService extends GenericService<Gender> {

    @Autowired
    private GenderDao genderDao;

}
