package cn.jxc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Èë¿âµ¥ 
 */
public class EnterStock implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String enterStockId;
	private Employee employee;
	private EnterStockType enterstocktype;
	private StoreHouse storehouse;
	private Date enterDate;
	private String upstreamNo;
	private Employee reviewEmp;
	private Date reviewDate;
	private ReviewStatus reviewStatus;
	private String reviewReason;
	private String remark;
	
	private List<EnterStockDetail> enterstockdetails = new ArrayList<EnterStockDetail>(0);

	public EnterStock() {
		super();
	}

	public EnterStock(String enterStockId, Employee employee, EnterStockType enterstocktype, StoreHouse storehouse,
			Date enterDate, String upstreamNo, Employee reviewEmp, Date reviewDate, ReviewStatus reviewStatus,
			String reviewReason, String remark) {
		super();
		this.enterStockId = enterStockId;
		this.employee = employee;
		this.enterstocktype = enterstocktype;
		this.storehouse = storehouse;
		this.enterDate = enterDate;
		this.upstreamNo = upstreamNo;
		this.reviewEmp = reviewEmp;
		this.reviewDate = reviewDate;
		this.reviewStatus = reviewStatus;
		this.reviewReason = reviewReason;
		this.remark = remark;
	}

	public EnterStock(String enterStockId, Employee employee, EnterStockType enterstocktype, StoreHouse storehouse,
			Date enterDate, String upstreamNo, Employee reviewEmp, Date reviewDate, ReviewStatus reviewStatus,
			String reviewReason, String remark, List<EnterStockDetail> enterstockdetails) {
		super();
		this.enterStockId = enterStockId;
		this.employee = employee;
		this.enterstocktype = enterstocktype;
		this.storehouse = storehouse;
		this.enterDate = enterDate;
		this.upstreamNo = upstreamNo;
		this.reviewEmp = reviewEmp;
		this.reviewDate = reviewDate;
		this.reviewStatus = reviewStatus;
		this.reviewReason = reviewReason;
		this.remark = remark;
		this.enterstockdetails = enterstockdetails;
	}

	public String getEnterStockId() {
		return this.enterStockId;
	}

	public void setEnterStockId(String enterStockId) {
		this.enterStockId = enterStockId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EnterStockType getEnterstocktype() {
		return this.enterstocktype;
	}

	public void setEnterstocktype(EnterStockType enterstocktype) {
		this.enterstocktype = enterstocktype;
	}

	public StoreHouse getStorehouse() {
		return this.storehouse;
	}

	public void setStorehouse(StoreHouse storehouse) {
		this.storehouse = storehouse;
	}

	public Date getEnterDate() {
		return this.enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public String getUpstreamNo() {
		return this.upstreamNo;
	}

	public void setUpstreamNo(String upstreamNo) {
		this.upstreamNo = upstreamNo;
	}

	public List<EnterStockDetail> getEnterstockdetails() {
		return this.enterstockdetails;
	}

	public void setEnterstockdetails(List<EnterStockDetail> enterstockdetails) {
		this.enterstockdetails = enterstockdetails;
	}

	public Employee getReviewEmp() {
		return reviewEmp;
	}

	public void setReviewEmp(Employee reviewEmp) {
		this.reviewEmp = reviewEmp;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public ReviewStatus getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(ReviewStatus reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public String getReviewReason() {
		return reviewReason;
	}

	public void setReviewReason(String reviewReason) {
		this.reviewReason = reviewReason;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
