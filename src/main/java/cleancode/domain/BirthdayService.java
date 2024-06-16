package cleancode.domain;

import java.util.List;

import cleancode.BirthdayMessage;
import cleancode.XDate;
import cleancode.port.EmployeesFeacther;


public class BirthdayService {

	private EmployeesFeacther employeesFeacther;

	public BirthdayService(EmployeesFeacther employeesFeacther) {
		this.employeesFeacther = employeesFeacther;
	}

	public void sendGreetings(XDate xDate) {
		List<Employee> employees = employeesFeacther.fetchEmployeeRecords();

		employees.forEach(employee -> buildAndSendBirthdayGreetings(xDate, employee));
	}

	private void buildAndSendBirthdayGreetings(XDate xDate, Employee employee) {
		if (employee.isBirthday(xDate)) {
			BirthdayMessage message = employee.buildMessage();
			message.send();
		}
	}
}
