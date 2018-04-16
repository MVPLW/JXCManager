package cn.jxc.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * ����ʵ��  ����:���� ���۲� �ɹ��� �ֿ���� ...
 */
public class Dept implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer deptId;
	private String deptName;
	private String deptDes;
	
	private Set<Object> employees = new HashSet<Object>(0);

	public Dept() {
	}

	public Dept(String deptName) {
		this.deptName = deptName;
	}

	public Dept(String deptName, String deptDes, Set<Object> employees) {
		this.deptName = deptName;
		this.deptDes = deptDes;
		this.employees = employees;
	}

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDes() {
		return this.deptDes;
	}

	public void setDeptDes(String deptDes) {
		this.deptDes = deptDes;
	}

	public Set<Object> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Object> employees) {
		this.employees = employees;
	}

}
