package cn.jxc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 仓库表
 */
public class StoreHouse implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int storeHouseId;//仓库编号
	private Employee employee;//负责人 外键
	private String shAddress;//地址
	private String shPhone;//电话
	private Date createDate;//仓库成立时间
	private String shName;//仓库名字

	private List<EnterStock> enterstocks = new ArrayList<EnterStock>(0);
	private List<Requisition> requisitionsForOutboundStoreHouse = new ArrayList<Requisition>(0);
	private List<LeaveStock> leavestocks = new ArrayList<LeaveStock>(0);
	private List<StockPile> stockpiles = new ArrayList<StockPile>(0);
	private List<Requisition> requisitionsForStorageStoreHouse = new ArrayList<Requisition>(0);
	
	public String getShName() {
		return shName;
	}
	
	public void setShName(String shName) {
		this.shName = shName;
	}

	public StoreHouse() {
		super();
	}

	public StoreHouse(int storeHouseId, Employee employee, String shAddress, String shPhone, Date createDate) {
		super();
		this.storeHouseId = storeHouseId;
		this.employee = employee;
		this.shAddress = shAddress;
		this.shPhone = shPhone;
		this.createDate = createDate;
	}

	public StoreHouse(int storeHouseId, Employee employee, String shAddress, String shPhone, Date createDate,
			List<EnterStock> enterstocks, List<Requisition> requisitionsForOutboundStoreHouse, List<LeaveStock> leavestocks, List<StockPile> stockpiles,
			List<Requisition> requisitionsForStorageStoreHouse) {
		super();
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

	public List<EnterStock> getEnterstocks() {
		return this.enterstocks;
	}

	public void setEnterstocks(List<EnterStock> enterstocks) {
		this.enterstocks = enterstocks;
	}

	public List<Requisition> getRequisitionsForOutboundStoreHouse() {
		return this.requisitionsForOutboundStoreHouse;
	}

	public void setRequisitionsForOutboundStoreHouse(List<Requisition> requisitionsForOutboundStoreHouse) {
		this.requisitionsForOutboundStoreHouse = requisitionsForOutboundStoreHouse;
	}

	public List<LeaveStock> getLeavestocks() {
		return this.leavestocks;
	}

	public void setLeavestocks(List<LeaveStock> leavestocks) {
		this.leavestocks = leavestocks;
	}

	public List<StockPile> getStockpiles() {
		return this.stockpiles;
	}

	public void setStockpiles(List<StockPile> stockpiles) {
		this.stockpiles = stockpiles;
	}

	public List<Requisition> getRequisitionsForStorageStoreHouse() {
		return this.requisitionsForStorageStoreHouse;
	}

	public void setRequisitionsForStorageStoreHouse(List<Requisition> requisitionsForStorageStoreHouse) {
		this.requisitionsForStorageStoreHouse = requisitionsForStorageStoreHouse;
	}

}
