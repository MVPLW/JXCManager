package cn.jxc.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 随机生成订单号
 * @author Administrator
 *
 */
public class OrderGenerator {
	
	private static String getLetter(String type) {
		String randomcode = "";
		Random random=new Random();
		for (int i = 0; i < 4; i++) {
			// 52个字母与6个大小写字母间的符号；范围为91~96
			int value = random.nextInt(26)+65;
			randomcode = randomcode + (char) value;
		}
		return type+randomcode;
	}
	
	private static String getNumber() {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MMddhhmmsss");
		return simpleDateFormat.format(new Date())+String.valueOf( (int)((Math.random()*9+1)*1000));
	}
	/**
	 * 随机生成订单号
	 * 采购付款单-采购申请单-入库单-调拨单-销售订单-客户付款单- 出库单
	 * @param type 生成的哪种单据
	 * @return
	 */
	public static String getOrderNo(String type) {
		return getLetter(type)+getNumber();
	}
	
}
