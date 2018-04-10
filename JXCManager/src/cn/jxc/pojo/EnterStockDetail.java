package cn.jxc.pojo;

/**
 * Èë¿âµ¥Ã÷Ï¸
 */
public class EnterStockDetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int spId;
	private EnterStock enterstock;
	private Product product;
	private int productCount;
	private double productPrice;
	private ProductUnit productUnit;

	public EnterStockDetail() {
		super();
	}

	public EnterStockDetail(int spId, EnterStock enterstock, Product product, int productCount, double productPrice,
			ProductUnit productUnit) {
		super();
		this.spId = spId;
		this.enterstock = enterstock;
		this.product = product;
		this.productCount = productCount;
		this.productPrice = productPrice;
		this.productUnit = productUnit;
	}

	public int getSpId() {
		return this.spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public EnterStock getEnterstock() {
		return this.enterstock;
	}

	public void setEnterstock(EnterStock enterstock) {
		this.enterstock = enterstock;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductCount() {
		return this.productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public double getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public ProductUnit getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(ProductUnit productUnit) {
		this.productUnit = productUnit;
	}
	
}
