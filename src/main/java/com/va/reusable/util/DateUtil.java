package com.va.reusable.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class DateUtil {
	public static String add(Date date, int field, int days, String pattern) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, days);

		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(calendar.getTime());
	}
	
	public static String formatDate(Date date, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public static java.util.Date parseDate(String dateParam, String pattern){
		try{
			DateFormat df = new SimpleDateFormat(pattern);
			java.util.Date date = df.parse(dateParam);
			return date;
		}catch(Exception e){
			
		}
		return null;
	}
	
	public static Date getStartOfToday() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getEndOfToday() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	public static int getDayOffset(Date start, Date end) {
		long millis = end.getTime() - start.getTime();
		int daysOffset = (int) (millis / (1000 * 60 * 60 * 24));
		return daysOffset;
	}
	
	public static int getSecondsOffset(Date start, Date end) {
		long millis = end.getTime() - start.getTime();
		int offset = (int) (millis / 1000);
		return offset;
	}

	public static String getTodayInText(String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);

		return df.format(new Date());
	}

	public static String getTimestamp(Date date) {
		String result = "";
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss z");
			result = df.format(date);
		}
		return result;
	}

	public static String getSqlDate(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
	
	/**
	 * string date format MM/dd/yyyy
	 * @param date
	 * @return
	 */
	public static java.sql.Date getSqlDate(String date){
		List<String> list = splitDate(date, "/");
		try{
			Date sDate = getDate(Integer.parseInt(list.get(0)), Integer.parseInt(list.get(1)), Integer.parseInt(list.get(2)));
			return new java.sql.Date(sDate.getTime());
		}catch(Exception e){
			return null;
		}
	}
	
	public static List<String> splitDate(String date, String regex){
		if(StringUtils.isBlank(date))
			return null;
		
		String st[] = date.split(regex);
		List<String> list = new ArrayList<String>();
		for(String s : st){
			if(StringUtils.isNotBlank(s))
				list.add(s);
		}
		return list;
	}
	
	public static String convertSQLDateToText(java.sql.Date date){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		return df.format(new java.util.Date(date.getTime()));
	}

	/**
	 * @param month
	 *            1 to 12
	 */
	public static Date getDate(int month, int day, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setLenient(true);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.YEAR, year);

		return cal.getTime();
	}

	public static String getCurrentYearString() {
		String year = "" + getCurrentYear();
		return year.replaceAll(",", "");
	}

	public static int getCurrentYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	public static int getCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH);
	}

	public static java.sql.Date getCurrentSqlDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new java.util.Date());
		java.sql.Date date = new java.sql.Date(calendar.getTimeInMillis());
		return date;
	}

	public static Timestamp getCurrentSqlTimestamp() {
		java.util.Date date = null;
		java.sql.Timestamp timeStamp = null;
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new java.util.Date());
			java.sql.Date dt = new java.sql.Date(calendar.getTimeInMillis());
			java.sql.Time sqlTime = new java.sql.Time(calendar.getTime().getTime());
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			date = simpleDateFormat.parse(dt.toString() + " " + sqlTime.toString());
			timeStamp = new java.sql.Timestamp(date.getTime());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return timeStamp;
	}

	public static String getTimeStampForFileName() {
		String timeStamp = null;
		DateFormat dateFormat = new SimpleDateFormat("MM.dd.yy_h_mma");
		timeStamp = dateFormat.format(new Date());
		return timeStamp;
	}

	// move out of DateUtil
	public static String getNoteTimestamp() {
		return "\n" + DateUtil.getTodayInText("MMM dd, yyyy HH:mm:ss z") + ": ";
	}
	
	public static String getNewNoteTimestamp(){
		return DateUtil.getTodayInText("MMM dd, yyyy HH:mm:ss z");	
	}

	public static String formatChargebackDate(String date) {
		if (date.indexOf("/") != -1) {
			// format mm/dd/yyyy; add 0 for mm & dd
			String mm = date.substring(0, date.indexOf("/"));
			if (mm.length() == 1)
				mm = "0" + mm;
			String dd = date.substring(date.indexOf("/") + 1, date.lastIndexOf("/"));
			if (dd.length() == 1)
				dd = "0" + dd;
			String yy = date.substring(date.lastIndexOf("/") + 1, date.length());

			StringBuffer sb = new StringBuffer();
			sb.append(yy);
			sb.append("-");
			sb.append(mm);
			sb.append("-");
			sb.append(dd);

			return sb.toString();
		} else if (date.indexOf("-") != 1) {
			// format yyyy-mm-dd; add 0 for mm & dd
			String yy = date.substring(0, date.indexOf("-"));
			String mm = date.substring(date.indexOf("-") + 1, date.lastIndexOf("-"));
			if (mm.length() == 1)
				mm = "0" + mm;
			String dd = date.substring(date.lastIndexOf("-") + 1, date.length());
			if (dd.length() == 1)
				dd = "0" + dd;

			StringBuffer sb = new StringBuffer();
			sb.append(yy);
			sb.append("-");
			sb.append(mm);
			sb.append("-");
			sb.append(dd);

			return sb.toString();
		}
		return date;
	}

	public static Timestamp add30DaysToDate(java.util.Date date) {
		java.sql.Timestamp timeStamp = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// 30 days = 1 month; using 30 days will generate different result,
		// days are lacking; using Calendar.MONTH + 1 will give the exact result
		calendar.add(Calendar.MONTH, 1);
		timeStamp = new java.sql.Timestamp(calendar.getTime().getTime());

		return timeStamp;
	}
	
	public static int getMonthsDifference(Date dateBefore, Date dateAfter) {  
		int years, months, months_from_years,days;
	
		Calendar c1 = Calendar.getInstance(); //now
		Calendar c2 = Calendar.getInstance();
		
		c1.setTime(dateBefore);
		c2.setTime(dateAfter);
		
		//get year differential
		years = c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR);
		//get months differential
		months = c2.get(Calendar.MONTH)-c1.get(Calendar.MONDAY);
		//get days differential
		days = (c1.getActualMaximum(Calendar.DAY_OF_MONTH)-c1.get(Calendar.DAY_OF_MONTH))+c2.get(Calendar.DAY_OF_MONTH);		
			
		
		months=years*12+months;
		if((days/31) > 0)months++;
		
		return months;
	}  
	
	public static String getCurrentDateTimeStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hhmmss");
		String dateStr = sdf.format(Calendar.getInstance().getTime());
		return dateStr;
	}
	public static String getCurrentDateStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
		String dateStr = sdf.format(Calendar.getInstance().getTime());
		return dateStr;
	}
}
