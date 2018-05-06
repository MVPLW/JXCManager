package cn.jxc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.jxc.excel.ExcelField;
import cn.jxc.util.OrderStatus;

/**
 * 采购申请单据
 */
public class PurchaseRequest implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ExcelField(title = "采购申请单号", align = 2)
	private String purchaseRequestId;
	@ExcelField(title = "申请人", align = 2, value = "employeeByRequestEmpId.empLoginName")
	private Employee employeeByRequestEmpId;
	@ExcelField(title = "供货商", align = 2, value = "supplier.suppName")
	private Supplier supplier;
	@ExcelField(title = "联系人", align = 2)
	private String suppContact;
	@ExcelField(title = "联系电话", align = 2)
	private String suppPhone;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@ExcelField(title = "申请时间", align = 2)
	private Date requestTime;
	@ExcelField(title = "备注", align = 2)
	private String remark;

	private OrderStatus orderStatus;

	@ExcelField(title = "部门审核人", align = 2, value = "employeeByDeptReviewEmp.empLoginName")
	private Employee employeeByDeptReviewEmp;
	@ExcelField(title = "部门审核状态", align = 2, value = "reviewstatusByDeptReviewStatus.rsName")
	private ReviewStatus reviewstatusByDeptReviewStatus;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ExcelField(title = "部门审核时间", align = 2)
	private Date deptReviewTime;
	@ExcelField(title = "部门审核原因", align = 2)
	private String deptReviewReason;// 部门审核原因

	@ExcelField(title = "财务审核人", align = 2, value = "employeeByFinancialAuditEmp.empLoginName")
	private Employee employeeByFinancialAuditEmp;
	@ExcelField(title = "财务审核状态", align = 2, value = "reviewstatusByFinancialAuditStatus.rsName")
	private ReviewStatus reviewstatusByFinancialAuditStatus;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ExcelField(title = "财务审核时间", align = 2)
	private Date financialAuditTime;
	@ExcelField(title = "财务审核原因", align = 2)
	private String financialAuditReason;// 财务审核原因

	// 存放当前订单中明细
	private List<PurchaseRequestDetail> purchaserequestdetails = new ArrayList<PurchaseRequestDetail>(0);

	private List<PurchasePaymentSlip> purchasepaymentslips = new ArrayList<PurchasePaymentSlip>(0);

	public PurchaseRequest() {

	}

	public PurchaseRequest(String purchaseRequestId, Employee employeeByRequestEmpId, Supplier supplier,
			Date requestTime, String remark, OrderStatus orderStatus) {
		super();
		this.purchaseRequestId = purchaseRequestId;
		this.employeeByRequestEmpId = employeeByRequestEmpId;
		this.supplier = supplier;
		this.requestTime = requestTime;
		this.remark = remark;
		this.orderStatus = orderStatus;
	}

	public PurchaseRequest(String purchaseRequestId, Employee employeeByFinancialAuditEmp,
			Employee employeeByRequestEmpId, Employee employeeByDeptReviewEmp,
			ReviewStatus reviewstatusByDeptReviewStatus, ReviewStatus reviewstatusByFinancialAuditStatus,
			Supplier supplier, String suppContact, String suppPhone, Date requestTime, Date deptReviewTime,
			Date financialAuditTime, String remark, List<PurchaseRequestDetail> purchaserequestdetails,
			List<PurchasePaymentSlip> purchasepaymentslips, OrderStatus orderStatus, String deptReviewReason,
			String financialAuditReason) {
		super();
		this.purchaseRequestId = purchaseRequestId;
		this.employeeByFinancialAuditEmp = employeeByFinancialAuditEmp;
		this.employeeByRequestEmpId = employeeByRequestEmpId;
		this.employeeByDeptReviewEmp = employeeByDeptReviewEmp;
		this.reviewstatusByDeptReviewStatus = reviewstatusByDeptReviewStatus;
		this.reviewstatusByFinancialAuditStatus = reviewstatusByFinancialAuditStatus;
		this.supplier = supplier;
		this.suppContact = suppContact;
		this.suppPhone = suppPhone;
		this.requestTime = requestTime;
		this.deptReviewTime = deptReviewTime;
		this.financialAuditTime = financialAuditTime;
		this.remark = remark;
		this.purchaserequestdetails = purchaserequestdetails;
		this.purchasepaymentslips = purchasepaymentslips;
		this.orderStatus = orderStatus;
		this.deptReviewReason = deptReviewReason;
		this.financialAuditReason = financialAuditReason;
	}

	public String getPurchaseRequestId() {
		return this.purchaseRequestId;
	}

	public void setPurchaseRequestId(String purchaseRequestId) {
		this.purchaseRequestId = purchaseRequestId;
	}

	public Employee getEmployeeByFinancialAuditEmp() {
		return this.employeeByFinancialAuditEmp;
	}

	public void setEmployeeByFinancialAuditEmp(Employee employeeByFinancialAuditEmp) {
		this.employeeByFinancialAuditEmp = employeeByFinancialAuditEmp;
	}

	public Employee getEmployeeByRequestEmpId() {
		return this.employeeByRequestEmpId;
	}

	public void setEmployeeByRequestEmpId(Employee employeeByRequestEmpId) {
		this.employeeByRequestEmpId = employeeByRequestEmpId;
	}

	public Employee getEmployeeByDeptReviewEmp() {
		return this.employeeByDeptReviewEmp;
	}

	public void setEmployeeByDeptReviewEmp(Employee employeeByDeptReviewEmp) {
		this.employeeByDeptReviewEmp = employeeByDeptReviewEmp;
	}

	public ReviewStatus getReviewstatusByDeptReviewStatus() {
		return this.reviewstatusByDeptReviewStatus;
	}

	public void setReviewstatusByDeptReviewStatus(ReviewStatus reviewstatusByDeptReviewStatus) {
		this.reviewstatusByDeptReviewStatus = reviewstatusByDeptReviewStatus;
	}

	public ReviewStatus getReviewstatusByFinancialAuditStatus() {
		return this.reviewstatusByFinancialAuditStatus;
	}

	public void setReviewstatusByFinancialAuditStatus(ReviewStatus reviewstatusByFinancialAuditStatus) {
		this.reviewstatusByFinancialAuditStatus = reviewstatusByFinancialAuditStatus;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Date getRequestTime() {
		return this.requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public Date getDeptReviewTime() {
		return this.deptReviewTime;
	}

	public void setDeptReviewTime(Date deptReviewTime) {
		this.deptReviewTime = deptReviewTime;
	}

	public Date getFinancialAuditTime() {
		return this.financialAuditTime;
	}

	public void setFinancialAuditTime(Date financialAuditTime) {
		this.financialAuditTime = financialAuditTime;
	}

	public List<PurchasePaymentSlip> getPurchasepaymentslips() {
		return this.purchasepaymentslips;
	}

	public void setPurchasepaymentslips(List<PurchasePaymentSlip> purchasepaymentslips) {
		this.purchasepaymentslips = purchasepaymentslips;
	}

	public List<PurchaseRequestDetail> getPurchaserequestdetails() {
		return this.purchaserequestdetails;
	}

	public void setPurchaserequestdetails(List<PurchaseRequestDetail> purchaserequestdetails) {
		this.purchaserequestdetails = purchaserequestdetails;
	}

	public String getSuppContact() {
		return suppContact;
	}

	public void setSuppContact(String suppContact) {
		this.suppContact = suppContact;
	}

	public String getSuppPhone() {
		return suppPhone;
	}

	public void setSuppPhone(String suppPhone) {
		this.suppPhone = suppPhone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getDeptReviewReason() {
		return deptReviewReason;
	}

	public void setDeptReviewReason(String deptReviewReason) {
		this.deptReviewReason = deptReviewReason;
	}

	public String getFinancialAuditReason() {
		return financialAuditReason;
	}

	public void setFinancialAuditReason(String financialAuditReason) {
		this.financialAuditReason = financialAuditReason;
	}

}
