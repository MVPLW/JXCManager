package cn.jxc.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 供货商实体类
 */
public class Supplier implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String supplierId;
	private String suppName;
	private String suppAddress;
	private String phone;
	private String postalCode;
	private String suppContact;
	private String suppContactPho;
	private String suppBank;
	private String suppBankNum;
	private String remark;
	
	private Set<PurchaseRequest> purchaserequests = new HashSet<PurchaseRequest>(0);
	private Set<PurchasePaymentSlip> purchasepaymentslips = new HashSet<PurchasePaymentSlip>(0);

	public Supplier() {
	}

	public Supplier(String supplierId, String suppName, String suppAddress, String phone, String postalCode,
			String suppContact, String suppContactPho, String suppBank, String suppBankNum) {
		this.supplierId = supplierId;
		this.suppName = suppName;
		this.suppAddress = suppAddress;
		this.phone = phone;
		this.postalCode = postalCode;
		this.suppContact = suppContact;
		this.suppContactPho = suppContactPho;
		this.suppBank = suppBank;
		this.suppBankNum = suppBankNum;
	}

	public Supplier(String supplierId, String suppName, String suppAddress, String phone, String postalCode,
			String suppContact, String suppContactPho, String suppBank, String suppBankNum, String remark,
			Set<PurchaseRequest> purchaserequests, Set<PurchasePaymentSlip> purchasepaymentslips) {
		this.supplierId = supplierId;
		this.suppName = suppName;
		this.suppAddress = suppAddress;
		this.phone = phone;
		this.postalCode = postalCode;
		this.suppContact = suppContact;
		this.suppContactPho = suppContactPho;
		this.suppBank = suppBank;
		this.suppBankNum = suppBankNum;
		this.remark = remark;
		this.purchaserequests = purchaserequests;
		this.purchasepaymentslips = purchasepaymentslips;
	}

	public String getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSuppName() {
		return this.suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public String getSuppAddress() {
		return this.suppAddress;
	}

	public void setSuppAddress(String suppAddress) {
		this.suppAddress = suppAddress;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getSuppContact() {
		return this.suppContact;
	}

	public void setSuppContact(String suppContact) {
		this.suppContact = suppContact;
	}

	public String getSuppContactPho() {
		return this.suppContactPho;
	}

	public void setSuppContactPho(String suppContactPho) {
		this.suppContactPho = suppContactPho;
	}

	public String getSuppBank() {
		return this.suppBank;
	}

	public void setSuppBank(String suppBank) {
		this.suppBank = suppBank;
	}

	public String getSuppBankNum() {
		return this.suppBankNum;
	}

	public void setSuppBankNum(String suppBankNum) {
		this.suppBankNum = suppBankNum;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set<PurchaseRequest> getPurchaserequests() {
		return this.purchaserequests;
	}

	public void setPurchaserequests(Set<PurchaseRequest> purchaserequests) {
		this.purchaserequests = purchaserequests;
	}

	public Set<PurchasePaymentSlip> getPurchasepaymentslips() {
		return this.purchasepaymentslips;
	}

	public void setPurchasepaymentslips(Set<PurchasePaymentSlip> purchasepaymentslips) {
		this.purchasepaymentslips = purchasepaymentslips;
	}

}
