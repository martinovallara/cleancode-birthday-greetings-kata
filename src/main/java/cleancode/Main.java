package cleancode;

public class Main {

	public static void main(String[] args) {
		BirthdayService service = new BirthdayService(new EmployeesCSVReader("employee_data.txt"));
		service.sendGreetings(new XDate(), "localhost", 25);
	}
}
