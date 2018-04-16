package cn.jxc.test;

import org.junit.jupiter.api.Test;

import cn.jxc.util.OrderGenerator;

public class ding {
	
	@Test
	public void a() {
		String aString=OrderGenerator.getOrderNo("CG");
		System.out.println(aString);
	}
	
}
