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
 * @autor Artemyev Artoym
 */
@Service
public class MailServiceImpl implements MailService {
    private static Logger logger = LogManager.getLogger(MailServiceImpl.class.getName());
    private final String FROM = "artairline2017@gmail.com";
    private final String SUBJECT = "Registration in ArtAirline system";
    private final String MESSAGE = "Thank you for registration in our system. Now you can enter in system";

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendMail(String userMail) throws ServiceException {
        logger.debug(LoggingName.SERVICE_FUNCTION_SEND_MAIL);
        SimpleMailMessage templateMessage = new SimpleMailMessage();
        templateMessage.setFrom(FROM);
        templateMessage.setSubject(SUBJECT);
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
}

