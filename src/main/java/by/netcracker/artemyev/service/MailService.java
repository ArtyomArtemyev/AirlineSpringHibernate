package by.netcracker.artemyev.service;

/**
 * @autor Artemyev Artoym
 */
public interface MailService {
    void sendMail(String to, String subject, String body);
}
