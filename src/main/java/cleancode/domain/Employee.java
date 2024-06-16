package cleancode.domain;

import java.text.ParseException;

import cleancode.port.BirthdayFactory;
import cleancode.port.BirthdayMessage;

public class Employee {

	private XDate birthDate;
	private String lastName;
	private String firstName;
	private String email;
	private BirthdayFactory birthdayFactory;

	public Employee(String firstName, String lastName, String birthDate, String email, BirthdayFactory birthdayFactory) throws ParseException {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = new XDate(birthDate);
		this.email = email;
		this.birthdayFactory = birthdayFactory;
	}

	public boolean isBirthday(XDate today) {
		return today.isSameDay(birthDate);
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	@Override
	public String toString() {
		return "Employee " + firstName + " " + lastName + " <" + email + "> born " + birthDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	
	public BirthdayMessage buildMessage() {
		return this.birthdayFactory.build(this); 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

}
