
package cn.jxc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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

import cn.jxc.excel.ExportExcel;
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

	@RequiresPermissions("purchase:list")
	@RequestMapping("/gopurchase")
	public String gopurchase(@RequestParam(value = "pageNo", required = false) Integer pageNo,
			@RequestParam(value = "empNo", required = false) String empNo,
			@RequestParam(value = "singleNo", required = false) String singleNo,
			@RequestParam(value = "suppName", required = false) String suppName, Model model) {
		if (pageNo == null) {
			pageNo = 1;
		}
		PageInfo<PurchaseRequest> purchaseRequestByBlurry = purchaseRequestService.getPurchaseRequestByBlurry(pageNo, 5,
				empNo, singleNo, suppName);
		model.addAttribute("prbb", purchaseRequestByBlurry);
		model.addAttribute("empNo", empNo); // 查询条件保存
		model.addAttribute("singleNo", singleNo);
		model.addAttribute("suppName", suppName);
		// model.addAttribute("msg", "a"); //前台提示语句
		return "purchase/purchaseRequest";
	}

	/**
	 * 跳转到采购订单申请页面
	 * 
	 * @param model
	 * @return
	 */
	@RequiresPermissions("purchase:add")
	@RequestMapping("/goPurchaseRequest")
	public String goPurchaseRequest(Model model) {
		PageInfo<Employee> employees = employeeService.getEmployeeAll(1, 10000);
		List<Supplier> suppliers = supplierService.getSupplierAll();
		PageInfo<Product> productAll = productService.getProductAll(1); // 分页查询 刚开始进入查询第一页的数据

		model.addAttribute("employees", employees.getList());
		model.addAttribute("suppliers", suppliers);
		model.addAttribute("productAll", productAll);

		return "purchase/purchaseRequestAdd";
	}

	/**
	 * 通过ajax实现分页产品信息 采购订单申请页面中
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
	 * 通过ajax实现 根据采购单号查询一个采购订单所有信息
	 * 
	 * @param singleNo
	 * @return
	 */
	@RequestMapping("getPurchaseRequestBySingleNo")
	@ResponseBody
	public String getPurchaseRequestBySingleNo(@RequestParam("singleNo") String singleNo,
			@RequestParam(value = "pageNo", required = false) Integer pageNo) {
		if (null == pageNo) {
			pageNo = 1;
		}
		PurchaseRequest purchaseRequestBySingleNo = purchaseRequestService.getPurchaseRequestBySingleNo(singleNo);
		PageInfo<PurchaseRequestDetail> pageInfos = purchaseRequestDetailService.getPurchaseRequestDetail(singleNo,
				pageNo, 3);
		pageInfos.getList().get(0).setPurchaserequest(purchaseRequestBySingleNo);
		String jsonString = JSON.toJSONString(pageInfos);
		return jsonString;
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
		if (addPurchaseRequest == 1) { // 申请失败
			return "error";
		} else { // 申请成功
			return "redirect:gopurchase"; // 跳转到首页查询页面
		}
	}

	/**
	 * 跳转到修改的页面
	 * 
	 * @param singleNo
	 * @param model
	 * @return
	 */
	@RequiresPermissions("purchase:update")
	@RequestMapping("/goPurchaseUpdate")
	public String goPurchaseUpdate(String singleNo, Model model, Integer productPageNo) {
		if (null == productPageNo) {
			productPageNo = 1;
		}
		// 根据订单号查询一个订单所有信息
		PurchaseRequest purchase = purchaseRequestService.getPurchaseRequestBySingleNo(singleNo);
		PageInfo<PurchaseRequestDetail> purchaseRequestDetails = purchaseRequestDetailService
				.getPurchaseRequestDetail(singleNo, 1, 1000);
		PageInfo<Employee> employeeAll = employeeService.getEmployeeAll(1, 10000);
		List<Supplier> supplierAll = supplierService.getSupplierAll();
		PageInfo<Product> productAll = productService.getProductAll(productPageNo);
		model.addAttribute("purchase", purchase);
		model.addAttribute("purchaseDetails", purchaseRequestDetails);
		model.addAttribute("employeeAll", employeeAll.getList());
		model.addAttribute("supplierAll", supplierAll);
		model.addAttribute("productAll", productAll);
		return "purchase/purchaseUpdate";
	}

	/**
	 * 采购申请修改的方法 同时添加采购订单明细
	 * 
	 * @return
	 */
	@RequestMapping("productRequestUpdate")
	public String productRequestUpdate(PurchaseRequest purchaseRequest, Model model, String products) {
		// 修改基本信息
		List<PurchaseRequestDetail> parseArray = JSONObject.parseArray(products, PurchaseRequestDetail.class);
		purchaseRequest.setPurchaserequestdetails(parseArray);// 为产品详情赋值
		int updatePurchaseRequest = purchaseRequestService.updatePurchaseRequest(purchaseRequest);
		if (updatePurchaseRequest > 0) { // 修改成功
			return "redirect:gopurchase";
		} else { // 修改失败
			return "error";
		}
	}

	/**
	 * 
	 * 修改页面分页查询采购订单明细
	 * 
	 * @param pageNum
	 * @param purchaseId
	 * @return
	 */
	@RequestMapping("getExistProductByPage")
	@ResponseBody
	public String getExistProductByPage(Integer pageNum, String purchaseId) {
		PageInfo<PurchaseRequestDetail> purchaseRequestDetail = purchaseRequestDetailService
				.getPurchaseRequestDetail(purchaseId, pageNum, 1000);
		return JSON.toJSONString(purchaseRequestDetail);
	}

	/**
	 * 使用ajax实现根据id删除一条采购明细
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions("purchase:delete")
	@RequestMapping("delPurchaseDetailById")
	@ResponseBody
	public String delPurchaseDetailById(int id) {
		int delPurchaseRequestDetail = purchaseRequestDetailService.delPurchaseRequestDetail(id);
		if (delPurchaseRequestDetail > 0) { // 删除成功
			return "1";
		} else
			return "0";
	}

	/**
	 * 提交表单
	 * 
	 * @return
	 */
	@RequestMapping("operaOrder")
	public String operaOrder(String singleNo, Integer statusNo) {
		int updatePurchaseOrderStatus = purchaseRequestService.updatePurchaseOrderStatus(singleNo, statusNo);// 直接把订单状态改成订单审核中
		if (updatePurchaseOrderStatus > 0) { // 修改成功
			return "redirect:gopurchase"; // 跳转到查询所有
		} else {
			return "error";
		}
	}

	/**
	 * 订单审核 部门经理审核
	 * 
	 * @param singleNo
	 *            订单号
	 * @param no
	 *            是否通过
	 * @param reason
	 *            原因
	 * @return
	 */
	@RequiresPermissions("purchase:deptreview")
	@RequestMapping("deptReview")
	public String deptReview(String singleNo, Integer no, String reason, HttpServletRequest request) {
		Employee employee = (Employee) request.getSession().getAttribute("loginEmp");
		int updateDeptReivewStatus = purchaseRequestService.updateDeptReivewStatus(singleNo, employee.getEmpLoginName(),
				new Date(), no, reason);
		if (updateDeptReivewStatus > 0) { // 执行成功
			return "redirect:gopurchase";
		} else {
			return "error";
		}
	}

	/**
	 * 财务审核采购单
	 * 
	 * @param singleNo
	 *            采购单号
	 * @param no
	 *            是否同意
	 * @param reason
	 *            原因
	 * @param request
	 * @return
	 */
	@RequiresPermissions("purchase:finalreview")
	@RequestMapping("finalReview")
	public String finalReview(String singleNo, Integer no, String reason, HttpServletRequest request) {
		Employee employee = (Employee) request.getSession().getAttribute("loginEmp");
		int updateFinancialReivewStatus = purchaseRequestService.updateFinancialReivewStatus(singleNo,
				employee.getEmpLoginName(), new Date(), no, reason);
		if (updateFinancialReivewStatus > 0) {// 执行成功
			return "redirect:gopurchase";
		} else
			return "error";
	}

	/**
	 * 使用ajax验证是否可以执行操作
	 * 
	 * @param singleNo
	 * @return
	 */
	@RequestMapping("judgmen")
	@ResponseBody
	public String judgmen(String singleNo) {
		PurchaseRequest purchaseRequestBySingleNo = purchaseRequestService.getPurchaseRequestBySingleNo(singleNo);
		int no = purchaseRequestBySingleNo.getOrderStatus().getNo();
		System.out.println(no + "\t" + purchaseRequestBySingleNo.getOrderStatus().getOrderType());
		if (no == 2 || no == 5 || no == 7) { // 当订单状态处于取消 拒绝 全部入库的状态才可以删除
			return "1";
		} else
			return "0"; // 不可以删除
	}

	/**
	 * 删除所选订单
	 * 
	 * @return
	 */
	@RequestMapping("deletePurchases")
	public String deletePurchases(String singleNos) {
		try {
			String[] single = singleNos.split("-");
			for (int i = 1; i < single.length; i++) {
				purchaseRequestService.deletePurchaseRequest(single[i]);
			}
			return "redirect:gopurchase";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 导出excel 有pageNo导出当前 没有导出所有
	 * 
	 * @param pageNo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/purchaseExport")
	public void exportExcel(@RequestParam(value = "pageNo", required = false) Integer pageNo,
			@RequestParam(value = "empNo", required = false) String empNo,
			@RequestParam(value = "singleNo", required = false) String singleNo,
			@RequestParam(value = "suppName", required = false) String suppName, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 获取数据
		List<PurchaseRequest> list = null;
		if (null == pageNo) {
			list = purchaseRequestService.getPurchaseRequestByBlurry(1, 100000, null, null, null).getList();
		} else {
			list = purchaseRequestService.getPurchaseRequestByBlurry(pageNo, 5, empNo, singleNo, suppName).getList();
		}
		// 获取文件名
		String fileName = "Purchase" + new SimpleDateFormat("MMddhhmmsss").format(new Date())
				+ String.valueOf((int) (Math.random() * 9 + 1) * 1000) + ".xlsx";
		// 生成excel并且下载
		new ExportExcel(null, PurchaseRequest.class, 1).setDataList(list).write(response, fileName).dispose();
	}

}
