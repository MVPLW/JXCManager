package cn.jxc.pojo;
// Generated 2018-3-14 20:32:32 by Hibernate Tools 5.2.8.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * µ÷²¦µ¥¾Ý
 */
public class Requisition implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String requisitionId;
	private Employee employeeByReviewEmp;
	private Employee employeeByStorageStoreHouseEmp;
	private Employee employeeByRequestEmp;
	private Employee employeeByOutboundEmp;
	private ReviewStatus reviewstatus;
	private StoreHouse storehouseByOutboundStoreHouse;
	private StoreHouse storehouseByStorageStoreHouse;
	private Date requestTime;
	private Date reviewTime;
	private Date outboundStoreHouseTime;
	private Date storageStoreHouseTime;
	
	private Set<RequisitionDetail> requisitiondetails = new HashSet<RequisitionDetail>(0);

	public Requisition() {
	}

	public Requisition(String requisitionId, Employee employeeByRequestEmp, Date requestTime) {
		this.requisitionId = requisitionId;
		this.employeeByRequestEmp = employeeByRequestEmp;
		this.requestTime = requestTime;
	}

	public Requisition(String requisitionId, Employee employeeByReviewEmp, Employee employeeByStorageStoreHouseEmp,
			Employee employeeByRequestEmp, Employee employeeByOutboundEmp, ReviewStatus reviewstatus,
			StoreHouse storehouseByOutboundStoreHouse, StoreHouse storehouseByStorageStoreHouse, Date requestTime,
			Date reviewTime, Date outboundStoreHouseTime, Date storageStoreHouseTime, Set<RequisitionDetail> requisitiondetails) {
		this.requisitionId = requisitionId;
		this.employeeByReviewEmp = employeeByReviewEmp;
		this.employeeByStorageStoreHouseEmp = employeeByStorageStoreHouseEmp;
		this.employeeByRequestEmp = employeeByRequestEmp;
		this.employeeByOutboundEmp = employeeByOutboundEmp;
		this.reviewstatus = reviewstatus;
		this.storehouseByOutboundStoreHouse = storehouseByOutboundStoreHouse;
		this.storehouseByStorageStoreHouse = storehouseByStorageStoreHouse;
		this.requestTime = requestTime;
		this.reviewTime = reviewTime;
		this.outboundStoreHouseTime = outboundStoreHouseTime;
		this.storageStoreHouseTime = storageStoreHouseTime;
		this.requisitiondetails = requisitiondetails;
	}

	public String getRequisitionId() {
		return this.requisitionId;
	}

	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}

	public Employee getEmployeeByReviewEmp() {
		return this.employeeByReviewEmp;
	}

	public void setEmployeeByReviewEmp(Employee employeeByReviewEmp) {
		this.employeeByReviewEmp = employeeByReviewEmp;
	}

	public Employee getEmployeeByStorageStoreHouseEmp() {
		return this.employeeByStorageStoreHouseEmp;
	}

	public void setEmployeeByStorageStoreHouseEmp(Employee employeeByStorageStoreHouseEmp) {
		this.employeeByStorageStoreHouseEmp = employeeByStorageStoreHouseEmp;
	}

	public Employee getEmployeeByRequestEmp() {
		return this.employeeByRequestEmp;
	}

	public void setEmployeeByRequestEmp(Employee employeeByRequestEmp) {
		this.employeeByRequestEmp = employeeByRequestEmp;
	}

	public Employee getEmployeeByOutboundEmp() {
		return this.employeeByOutboundEmp;
	}

	public void setEmployeeByOutboundEmp(Employee employeeByOutboundEmp) {
		this.employeeByOutboundEmp = employeeByOutboundEmp;
	}

	public ReviewStatus getReviewstatus() {
		return this.reviewstatus;
	}

	public void setReviewstatus(ReviewStatus reviewstatus) {
		this.reviewstatus = reviewstatus;
	}

	public StoreHouse getStorehouseByOutboundStoreHouse() {
		return this.storehouseByOutboundStoreHouse;
	}

	public void setStorehouseByOutboundStoreHouse(StoreHouse storehouseByOutboundStoreHouse) {
		this.storehouseByOutboundStoreHouse = storehouseByOutboundStoreHouse;
	}

	public StoreHouse getStorehouseByStorageStoreHouse() {
		return this.storehouseByStorageStoreHouse;
	}

	public void setStorehouseByStorageStoreHouse(StoreHouse storehouseByStorageStoreHouse) {
		this.storehouseByStorageStoreHouse = storehouseByStorageStoreHouse;
	}

	public Date getRequestTime() {
		return this.requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public Date getReviewTime() {
		return this.reviewTime;
	}

	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}

	public Date getOutboundStoreHouseTime() {
		return this.outboundStoreHouseTime;
	}

	public void setOutboundStoreHouseTime(Date outboundStoreHouseTime) {
		this.outboundStoreHouseTime = outboundStoreHouseTime;
	}

	public Date getStorageStoreHouseTime() {
		return this.storageStoreHouseTime;
	}

	public void setStorageStoreHouseTime(Date storageStoreHouseTime) {
		this.storageStoreHouseTime = storageStoreHouseTime;
	}

	public Set<RequisitionDetail> getRequisitiondetails() {
		return this.requisitiondetails;
	}

	public void setRequisitiondetails(Set<RequisitionDetail> requisitiondetails) {
		this.requisitiondetails = requisitiondetails;
	}

}
