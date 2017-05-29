package by.netcracker.artemyev.service;

import by.netcracker.artemyev.entity.impl.Order;
import by.netcracker.artemyev.exception.ServiceException;

import java.util.List;

public interface OrderService extends GeneralService<Order> {
    void add(Order object) throws ServiceException;
    void update(Order object) throws ServiceException;
    void remove(Order object) throws ServiceException;
    Order getById(Long id) throws ServiceException;
    List<Order> getAll() throws ServiceException;
}
