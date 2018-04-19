package cn.jxc.pojo;
// Generated 2018-3-14 20:32:32 by Hibernate Tools 5.2.8.Final

import java.util.ArrayList;
import java.util.List;

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
	
	private List<?> purchaserequestsForPrepaymentReviewStatus = new ArrayList<>();
	private List<?> purchasepaymentslipsForFreviewStatus = new ArrayList<>();
	private List<?> purchaserequestsForDeptReviewStatus = new ArrayList<>();
	private List<SalesOrder> salesorders = new ArrayList<SalesOrder>();
	private List<?> purchaserequestsForFinancialAuditStatus = new ArrayList<>();
	private List<?> purchasepaymentslipsForLreviewStatus = new ArrayList<>();
	private List<Requisition> requisitions = new ArrayList<Requisition>(0);

	public ReviewStatus() {
	}

	public ReviewStatus(int rsId, String rsName) {
		this.rsId = rsId;
		this.rsName = rsName;
	}

	public ReviewStatus(int rsId, String rsName, List<?> purchaserequestsForPrepaymentReviewStatus,
			List<?> purchasepaymentslipsForFreviewStatus, List<?> purchaserequestsForDeptReviewStatus, List<SalesOrder> salesorders,
			List<?> purchaserequestsForFinancialAuditStatus, List<?> purchasepaymentslipsForLreviewStatus, List<Requisition> requisitions) {
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

	public List<?> getPurchaserequestsForPrepaymentReviewStatus() {
		return this.purchaserequestsForPrepaymentReviewStatus;
	}

	public void setPurchaserequestsForPrepaymentReviewStatus(List<?> purchaserequestsForPrepaymentReviewStatus) {
		this.purchaserequestsForPrepaymentReviewStatus = purchaserequestsForPrepaymentReviewStatus;
	}

	public List<?> getPurchasepaymentslipsForFreviewStatus() {
		return this.purchasepaymentslipsForFreviewStatus;
	}

	public void setPurchasepaymentslipsForFreviewStatus(List<?> purchasepaymentslipsForFreviewStatus) {
		this.purchasepaymentslipsForFreviewStatus = purchasepaymentslipsForFreviewStatus;
	}

	public List<?> getPurchaserequestsForDeptReviewStatus() {
		return this.purchaserequestsForDeptReviewStatus;
	}

	public void setPurchaserequestsForDeptReviewStatus(List<?> purchaserequestsForDeptReviewStatus) {
		this.purchaserequestsForDeptReviewStatus = purchaserequestsForDeptReviewStatus;
	}

	public List<SalesOrder> getSalesorders() {
		return this.salesorders;
	}

	public void setSalesorders(List<SalesOrder> salesorders) {
		this.salesorders = salesorders;
	}

	public List<?> getPurchaserequestsForFinancialAuditStatus() {
		return this.purchaserequestsForFinancialAuditStatus;
	}

	public void setPurchaserequestsForFinancialAuditStatus(List<?> purchaserequestsForFinancialAuditStatus) {
		this.purchaserequestsForFinancialAuditStatus = purchaserequestsForFinancialAuditStatus;
	}

	public List<?> getPurchasepaymentslipsForLreviewStatus() {
		return this.purchasepaymentslipsForLreviewStatus;
	}

	public void setPurchasepaymentslipsForLreviewStatus(List<?> purchasepaymentslipsForLreviewStatus) {
		this.purchasepaymentslipsForLreviewStatus = purchasepaymentslipsForLreviewStatus;
	}

	public List<Requisition> getRequisitions() {
		return this.requisitions;
	}

	public void setRequisitions(List<Requisition> requisitions) {
		this.requisitions = requisitions;
	}

}
