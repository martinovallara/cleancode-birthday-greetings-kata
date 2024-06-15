package cleancode;

import com.dumbster.smtp.*;

import cleancode.infrascructure.EmployeesCSVReader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;


class AcceptanceTest {

	private static final int NONSTANDARD_PORT = 9999;
	private BirthdayService birthdayService;
	private SimpleSmtpServer mailServer;

	@BeforeEach
	public void setUp() {
		mailServer = SimpleSmtpServer.start(NONSTANDARD_PORT);
		birthdayService = new BirthdayService(new EmployeesCSVReader("employee_data.txt"));
	}

	@AfterEach
	public void tearDown() throws Exception {
		mailServer.stop();
		Thread.sleep(200);
	}

	@Test
	void willSendGreetings_whenItsSomebodysBirthday() throws Exception {

		birthdayService.sendGreetings( new XDate("2008/10/08"), "localhost", NONSTANDARD_PORT);

		assertThat(mailServer.getReceivedEmailSize()).isEqualTo(1);
		SmtpMessage message = (SmtpMessage) mailServer.getReceivedEmail().next();
		assertThat(message.getBody()).isEqualTo("Happy Birthday, dear John!");
		assertThat(message.getHeaderValue("Subject")).isEqualTo("Happy Birthday!");
		String[] recipients = message.getHeaderValues("To");
		assertThat(recipients).hasSize(1);
		assertThat(recipients[0]).isEqualTo("john.doe@foobar.com");
	}

	@Test
	void willNotSendEmailsWhenNobodysBirthday() throws Exception {
		birthdayService.sendGreetings( new XDate("2008/01/01"), "localhost", NONSTANDARD_PORT);

		assertThat(mailServer.getReceivedEmailSize()).isZero();
	}
}
