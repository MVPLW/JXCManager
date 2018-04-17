package cn.jxc.pojo;
// Generated 2018-3-14 20:32:32 by Hibernate Tools 5.2.8.Final

/**
 * Backsalesdetail generated by hbm2java
 */
public class BackSalesDetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int bsadId;
	private BackSales bs;
	private Product product;
	private ProductUnit productUnit;
	private double price;
	private int count;
	
	public BackSalesDetail(int bsadId, BackSales bs, Product product, ProductUnit productUnit, double price,
			int count) {
		super();
		this.bsadId = bsadId;
		this.bs = bs;
		this.product = product;
		this.productUnit = productUnit;
		this.price = price;
		this.count = count;
	}

	public BackSalesDetail() {
		super();
	}

	public int getBsadId() {
		return bsadId;
	}

	public void setBsadId(int bsadId) {
		this.bsadId = bsadId;
	}

	public BackSales getBs() {
		return bs;
	}

	public void setBs(BackSales bs) {
		this.bs = bs;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductUnit getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(ProductUnit productUnit) {
		this.productUnit = productUnit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	 
}