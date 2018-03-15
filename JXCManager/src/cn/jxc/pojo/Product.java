package cn.jxc.pojo;
// Generated 2018-3-14 20:32:32 by Hibernate Tools 5.2.8.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
	private double price;
	private Date createDate;
	
	private Set salesorderdetails = new HashSet(0);
	private Set enterstockdetails = new HashSet(0);
	private Set stockpiles = new HashSet(0);
	private Set leavestockdetails = new HashSet(0);
	private Set purchaserequestdetails = new HashSet(0);
	private Set requisitiondetails = new HashSet(0);

	public Product() {
		
	}

	public Product(String productId, ProductType producttype, ProductUnit productunit, String productName, double price,
			Employee employeeId, Date createDate) {
		this.productId = productId;
		this.producttype = producttype;
		this.productunit = productunit;
		this.productName = productName;
		this.price = price;
		this.employeeId = employeeId;
		this.createDate = createDate;
	}

	public Product(String productId, ProductType producttype, ProductUnit productunit, String productName, double price,
			Employee employeeId, Date createDate, Set salesorderdetails, Set enterstockdetails, Set stockpiles,
			Set leavestockdetails, Set purchaserequestdetails, Set requisitiondetails) {
		this.productId = productId;
		this.producttype = producttype;
		this.productunit = productunit;
		this.productName = productName;
		this.price = price;
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

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public Set getSalesorderdetails() {
		return this.salesorderdetails;
	}

	public void setSalesorderdetails(Set salesorderdetails) {
		this.salesorderdetails = salesorderdetails;
	}

	public Set getEnterstockdetails() {
		return this.enterstockdetails;
	}

	public void setEnterstockdetails(Set enterstockdetails) {
		this.enterstockdetails = enterstockdetails;
	}

	public Set getStockpiles() {
		return this.stockpiles;
	}

	public void setStockpiles(Set stockpiles) {
		this.stockpiles = stockpiles;
	}

	public Set getLeavestockdetails() {
		return this.leavestockdetails;
	}

	public void setLeavestockdetails(Set leavestockdetails) {
		this.leavestockdetails = leavestockdetails;
	}

	public Set getPurchaserequestdetails() {
		return this.purchaserequestdetails;
	}

	public void setPurchaserequestdetails(Set purchaserequestdetails) {
		this.purchaserequestdetails = purchaserequestdetails;
	}

	public Set getRequisitiondetails() {
		return this.requisitiondetails;
	}

	public void setRequisitiondetails(Set requisitiondetails) {
		this.requisitiondetails = requisitiondetails;
	}

}
