package by.netcracker.artemyev.service.impl;


import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.dao.AirplaneDao;
import by.netcracker.artemyev.entity.impl.Airplane;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.AirplaneService;
import by.netcracker.artemyev.service.GenericService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class describes concrete implementation of the AirplaneService
 *
 * @autor Artemyev Artoym
 */
@Service
public class AirplaneServiceImpl extends GenericService<Airplane> implements AirplaneService {
    private static Logger logger = LogManager.getLogger(AirplaneServiceImpl.class);

    @Autowired
    private AirplaneDao airplaneDao;

    /**
     * Returns team for airplane from database
     *
     * @param idAirplane - id of the airplane from database
     * @return string with team
     * @throws ServiceException - if something fails at service layer
     */
    @Override
    public String getTypeTeam(Long idAirplane) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_GET_TYPE_TEAM);
        Airplane airplane;
        try {
           airplane = airplaneDao.getById(idAirplane);
        } catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(e.getMessage());
        }
        return airplane.getAirplaneTeam().getTeam();
    }

}
