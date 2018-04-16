package cn.jxc.pojo;

import java.util.Date;

/**
 * 权限  资源
 */
public class Authority implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int authId;
	private String authName;
	private Date authCreateTime;
	
	public Authority() {
		super();
	}

	public Authority(int authId, String authName, Date authCreateTime) {
		super();
		this.authId = authId;
		this.authName = authName;
		this.authCreateTime = authCreateTime;
	}


	public int getAuthId() {
		return this.authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}

	public String getAuthName() {
		return this.authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public Date getAuthCreateTime() {
		return this.authCreateTime;
	}

	public void setAuthCreateTime(Date authCreateTime) {
		this.authCreateTime = authCreateTime;
	}

}
