package by.netcracker.artemyev.service.impl;

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

@Service
public class OrderServiceImpl extends GenericService<Order> implements OrderService {
    private static Logger logger = LogManager.getLogger(OrderServiceImpl.class.getName());

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private FlightService flightService;

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @Transactional
    @Override
    public void createOrder(Long idFlight, Long idUser, String name, String surname, String phone, String mail) throws ServiceException {
        Flight flight = flightService.getById(idFlight);
        User user = userService.getById(idUser);
        Order order = new Order();
        order.setFlight(flight);
        order.setUser(user);
        order.setName(name);
        order.setSurname(surname);
        order.setMail(mail);
        order.setPhone(phone);
        try {
            orderDao.add(order);
        }  catch (DaoException e) {
            logger.debug(e);
            throw new ServiceException(e.getMessage());
        }
        mailService.sendNotification(name, surname, mail, flight.getNavigation());
    }

}
