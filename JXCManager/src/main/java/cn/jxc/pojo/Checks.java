package cn.jxc.pojo;

import java.io.Serializable;
import java.util.Date;

import cn.jxc.util.OrderStatus;

public class Checks implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int cid;
	private String crelationno;
	private int ctype;
	private String ccreater;
	private Date createStartDate;
	private Date createEndDate;
	private OrderStatus orderStatus;

	public int getCid() {
		
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCrelationno() {
		return crelationno;
	}

	public void setCrelationno(String crelationno) {
		this.crelationno = crelationno;
	}

	public int getCtype() {
		return ctype;
	}

	public void setCtype(int ctype) {
		this.ctype = ctype;
	}

	public String getCcreater() {
		return ccreater;
	}

	public void setCcreater(String ccreater) {
		this.ccreater = ccreater;
	}

	public Date getCreateStartDate() {
		return createStartDate;
	}

	public void setCreateStartDate(Date createStartDate) {
		this.createStartDate = createStartDate;
	}

	public Date getCreateEndDate() {
		return createEndDate;
	}

	public void setCreateEndDate(Date createEndDate) {
		this.createEndDate = createEndDate;
	}
}
