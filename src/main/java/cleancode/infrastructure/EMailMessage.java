package cleancode.infrastructure;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

import cleancode.port.BirthdayMessage;


public final class EMailMessage implements BirthdayMessage {

    private final String recipient;
    private final String body;
    private final String subject;
	private final EMailSender emailSender;

    public EMailMessage(String recipient, String body, String subject, EMailSender emailSender) {
        this.recipient = recipient;
        this.body = body;
        this.subject = subject;
        this.emailSender = emailSender;
    }
    
	public Message buildMailMessage(Message msg)  throws MessagingException{
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(this.recipient));
        msg.setSubject(this.subject);
        msg.setText(this.body);
        return msg;
    }

    @Override
	public void send() {
		try {
            this.emailSender.send(this);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
}
