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
	private Employee employeeByRequestEmpId;
	private Employee employeeByDeptReviewEmp;
	private ReviewStatus reviewstatusByDeptReviewStatus;
	private ReviewStatus reviewstatusByFinancialAuditStatus;
	private Supplier supplier;
	private String SuppContact;
	private String SuppPhone;
	private Date requestTime;
	private Date deptReviewTime;
	private Date financialAuditTime;
	private String Remark;
	
	//存放当前订单中明细
	private Set<PurchaseRequestDetail> purchaserequestdetails = new HashSet<PurchaseRequestDetail>(0);

	private Set<PurchasePaymentSlip> purchasepaymentslips = new HashSet<PurchasePaymentSlip>(0);

	public PurchaseRequest() {
		
	}

	public PurchaseRequest(String purchaseRequestId, Employee employeeByRequestEmpId, Supplier supplier,
			Date requestTime) {
		super();
		this.purchaseRequestId = purchaseRequestId;
		this.employeeByRequestEmpId = employeeByRequestEmpId;
		this.supplier = supplier;
		this.requestTime = requestTime;
	}
	
	public PurchaseRequest(String purchaseRequestId, Employee employeeByFinancialAuditEmp,
			Employee employeeByRequestEmpId, Employee employeeByDeptReviewEmp,
			ReviewStatus reviewstatusByDeptReviewStatus, ReviewStatus reviewstatusByFinancialAuditStatus,
			Supplier supplier, String suppContact, String suppPhone, Date requestTime, Date deptReviewTime,
			Date financialAuditTime, String remark, Set<PurchaseRequestDetail> purchaserequestdetails,
			Set<PurchasePaymentSlip> purchasepaymentslips) {
		super();
		this.purchaseRequestId = purchaseRequestId;
		this.employeeByFinancialAuditEmp = employeeByFinancialAuditEmp;
		this.employeeByRequestEmpId = employeeByRequestEmpId;
		this.employeeByDeptReviewEmp = employeeByDeptReviewEmp;
		this.reviewstatusByDeptReviewStatus = reviewstatusByDeptReviewStatus;
		this.reviewstatusByFinancialAuditStatus = reviewstatusByFinancialAuditStatus;
		this.supplier = supplier;
		this.SuppContact = suppContact;
		this.SuppPhone = suppPhone;
		this.requestTime = requestTime;
		this.deptReviewTime = deptReviewTime;
		this.financialAuditTime = financialAuditTime;
		this.Remark = remark;
		this.purchaserequestdetails = purchaserequestdetails;
		this.purchasepaymentslips = purchasepaymentslips;
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

	public String getSuppContact() {
		return SuppContact;
	}

	public void setSuppContact(String suppContact) {
		this.SuppContact = suppContact;
	}

	public String getSuppPhone() {
		return SuppPhone;
	}

	public void setSuppPhone(String suppPhone) {
		this.SuppPhone = suppPhone;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		this.Remark = remark;
	}

}
