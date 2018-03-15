package cn.jxc.pojo;
// Generated 2018-3-14 20:32:32 by Hibernate Tools 5.2.8.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Èë¿âµ¥ 
 */
public class EnterStock implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String enterStockId;
	private Employee employee;
	private EnterStockType enterstocktype;
	private StoreHouse storehouse;
	private Date enterDate;
	private String upstreamNo;
	
	private Set<EnterStockDetail> enterstockdetails = new HashSet<EnterStockDetail>(0);

	public EnterStock() {
	}

	public EnterStock(String enterStockId, Employee employee, EnterStockType enterstocktype, StoreHouse storehouse,
			Date enterDate) {
		this.enterStockId = enterStockId;
		this.employee = employee;
		this.enterstocktype = enterstocktype;
		this.storehouse = storehouse;
		this.enterDate = enterDate;
	}

	public EnterStock(String enterStockId, Employee employee, EnterStockType enterstocktype, StoreHouse storehouse,
			Date enterDate, String upstreamNo, Set<EnterStockDetail> enterstockdetails) {
		this.enterStockId = enterStockId;
		this.employee = employee;
		this.enterstocktype = enterstocktype;
		this.storehouse = storehouse;
		this.enterDate = enterDate;
		this.upstreamNo = upstreamNo;
		this.enterstockdetails = enterstockdetails;
	}

	public String getEnterStockId() {
		return this.enterStockId;
	}

	public void setEnterStockId(String enterStockId) {
		this.enterStockId = enterStockId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EnterStockType getEnterstocktype() {
		return this.enterstocktype;
	}

	public void setEnterstocktype(EnterStockType enterstocktype) {
		this.enterstocktype = enterstocktype;
	}

	public StoreHouse getStorehouse() {
		return this.storehouse;
	}

	public void setStorehouse(StoreHouse storehouse) {
		this.storehouse = storehouse;
	}

	public Date getEnterDate() {
		return this.enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public String getUpstreamNo() {
		return this.upstreamNo;
	}

	public void setUpstreamNo(String upstreamNo) {
		this.upstreamNo = upstreamNo;
	}

	public Set<EnterStockDetail> getEnterstockdetails() {
		return this.enterstockdetails;
	}

	public void setEnterstockdetails(Set<EnterStockDetail> enterstockdetails) {
		this.enterstockdetails = enterstockdetails;
	}

}
