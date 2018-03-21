package cn.jxc.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 采购申请单据
 */
public class PurchaseRequest implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String purchaseRequestId;
	private Employee employeeByFinancialAuditEmp;
	private Employee employeeByPrepaymentReviewEmp;
	private Employee employeeByRequestEmpId;
	private Employee employeeByDeptReviewEmp;
	private ReviewStatus reviewstatusByPrepaymentReviewStatus;
	private ReviewStatus reviewstatusByDeptReviewStatus;
	private ReviewStatus reviewstatusByFinancialAuditStatus;
	private Supplier supplier;
	private Date requestTime;
	private Date deptReviewTime;
	private Date prepaymentReviewTime;
	private Date financialAuditTime;
	//存放当前订单中明细
	private Set<PurchaseRequestDetail> purchaserequestdetails = new HashSet<PurchaseRequestDetail>(0);

	private Set<PurchasePaymentSlip> purchasepaymentslips = new HashSet<PurchasePaymentSlip>(0);

	public PurchaseRequest() {
	}

	public PurchaseRequest(String purchaseRequestId, Employee employeeByRequestEmpId, Supplier supplier,
			Date requestTime) {
		this.purchaseRequestId = purchaseRequestId;
		this.employeeByRequestEmpId = employeeByRequestEmpId;
		this.supplier = supplier;
		this.requestTime = requestTime;
	}

	public PurchaseRequest(String purchaseRequestId, Employee employeeByFinancialAuditEmp,
			Employee employeeByPrepaymentReviewEmp, Employee employeeByRequestEmpId, Employee employeeByDeptReviewEmp,
			ReviewStatus reviewstatusByPrepaymentReviewStatus, ReviewStatus reviewstatusByDeptReviewStatus,
			ReviewStatus reviewstatusByFinancialAuditStatus, Supplier supplier, Date requestTime, Date deptReviewTime,
			Date prepaymentReviewTime, Date financialAuditTime, Set<PurchasePaymentSlip> purchasepaymentslips, Set<PurchaseRequestDetail> purchaserequestdetails) {
		this.purchaseRequestId = purchaseRequestId;
		this.employeeByFinancialAuditEmp = employeeByFinancialAuditEmp;
		this.employeeByPrepaymentReviewEmp = employeeByPrepaymentReviewEmp;
		this.employeeByRequestEmpId = employeeByRequestEmpId;
		this.employeeByDeptReviewEmp = employeeByDeptReviewEmp;
		this.reviewstatusByPrepaymentReviewStatus = reviewstatusByPrepaymentReviewStatus;
		this.reviewstatusByDeptReviewStatus = reviewstatusByDeptReviewStatus;
		this.reviewstatusByFinancialAuditStatus = reviewstatusByFinancialAuditStatus;
		this.supplier = supplier;
		this.requestTime = requestTime;
		this.deptReviewTime = deptReviewTime;
		this.prepaymentReviewTime = prepaymentReviewTime;
		this.financialAuditTime = financialAuditTime;
		this.purchasepaymentslips = purchasepaymentslips;
		this.purchaserequestdetails = purchaserequestdetails;
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

	public Employee getEmployeeByPrepaymentReviewEmp() {
		return this.employeeByPrepaymentReviewEmp;
	}

	public void setEmployeeByPrepaymentReviewEmp(Employee employeeByPrepaymentReviewEmp) {
		this.employeeByPrepaymentReviewEmp = employeeByPrepaymentReviewEmp;
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

	public ReviewStatus getReviewstatusByPrepaymentReviewStatus() {
		return this.reviewstatusByPrepaymentReviewStatus;
	}

	public void setReviewstatusByPrepaymentReviewStatus(ReviewStatus reviewstatusByPrepaymentReviewStatus) {
		this.reviewstatusByPrepaymentReviewStatus = reviewstatusByPrepaymentReviewStatus;
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

	public Date getPrepaymentReviewTime() {
		return this.prepaymentReviewTime;
	}

	public void setPrepaymentReviewTime(Date prepaymentReviewTime) {
		this.prepaymentReviewTime = prepaymentReviewTime;
	}

	public Date getFinancialAuditTime() {
		return this.financialAuditTime;
	}

	public void setFinancialAuditTime(Date financialAuditTime) {
		this.financialAuditTime = financialAuditTime;
	}

	public Set<PurchasePaymentSlip> getPurchasepaymentslips() {
		return this.purchasepaymentslips;
	}

	public void setPurchasepaymentslips(Set<PurchasePaymentSlip> purchasepaymentslips) {
		this.purchasepaymentslips = purchasepaymentslips;
	}

	public Set<PurchaseRequestDetail> getPurchaserequestdetails() {
		return this.purchaserequestdetails;
	}

	public void setPurchaserequestdetails(Set<PurchaseRequestDetail> purchaserequestdetails) {
		this.purchaserequestdetails = purchaserequestdetails;
	}

}
