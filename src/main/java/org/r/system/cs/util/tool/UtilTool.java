/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: com.tongc.cs.util 
 * @author: Casper   
 * @date: 2018年6月20日 上午11:56:17 
 */
package org.r.system.cs.util.tool;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtilTool {

	private static final Random randomer = new Random();
	private static final String DATESTRING = "yyyy-MM-dd";
	private static final String DATETIMESTRING = "yyyy-MM-dd HH:mm:ss";

	/**
	 * @author Casper
	 * @date 2018年6月20日 上午11:56:43
	 * @return 当前系统的日期，格式为年-月-日
	 */
	public static String getSystemCurrentDate() {
		String fromatString = DATESTRING;
		SimpleDateFormat formatter = new SimpleDateFormat(fromatString);
		formatter.format(new Date());
		return formatter.format(new Date());
	}

	private UtilTool() {
	}

	/**
	 * @author Casper
	 * @date 2018年6月23日 下午7:38:30
	 * @return 当前系统的日期时间，格式为年-月-日 时-分-秒
	 */
	public static String getSystemCurrentDateTime() {
		String fromatString = DATETIMESTRING;
		return new SimpleDateFormat(fromatString).format(new Date());
	}

	/**
	 * @author Casper
	 * @date 2018年9月18日 上午10:49:12
	 * @return 当前系统时间的sql类型时间戳
	 */
	public static Timestamp getSystemCurDateTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * @author Casper
	 * @date 2018年9月18日 上午10:49:34
	 * @param DateTime
	 *            时间字符串
	 * @return 当前系统时间的sql类型时间戳
	 * @throws ParseException
	 */
	public static Timestamp getTimestampByDateTimeString(String dateTime) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(DATETIMESTRING);
		Timestamp target = null;

		try {
			target = new Timestamp(format.parse(dateTime).getTime());
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
			throw new ParseException("日期转化出错，请确保日期格式为yyyy-mm-dd", e.getErrorOffset());
		}

		return target;
	}

	/**
	 * @author Casper
	 * @date 2018年9月18日 上午10:49:34
	 * @param DateTime
	 *            时间字符串
	 * @return 当前系统时间的sql类型时间戳
	 * @throws ParseException
	 */
	public static Timestamp getTimestampByDateString(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(DATESTRING);
		Timestamp target = null;

		try {
			target = new Timestamp(format.parse(date).getTime());
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
			throw new ParseException("日期转化出错，请确保日期格式为yyyy-mm-dd", e.getErrorOffset());
		}

		return target;
	}

	/**
	 * @author Casper
	 * @date 2018年6月23日 上午8:49:49
	 * @param date
	 *            年-月 根据年月获取该月的天数
	 * @return
	 */
	public static int getNumDaysByDate(String date) {
		String[] dates = date.split("-");
		int day = 0;
		switch (dates[1]) {
		case "01":
		case "03":
		case "05":
		case "07":
		case "08":
		case "10":
		case "12":
			day = 31;
			break;
		case "04":
		case "06":
		case "09":
		case "11":
			day = 30;
			break;
		case "02":
			day = Integer.parseInt(dates[0]) % 4 == 0 ? 28 : 29;
			break;
		default:
			break;
		}
		return day;
	}

	/**
	 * @author Casper
	 * @date 2018年6月23日 上午9:38:57
	 * @param day
	 *            日 把参数day格式化为dd
	 * @return
	 */
	public static String formatDay(String day) {
		if (day.length() < 2)
			day = "0" + day;
		else if (day.length() > 2)
			day = null;
		return day;
	}

	/**
	 * 获取指定日期的下一日
	 * 
	 * @author Casper
	 * @date 2018年6月23日 下午5:00:04
	 * @param date
	 *            日期（年-月-日，yyyy-MM-dd）
	 * @return
	 */
	public static String getNextDate(String date) {
		return getNextLastDate(date, 1);
	}

	/**
	 * 获取指定日期的上一日
	 * 
	 * @author Casper
	 * @date 2018年7月11日 上午9:22:24
	 * @param date
	 *            日期（年-月-日，yyyy-MM-dd）
	 * @return
	 */
	public static String getLastDate(String date) {
		return getNextLastDate(date, -1);
	}

	/**
	 * 获取指定日期的一个步长后的日期
	 * 
	 * @author Casper
	 * @date 2018年7月11日 上午9:22:59
	 * @param date
	 *            日期（年-月-日，yyyy-MM-dd）
	 * @param step
	 *            步长
	 * @return
	 */
	public static String getNextLastDate(String date, int step) {
		Calendar calendar = Calendar.getInstance();
		Date targetDate = null;
		String nextDate = null;
		try {
			targetDate = new SimpleDateFormat(DATESTRING).parse(date);
			calendar.setTime(targetDate);
			int tmp = calendar.get(Calendar.DATE);
			calendar.set(Calendar.DATE, tmp + step);
			nextDate = new SimpleDateFormat(DATESTRING).format(calendar.getTime());
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		}
		return nextDate;
	}

	/**
	 * 获取随机的4位整数
	 * 
	 * @author Casper
	 * @date 2018年6月27日 下午4:07:02
	 * @param n
	 * @return
	 */
	public static int getRandomIntNumber() {
		return randomer.nextInt(9000) + 1000;
	}

	/**
	 * 获取随机最大值为n整数
	 * 
	 * @author Casper
	 * @date 2018年6月27日 下午4:07:02
	 * @param n
	 * @return
	 */
	public static int getRandomIntNumber(int n) {
		return randomer.nextInt(n);
	}

	/**
	 * 获取随机4位长的字符串
	 * 
	 * @author Casper
	 * @date 2018年6月27日 下午3:50:34
	 * @return
	 */
	public static String getRandomNumberString() {
		return String.valueOf(randomer.nextInt(9000) + 1000);
	}

	/**
	 * 获取随机最大值为n的字符串
	 * 
	 * @author Casper
	 * @date 2018年6月27日 下午3:50:34
	 * @return
	 */
	public static String getRandomNumberString(int n) {
		return String.valueOf(randomer.nextInt(n));
	}

	/**
	 * 计算开始日期到结束日期的相距天数
	 * 
	 * @author Casper
	 * @date 2018年7月13日 下午3:05:04
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 */
	public static int getDayDifference(String startDate, String endDate) {
//		SimpleDateFormat simpleFormat = new SimpleDateFormat(DATESTRING);
//		long from1 = 0;
//		long to1 = 0;
//		try {
//			Date fromDate1 = simpleFormat.parse(startDate);
//			Date toDate1 = simpleFormat.parse(endDate);
//			from1 = fromDate1.getTime();
//			to1 = toDate1.getTime();
//		} catch (ParseException e) {
//			log.error(e.getMessage(), e);
//		}

//		return (int) ((to1 - from1) / (1000 * 60 * 60 * 24));
		return (int) getDayDiffernece(startDate, endDate, DATESTRING)+1;
	}

	/**
	 * 计算开始日期到结束日期的相距天数，精确到小时
	 * 
	 * @author Casper
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @return
	 */
	public static double getDayDifferenceF(String startDate, String endDate) {
		return getDayDiffernece(startDate, endDate, DATETIMESTRING);
	}

	public static double getDayDiffernece(String startDate, String endDate, String formatString) {
		if (startDate.length() < 19)
			startDate += " 00:00:00";
		if (endDate.length() < 19)
			endDate += " 00:00:00";
		SimpleDateFormat simpleFormat = new SimpleDateFormat(formatString);
		long from1 = 0;
		long to1 = 0;
		try {
			Date fromDate1 = simpleFormat.parse(startDate);
			Date toDate1 = simpleFormat.parse(endDate);
			from1 = fromDate1.getTime();
			to1 = toDate1.getTime();
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		}
		return ((to1 - from1) * 1.0 / (1000 * 60 * 60 * 24));
	}

	public static int mapDayIndex(String dateTime) {
		if (dateTime.length() < 19)
			return 0;
		String target =  new StringBuilder(dateTime.split(" ")[0]).append(" 12:00:00").toString();

		double index = getDayDifferenceF(dateTime, target);
		if (index < 0)
			return 2;
		else
			return 1;
	}

}
