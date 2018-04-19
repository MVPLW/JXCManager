package cn.jxc.pojo;

/**
 * 角色权限关系
 */
public class RolePermission implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int rolePermissionId;
	private Permission permissionId;
	private Role roleId;

	public RolePermission() {
		super();
	}

	public RolePermission(int rolePermissionId, Permission permissionId, Role roleId) {
		super();
		this.rolePermissionId = rolePermissionId;
		this.permissionId = permissionId;
		this.roleId = roleId;
	}

	public int getRolePermissionId() {
		return rolePermissionId;
	}

	public void setRolePermissionId(int rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}

	public Permission getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Permission permissionId) {
		this.permissionId = permissionId;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

}
