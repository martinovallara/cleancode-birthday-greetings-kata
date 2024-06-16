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
        return new EMailMessage(employee, this.emailSender);
    }
}
