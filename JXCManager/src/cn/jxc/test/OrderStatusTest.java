package cn.jxc.test;

import org.junit.Test;

import cn.jxc.util.OrderStatus;

public class OrderStatusTest {
	@Test
	public void a() {
		OrderStatus orderStatus = OrderStatus.cancelOrder;
		System.out.println(orderStatus.getOrderType());
		System.out.println(orderStatus.toString());
	}
}
