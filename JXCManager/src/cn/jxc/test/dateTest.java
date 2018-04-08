package cn.jxc.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;


import cn.jxc.util.DateConverter;

public class dateTest {
	@Test
	public void a() {
		String aString="04/05/1988";
		Date convertFromString = DateConverter.convertFromString(aString);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(convertFromString));
//		
//		String convertStringyyyy = DateConverter.convertStringyyyy(aString);
//		System.out.println(convertStringyyyy);
	}
}
