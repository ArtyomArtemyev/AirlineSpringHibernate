package by.netcracker.artemyev.dao.impl;

import by.netcracker.artemyev.constant.ErrorMessage;
import by.netcracker.artemyev.constant.Statement;
import by.netcracker.artemyev.dao.GenericDao;
import by.netcracker.artemyev.dao.OrderDao;
import by.netcracker.artemyev.entity.impl.Order;
import by.netcracker.artemyev.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class describes dao for order
 *
 * @autor Artemyev Artoym
 */
@Repository
public class OrderDaoImpl extends GenericDao<Order> implements OrderDao {
    private static Logger logger = LogManager.getLogger(OrderDaoImpl.class);

    private OrderDaoImpl() {
        super(Order.class);
    }

    @Override
    public List<Order> getAll() throws DaoException {
        List<Order> orderList;
        try {
            orderList = getEntityManager().createQuery(Statement.GET_ALL_ORDERS).getResultList();
        } catch (HibernateException e) {
            logger.debug(e);
            throw new DaoException(ErrorMessage.GET_ALL_ENTITY_FAIL, e);
        }
        return orderList;
    }
}
