package cn.jxc.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ²Ö¿â±í
 */
public class StoreHouse implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int storeHouseId;
	private Employee employee;
	private String shAddress;
	private String shPhone;
	private Date createDate;
	
	private Set<EnterStock> enterstocks = new HashSet<EnterStock>(0);
	private Set requisitionsForOutboundStoreHouse = new HashSet(0);
	private Set<LeaveStock> leavestocks = new HashSet<LeaveStock>(0);
	private Set<StockPile> stockpiles = new HashSet<StockPile>(0);
	private Set requisitionsForStorageStoreHouse = new HashSet(0);

	public StoreHouse() {
	}

	public StoreHouse(int storeHouseId, Employee employee, String shAddress, String shPhone, Date createDate) {
		this.storeHouseId = storeHouseId;
		this.employee = employee;
		this.shAddress = shAddress;
		this.shPhone = shPhone;
		this.createDate = createDate;
	}

	public StoreHouse(int storeHouseId, Employee employee, String shAddress, String shPhone, Date createDate,
			Set enterstocks, Set requisitionsForOutboundStoreHouse, Set leavestocks, Set stockpiles,
			Set requisitionsForStorageStoreHouse) {
		this.storeHouseId = storeHouseId;
		this.employee = employee;
		this.shAddress = shAddress;
		this.shPhone = shPhone;
		this.createDate = createDate;
		this.enterstocks = enterstocks;
		this.requisitionsForOutboundStoreHouse = requisitionsForOutboundStoreHouse;
		this.leavestocks = leavestocks;
		this.stockpiles = stockpiles;
		this.requisitionsForStorageStoreHouse = requisitionsForStorageStoreHouse;
	}

	public int getStoreHouseId() {
		return this.storeHouseId;
	}

	public void setStoreHouseId(int storeHouseId) {
		this.storeHouseId = storeHouseId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getShAddress() {
		return this.shAddress;
	}

	public void setShAddress(String shAddress) {
		this.shAddress = shAddress;
	}

	public String getShPhone() {
		return this.shPhone;
	}

	public void setShPhone(String shPhone) {
		this.shPhone = shPhone;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Set getEnterstocks() {
		return this.enterstocks;
	}

	public void setEnterstocks(Set enterstocks) {
		this.enterstocks = enterstocks;
	}

	public Set getRequisitionsForOutboundStoreHouse() {
		return this.requisitionsForOutboundStoreHouse;
	}

	public void setRequisitionsForOutboundStoreHouse(Set requisitionsForOutboundStoreHouse) {
		this.requisitionsForOutboundStoreHouse = requisitionsForOutboundStoreHouse;
	}

	public Set getLeavestocks() {
		return this.leavestocks;
	}

	public void setLeavestocks(Set leavestocks) {
		this.leavestocks = leavestocks;
	}

	public Set getStockpiles() {
		return this.stockpiles;
	}

	public void setStockpiles(Set stockpiles) {
		this.stockpiles = stockpiles;
	}

	public Set getRequisitionsForStorageStoreHouse() {
		return this.requisitionsForStorageStoreHouse;
	}

	public void setRequisitionsForStorageStoreHouse(Set requisitionsForStorageStoreHouse) {
		this.requisitionsForStorageStoreHouse = requisitionsForStorageStoreHouse;
	}

}
