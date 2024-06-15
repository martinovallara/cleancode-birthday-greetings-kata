package cleancode;


import javax.mail.MessagingException;

import cleancode.port.EmployeesFeacther;
import cleancode.port.SenderService;

import java.util.List;


public class BirthdayService {

	private EmployeesFeacther employeesFeacther;
	private SenderService senderService;

	public BirthdayService(EmployeesFeacther employeesFeacther, SenderService senderService) {
		this.employeesFeacther = employeesFeacther;
		this.senderService = senderService;
	}

	public void sendGreetings(XDate xDate) {
		List<Employee> employees = employeesFeacther.fetchEmployeeRecords();

		employees.forEach(employee -> buildAndSendBirthdayGreetings(xDate, employee));
	}

	private void buildAndSendBirthdayGreetings(XDate xDate, Employee employee) {
		try {
			if (employee.isBirthday(xDate)) {
				EMailMessage message = new EMailMessage(employee);
				senderService.send(message);
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}


}
