package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.dao.OrderDao;
import by.netcracker.artemyev.entity.impl.Flight;
import by.netcracker.artemyev.entity.impl.Order;
import by.netcracker.artemyev.entity.impl.User;
import by.netcracker.artemyev.exception.DaoException;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class describes concrete implementation of the OrderService
 *
 * @autor Artemyev Artoym
 */
@Service
public class OrderServiceImpl extends GenericService<Order> implements OrderService {
    private static Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private FlightService flightService;

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    /**
     * Creates new order
     *
     * @param idFlight - selected flight
     * @param idUser - user id
     * @param name - entered user name
     * @param surname - entered user surname
     * @param phone - entered user phone
     * @param mail - entered user email
     * @throws ServiceException - if something fails at service layer
     */
    @Transactional
    @Override
    public void createOrder(Long idFlight, Long idUser, String name, String surname, String phone, String mail) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_CREATE_ORDER);
        Flight flight = flightService.getById(idFlight);
        User user = userService.getById(idUser);
        Order order = orderBuilder(flight, user, name, surname, phone, mail);
        try {
            orderDao.add(order);
        }  catch (DaoException e) {
            logger.error(e);
            throw new ServiceException(e.getMessage());
        }
        mailService.sendNotificationAboutFlight(name, surname, mail, flight.getNavigation());
    }

    /**
     * Creates order object
     *
     * @param flight - selected flight
     * @param user - user
     * @param name - entered user name
     * @param surname - entered user surname
     * @param phone - entered user phone
     * @param mail - entered user email
     */
    private Order orderBuilder(Flight flight, User user, String name, String surname, String phone, String mail) {
        logger.debug(LoggingName.SERVICE_FUNCTION_CREATE_OBJECT_ORDER);
        Order order = new Order();
        order.setFlight(flight);
        order.setUser(user);
        order.setName(name);
        order.setSurname(surname);
        order.setMail(mail);
        order.setPhone(phone);
        return order;
    }

}
