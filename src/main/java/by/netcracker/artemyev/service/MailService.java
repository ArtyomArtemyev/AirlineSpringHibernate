package by.netcracker.artemyev.service;

import by.netcracker.artemyev.exception.ServiceException;

/**
 * @autor Artemyev Artoym
 */
public interface MailService {
    void sendMail(String mailUser) throws ServiceException;
}
