package cn.jxc.pojo;

import java.util.Date;

/**
 * 采购付款单据
 */
public class PurchasePaymentSlip implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ppsId;
	private Employee employeeByLreviewEmpId;
	private Employee employeeByLemployeeId;
	private Employee employeeByFreviewEmpId;
	private Employee employeeByFemployeeId;
	private PurchaseRequest purchaserequest;
	private ReviewStatus reviewstatusByFreviewStatus;
	private ReviewStatus reviewstatusByLreviewStatus;
	private Supplier supplier;
	private Date fpaymentTime;
	private Long fpaymentAmount;
	private String fpaymentStatus;
	private Date freviewTime;
	private Date lpaymentTime;
	private Long lpaymentAmount;
	private String lpaymentStatus;
	private Date lreviewTime;

	public PurchasePaymentSlip() {
	}

	public PurchasePaymentSlip(String ppsId, PurchaseRequest purchaserequest, Supplier supplier) {
		this.ppsId = ppsId;
		this.purchaserequest = purchaserequest;
		this.supplier = supplier;
	}

	public PurchasePaymentSlip(String ppsId, Employee employeeByLreviewEmpId, Employee employeeByLemployeeId,
			Employee employeeByFreviewEmpId, Employee employeeByFemployeeId, PurchaseRequest purchaserequest,
			ReviewStatus reviewstatusByFreviewStatus, ReviewStatus reviewstatusByLreviewStatus, Supplier supplier,
			Date fpaymentTime, Long fpaymentAmount, String fpaymentStatus, Date freviewTime, Date lpaymentTime,
			Long lpaymentAmount, String lpaymentStatus, Date lreviewTime) {
		this.ppsId = ppsId;
		this.employeeByLreviewEmpId = employeeByLreviewEmpId;
		this.employeeByLemployeeId = employeeByLemployeeId;
		this.employeeByFreviewEmpId = employeeByFreviewEmpId;
		this.employeeByFemployeeId = employeeByFemployeeId;
		this.purchaserequest = purchaserequest;
		this.reviewstatusByFreviewStatus = reviewstatusByFreviewStatus;
		this.reviewstatusByLreviewStatus = reviewstatusByLreviewStatus;
		this.supplier = supplier;
		this.fpaymentTime = fpaymentTime;
		this.fpaymentAmount = fpaymentAmount;
		this.fpaymentStatus = fpaymentStatus;
		this.freviewTime = freviewTime;
		this.lpaymentTime = lpaymentTime;
		this.lpaymentAmount = lpaymentAmount;
		this.lpaymentStatus = lpaymentStatus;
		this.lreviewTime = lreviewTime;
	}

	public String getPpsId() {
		return this.ppsId;
	}

	public void setPpsId(String ppsId) {
		this.ppsId = ppsId;
	}

	public Employee getEmployeeByLreviewEmpId() {
		return this.employeeByLreviewEmpId;
	}

	public void setEmployeeByLreviewEmpId(Employee employeeByLreviewEmpId) {
		this.employeeByLreviewEmpId = employeeByLreviewEmpId;
	}

	public Employee getEmployeeByLemployeeId() {
		return this.employeeByLemployeeId;
	}

	public void setEmployeeByLemployeeId(Employee employeeByLemployeeId) {
		this.employeeByLemployeeId = employeeByLemployeeId;
	}

	public Employee getEmployeeByFreviewEmpId() {
		return this.employeeByFreviewEmpId;
	}

	public void setEmployeeByFreviewEmpId(Employee employeeByFreviewEmpId) {
		this.employeeByFreviewEmpId = employeeByFreviewEmpId;
	}

	public Employee getEmployeeByFemployeeId() {
		return this.employeeByFemployeeId;
	}

	public void setEmployeeByFemployeeId(Employee employeeByFemployeeId) {
		this.employeeByFemployeeId = employeeByFemployeeId;
	}

	public PurchaseRequest getPurchaserequest() {
		return this.purchaserequest;
	}

	public void setPurchaserequest(PurchaseRequest purchaserequest) {
		this.purchaserequest = purchaserequest;
	}

	public ReviewStatus getReviewstatusByFreviewStatus() {
		return this.reviewstatusByFreviewStatus;
	}

	public void setReviewstatusByFreviewStatus(ReviewStatus reviewstatusByFreviewStatus) {
		this.reviewstatusByFreviewStatus = reviewstatusByFreviewStatus;
	}

	public ReviewStatus getReviewstatusByLreviewStatus() {
		return this.reviewstatusByLreviewStatus;
	}

	public void setReviewstatusByLreviewStatus(ReviewStatus reviewstatusByLreviewStatus) {
		this.reviewstatusByLreviewStatus = reviewstatusByLreviewStatus;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Date getFpaymentTime() {
		return this.fpaymentTime;
	}

	public void setFpaymentTime(Date fpaymentTime) {
		this.fpaymentTime = fpaymentTime;
	}

	public Long getFpaymentAmount() {
		return this.fpaymentAmount;
	}

	public void setFpaymentAmount(Long fpaymentAmount) {
		this.fpaymentAmount = fpaymentAmount;
	}

	public String getFpaymentStatus() {
		return this.fpaymentStatus;
	}

	public void setFpaymentStatus(String fpaymentStatus) {
		this.fpaymentStatus = fpaymentStatus;
	}

	public Date getFreviewTime() {
		return this.freviewTime;
	}

	public void setFreviewTime(Date freviewTime) {
		this.freviewTime = freviewTime;
	}

	public Date getLpaymentTime() {
		return this.lpaymentTime;
	}

	public void setLpaymentTime(Date lpaymentTime) {
		this.lpaymentTime = lpaymentTime;
	}

	public Long getLpaymentAmount() {
		return this.lpaymentAmount;
	}

	public void setLpaymentAmount(Long lpaymentAmount) {
		this.lpaymentAmount = lpaymentAmount;
	}

	public String getLpaymentStatus() {
		return this.lpaymentStatus;
	}

	public void setLpaymentStatus(String lpaymentStatus) {
		this.lpaymentStatus = lpaymentStatus;
	}

	public Date getLreviewTime() {
		return this.lreviewTime;
	}

	public void setLreviewTime(Date lreviewTime) {
		this.lreviewTime = lreviewTime;
	}

}
