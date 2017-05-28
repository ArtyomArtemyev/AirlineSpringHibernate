package by.netcracker.artemyev.service.impl;


import by.netcracker.artemyev.dao.AirplaneDao;
import by.netcracker.artemyev.entity.impl.Airplane;
import by.netcracker.artemyev.service.AirplaneService;
import by.netcracker.artemyev.service.GenericService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class AirplaneServiceImpl extends GenericService<Airplane> implements AirplaneService {
    private static Logger logger = LogManager.getLogger(AirplaneServiceImpl.class.getName());

    @Autowired
    private AirplaneDao airplaneDao;
}
