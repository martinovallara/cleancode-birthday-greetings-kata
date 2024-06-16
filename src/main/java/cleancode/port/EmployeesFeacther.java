package cleancode.port;

import java.util.List;

import cleancode.domain.Employee;

public interface EmployeesFeacther {

    List<Employee> fetchEmployeeRecords();

}