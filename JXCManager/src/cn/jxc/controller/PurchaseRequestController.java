
package cn.jxc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Employee;
import cn.jxc.pojo.Product;
import cn.jxc.pojo.PurchaseRequest;
import cn.jxc.pojo.PurchaseRequestDetail;
import cn.jxc.pojo.Supplier;
import cn.jxc.service.EmployeeService;
import cn.jxc.service.ProductService;
import cn.jxc.service.PurchaseRequestService;
import cn.jxc.service.SupplierService;

@Controller
public class PurchaseRequestController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PurchaseRequestService purchaseRequestService;

	@RequestMapping("/gopurchase")
	public String gopurchase() {
		return "purchase/purchaseRequest";
	}

	@RequestMapping("/goPurchaseRequest")
	public String goPurchaseRequest(Model model) {
		List<Employee> employees = employeeService.getEmployeeAll();
		List<Supplier> suppliers = supplierService.getSupplierAll();
		PageInfo<Product> productAll = productService.getProductAll(1); // ��ҳ��ѯ �տ�ʼ�����ѯ��һҳ������

		model.addAttribute("employees", employees);
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("productAll", productAll);
		
		return "purchase/purchaseRequestAdd";
	}

	/**
	 * ͨ��ajaxʵ�ַ�ҳ��Ʒ��Ϣ
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getProductByPage", method = RequestMethod.POST)
	@ResponseBody
	public String getProductPage(@RequestParam("pageNum") Integer pageNum) {
		PageInfo<Product> productAll = productService.getProductAll(pageNum);
		return JSON.toJSONString(productAll.getList());
	}

	/**
	 * �ɹ����������
	 * 
	 * @return
	 * @author Killy
	 * @param purchaseRequestadd
	 *            ���еĲ���
	 * @param products
	 *            �ɹ�������ϸ
	 */
	@RequestMapping("/productRequestAdd")
	public String productRequestAdd(PurchaseRequest purchaseRequestadd, String products) {
		List<PurchaseRequestDetail> purchaseRequestDetails = JSONObject.parseArray(products,
				PurchaseRequestDetail.class);
		purchaseRequestadd.setPurchaserequestdetails(purchaseRequestDetails);
		int addPurchaseRequest = purchaseRequestService.addPurchaseRequest(purchaseRequestadd);
		if(addPurchaseRequest==1) {                           //����ʧ��
			return "error";
		} else {                                              //����ɹ�
			return "redirect:gopurchase";                     //��ת����ҳ��ѯҳ��
		}
	}

	@RequestMapping("/goPurchaseDetail")
	public String goPurchaseDetail() {
		return "purchase/purchaseDetail";
	}

	@RequestMapping("/goPurchaseUpdate")
	public String goPurchaseUpdate() {
		return "purchase/purchaseUpdate";
	}

}
