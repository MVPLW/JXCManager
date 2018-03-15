package cn.jxc.pojo;
// Generated 2018-3-14 20:32:32 by Hibernate Tools 5.2.8.Final

import java.util.HashSet;
import java.util.Set;

/**
 * 客户实体 包涵:
 */
public class Customer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int customerId;
	private String cusName;
	private String cusAddress;
	private String cusPhone;
	private String postalCode;
	private String cusContact;
	/**
	 * 客户的订单表
	 */
	private Set<SalesOrder> salesorders = new HashSet<SalesOrder>(0);
	
	/**
	 * 客户付款信息
	 */
	private Set<CustomerPayment> customerpayments = new HashSet<CustomerPayment>(0);

	public Customer() {
		
	}

	public Customer(int customerId, String cusName, String cusAddress, String cusPhone) {
		this.customerId = customerId;
		this.cusName = cusName;
		this.cusAddress = cusAddress;
		this.cusPhone = cusPhone;
	}

	public Customer(int customerId, String cusName, String cusAddress, String cusPhone, String postalCode,
			String cusContact, Set<SalesOrder> salesorders, Set<CustomerPayment> customerpayments) {
		this.customerId = customerId;
		this.cusName = cusName;
		this.cusAddress = cusAddress;
		this.cusPhone = cusPhone;
		this.postalCode = postalCode;
		this.cusContact = cusContact;
		this.salesorders = salesorders;
		this.customerpayments = customerpayments;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCusName() {
		return this.cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusAddress() {
		return this.cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	public String getCusPhone() {
		return this.cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCusContact() {
		return this.cusContact;
	}

	public void setCusContact(String cusContact) {
		this.cusContact = cusContact;
	}

	public Set<SalesOrder> getSalesorders() {
		return this.salesorders;
	}

	public void setSalesorders(Set<SalesOrder> salesorders) {
		this.salesorders = salesorders;
	}

	public Set<CustomerPayment> getCustomerpayments() {
		return this.customerpayments;
	}

	public void setCustomerpayments(Set<CustomerPayment> customerpayments) {
		this.customerpayments = customerpayments;
	}

}
