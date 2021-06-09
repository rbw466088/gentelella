package cn.appsys.tools;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Util {
	
	/**
	 * ����ָ����ʽ���ַ���
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String StringConvert(String str) throws Exception {
		return new String(str.getBytes("ISO8859-1"), "UTF-8");
		// GBK GB2312 GB18030 Big5 utf-8
	}

	/**
	 * �����ڸ�ʽת��Ϊ�ַ���
	 * 
	 * @param date
	 * @return date
	 */
	public static String DateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * ���ַ���ת��Ϊ���ڸ�ʽ
	 * 
	 * @param str
	 * @return str
	 * @throws Exception
	 */
	public static Date parseDate(String dateStr){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date parse = format.parse(dateStr);
			Date date = new Date(parse.getTime());
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getDateTime() {
		String nowTime=null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			nowTime = format.format(new java.util.Date()).toString();
			return nowTime;
		} catch (Exception e) {
			e.printStackTrace();
			return nowTime;
		}		
	}

}

