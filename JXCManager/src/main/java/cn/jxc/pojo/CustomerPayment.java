package cn.jxc.pojo;

import java.util.Date;

/**
 * 客户付款单    包含 销售人  销售订单  首款金额 时间 状态  尾款 金额 时间 状态
 */
public class CustomerPayment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int cpId;
	private Customer customer;
	private SalesOrder salesorder;
	private String fpaymentAmount;
	private Date fpaymentTime;
	private String fpaymentStatus;
	private String lpaymentAmount;
	private Date lpaymentTime;
	private String lpaymentStatus;

	public CustomerPayment() {
		
	}

	public CustomerPayment(int cpId, Customer customer, SalesOrder salesorder) {
		this.cpId = cpId;
		this.customer = customer;
		this.salesorder = salesorder;
	}

	public CustomerPayment(int cpId, Customer customer, SalesOrder salesorder, String fpaymentAmount, Date fpaymentTime,
			String fpaymentStatus, String lpaymentAmount, Date lpaymentTime, String lpaymentStatus) {
		this.cpId = cpId;
		this.customer = customer;
		this.salesorder = salesorder;
		this.fpaymentAmount = fpaymentAmount;
		this.fpaymentTime = fpaymentTime;
		this.fpaymentStatus = fpaymentStatus;
		this.lpaymentAmount = lpaymentAmount;
		this.lpaymentTime = lpaymentTime;
		this.lpaymentStatus = lpaymentStatus;
	}

	public int getCpId() {
		return this.cpId;
	}

	public void setCpId(int cpId) {
		this.cpId = cpId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public SalesOrder getSalesorder() {
		return this.salesorder;
	}

	public void setSalesorder(SalesOrder salesorder) {
		this.salesorder = salesorder;
	}

	public String getFpaymentAmount() {
		return this.fpaymentAmount;
	}

	public void setFpaymentAmount(String fpaymentAmount) {
		this.fpaymentAmount = fpaymentAmount;
	}

	public Date getFpaymentTime() {
		return this.fpaymentTime;
	}

	public void setFpaymentTime(Date fpaymentTime) {
		this.fpaymentTime = fpaymentTime;
	}

	public String getFpaymentStatus() {
		return this.fpaymentStatus;
	}

	public void setFpaymentStatus(String fpaymentStatus) {
		this.fpaymentStatus = fpaymentStatus;
	}

	public String getLpaymentAmount() {
		return this.lpaymentAmount;
	}

	public void setLpaymentAmount(String lpaymentAmount) {
		this.lpaymentAmount = lpaymentAmount;
	}

	public Date getLpaymentTime() {
		return this.lpaymentTime;
	}

	public void setLpaymentTime(Date lpaymentTime) {
		this.lpaymentTime = lpaymentTime;
	}

	public String getLpaymentStatus() {
		return this.lpaymentStatus;
	}

	public void setLpaymentStatus(String lpaymentStatus) {
		this.lpaymentStatus = lpaymentStatus;
	}

}
