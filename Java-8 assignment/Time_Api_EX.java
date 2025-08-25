package java8;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class Time_Api_EX {

	public static void main(String[] args) {

		LocalTime today = LocalTime.now();
		System.out.println(today);

		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);

		LocalDate birthday = LocalDate.of(2001, 5, 25);

		Period ageDiff = Period.between(birthday, localDate);

		System.out.println(ageDiff.getYears());

		LocalTime start = LocalTime.of(9, 50);
		LocalTime end = LocalTime.of(10, 50);

		Duration d = Duration.between(start, end);
		System.out.println(d.toMinutes());

	}

}