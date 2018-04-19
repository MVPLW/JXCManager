package cn.jxc.pojo;


/**
 * х╗оч
 */
public class Permission implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int permissionId;
	private String permissionDesc;
	private String permissionUrl;
	private int isNavi;
	private String permissionCode;
	
	public Permission() {
		super();
	}
	
	public Permission(int permissionId, String permissionDesc, String permissionUrl, int isNavi,
			String permissionCode) {
		super();
		this.permissionId = permissionId;
		this.permissionDesc = permissionDesc;
		this.permissionUrl = permissionUrl;
		this.isNavi = isNavi;
		this.permissionCode = permissionCode;
	}

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionDesc() {
		return permissionDesc;
	}

	public void setPermissionDesc(String permissionDesc) {
		this.permissionDesc = permissionDesc;
	}

	public String getPermissionUrl() {
		return permissionUrl;
	}

	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}

	public int getIsNavi() {
		return isNavi;
	}

	public void setIsNavi(int isNavi) {
		this.isNavi = isNavi;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}


}
