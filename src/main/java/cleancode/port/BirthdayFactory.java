package cleancode.port;

import cleancode.BirthdayMessage;
import cleancode.domain.Employee;

public interface BirthdayFactory {

    BirthdayMessage build(Employee employee);

}
