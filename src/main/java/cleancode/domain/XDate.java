package cleancode.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class XDate {

	private final Date date;

	public XDate() {
		date = new Date();
	}

	public XDate(String yyyyMMdd) throws ParseException {
		date = new SimpleDateFormat("yyyy/MM/dd").parse(yyyyMMdd);
	}

	public int getDay() {
		return getPartOfDate(Calendar.DAY_OF_MONTH);
	}

	public int getMonth() {
		return 1 + getPartOfDate(Calendar.MONTH);
	}

	public boolean isSameDay(XDate anotherDate) {
		return anotherDate.getDay() == this.getDay() && anotherDate.getMonth() == this.getMonth();
	}

	@Override
	public int hashCode() {
		return date.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof XDate))
			return false;
		XDate other = (XDate) obj;
		return other.date.equals(this.date);
	}

	private int getPartOfDate(int part) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar.get(part);
	}
}
