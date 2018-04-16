package cn.jxc.pojo;

/**
 * 调拨单明细表
 */
public class RequisitionDetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int reId;//调拨明细id
	private Product product;//产品外键
	private Requisition requisition;//调拨单外键
	private int count;//产品数量
	private ProductUnit productUnit;//批次外键

	public RequisitionDetail() {
	}

	public RequisitionDetail(int reId, Product product, Requisition requisition, int count,ProductUnit productUnit) {
		this.reId = reId;
		this.product = product;
		this.requisition = requisition;
		this.count = count;
		this.productUnit=productUnit;
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

	public ProductUnit getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(ProductUnit productUnit) {
		this.productUnit = productUnit;
	}
	
}
