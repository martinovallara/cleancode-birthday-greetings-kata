package cleancode.infrastructure;

import cleancode.domain.Employee;
import cleancode.port.BirthdayMessage;

public class BirthdayMessageFactory implements EMailMessageFactory {

    private final EMailSender emailSender;

    public BirthdayMessageFactory(EMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public BirthdayMessage build(Employee employee) {
        var recipient = employee.getEmail();
        var body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
        var subject = "Happy Birthday!";
        // here can define the message type: ex EMailMessage, SMSMessage, etc
        return new EMailMessage(recipient, body, subject, this.emailSender);
    }
}
