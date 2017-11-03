package com.zhsj.m.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil
{
	/**
	 * 格式化字符串日期<br>
	 * 字符串格式为 yyyyMMddHHmmss
	 * 
	 * @param stringTime
	 *            字符串日期
	 * @return Date 实例 <br>
	 *         null 失败
	 */
	public static Date formatStringTimeNotBlank(String stringTime)
	{
		try
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = new Date();
			date = format.parse(stringTime);
			return date;
		} catch (ParseException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static long formatStringUnixTime(String stringTime,String formatStr)
	{
		try
		{
			SimpleDateFormat format = new SimpleDateFormat(formatStr);
			Date date = new Date();
			date = format.parse(stringTime);
			return date.getTime()/1000;
		} catch (ParseException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 获取当前时间的yyyy-MM-dd HH:mm:ss字符串格式
	 * 
	 * @return 成功： yyyy-MM-dd HH:mm:ss 字符串 <br>
	 *         失败： null
	 */
	public static String getCurrentTimeHaveHR()
	{
		try
		{
			String stringTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			return stringTime;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getTime(long date)
	{
		try 
		{
			String stringTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(date));
			return stringTime;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
    
	
	public static String getYMD(long date){
		try 
		{
			String stringTime = new SimpleDateFormat("yyyy/MM/dd").format(new Date(date));
			return stringTime;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static String getDateFormat(String format)
	{
		try
		{
			String stringTime = new SimpleDateFormat(format).format(new Date());
			return stringTime;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取当前时间的 yyyyMMddHHmmss 字符串格式
	 * 
	 * @return 成功： yyyyMMddHHmmss 字符串 <br>
	 *         失败： null
	 */
	public static String getCurrentTime()
	{
		try
		{
			String stringTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			return stringTime;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static long unixTime() {
		return (long)(System.currentTimeMillis() / 1000L);
	}

	public static int getTodayStartTime() {
		Calendar time = Calendar.getInstance();
		time.set(Calendar.HOUR_OF_DAY, 0);
		time.set(Calendar.MINUTE, 0);
		time.set(Calendar.SECOND, 0);
		return (int)(time.getTimeInMillis()/1000L);
	}

	public static int getMonthStartTime() {
		Calendar time = Calendar.getInstance();
		time.add(Calendar.MONTH, 0);
		time.set(Calendar.DAY_OF_MONTH, 1);
		time.set(Calendar.HOUR_OF_DAY, 0);
		time.set(Calendar.MINUTE, 0);
		time.set(Calendar.SECOND, 0);
		return (int)(time.getTimeInMillis()/1000L);
	}

	public static int getMonthEndTime() {
		Calendar time = Calendar.getInstance();
		time.add(Calendar.MONTH, 1);
		time.set(Calendar.DAY_OF_MONTH, 0);
		time.set(Calendar.HOUR_OF_DAY, 0);
		time.set(Calendar.MINUTE, 0);
		time.set(Calendar.SECOND, 0);
		return (int)(time.getTimeInMillis()/1000L);
	}
	public static String formatDate(Date date, String df) {
		SimpleDateFormat sdf = new SimpleDateFormat(df);
		return sdf.format(date);
	}

/************************************************************/
	/**
	 * 获取当前时间前N个月的年月日
	 * @return
	 */
	public static Date getDateBeforeNMonths(int n){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -n);    //得到前一个月
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		return  calendar.getTime();
	}
	/**
	 * 获取当前时间前N个天的年月日
	 * @return
	 */
	public static Date getDateBeforeNDays(int n){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -n);    //得到前一个月
		return  calendar.getTime();
	}
	/**
	 * 获取date所在月的第一天
	 * @param date
	 * @return
	 */
	public static  Date getMonthLastDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int maxday =calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, maxday);
		return calendar.getTime();

	}

	/**
	 * 获取date所在月的最后一天
	 * @param date
	 * @return
	 */
	public static  Date getMonthFirstDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int minday =calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, minday);
		return calendar.getTime();

	}
	/**
	 * 获取当前日期的前N周的日期
	 */
	public static Date getDateBeforeNWeeks(int n){
		Calendar calendar = Calendar.getInstance();
		//calendar.setTime(new Date());
		calendar.add(Calendar.DATE, - 7*n);
		//calendar.add(Calendar.MONTH, -n);    //得到前一个月
		return  calendar.getTime();
	}
	/**
	 * 获取date所在月的第一天
	 * @param date
	 * @return
	 */
	public static  Date getWeekLastDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
		if(1 == dayWeek) {
			calendar.add(Calendar.DAY_OF_MONTH, -1);
		}
		calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		int day = calendar.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
		calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek()-day);
		calendar.add(Calendar.DATE, 6);
		return calendar.getTime();

	}

	/**
	 * 获取date所在月的最后一天
	 * @param date
	 * @return
	 */
	public static  Date getWeekFirstDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
		if(1 == dayWeek) {
			calendar.add(Calendar.DAY_OF_MONTH, -1);
		}
		calendar.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		int day = calendar.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
		calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek()-day);
		return calendar.getTime();
	}
	public static  String timestampToDate(String time){
		Timestamp ts = new Timestamp(Long.parseLong(time));
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(ts) ;
	}
	public static String dateToStrLong(java.util.Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dateDate);
		return dateString;
	}
	/**
	 * 返回String格式：yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateEN() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = format1.format(new Date(System.currentTimeMillis()));
		return date1;// 2012-10-03 23:41:31
	}
	
	public static String getYMDHMS(long date)
	{
		try 
		{
			String stringTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(date));
			return stringTime;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static long formatTime2Long(String stringTime,String formatStr)
	{
		try
		{
			SimpleDateFormat format = new SimpleDateFormat(formatStr);
			Date date = new Date();
			date = format.parse(stringTime);
			return date.getTime();
		} catch (ParseException e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	public static String formateDate2String(Date date,String formatStr){
		try
		{
			SimpleDateFormat format = new SimpleDateFormat(formatStr);
            String dateStr = format.format(date);
			return dateStr;
		} catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}
	
	public static String addDateBeginStr(String date){
		return date + " 00:00:00";
	}
	
	public static String addDateEndStr(String date){
		return date + " 23:59:59";
	}
/************************************************************/
	public static void main(String[] args)
	{
//		String time = DateUtil.getCurrentTimeHaveHR();
		System.out.println(DateUtil.getMonthStartTime()+"=="+DateUtil.getMonthEndTime());
		System.out.println(new Date().getTime());
		//Integer k =  1509542780730L;
		System.out.println(DateUtil.formatTime2Long("2017-11-1","yyyy-MM-dd"));
		System.out.println(DateUtil.getYMDHMS(new Date().getTime()));
		System.err.println(formatStringUnixTime("2015-05-19 15:26:59","yyyy-MM-dd HH:mm:ss"));
	}
}
