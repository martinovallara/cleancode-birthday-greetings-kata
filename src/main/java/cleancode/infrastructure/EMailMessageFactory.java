package cleancode.infrastructure;

import cleancode.domain.Employee;
import cleancode.port.BirthdayMessage;

public interface EMailMessageFactory {

    BirthdayMessage build(Employee employee);

}
