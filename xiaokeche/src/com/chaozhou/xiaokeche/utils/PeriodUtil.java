package com.chaozhou.xiaokeche.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

public class PeriodUtil {

	private static int CheckDay = 25;

	public static GregorianCalendar getLatestPeriod() {
		GregorianCalendar c = new GregorianCalendar();

		if (c.get(GregorianCalendar.DAY_OF_MONTH) < CheckDay) {
			c.add(GregorianCalendar.MONTH, -1);
		}

		return c;
	}

	public static GregorianCalendar getFirstPeriod() {
		GregorianCalendar c = new GregorianCalendar(2011, 00, 25);
		TimeZone timezone = TimeZone.getTimeZone("GMT+8");
		c.setTimeZone(timezone);

		return c;
	}

	public static List<GregorianCalendar> getAllPeriod() {
		GregorianCalendar first = getFirstPeriod();
		GregorianCalendar latest = getLatestPeriod();

		List<GregorianCalendar> calendars = new ArrayList<GregorianCalendar>();

		int months = latest.get(GregorianCalendar.YEAR) * 12
				+ latest.get(GregorianCalendar.MONTH)
				- first.get(GregorianCalendar.YEAR) * 12
				- first.get(GregorianCalendar.MONTH);

		int count = 0;
		GregorianCalendar ca = first;
		calendars.add(ca);
		while (count < months) {
			ca = (GregorianCalendar) ca.clone();
			ca.add(GregorianCalendar.MONTH, 1);
			calendars.add(ca);
			count++;
		}

		return calendars;
	}

	public static String getYearMonthString(GregorianCalendar calendar) {
		DateFormat df = new SimpleDateFormat("yyyyMM");
		return df.format(calendar);
	}

	private GregorianCalendar getBeijingCalendar() {
		GregorianCalendar c = new GregorianCalendar();
		TimeZone timezone = TimeZone.getTimeZone("GMT+8");
		c.setTimeZone(timezone);
		return c;
	}
}
