package cn.jxc.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色 包含采购员 仓管员 销售员等等...
 */
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int roleId;
	private String roleName;
	private String description;
	private String roleCode;

	private List<RolePermission> rolePermissions = new ArrayList<RolePermission>();
	
	private List<EmployeeRole> employeeRoles = new ArrayList<EmployeeRole>();

	public Role() {
		super();
	}

	public Role(int roleId, String roleName, String description, String roleCode) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
		this.roleCode = roleCode;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public List<RolePermission> getRolePermissions() {
		return rolePermissions;
	}

	public void setRolePermissions(List<RolePermission> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

	public List<EmployeeRole> getEmployeeRoles() {
		return employeeRoles;
	}

	public void setEmployeeRoles(List<EmployeeRole> employeeRoles) {
		this.employeeRoles = employeeRoles;
	}

}
