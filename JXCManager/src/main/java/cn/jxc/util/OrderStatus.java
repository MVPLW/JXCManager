package cn.jxc.util;

/**
 * 订单状态
 * 
 * @author Administrator
 *
 */
public enum OrderStatus {
	
	createOrder(1,"创建订单"),
	cancelOrder(2,"订单取消"),
	reviewing(3,"订单审核中"),
	reviewOk(4,"审核通过"),
	reviewRefuse(5,"审核拒绝"),
	purchaseing(6,"采购中"),
	storage(7,"全部入库");
	
	private int no;
	
	private String orderType;
	
	private OrderStatus (int no,String orderType) {
		this.orderType=orderType;
		this.no=no;
	}
	
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return orderType;
	}
	
}
