package cn.jxc.pojo;

/**
 * ≤…π∫…Í«ÎœÍ«È
 */
public class PurchaseRequestDetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int prdId;
	private Product product;
	private PurchaseRequest purchaserequest;
	private int count;

	public PurchaseRequestDetail() {
	}

	public PurchaseRequestDetail(int prdId, Product product, PurchaseRequest purchaserequest, int count) {
		this.prdId = prdId;
		this.product = product;
		this.purchaserequest = purchaserequest;
		this.count = count;
	}

	public int getPrdId() {
		return this.prdId;
	}

	public void setPrdId(int prdId) {
		this.prdId = prdId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public PurchaseRequest getPurchaserequest() {
		return this.purchaserequest;
	}

	public void setPurchaserequest(PurchaseRequest purchaserequest) {
		this.purchaserequest = purchaserequest;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
