package cn.jxc.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * ½ÇÉ«±í
 */
public class Role implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int roleId;
	private String roleName;
	private String description;
	private Set<RoleAuth> roleAuths = new HashSet<RoleAuth>(0);
	private Set<Employee> employees = new HashSet<Employee>(0);

	public Role() {
	}

	public Role(int roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Role(int roleId, String roleName, String description, Set<RoleAuth> roleAuths, Set<Employee> employees) {
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
		this.roleAuths = roleAuths;
		this.employees = employees;
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

	public Set<RoleAuth> getRoleAuths() {
		return this.roleAuths;
	}

	public void setRoleAuths(Set<RoleAuth> roleAuths) {
		this.roleAuths = roleAuths;
	}

	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
