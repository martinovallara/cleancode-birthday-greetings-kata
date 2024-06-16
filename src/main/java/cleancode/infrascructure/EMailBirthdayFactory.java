package cleancode.infrascructure;

import cleancode.domain.Employee;
import cleancode.port.BirthdayFactory;
import cleancode.port.BirthdayMessage;

public class EMailBirthdayFactory implements BirthdayFactory {

    private final EMailSender emailSender;

    public EMailBirthdayFactory(EMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public BirthdayMessage build(Employee employee) {
        return new EMailMessage(employee, this.emailSender);
    }
}
