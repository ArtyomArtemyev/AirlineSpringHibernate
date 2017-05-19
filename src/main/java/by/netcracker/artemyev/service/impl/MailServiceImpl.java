package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.service.MailService;
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
    private final String FROM = "artairline2017@gmail.com";
    private final String SUBJECT = "Registration in ArtAirline system";
    private final String MESSAGE = "Thank you for registration in our system. Now you can enter in system";

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendMail(String userMail) {
        SimpleMailMessage templateMessage = new SimpleMailMessage();
        templateMessage.setFrom(FROM);
        templateMessage.setSubject(SUBJECT);
        SimpleMailMessage mailMessage = new SimpleMailMessage(templateMessage);
        mailMessage.setTo(userMail);
        mailMessage.setText(MESSAGE);
        try {
            mailSender.send(mailMessage);
        } catch (MailException mailException) {
            mailException.printStackTrace();
        }
    }
}

