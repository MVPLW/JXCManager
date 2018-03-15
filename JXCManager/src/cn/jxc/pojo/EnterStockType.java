package cn.jxc.pojo;
// Generated 2018-3-14 20:32:32 by Hibernate Tools 5.2.8.Final

import java.util.HashSet;
import java.util.Set;

/**
 * »Îø‚¿‡–Õ
 */
public class EnterStockType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int estId;
	private String estName;
	private String description;
	private Set<Object> enterstocks = new HashSet<Object>(0);

	public EnterStockType() {
	}

	public EnterStockType(int estId, String estName) {
		this.estId = estId;
		this.estName = estName;
	}

	public EnterStockType(int estId, String estName, String description, Set<Object> enterstocks) {
		this.estId = estId;
		this.estName = estName;
		this.description = description;
		this.enterstocks = enterstocks;
	}

	public int getEstId() {
		return this.estId;
	}

	public void setEstId(int estId) {
		this.estId = estId;
	}

	public String getEstName() {
		return this.estName;
	}

	public void setEstName(String estName) {
		this.estName = estName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Object> getEnterstocks() {
		return this.enterstocks;
	}

	public void setEnterstocks(Set<Object> enterstocks) {
		this.enterstocks = enterstocks;
	}

}
