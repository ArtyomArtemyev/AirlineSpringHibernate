package by.netcracker.artemyev.service.impl;

import by.netcracker.artemyev.service.MailService;
import org.springframework.stereotype.Service;

import javax.mail.*;
import java.util.Properties;

/**
 * @autor Artemyev Artoym
 */
@Service
public class MailServiceImpl implements MailService {
    private String username;
    private String password;
    private Properties properties;

    private MailServiceImpl() {
        this.username ="artairline2017@gmail.com";
        this.password = "netcracker2017";
        properties = new Properties();
        properties.put("mail.smtp.host", "imap.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
    }

    @Override
    public void sendMail(String to, String subject, String body) {
        String host = "imap.gmail.com";
        Properties props = new Properties();
        Session session = Session.getInstance(props);
        Store store = null;
        try {
            store = session.getStore("imap");
            store.connect(host, username, password);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

