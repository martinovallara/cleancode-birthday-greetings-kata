package cleancode.port;

import cleancode.domain.Employee;

public interface BirthdayFactory {

    BirthdayMessage build(Employee employee);

}
