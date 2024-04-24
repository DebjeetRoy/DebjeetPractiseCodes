package com.dev.java.DateTimeAPI;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;//mutable

public class JavaDateTIme {
	public static void main(String[] args) throws ParseException {
		Date d = new Date();
		System.out.println(d);

		java.sql.Date sqlDate = new java.sql.Date(d.getTime());
		System.out.println(sqlDate);

		// DateTime API from Java8
		LocalDate ld = LocalDate.of(1992, Month.OCTOBER, 27);
		System.out.println(ld);

		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);

		// Zone Details
		LocalDateTime dt = LocalDateTime.now(ZoneId.of("GMT")); // Human Readable
		System.out.println("Local date time with zone details = " + dt);

		Instant i = Instant.now();
		System.out.println("Instant Time = " + i);
	}
}
