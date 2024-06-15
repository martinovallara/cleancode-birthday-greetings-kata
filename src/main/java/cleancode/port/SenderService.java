package cleancode.port;

import javax.mail.MessagingException;

import cleancode.EMailMessage;

public interface SenderService {

    void send(EMailMessage message) throws MessagingException;

}
