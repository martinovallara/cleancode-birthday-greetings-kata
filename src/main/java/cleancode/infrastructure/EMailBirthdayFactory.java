package cleancode.infrastructure;

import cleancode.domain.Employee;
import cleancode.port.BirthdayMessageFactory;
import cleancode.port.BirthdayMessage;

public class EMailBirthdayFactory implements BirthdayMessageFactory {

    private BirthdayMessageFactory birthdayMessageFactory;

    public EMailBirthdayFactory(BirthdayMessageFactory emailMessageFactory) {
        this.birthdayMessageFactory = emailMessageFactory;
    }

    @Override
    public BirthdayMessage build(Employee employee) {
        return this.birthdayMessageFactory.build(employee);
    }
}
