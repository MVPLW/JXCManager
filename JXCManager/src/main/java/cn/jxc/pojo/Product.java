package cn.jxc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 产品数据表
 */
public class Product implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String productId;
	private ProductType producttype;
	private ProductUnit productunit;
	private Employee employeeId;
	private String productName;
	private Date createDate;
	
	private List<SalesOrderDetail> salesorderdetails = new ArrayList<SalesOrderDetail>();
	private List<EnterStockDetail> enterstockdetails = new ArrayList<>();
	private List<StockPile> stockpiles = new ArrayList<>();
	private List<LeaveStockDetail> leavestockdetails = new ArrayList<>();
	private List<PurchaseRequestDetail> purchaserequestdetails = new ArrayList<>();
	private List<RequisitionDetail> requisitiondetails = new ArrayList<>();

	public Product() {
		
	}

	public Product(String productId, ProductType producttype, ProductUnit productunit, String productName,
			Employee employeeId, Date createDate) {
		this.productId = productId;
		this.producttype = producttype;
		this.productunit = productunit;
		this.productName = productName;
		this.employeeId = employeeId;
		this.createDate = createDate;
	}

	public Product(String productId, ProductType producttype, ProductUnit productunit, String productName, 
			Employee employeeId, Date createDate, List<SalesOrderDetail> salesorderdetails, List<EnterStockDetail> enterstockdetails, List<StockPile> stockpiles,
			List<LeaveStockDetail> leavestockdetails, List<PurchaseRequestDetail> purchaserequestdetails, List<RequisitionDetail> requisitiondetails) {
		this.productId = productId;
		this.producttype = producttype;
		this.productunit = productunit;
		this.productName = productName;
		this.employeeId = employeeId;
		this.createDate = createDate;
		this.salesorderdetails = salesorderdetails;
		this.enterstockdetails = enterstockdetails;
		this.stockpiles = stockpiles;
		this.leavestockdetails = leavestockdetails;
		this.purchaserequestdetails = purchaserequestdetails;
		this.requisitiondetails = requisitiondetails;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public ProductType getProducttype() {
		return this.producttype;
	}

	public void setProducttype(ProductType producttype) {
		this.producttype = producttype;
	}

	public ProductUnit getProductunit() {
		return this.productunit;
	}

	public void setProductunit(ProductUnit productunit) {
		this.productunit = productunit;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Employee getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<SalesOrderDetail> getSalesorderdetails() {
		return this.salesorderdetails;
	}

	public void setSalesorderdetails(List<SalesOrderDetail> salesorderdetails) {
		this.salesorderdetails = salesorderdetails;
	}

	public List<EnterStockDetail> getEnterstockdetails() {
		return this.enterstockdetails;
	}

	public void setEnterstockdetails(List<EnterStockDetail> enterstockdetails) {
		this.enterstockdetails = enterstockdetails;
	}

	public List<StockPile> getStockpiles() {
		return this.stockpiles;
	}

	public void setStockpiles(List<StockPile> stockpiles) {
		this.stockpiles = stockpiles;
	}

	public List<LeaveStockDetail> getLeavestockdetails() {
		return this.leavestockdetails;
	}

	public void setLeavestockdetails(List<LeaveStockDetail> leavestockdetails) {
		this.leavestockdetails = leavestockdetails;
	}

	public List<PurchaseRequestDetail> getPurchaserequestdetails() {
		return this.purchaserequestdetails;
	}

	public void setPurchaserequestdetails(List<PurchaseRequestDetail> purchaserequestdetails) {
		this.purchaserequestdetails = purchaserequestdetails;
	}

	public List<RequisitionDetail> getRequisitiondetails() {
		return this.requisitiondetails;
	}

	public void setRequisitiondetails(List<RequisitionDetail> requisitiondetails) {
		this.requisitiondetails = requisitiondetails;
	}

}
