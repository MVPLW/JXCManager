package cn.jxc.pojo;
// Generated 2018-3-14 20:32:32 by Hibernate Tools 5.2.8.Final

import java.util.HashSet;
import java.util.Set;

/**
 * ÉóºË×´Ì¬   Î´ÉóºË  ÉóºËÍ¨¹ý  ÉóºËÃ»Í¨¹ý
 */
public class ReviewStatus implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int rsId;
	private String rsName;
	
	private Set<?> purchaserequestsForPrepaymentReviewStatus = new HashSet(0);
	private Set<?> purchasepaymentslipsForFreviewStatus = new HashSet(0);
	private Set<?> purchaserequestsForDeptReviewStatus = new HashSet(0);
	private Set<SalesOrder> salesorders = new HashSet<SalesOrder>(0);
	private Set<?> purchaserequestsForFinancialAuditStatus = new HashSet(0);
	private Set<?> purchasepaymentslipsForLreviewStatus = new HashSet(0);
	private Set<Requisition> requisitions = new HashSet<Requisition>(0);

	public ReviewStatus() {
	}

	public ReviewStatus(int rsId, String rsName) {
		this.rsId = rsId;
		this.rsName = rsName;
	}

	public ReviewStatus(int rsId, String rsName, Set purchaserequestsForPrepaymentReviewStatus,
			Set purchasepaymentslipsForFreviewStatus, Set purchaserequestsForDeptReviewStatus, Set salesorders,
			Set purchaserequestsForFinancialAuditStatus, Set purchasepaymentslipsForLreviewStatus, Set requisitions) {
		this.rsId = rsId;
		this.rsName = rsName;
		this.purchaserequestsForPrepaymentReviewStatus = purchaserequestsForPrepaymentReviewStatus;
		this.purchasepaymentslipsForFreviewStatus = purchasepaymentslipsForFreviewStatus;
		this.purchaserequestsForDeptReviewStatus = purchaserequestsForDeptReviewStatus;
		this.salesorders = salesorders;
		this.purchaserequestsForFinancialAuditStatus = purchaserequestsForFinancialAuditStatus;
		this.purchasepaymentslipsForLreviewStatus = purchasepaymentslipsForLreviewStatus;
		this.requisitions = requisitions;
	}

	public int getRsId() {
		return this.rsId;
	}

	public void setRsId(int rsId) {
		this.rsId = rsId;
	}

	public String getRsName() {
		return this.rsName;
	}

	public void setRsName(String rsName) {
		this.rsName = rsName;
	}

	public Set getPurchaserequestsForPrepaymentReviewStatus() {
		return this.purchaserequestsForPrepaymentReviewStatus;
	}

	public void setPurchaserequestsForPrepaymentReviewStatus(Set purchaserequestsForPrepaymentReviewStatus) {
		this.purchaserequestsForPrepaymentReviewStatus = purchaserequestsForPrepaymentReviewStatus;
	}

	public Set getPurchasepaymentslipsForFreviewStatus() {
		return this.purchasepaymentslipsForFreviewStatus;
	}

	public void setPurchasepaymentslipsForFreviewStatus(Set purchasepaymentslipsForFreviewStatus) {
		this.purchasepaymentslipsForFreviewStatus = purchasepaymentslipsForFreviewStatus;
	}

	public Set getPurchaserequestsForDeptReviewStatus() {
		return this.purchaserequestsForDeptReviewStatus;
	}

	public void setPurchaserequestsForDeptReviewStatus(Set purchaserequestsForDeptReviewStatus) {
		this.purchaserequestsForDeptReviewStatus = purchaserequestsForDeptReviewStatus;
	}

	public Set getSalesorders() {
		return this.salesorders;
	}

	public void setSalesorders(Set salesorders) {
		this.salesorders = salesorders;
	}

	public Set getPurchaserequestsForFinancialAuditStatus() {
		return this.purchaserequestsForFinancialAuditStatus;
	}

	public void setPurchaserequestsForFinancialAuditStatus(Set purchaserequestsForFinancialAuditStatus) {
		this.purchaserequestsForFinancialAuditStatus = purchaserequestsForFinancialAuditStatus;
	}

	public Set getPurchasepaymentslipsForLreviewStatus() {
		return this.purchasepaymentslipsForLreviewStatus;
	}

	public void setPurchasepaymentslipsForLreviewStatus(Set purchasepaymentslipsForLreviewStatus) {
		this.purchasepaymentslipsForLreviewStatus = purchasepaymentslipsForLreviewStatus;
	}

	public Set getRequisitions() {
		return this.requisitions;
	}

	public void setRequisitions(Set requisitions) {
		this.requisitions = requisitions;
	}

}
