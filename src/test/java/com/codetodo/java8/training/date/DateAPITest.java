package com.codetodo.java8.training.date;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class DateAPITest {

	/**
	 * Clock provides access to the current date and time. Clocks are aware of a
	 * timezone and may be used instead of System.currentTimeMillis() to
	 * retrieve the current milliseconds. Such an instantaneous point on the
	 * time-line is also represented by the class Instant. Instants can be used
	 * to create legacy java.util.Date objects.
	 */
	@Test
	public void testClock() {
		Clock clock = Clock.systemDefaultZone();

		long millis = clock.millis();

		System.out.println(millis);

		Instant instant = clock.instant();

		Date legacyDate = Date.from(instant); // legacy java.util.Date

		System.out.println(legacyDate);
	}

	/**
	 * Timezones are represented by a ZoneId. They can easily be accessed via
	 * static factory methods. Timezones define the offsets which are important
	 * to convert between instants and local dates and times.
	 */
	@Test
	public void testTimezones() {
		System.out.println(ZoneId.getAvailableZoneIds());

		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");

		System.out.println(zone1.getRules());
		System.out.println(zone2.getRules());
	}

	/**
	 * LocalTime represents a time without a timezone, e.g. 10pm or 17:30:15.
	 * The following example creates two local times for the timezones defined
	 * above. Then we compare both times and calculate the difference in hours
	 * and minutes between both times.
	 */
	@Test
	public void testLocalTime() {
		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");

		LocalTime now1 = LocalTime.now(zone1);
		LocalTime now2 = LocalTime.now(zone2);

		System.out.println(now1.isBefore(now2)); // false

		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

		System.out.println(hoursBetween); // -3
		System.out.println(minutesBetween); // -239
	}

	/**
	 * LocalDate represents a distinct date, e.g. 2014-03-11. It's immutable and
	 * works exactly analog to LocalTime. The sample demonstrates how to
	 * calculate new dates by adding or substracting days, months or years. Keep
	 * in mind that each manipulation returns a new instance.
	 */
	@Test
	public void testLocalDate() {
		LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
		DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
		System.out.println(dayOfWeek); // FRIDAY

		DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
				.withLocale(Locale.GERMAN);

		LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
		System.out.println(xmas); // 2014-12-24
	}

	/**
	 * LocalDateTime represents a date-time. It combines date and time as seen
	 * in the above sections into one instance. LocalDateTime is immutable and
	 * works similar to LocalTime and LocalDate. We can utilize methods for
	 * retrieving certain fields from a date-time.
	 */
	@Test
	public void testLocalDateTime() {
		LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

		DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
		System.out.println(dayOfWeek); // WEDNESDAY

		Month month = sylvester.getMonth();
		System.out.println(month); // DECEMBER

		long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
		System.out.println(minuteOfDay); // 1439
	}

}
