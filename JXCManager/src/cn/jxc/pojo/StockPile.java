package cn.jxc.pojo;

/**
 * 库存信息表
 */
public class StockPile implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int spId;
	private Product product;
	private ProductUnit productunit;
	private StoreHouse storehouse;
	private int quantity;
	private String prosPecification;
	private Long costPrice;       //平均价

	public StockPile() {
		
	}

	public StockPile(int spId, Product product, StoreHouse storehouse, int quantity) {
		this.spId = spId;
		this.product = product;
		this.storehouse = storehouse;
		this.quantity = quantity;
	}

	public StockPile(int spId, Product product, ProductUnit productunit, StoreHouse storehouse, int quantity,
			String prosPecification, Long costPrice) {
		this.spId = spId;
		this.product = product;
		this.productunit = productunit;
		this.storehouse = storehouse;
		this.quantity = quantity;
		this.prosPecification = prosPecification;
		this.costPrice = costPrice;
	}

	public int getSpId() {
		return this.spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductUnit getProductunit() {
		return this.productunit;
	}

	public void setProductunit(ProductUnit productunit) {
		this.productunit = productunit;
	}

	public StoreHouse getStorehouse() {
		return this.storehouse;
	}

	public void setStorehouse(StoreHouse storehouse) {
		this.storehouse = storehouse;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProsPecification() {
		return this.prosPecification;
	}

	public void setProsPecification(String prosPecification) {
		this.prosPecification = prosPecification;
	}

	public Long getCostPrice() {
		return this.costPrice;
	}

	public void setCostPrice(Long costPrice) {
		this.costPrice = costPrice;
	}

}
