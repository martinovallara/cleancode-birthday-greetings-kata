package cleancode.port;

import cleancode.domain.Employee;

public interface BirthdayMessageFactory {

    BirthdayMessage build(Employee employee);

}
