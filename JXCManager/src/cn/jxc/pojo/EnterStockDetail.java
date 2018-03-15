package cn.jxc.pojo;
// Generated 2018-3-14 20:32:32 by Hibernate Tools 5.2.8.Final

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
	private long productPrice;

	public EnterStockDetail() {
	}

	public EnterStockDetail(int spId, EnterStock enterstock, Product product, int productCount, long productPrice) {
		this.spId = spId;
		this.enterstock = enterstock;
		this.product = product;
		this.productCount = productCount;
		this.productPrice = productPrice;
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

	public long getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

}
