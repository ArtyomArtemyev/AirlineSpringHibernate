package by.netcracker.artemyev.dao.impl;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.constant.Statement;
import by.netcracker.artemyev.dao.AirplaneDao;
import by.netcracker.artemyev.dao.GenericDao;
import by.netcracker.artemyev.entity.impl.Airplane;
import by.netcracker.artemyev.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class describes dao for airplane
 *
 * @autor Artemyev Artoym
 */
@Repository
public class AirplaneDaoImpl extends GenericDao<Airplane> implements AirplaneDao {
    private static Logger logger = LogManager.getLogger(FlightDaoImpl.class);

    private AirplaneDaoImpl() {
        super(Airplane.class);
    }

    @Override
    public List<Airplane> getAll() throws DaoException {
        List<Airplane> airplaneList;
        try {
            airplaneList = getEntityManager().createQuery(Statement.GET_ALL_AIRPLANES).getResultList();
        } catch (HibernateException e) {
            logger.debug(e);
            throw new DaoException(ErrorMessage.GET_ALL_ENTITY_FAIL, e);
        }
        return airplaneList;
    }

}
