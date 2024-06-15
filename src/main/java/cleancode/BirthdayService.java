package cleancode;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;


public class BirthdayService {

	private EmployeesFeacther employeesFeacther;

	public BirthdayService(EmployeesFeacther employeesFeacther) {
		this.employeesFeacther = employeesFeacther;
	}

	public void sendGreetings(XDate xDate, String smtpHost, int smtpPort) {
		List<Employee> employees = employeesFeacther.fetchEmployeeRecords();

		employees.forEach(employee -> buildAndSendBirthdayGreetings(xDate, smtpHost, smtpPort, employee));
	}

	private void buildAndSendBirthdayGreetings(XDate xDate, String smtpHost, int smtpPort, Employee employee) {
		try {
			if (employee.isBirthday(xDate)) {
				EmailMessage message = new EmailMessage(employee);
				sendMessage(smtpHost, smtpPort, "sender@here.com", message);
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private void sendMessage(String smtpHost, int smtpPort, String sender, EmailMessage message) throws MessagingException {
		// Create a mail session
		java.util.Properties props = new java.util.Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", "" + smtpPort);
		Session session = Session.getInstance(props, null);

		// Construct the message
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(sender));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(message.getRecipient()));
		msg.setSubject(message.getSubject());
		msg.setText(message.getBody());

		// Send the message
		Transport.send(msg);
	}
}
