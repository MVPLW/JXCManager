package cn.jxc.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.jxc.util.OrderStatus;

/**
 * 报损单据
 */
public class DamagedRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String damagedRequestId;		//报损单号
	private Employee requestEmp;			//报损申请人
	private Date requestTime;				//报损制单时间
	private StoreHouse damagedStoreHouse;	//报损所在仓库
	private ReviewStatus deptReviewStatus;	//审核状态
	private Employee deptReviewEmp;			//审核人
	private Date deptReviewTime;			//审核时间
	private String damagedReason;			//报损原因
	private String remark;    				//备注
	private OrderStatus orderStatus; 			//报损详情
	
	private List<DamagedRequestDetail> damagedrequestdetail = new ArrayList<DamagedRequestDetail>();
	public List<DamagedRequestDetail> getDamagedrequestdetail() {
		return damagedrequestdetail;
	}

	public void setDamagedrequestdetail(List<DamagedRequestDetail> damagedrequestdetail) {
		this.damagedrequestdetail = damagedrequestdetail;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

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
