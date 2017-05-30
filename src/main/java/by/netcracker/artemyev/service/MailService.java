package by.netcracker.artemyev.service;

import by.netcracker.artemyev.exception.ServiceException;

/**
 * @autor Artemyev Artoym
 */
public interface MailService {
    void sendMail(String mailUser) throws ServiceException;
    void sendNotification(String name, String surname, String email, String navigationFlight) throws ServiceException;
}
