package cn.jxc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateConverter {

	private static SimpleDateFormat[] formats = { new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyy-MM-dd"), new SimpleDateFormat("yyyy/MM/dd"),
			new SimpleDateFormat("yyyy/MM/dd"), new SimpleDateFormat("yyyyƒÍMM‘¬dd»’"),
			new SimpleDateFormat("MM/dd/yyyy")};

	public static Date convertFromString(String date) {
		if (date==null || date=="") {
			return null;
		}
		for (SimpleDateFormat simpleDateFormat : formats) {
			try {
				return simpleDateFormat.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public String convertToString(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	public static String convertStringyyyy(String date) {
		try {
			String month=date.substring(0, date.indexOf('/'));
			String day=date.substring(date.indexOf('/')+1,date.lastIndexOf('/'));
			String year=date.substring(date.lastIndexOf('/')+1);
			return year+"-"+month+"-"+day;
		} catch (Exception e) {
			return null;
		}
		
	}

}
