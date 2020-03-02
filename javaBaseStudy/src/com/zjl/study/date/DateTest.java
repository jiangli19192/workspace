package com.zjl.study.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	// 默认日期格式
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	// 一天时间
	private static final int DAY_DURATION = 60 * 60 * 24;
	public static final String LFO = "lfo";
	
	
	private static Date removeTime(Date date) {
        long days = date.getTime() / (DAY_DURATION + 1) * DAY_DURATION - 2;
        Calendar calendar = Calendar.getInstance();
        int offset = calendar.getTimeZone().getOffset(date.getTime());
        date = new Date(days - offset);
        return date;
    }
	
	public static void main(String[] args) throws ParseException {
		Date date = DateTest.removeTime(new Date());
		// 将String类型日期 转化成Date类型 
		// 时间简单格式化
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		System.out.println(date + ";" + simpleDateFormat.format(date));
		String dateStr = "2020-01-14";
		Date date2 = simpleDateFormat.parse(dateStr);
		System.out.println(date2);
		
		String dateBegin = "2017-05-27";
		String dateEnd = "2017-05-28";
		System.out.println(stringDateCompare(dateBegin, dateEnd));
		
		String dateBegin2 = "2017-05-27";
		String dateEnd2 = "2017-05-27";
		System.out.println(stringDateCompareEquals(dateBegin2, dateEnd2));
	}
	
	/**
	 * 比较日期字符串dateEnd在日期字符串dateBegin之后
	 * @param dateBegin
	 * @param dateEnd
	 * @return boolean
	 */
	private static boolean stringDateCompare(String dateBegin, String dateEnd) {
		if (java.sql.Date.valueOf(dateEnd).after(java.sql.Date.valueOf(dateBegin))) {
			return true;
		}
		return false;
	}
	
	/**
	 * 比较两个日期字符串是否相等
	 * @param dateBegin
	 * @param dateEnd
	 * @return boolean
	 */
	private static boolean stringDateCompareEquals(String dateBegin, String dateEnd) {
		if (java.sql.Date.valueOf(dateEnd).equals(java.sql.Date.valueOf(dateBegin))) {
			return true;
		}
		return false;
	}
}
