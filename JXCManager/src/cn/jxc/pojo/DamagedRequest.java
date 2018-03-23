package cn.jxc.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * ±¨Ëðµ¥¾Ý
 */
public class DamagedRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String damagedRequestId;
	private Employee requestEmp;
	private Date requestTime;
	private StoreHouse damagedStoreHouse;
	private ReviewStatus deptReviewStatus;
	private Employee deptReviewEmp;
	private Date deptReviewTime;
	private String damagedReason;
	private String remark;
	
	public DamagedRequest() {
		super();
	}
	
	public DamagedRequest(String damagedRequestId, Employee requestEmp, Date requestTime, StoreHouse damagedStoreHouse,
			ReviewStatus deptReviewStatus, Employee deptReviewEmp, Date deptReviewTime, String damagedReason,
			String remark) {
		super();
		this.damagedRequestId = damagedRequestId;
		this.requestEmp = requestEmp;
		this.requestTime = requestTime;
		this.damagedStoreHouse = damagedStoreHouse;
		this.deptReviewStatus = deptReviewStatus;
		this.deptReviewEmp = deptReviewEmp;
		this.deptReviewTime = deptReviewTime;
		this.damagedReason = damagedReason;
		this.remark = remark;
	}
	
	public String getDamagedRequestId() {
		return damagedRequestId;
	}
	
	public void setDamagedRequestId(String damagedRequestId) {
		this.damagedRequestId = damagedRequestId;
	}
	
	public Employee getRequestEmp() {
		return requestEmp;
	}
	
	public void setRequestEmp(Employee requestEmp) {
		this.requestEmp = requestEmp;
	}
	
	public Date getRequestTime() {
		return requestTime;
	}
	
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	
	public StoreHouse getDamagedStoreHouse() {
		return damagedStoreHouse;
	}
	
	public void setDamagedStoreHouse(StoreHouse damagedStoreHouse) {
		this.damagedStoreHouse = damagedStoreHouse;
	}
	
	public ReviewStatus getDeptReviewStatus() {
		return deptReviewStatus;
	}
	
	public void setDeptReviewStatus(ReviewStatus deptReviewStatus) {
		this.deptReviewStatus = deptReviewStatus;
	}
	
	public Employee getDeptReviewEmp() {
		return deptReviewEmp;
	}
	
	public void setDeptReviewEmp(Employee deptReviewEmp) {
		this.deptReviewEmp = deptReviewEmp;
	}
	
	public Date getDeptReviewTime() {
		return deptReviewTime;
	}
	
	public void setDeptReviewTime(Date deptReviewTime) {
		this.deptReviewTime = deptReviewTime;
	}
	
	public String getDamagedReason() {
		return damagedReason;
	}
	
	public void setDamagedReason(String damagedReason) {
		this.damagedReason = damagedReason;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
