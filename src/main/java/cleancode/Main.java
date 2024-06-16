package cleancode;

import cleancode.domain.BirthdayService;
import cleancode.domain.XDate;
import cleancode.infrascructure.EMailBirthdayFactory;
import cleancode.infrascructure.EMailSender;
import cleancode.infrascructure.EmployeesCSVReader;

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
