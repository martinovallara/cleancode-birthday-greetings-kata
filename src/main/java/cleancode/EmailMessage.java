package cleancode;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import cleancode.infrascructure.EMailSender;


public final class EMailMessage {

    private final String recipient;
    private final String body;
    private final String subject;
	private final EMailSender emailSender;


    public EMailMessage(Employee employee, EMailSender emailSender) {
        this.recipient = employee.getEmail();
        this.body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
        this.subject = "Happy Birthday!";
        this.emailSender = emailSender;
    }

	public Message buildMessage(Message msg)  throws MessagingException{
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(this.recipient));
        msg.setSubject(this.subject);
        msg.setText(this.body);
        return msg;
    }

	public void send() throws MessagingException{
		this.emailSender.send(this);
	}
}