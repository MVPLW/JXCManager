package cn.jxc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.jxc.excel.ExcelField;

/**
 * 调拨单据
 */
public class Requisition implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ExcelField(title = "调拨单号", align = 2)
	private String requisitionId;//调拨订单号
	@ExcelField(title = "审核人", align = 2, value = "employeeByReviewEmp.empLoginName")
	private Employee employeeByReviewEmp;//审核人
	@ExcelField(title = "入库人", align = 2, value = "employeeByStorageStoreHouseEmp.empLoginName")
	private Employee employeeByStorageStoreHouseEmp;//入库人
	@ExcelField(title = "申请人", align = 2, value = "employeeByRequestEmp.empLoginName")
	private Employee employeeByRequestEmp;//申请人
	@ExcelField(title = "出库人", align = 2, value = "employeeByOutboundEmp.empLoginName")
	private Employee employeeByOutboundEmp;//出库人
	@ExcelField(title = "审核状态", align = 2, value = "reviewstatus.rsName")
	private ReviewStatus reviewstatus;//审核状态
	@ExcelField(title = "出库仓库", align = 2, value = "storehouseByOutboundStoreHouse.shName")
	private StoreHouse storehouseByOutboundStoreHouse;//出库仓库
	@ExcelField(title = "入库仓库", align = 2, value = "storehouseByStorageStoreHouse.shName")
	private StoreHouse storehouseByStorageStoreHouse;//入库仓库
	@ExcelField(title = "申请时间", align = 2)
	private Date requestTime;//申请时间
	@ExcelField(title = "审核时间", align = 2)
	private Date reviewTime;//审核时间
	@ExcelField(title = "出库时间", align = 2)
	private Date outboundStoreHouseTime;//出库时间
	@ExcelField(title = "入库时间", align = 2)
	private Date storageStoreHouseTime;//入库时间
	@ExcelField(title = "审核备注", align = 2)
	private String reason;//审核备注
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	//private Set<RequisitionDetail> requisitiondetails = new HashSet<RequisitionDetail>(0);
	private List<RequisitionDetail>  requisitiondetails = new ArrayList<RequisitionDetail>();
	public List<RequisitionDetail> getRequisitiondetails() {
		return requisitiondetails;
	}

	public void setRequisitiondetails(List<RequisitionDetail> requisitiondetails) {
		this.requisitiondetails = requisitiondetails;
	}

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
			Date reviewTime, Date outboundStoreHouseTime, Date storageStoreHouseTime, List<RequisitionDetail> requisitiondetails) {
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

	

}
