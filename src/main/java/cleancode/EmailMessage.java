package cleancode;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

public final class EMailMessage {

    private final String recipient;
    private final String body;
    private final String subject;

    public EMailMessage(Employee employee) {
        this.recipient = employee.getEmail();
        this.body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
        this.subject = "Happy Birthday!";
    }


    public Message buildMessage(Message msg)  throws MessagingException{
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(this.recipient));
        msg.setSubject(this.subject);
        msg.setText(this.body);
        return msg;
    }
}