package cleancode.infrastructure;

import cleancode.domain.Employee;
import cleancode.port.BirthdayFactory;
import cleancode.port.BirthdayMessage;

public class EMailBirthdayFactory implements BirthdayFactory {

    private EMailMessageFactory emailMessageFactory;

    public EMailBirthdayFactory(EMailMessageFactory emailMessageFactory) {
        this.emailMessageFactory = emailMessageFactory;
    }

    @Override
    public BirthdayMessage build(Employee employee) {
        return this.emailMessageFactory.build(employee);
    }
}
