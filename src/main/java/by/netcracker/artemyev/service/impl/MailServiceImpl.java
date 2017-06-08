package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.constant.LoggingName;
import by.netcracker.artemyev.exception.ServiceException;
import by.netcracker.artemyev.service.MailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Class describes concrete implementation of the MailService
 *
 * @autor Artemyev Artoym
 */
@Service
public class MailServiceImpl implements MailService {
    private static Logger logger = LogManager.getLogger(MailServiceImpl.class);
    private final String FROM = "artairline2017@gmail.com";
    private final String SUBJECT_REGISTRATION_IN_SYSTEM = "Registration in ArtAirline system";
    private final String SUBJECT_REGISTRATION_TO_FLIGHT = "Registration to flight";
    private final String MESSAGE = "Thank you for registration in our system. Now you can enter in system";

    @Autowired
    private MailSender mailSender;

    /**
     * Sends notification to user about successful registration in system
     *
     * @param userMail - mail for sending notification
     * @throws ServiceException - if something fails at service layer
     */
    @Override
    public void sendNotificationAboutRegistration(String userMail) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_SEND_MAIL);
        SimpleMailMessage templateMessage = new SimpleMailMessage();
        templateMessage.setFrom(FROM);
        templateMessage.setSubject(SUBJECT_REGISTRATION_IN_SYSTEM);
        SimpleMailMessage mailMessage = new SimpleMailMessage(templateMessage);
        mailMessage.setTo(userMail);
        mailMessage.setText(MESSAGE);
        try {
            mailSender.send(mailMessage);
        } catch (MailException e) {
            logger.error(e);
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * Sends notification to user about successful registration in system
     *
     * @param name - entered user name
     * @param surname - entered user surname
     * @param email - entered user email
     * @param navigationFlight - selected flight
     * @throws ServiceException - if something fails at service layer
     */
    @Override
    public void sendNotificationAboutFlight(String name, String surname, String email, String navigationFlight) throws ServiceException {
        SimpleMailMessage templateMessage = new SimpleMailMessage();
        templateMessage.setFrom(FROM);
        templateMessage.setSubject(SUBJECT_REGISTRATION_TO_FLIGHT);
        SimpleMailMessage mailMessage = new SimpleMailMessage(templateMessage);
        mailMessage.setTo(email);
        mailMessage.setText(String.valueOf(createNotification(name, surname, navigationFlight)));
        try {
            mailSender.send(mailMessage);
        } catch (MailException e) {
            logger.error(e);
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * Creates notification for user
     *
     * @param name - entered user name
     * @param surname - entered user surname
     * @param navigationFlight - selected flight
     */
    private StringBuffer createNotification(String name, String surname, String navigationFlight) {
        StringBuffer notification = new StringBuffer();
        notification.append("Dear, " + name + " "+ surname + ".\n");
        notification.append("You have applied for a flight " + navigationFlight + ". In the near future our employee will contact you.");
        return notification;
    }

}

