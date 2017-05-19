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

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendMail(String to, String subject, String body) {
        SimpleMailMessage templateMessage = new SimpleMailMessage();
        templateMessage.setFrom("artairline2017@gmail.com");
        templateMessage.setSubject("Registration in ArtAirline system");
        SimpleMailMessage mailMessage = new SimpleMailMessage(templateMessage);
        mailMessage.setTo(to);
        mailMessage.setText(body);
        try {
            mailSender.send(mailMessage);
        } catch (MailException mailException) {
            mailException.printStackTrace();
        }
    }
}

