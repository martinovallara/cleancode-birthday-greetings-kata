package cleancode;

import cleancode.infrascructure.EMailSender;
import cleancode.infrascructure.EmployeesCSVReader;

public class Main {

	public static void main(String[] args) {
		BirthdayService service = new BirthdayService(
			new EmployeesCSVReader("employee_data.txt", new EMailSender("localhost", 25, "sender@here.com"))
			);
		service.sendGreetings(new XDate());
	}
}
