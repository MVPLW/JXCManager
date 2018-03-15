package cn.jxc.pojo;
// Generated 2018-3-14 20:32:32 by Hibernate Tools 5.2.8.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 员工信息表  包含  财务 审核人 仓管  等所有 
 */
public class Employee implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String empLoginName;
	private Dept dept;
	private Role role;
	private String empLoginPwd;
	private String empName;
	private Date joinDate;
	private String gender;
	private Date birthday;
	private String address;
	private String telephone;
	private String email;
	
	private Set requisitionsForReviewEmp = new HashSet(0);
	private Set purchasepaymentslipsForLreviewEmpId = new HashSet(0);
	private Set requisitionsForStorageStoreHouseEmp = new HashSet(0);
	private Set salesordersForEmployeeId = new HashSet(0);
	private Set requisitionsForRequestEmp = new HashSet(0);
	private Set storehouses = new HashSet(0);
	private Set purchaserequestsForFinancialAuditEmp = new HashSet(0);
	private Set purchasepaymentslipsForLemployeeId = new HashSet(0);
	private Set salesordersForReviewEmpId = new HashSet(0);
	private Set purchasepaymentslipsForFreviewEmpId = new HashSet(0);
	private Set purchaserequestsForPrepaymentReviewEmp = new HashSet(0);
	private Set purchasepaymentslipsForFemployeeId = new HashSet(0);
	private Set leavestocks = new HashSet(0);
	private Set enterstocks = new HashSet(0);
	private Set purchaserequestsForRequestEmpId = new HashSet(0);
	private Set purchaserequestsForDeptReviewEmp = new HashSet(0);
	private Set requisitionsForOutboundEmp = new HashSet(0);

	public Employee() {
	}

	public Employee(String empLoginName, Dept dept, Role role, String empLoginPwd, String empName, Date joinDate,
			String gender, Date birthday, String address, String telephone, String email) {
		this.empLoginName = empLoginName;
		this.dept = dept;
		this.role = role;
		this.empLoginPwd = empLoginPwd;
		this.empName = empName;
		this.joinDate = joinDate;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}

	public Employee(String empLoginName, Dept dept, Role role, String empLoginPwd, String empName, Date joinDate,
			String gender, Date birthday, String address, String telephone, String email, Set requisitionsForReviewEmp,
			Set purchasepaymentslipsForLreviewEmpId, Set requisitionsForStorageStoreHouseEmp,
			Set salesordersForEmployeeId, Set requisitionsForRequestEmp, Set storehouses,
			Set purchaserequestsForFinancialAuditEmp, Set purchasepaymentslipsForLemployeeId,
			Set salesordersForReviewEmpId, Set purchasepaymentslipsForFreviewEmpId,
			Set purchaserequestsForPrepaymentReviewEmp, Set purchasepaymentslipsForFemployeeId, Set leavestocks,
			Set enterstocks, Set purchaserequestsForRequestEmpId, Set purchaserequestsForDeptReviewEmp,
			Set requisitionsForOutboundEmp) {
		this.empLoginName = empLoginName;
		this.dept = dept;
		this.role = role;
		this.empLoginPwd = empLoginPwd;
		this.empName = empName;
		this.joinDate = joinDate;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.requisitionsForReviewEmp = requisitionsForReviewEmp;
		this.purchasepaymentslipsForLreviewEmpId = purchasepaymentslipsForLreviewEmpId;
		this.requisitionsForStorageStoreHouseEmp = requisitionsForStorageStoreHouseEmp;
		this.salesordersForEmployeeId = salesordersForEmployeeId;
		this.requisitionsForRequestEmp = requisitionsForRequestEmp;
		this.storehouses = storehouses;
		this.purchaserequestsForFinancialAuditEmp = purchaserequestsForFinancialAuditEmp;
		this.purchasepaymentslipsForLemployeeId = purchasepaymentslipsForLemployeeId;
		this.salesordersForReviewEmpId = salesordersForReviewEmpId;
		this.purchasepaymentslipsForFreviewEmpId = purchasepaymentslipsForFreviewEmpId;
		this.purchaserequestsForPrepaymentReviewEmp = purchaserequestsForPrepaymentReviewEmp;
		this.purchasepaymentslipsForFemployeeId = purchasepaymentslipsForFemployeeId;
		this.leavestocks = leavestocks;
		this.enterstocks = enterstocks;
		this.purchaserequestsForRequestEmpId = purchaserequestsForRequestEmpId;
		this.purchaserequestsForDeptReviewEmp = purchaserequestsForDeptReviewEmp;
		this.requisitionsForOutboundEmp = requisitionsForOutboundEmp;
	}

	public String getEmpLoginName() {
		return this.empLoginName;
	}

	public void setEmpLoginName(String empLoginName) {
		this.empLoginName = empLoginName;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmpLoginPwd() {
		return this.empLoginPwd;
	}

	public void setEmpLoginPwd(String empLoginPwd) {
		this.empLoginPwd = empLoginPwd;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set getRequisitionsForReviewEmp() {
		return this.requisitionsForReviewEmp;
	}

	public void setRequisitionsForReviewEmp(Set requisitionsForReviewEmp) {
		this.requisitionsForReviewEmp = requisitionsForReviewEmp;
	}

	public Set getPurchasepaymentslipsForLreviewEmpId() {
		return this.purchasepaymentslipsForLreviewEmpId;
	}

	public void setPurchasepaymentslipsForLreviewEmpId(Set purchasepaymentslipsForLreviewEmpId) {
		this.purchasepaymentslipsForLreviewEmpId = purchasepaymentslipsForLreviewEmpId;
	}

	public Set getRequisitionsForStorageStoreHouseEmp() {
		return this.requisitionsForStorageStoreHouseEmp;
	}

	public void setRequisitionsForStorageStoreHouseEmp(Set requisitionsForStorageStoreHouseEmp) {
		this.requisitionsForStorageStoreHouseEmp = requisitionsForStorageStoreHouseEmp;
	}

	public Set getSalesordersForEmployeeId() {
		return this.salesordersForEmployeeId;
	}

	public void setSalesordersForEmployeeId(Set salesordersForEmployeeId) {
		this.salesordersForEmployeeId = salesordersForEmployeeId;
	}

	public Set getRequisitionsForRequestEmp() {
		return this.requisitionsForRequestEmp;
	}

	public void setRequisitionsForRequestEmp(Set requisitionsForRequestEmp) {
		this.requisitionsForRequestEmp = requisitionsForRequestEmp;
	}

	public Set getStorehouses() {
		return this.storehouses;
	}

	public void setStorehouses(Set storehouses) {
		this.storehouses = storehouses;
	}

	public Set getPurchaserequestsForFinancialAuditEmp() {
		return this.purchaserequestsForFinancialAuditEmp;
	}

	public void setPurchaserequestsForFinancialAuditEmp(Set purchaserequestsForFinancialAuditEmp) {
		this.purchaserequestsForFinancialAuditEmp = purchaserequestsForFinancialAuditEmp;
	}

	public Set getPurchasepaymentslipsForLemployeeId() {
		return this.purchasepaymentslipsForLemployeeId;
	}

	public void setPurchasepaymentslipsForLemployeeId(Set purchasepaymentslipsForLemployeeId) {
		this.purchasepaymentslipsForLemployeeId = purchasepaymentslipsForLemployeeId;
	}

	public Set getSalesordersForReviewEmpId() {
		return this.salesordersForReviewEmpId;
	}

	public void setSalesordersForReviewEmpId(Set salesordersForReviewEmpId) {
		this.salesordersForReviewEmpId = salesordersForReviewEmpId;
	}

	public Set getPurchasepaymentslipsForFreviewEmpId() {
		return this.purchasepaymentslipsForFreviewEmpId;
	}

	public void setPurchasepaymentslipsForFreviewEmpId(Set purchasepaymentslipsForFreviewEmpId) {
		this.purchasepaymentslipsForFreviewEmpId = purchasepaymentslipsForFreviewEmpId;
	}

	public Set getPurchaserequestsForPrepaymentReviewEmp() {
		return this.purchaserequestsForPrepaymentReviewEmp;
	}

	public void setPurchaserequestsForPrepaymentReviewEmp(Set purchaserequestsForPrepaymentReviewEmp) {
		this.purchaserequestsForPrepaymentReviewEmp = purchaserequestsForPrepaymentReviewEmp;
	}

	public Set getPurchasepaymentslipsForFemployeeId() {
		return this.purchasepaymentslipsForFemployeeId;
	}

	public void setPurchasepaymentslipsForFemployeeId(Set purchasepaymentslipsForFemployeeId) {
		this.purchasepaymentslipsForFemployeeId = purchasepaymentslipsForFemployeeId;
	}

	public Set getLeavestocks() {
		return this.leavestocks;
	}

	public void setLeavestocks(Set leavestocks) {
		this.leavestocks = leavestocks;
	}

	public Set getEnterstocks() {
		return this.enterstocks;
	}

	public void setEnterstocks(Set enterstocks) {
		this.enterstocks = enterstocks;
	}

	public Set getPurchaserequestsForRequestEmpId() {
		return this.purchaserequestsForRequestEmpId;
	}

	public void setPurchaserequestsForRequestEmpId(Set purchaserequestsForRequestEmpId) {
		this.purchaserequestsForRequestEmpId = purchaserequestsForRequestEmpId;
	}

	public Set getPurchaserequestsForDeptReviewEmp() {
		return this.purchaserequestsForDeptReviewEmp;
	}

	public void setPurchaserequestsForDeptReviewEmp(Set purchaserequestsForDeptReviewEmp) {
		this.purchaserequestsForDeptReviewEmp = purchaserequestsForDeptReviewEmp;
	}

	public Set getRequisitionsForOutboundEmp() {
		return this.requisitionsForOutboundEmp;
	}

	public void setRequisitionsForOutboundEmp(Set requisitionsForOutboundEmp) {
		this.requisitionsForOutboundEmp = requisitionsForOutboundEmp;
	}

}
