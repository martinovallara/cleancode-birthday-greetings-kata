package cleancode;

import cleancode.domain.BirthdayService;
import cleancode.domain.XDate;
import cleancode.infrastructure.BirthdayMessageFactory;
import cleancode.infrastructure.EMailBirthdayFactory;
import cleancode.infrastructure.EMailMessageFactory;
import cleancode.infrastructure.EMailSender;
import cleancode.infrastructure.EmployeesCSVReader;

public class Main {

	public static void main(String[] args) {
		BirthdayService service = new BirthdayService(
			new EmployeesCSVReader("employee_data.txt", 
				new EMailBirthdayFactory(
					new EMailSender("localhost", 25, "sender@here.com")))
			);
		service.sendGreetings(new XDate());
	}
}
