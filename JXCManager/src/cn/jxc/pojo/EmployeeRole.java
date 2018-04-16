package cn.jxc.pojo;

import java.io.Serializable;

/**
 * 员工角色关系
 * 
 * @author Administrator
 *
 */
public class EmployeeRole implements Serializable {

	private static final long serialVersionUID = 1L;

	private int employeeRoleId;
	private Role roleId;
	private Employee emploginName;

	public EmployeeRole() {
		super();
	}
	
	public EmployeeRole(int employeeRoleId, Role roleId, Employee emploginName) {
		super();
		this.employeeRoleId = employeeRoleId;
		this.roleId = roleId;
		this.emploginName = emploginName;
	}


	public int getEmployeeRoleId() {
		return employeeRoleId;
	}

	public void setEmployeeRoleId(int employeeRoleId) {
		this.employeeRoleId = employeeRoleId;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public Employee getEmploginName() {
		return emploginName;
	}

	public void setEmploginName(Employee emploginName) {
		this.emploginName = emploginName;
	}

}
