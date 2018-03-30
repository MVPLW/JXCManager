
package cn.jxc.controller;

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
import cn.jxc.service.PurchaseRequestDetailService;
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
	@Autowired
	private PurchaseRequestDetailService purchaseRequestDetailService;
	
	@RequestMapping("/gopurchase")
	public String gopurchase(
			@RequestParam(value="pageNo",required=false)Integer pageNo,
			@RequestParam(value="empNo",required=false)String empNo,
			@RequestParam(value="singleNo",required=false)String singleNo,
			@RequestParam(value="suppName",required=false)String suppName,
			Model model) {
		if (pageNo==null) {
			pageNo=1;
		}
		PageInfo<PurchaseRequest> purchaseRequestByBlurry = 
				purchaseRequestService.getPurchaseRequestByBlurry(pageNo, empNo, singleNo, suppName);
		model.addAttribute("prbb", purchaseRequestByBlurry);
		model.addAttribute("empNo", empNo);      //查询条件保存
		model.addAttribute("singleNo", singleNo);
		model.addAttribute("suppName", suppName);
		return "purchase/purchaseRequest";
	}
	
	/**
	 * 跳转到采购订单申请页面
	 * @param model
	 * @return 
	 */
	@RequestMapping("/goPurchaseRequest")
	public String goPurchaseRequest(Model model) {
		List<Employee> employees = employeeService.getEmployeeAll();
		List<Supplier> suppliers = supplierService.getSupplierAll();
		PageInfo<Product> productAll = productService.getProductAll(1); // 分页查询 刚开始进入查询第一页的数据

		model.addAttribute("employees", employees);
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("productAll", productAll);
		
		return "purchase/purchaseRequestAdd";
	}

	/**
	 * 通过ajax实现分页产品信息
	 * 采购订单申请页面中
	 * @return
	 */
	@RequestMapping(value = "/getProductByPage", method = RequestMethod.POST)
	@ResponseBody
	public String getProductPage(@RequestParam("pageNum") Integer pageNum) {
		PageInfo<Product> productAll = productService.getProductAll(pageNum);
		return JSON.toJSONString(productAll.getList());
	}
	
	/**
	 * 通过ajax实现
	 * 根据采购单号查询一个采购订单所有信息
	 * @param singleNo
	 * @return 
	 */
	@RequestMapping("getPurchaseRequestBySingleNo")
	@ResponseBody
	public String getPurchaseRequestBySingleNo(@RequestParam("singleNo")String singleNo
			,@RequestParam(value="pageNo",required=false)Integer pageNo) {
		if(null==pageNo) {
			pageNo=1;
		}
		PurchaseRequest purchaseRequestBySingleNo = purchaseRequestService.getPurchaseRequestBySingleNo(singleNo);
		PageInfo<PurchaseRequestDetail> pageInfos = purchaseRequestDetailService.getPurchaseRequestDetail(singleNo, pageNo);
		pageInfos.getList().get(0).setPurchaserequest(purchaseRequestBySingleNo);
		return JSON.toJSONString(pageInfos);
	}

	/**
	 * 采购申请表的添加
	 * 
	 * @return
	 * @author Killy
	 * @param purchaseRequestadd
	 *            表单中的参数
	 * @param products
	 *            采购申请明细
	 */
	@RequestMapping("/productRequestAdd")
	public String productRequestAdd(PurchaseRequest purchaseRequestadd, String products) {
		List<PurchaseRequestDetail> purchaseRequestDetails = JSONObject.parseArray(products,
				PurchaseRequestDetail.class);
		purchaseRequestadd.setPurchaserequestdetails(purchaseRequestDetails);
		int addPurchaseRequest = purchaseRequestService.addPurchaseRequest(purchaseRequestadd);
		if(addPurchaseRequest==1) {                           //申请失败
			return "error";
		} else {                                              //申请成功
			return "redirect:gopurchase";                     //跳转到首页查询页面
		}
	}
	
	@RequestMapping("/goPurchaseUpdate")
	public String goPurchaseUpdate() {
		return "purchase/purchaseUpdate";
	}

}
