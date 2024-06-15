package cleancode;


import javax.mail.MessagingException;

import cleancode.port.EmployeesFeacther;

import java.util.List;


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
		try {
			if (employee.isBirthday(xDate)) {
				EMailMessage message = employee.buildMessage();
				message.send();
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}


}
