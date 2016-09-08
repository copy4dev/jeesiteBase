package com.thinkgem.jeesite.modules.debug.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间日期类工具
 * @author Admin
 * @version 2016年9月8日
 *
 */
public abstract class DateUtil {

	public static void main(String[] args) throws ParseException {
	}

	// /////////////////////////////////////////////////////////////////////////////////////
	// FORMART DATE TO STRING
	// /////////////////////////////////////////////////////////////////////////////////////

	// -------------- part 1 : LongStr ---------------

	/**
	 * Format the current date time to "yyyy-MM-dd HH:mm:ss.SSS" format string
	 * 
	 * @return yyyy-MM-dd HH:mm:ss.SSS
	 */
	public static final String formatDate2LongStr() {
		return formatDate2LongStr(new Date());
	}

	/**
	 * Format the given date time to "yyyy-MM-dd HH:mm:ss.SSS" format string
	 * 
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss.SSS
	 */
	public static final String formatDate2LongStr(Date date) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return s.format(date);
	}

	/**
	 * Format the given date time (long int) <br/>
	 * to "yyyy-MM-dd HH:mm:ss.SSS" format string
	 * 
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss.SSS
	 */
	public static final String formatDate2LongStr(long date) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return s.format(new Date(date));
	}

	// -------------- part 2 : TimeStr ---------------

	/**
	 * Format the current date time to "yyyy-MM-dd HH:mm:ss" format string
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static final String formatDate2TimeStr() {
		return formatDate2TimeStr(new Date());
	}

	/**
	 * Format the given date time to "yyyy-MM-dd HH:mm:ss" format string
	 * 
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static final String formatDate2TimeStr(Date date) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return s.format(date);
	}

	/**
	 * Format the given date time (long int) <br/>
	 * to "yyyy-MM-dd HH:mm:ss" format string
	 * 
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static final String formatDate2TimeStr(long date) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return s.format(new Date(date));
	}

	// -------------- part 3 : DateStr ---------------

	/**
	 * Format the current date time to "yyyy-MM-dd" format string
	 * 
	 * @return yyyy-MM-dd
	 */
	public static final String formatDate2DateStr() {
		return formatDate2DateStr(new Date());
	}

	/**
	 * Format the given date time to "yyyy-MM-dd" format string
	 * 
	 * @param date
	 * @return yyyy-MM-dd
	 */
	public static final String formatDate2DateStr(Date date) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		return s.format(date);
	}

	/**
	 * Format the given date time (long int) to "yyyy-MM-dd" format string
	 * 
	 * @param date
	 * @return yyyy-MM-dd
	 */
	public static final String formatDate2DateStr(long date) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		return s.format(new Date(date));
	}

	// -------------- part 4 : user define ---------------

	/**
	 * Format the given date time to "yyyy" format string
	 * 
	 * @param date
	 * @return yyyy
	 */
	public static final String formatDate2YearStr(Date date) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy");
		return s.format(date);
	}

	/**
	 * Format the given date time to "mm" format string
	 * 
	 * @param date
	 * @return mm
	 */
	public static final String formatDate2MonthStr(Date date) {
		SimpleDateFormat s = new SimpleDateFormat("MM");
		return s.format(date);
	}

	/**
	 * Format the given date time to "dd" format string
	 * 
	 * @param date
	 * @return dd
	 */
	public static final String formatDate2DayStr(Date date) {
		SimpleDateFormat s = new SimpleDateFormat("dd");
		return s.format(date);
	}

	// /////////////////////////////////////////////////////////////////////////////////////
	// PARSE DATE FROM STRING
	// /////////////////////////////////////////////////////////////////////////////////////

	// 把一定格式的字符串转化为Date,注意字符串的格式!

	public static final Date parseDateFromLongStr(String date)
			throws ParseException {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return s.parse(date);
	}

	public static final Date parseDateFromDateTimeStr(String date)
			throws ParseException {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return s.parse(date);
	}

	public static final Date parseDateFromDateStr(String date)
			throws ParseException {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		return s.parse(date);
	}

	// /////////////////////////////////////////////////////////////////////////////////////
	// GET SPECIAL DATE BY PARAM
	// /////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 根据输入的整数获取目前一周中的一个日期<br/>
	 * 1->sun<br\>
	 * 7->sat<br\>
	 * 以周期为7的方式浮动
	 * 
	 * @param weekDay
	 * @return
	 */
	public static final Date getLastWeekDay(int weekDay) {
		return getLastWeekDay(weekDay, new Date());
	}

	/**
	 * 获取给定日期所对应的上周的时间
	 * 
	 * @param end
	 * @return
	 */
	public static final Date getLastWeekDay(Date end) {
		if (end == null)
			throw new IllegalArgumentException(
					"The parameter [end date] should not be null!");
		GregorianCalendar cal = getCalender(end);
		cal.add(Calendar.DAY_OF_MONTH, -7);

		return cal.getTime();
	}

	/**
	 * 在给定的日期之前,输出7天内的日期 1->sun<br\>
	 * 7->sat<br\>
	 * 
	 * @param weekDay
	 * @param end
	 * @return
	 */
	public static final Date getLastWeekDay(int weekDay, Date end) {
		if (end == null)
			throw new IllegalArgumentException(
					"The parameter [end date] should not be null!");
		GregorianCalendar cal = getCalender(end);
		cal.set(Calendar.DAY_OF_WEEK, weekDay);

		if (!cal.getTime().before(end)) {
			cal.add(Calendar.DAY_OF_MONTH, -7);
		}
		return cal.getTime();
	}

	/**
	 * get the date of yester day and the time is zero
	 * 
	 * @return
	 */
	public static final Date getYesterday() {
		GregorianCalendar cal = getCalender(new Date());
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

	/**
	 * get the date of today and the time is zero
	 * 
	 * @return
	 */
	public static final Date getTodayZero() {
		GregorianCalendar cal = getCalender(new Date());
		return cal.getTime();
	}

	// /////////////////////////////////////////////////////////////////////////////////////
	// GET DATE PART
	// /////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 在给定日期中获取24小时制的小时
	 * 
	 * @param date
	 * @return
	 */
	public static final int getHour(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 在给定日期中获取分钟
	 * 
	 * @param date
	 * @return
	 */
	public static final int getMinute(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(Calendar.MINUTE);
	}

	/**
	 * 获取给定日期是一周中的第几天
	 * 
	 * @param date
	 * @return
	 */
	public static final int getWeekDay(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 获得给定日期是这个月的第几天
	 * 
	 * @param date
	 * @return
	 */
	public static final int getDayofMonth(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获得给定日期是这个年的第几个月
	 * 
	 * @param date
	 * @return
	 */
	public static final int getMonth(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * 自定日历格式
	 * 
	 * @param date
	 * @return
	 */
	private static final GregorianCalendar getCalender(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		return cal;
	}

	/**
	 * 根据输入的整数获取日期
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static final Date getDate(int year, int month, int day) {
		GregorianCalendar d = new GregorianCalendar(year, month - 1, day);
		return d.getTime();
	}

	/**
	 * 根据输入的整数获取日期
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	public static final Date getDate(int year, int month, int day, int hour,
			int minute, int second) {
		GregorianCalendar d = new GregorianCalendar(year, month - 1, day, hour,
				minute, second);
		return d.getTime();
	}
}
