package cleancode;



import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeTest {

	@Test
	void testBirthday() throws Exception {
		Employee employee = new Employee("foo", "bar", "1990/01/31", "a@b.c", null);
		assertThat(employee.isBirthday(new XDate("2008/01/30"))).isFalse();
		assertThat(employee.isBirthday(new XDate("2008/01/31"))).isTrue();
	}

	@Test
	void equality() throws Exception {
		Employee base = new Employee("First", "Last", "1999/09/01", "first@last.com", null);
		Employee same = new Employee("First", "Last", "1999/09/01", "first@last.com", null);
		Employee different = new Employee("First", "Last", "1999/09/01", "boom@boom.com", null);

		assertThat(base)
			.isNotNull()
			.isNotEqualTo("")
			.isEqualTo(same)
			.isNotEqualTo(different);
	}
}
