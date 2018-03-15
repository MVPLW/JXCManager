package cn.jxc.pojo;
// Generated 2018-3-14 20:32:32 by Hibernate Tools 5.2.8.Final

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

	public LeaveStockDetail() {
	}

	public LeaveStockDetail(int lsdId, LeaveStock leavestock, Product product, int count) {
		this.lsdId = lsdId;
		this.leavestock = leavestock;
		this.product = product;
		this.count = count;
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

}
