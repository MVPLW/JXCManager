package cn.jxc.pojo;

/**
 * ╫ги╚х╗оч
 */
public class RoleAuth implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int roleAuthId;
	private Authority authId;
	private Role roleId;

	public RoleAuth() {
		super();
	}

	public RoleAuth(int roleAuthId, Authority authId, Role roleId) {
		super();
		this.roleAuthId = roleAuthId;
		this.authId = authId;
		this.roleId = roleId;
	}

	public int getRoleAuthId() {
		return roleAuthId;
	}

	public void setRoleAuthId(int roleAuthId) {
		this.roleAuthId = roleAuthId;
	}

	public Authority getAuthId() {
		return authId;
	}

	public void setAuthId(Authority authId) {
		this.authId = authId;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}
	
}
