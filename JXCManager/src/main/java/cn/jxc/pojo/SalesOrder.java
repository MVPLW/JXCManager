package cn.jxc.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * œ˙ €∂©µ•
 */
public class SalesOrder implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String soId;
	private Customer customer;
	private Employee employeeByEmployeeId;
	private Employee employeeByReviewEmpId;
	private ReviewStatus reviewstatus;
 	private Date salesTime;
	private long salesPrice;
	private Date reviewDate;
	
	private Set<SalesOrderDetail> salesorderdetails = new HashSet<SalesOrderDetail>(0);
	private Set<CustomerPayment> customerpayments = new HashSet<CustomerPayment>(0);

	public SalesOrder() {
	}

	public SalesOrder(String soId, Customer customer, Employee employeeByEmployeeId, Date salesTime, long salesPrice) {
		this.soId = soId;
		this.customer = customer;
		this.employeeByEmployeeId = employeeByEmployeeId;
		this.salesTime = salesTime;
		this.salesPrice = salesPrice;
	}

	public SalesOrder(String soId, Customer customer, Employee employeeByEmployeeId, Employee employeeByReviewEmpId,
			ReviewStatus reviewstatus, Date salesTime, long salesPrice, Date reviewDate, Set<SalesOrderDetail> salesorderdetails,
			Set<CustomerPayment> customerpayments) {
		this.soId = soId;
		this.customer = customer;
		this.employeeByEmployeeId = employeeByEmployeeId;
		this.employeeByReviewEmpId = employeeByReviewEmpId;
		this.reviewstatus = reviewstatus;
		this.salesTime = salesTime;
		this.salesPrice = salesPrice;
		this.reviewDate = reviewDate;
		this.salesorderdetails = salesorderdetails;
		this.customerpayments = customerpayments;
	}

	public String getSoId() {
		return this.soId;
	}

	public void setSoId(String soId) {
		this.soId = soId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployeeByEmployeeId() {
		return this.employeeByEmployeeId;
	}

	public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
		this.employeeByEmployeeId = employeeByEmployeeId;
	}

	public Employee getEmployeeByReviewEmpId() {
		return this.employeeByReviewEmpId;
	}

	public void setEmployeeByReviewEmpId(Employee employeeByReviewEmpId) {
		this.employeeByReviewEmpId = employeeByReviewEmpId;
	}

	public ReviewStatus getReviewstatus() {
		return this.reviewstatus;
	}

	public void setReviewstatus(ReviewStatus reviewstatus) {
		this.reviewstatus = reviewstatus;
	}

	public Date getSalesTime() {
		return this.salesTime;
	}

	public void setSalesTime(Date salesTime) {
		this.salesTime = salesTime;
	}

	public long getSalesPrice() {
		return this.salesPrice;
	}

	public void setSalesPrice(long salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Date getReviewDate() {
		return this.reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Set<SalesOrderDetail> getSalesorderdetails() {
		return this.salesorderdetails;
	}

	public void setSalesorderdetails(Set<SalesOrderDetail> salesorderdetails) {
		this.salesorderdetails = salesorderdetails;
	}

	public Set<CustomerPayment> getCustomerpayments() {
		return this.customerpayments;
	}

	public void setCustomerpayments(Set<CustomerPayment> customerpayments) {
		this.customerpayments = customerpayments;
	}

}
