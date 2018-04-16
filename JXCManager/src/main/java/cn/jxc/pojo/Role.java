package cn.jxc.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色   包含采购员 仓管员  销售员等等...
 */
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int roleId;
	private String roleName;
	private String description;
	
	private List<RoleAuth> roleAuths = new ArrayList<RoleAuth>();
	private List<EmployeeRole> employeeRoles = new ArrayList<EmployeeRole>();

	public Role() {
		super();
	}

	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<RoleAuth> getRoleAuths() {
		return this.roleAuths;
	}

	public void setRoleAuths(List<RoleAuth> roleAuths) {
		this.roleAuths = roleAuths;
	}

	public List<EmployeeRole> getEmployees() {
		return this.employeeRoles;
	}

	public void setEmployees(List<EmployeeRole> employees) {
		this.employeeRoles = employees;
	}

}
