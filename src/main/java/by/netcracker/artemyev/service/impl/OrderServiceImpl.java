package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.dao.OrderDao;
import by.netcracker.artemyev.entity.impl.Order;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.GenericService;
import by.netcracker.artemyev.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends GenericService<Order> implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void createOrder(Long idFlight, Long idUser, String name, String surname, String phone, String mail) throws ServiceException {

    }

}
