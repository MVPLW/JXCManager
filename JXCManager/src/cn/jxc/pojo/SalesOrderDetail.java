package cn.jxc.pojo;

/**
 * 销售订单明细
 */
public class SalesOrderDetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int sodId;
	private Product product;
	private SalesOrder salesorder;
	private int count;
	private long price;
	private ProductUnit productUnit;

	public SalesOrderDetail() {
		super();
	}

	public SalesOrderDetail(int sodId, Product product, SalesOrder salesorder, int count, long price,ProductUnit productUnit) {
		super();
		this.sodId = sodId;
		this.product = product;
		this.salesorder = salesorder;
		this.count = count;
		this.price = price;
		this.productUnit=productUnit;
	}

	public int getSodId() {
		return this.sodId;
	}

	public void setSodId(int sodId) {
		this.sodId = sodId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public SalesOrder getSalesorder() {
		return this.salesorder;
	}

	public void setSalesorder(SalesOrder salesorder) {
		this.salesorder = salesorder;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public long getPrice() {
		return this.price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public ProductUnit getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(ProductUnit productUnit) {
		this.productUnit = productUnit;
	}
	
}
