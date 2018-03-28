package cn.jxc.pojo;

/**
 * ³ö¿âÃ÷Ï¸
 */
public class LeaveStockDetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int lsdId;
	private LeaveStock leavestock;
	private Product product;
	private int count;
	private ProductUnit productUnit;

	public LeaveStockDetail() {
		super();
	}

	public LeaveStockDetail(int lsdId, LeaveStock leavestock, Product product, int count,ProductUnit productUnit) {
		this.lsdId = lsdId;
		this.leavestock = leavestock;
		this.product = product;
		this.count = count;
		this.productUnit=productUnit;
	}

	public int getLsdId() {
		return this.lsdId;
	}

	public void setLsdId(int lsdId) {
		this.lsdId = lsdId;
	}

	public LeaveStock getLeavestock() {
		return this.leavestock;
	}

	public void setLeavestock(LeaveStock leavestock) {
		this.leavestock = leavestock;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ProductUnit getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(ProductUnit productUnit) {
		this.productUnit = productUnit;
	}
	
}
