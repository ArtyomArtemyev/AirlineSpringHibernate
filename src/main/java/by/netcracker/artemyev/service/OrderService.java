package by.netcracker.artemyev.service;

import by.netcracker.artemyev.entity.impl.Order;
import by.netcracker.artemyev.exception.ServiceException;

public interface OrderService extends GeneralService<Order> {
    void createOrder(Long idFlight, Long idUser, String name, String surname, String phone, String mail) throws ServiceException;
}
