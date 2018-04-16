package cn.jxc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 员工信息表 包含 财务 审核人 仓管 等所有
 */
public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String empLoginName;
	private Dept dept;
	private String empLoginPwd;
	private String empName;
	private Date joinDate;
	private String gender;
	private Date birthday;
	private String address;
	private String telephone;
	private String email;

	// 所有员工角色权限
	private List<EmployeeRole> employeeRoles = new ArrayList<EmployeeRole>();
	
	public Employee() {
		super();
	}

	public Employee(String empLoginName, Dept dept, String empLoginPwd, String empName, Date joinDate, String gender,
			Date birthday, String address, String telephone, String email) {
		super();
		this.empLoginName = empLoginName;
		this.dept = dept;
		this.empLoginPwd = empLoginPwd;
		this.empName = empName;
		this.joinDate = joinDate;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
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

	public List<EmployeeRole> getEmployeeRoles() {
		return employeeRoles;
	}

	public void setEmployeeRoles(List<EmployeeRole> employeeRoles) {
		this.employeeRoles = employeeRoles;
	}

}
