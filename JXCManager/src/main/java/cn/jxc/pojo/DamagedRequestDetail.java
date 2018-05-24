package cn.jxc.pojo;

import java.io.Serializable;

public class DamagedRequestDetail implements Serializable{

	/**
	 * 报损申请明细表
	 */
	private static final long serialVersionUID = 1L;
	
	private int dRDId;							//主键id			
	private DamagedRequest damagedRequest;		//报损编号
	private Product product;					//产品编号
	private int count;							//产品数量
	private ProductUnit productUnit;			//产品规格
	
	public DamagedRequestDetail() {
		super();
	}
	public DamagedRequestDetail(int dRDId, DamagedRequest damagedRequest, Product product, int count,
			ProductUnit productUnit) {
		super();
		this.dRDId = dRDId;
		this.damagedRequest = damagedRequest;
		this.product = product;
		this.count = count;
		this.productUnit = productUnit;
	}
	public int getdRDId() {
		return dRDId;
	}
	public void setdRDId(int dRDId) {
		this.dRDId = dRDId;
	}
	public DamagedRequest getDamagedRequest() {
		return damagedRequest;
	}
	public void setDamagedRequest(DamagedRequest damagedRequest) {
		this.damagedRequest = damagedRequest;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
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
