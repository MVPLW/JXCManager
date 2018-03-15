package cn.jxc.pojo;
// Generated 2018-3-14 20:32:32 by Hibernate Tools 5.2.8.Final

/**
 * 调拨单明细表
 */
public class RequisitionDetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int reId;
	private Product product;
	private Requisition requisition;
	private int count;

	public RequisitionDetail() {
	}

	public RequisitionDetail(int reId, Product product, Requisition requisition, int count) {
		this.reId = reId;
		this.product = product;
		this.requisition = requisition;
		this.count = count;
	}

	public int getReId() {
		return this.reId;
	}

	public void setReId(int reId) {
		this.reId = reId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Requisition getRequisition() {
		return this.requisition;
	}

	public void setRequisition(Requisition requisition) {
		this.requisition = requisition;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
