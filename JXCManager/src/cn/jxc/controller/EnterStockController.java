package cn.jxc.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Employee;
import cn.jxc.pojo.EnterStock;
import cn.jxc.pojo.EnterStockDetail;
import cn.jxc.pojo.EnterStockType;
import cn.jxc.pojo.Product;
import cn.jxc.pojo.StoreHouse;
import cn.jxc.service.BackSalesDetailService;
import cn.jxc.service.BackSalesService;
import cn.jxc.service.EmployeeService;
import cn.jxc.service.EnterStockDetailService;
import cn.jxc.service.EnterStockService;
import cn.jxc.service.EnterStockTypeService;
import cn.jxc.service.ProductService;
import cn.jxc.service.PurchaseRequestDetailService;
import cn.jxc.service.PurchaseRequestService;
import cn.jxc.service.RequisitionDetailService;
import cn.jxc.service.RequisitionService;
import cn.jxc.service.StoreHouseService;

/**
 * ���
 * 
 * @author ������
 *
 */
@Controller
public class EnterStockController {

	@Autowired
	private EnterStockTypeService enterStockType;
	@Autowired
	private EnterStockService enterStockService;
	@Autowired
	private EnterStockDetailService enterStockDetailService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private StoreHouseService storeHouseService;
	@Autowired
	private ProductService productService;
	@Autowired
	private BackSalesService backSalesService;
	@Autowired
	private RequisitionService requisitionService;
	@Autowired
	private PurchaseRequestService purchaseRequestService;
	@Autowired
	private PurchaseRequestDetailService purchaseRequestDetailService;
	@Autowired
	private BackSalesDetailService backSalesDetailService;
	@Autowired
	private RequisitionDetailService requisitionDetailService;

	/**
	 * ��ת����ⵥҳ��
	 * 
	 * @param singleNo
	 * @param shName
	 * @param start
	 * @param end
	 * @param pageNo
	 * @param model
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/goenterstock")
	public String goenterstock(@RequestParam(value = "singleNo", required = false) String singleNo,
			@RequestParam(value = "shName", required = false) String shName,
			@RequestParam(value = "start", required = false) String start,
			@RequestParam(value = "end", required = false) String end,
			@RequestParam(value = "pageNo", required = false) Integer pageNo, Model model) throws ParseException {
		if (null == pageNo) {
			pageNo = 1;
		}
		PageInfo<EnterStock> enterStockBySuless = enterStockService.getEnterStockBySuless(singleNo, shName, start, end,
				pageNo, 5);
		model.addAttribute("ess", enterStockBySuless);
		model.addAttribute("singleNo", singleNo);
		model.addAttribute("shName", shName);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		return "enterStork/enterStock";
	}

	/**
	 * ��ת�������ӵ�ҳ��
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/goenterstockadd")
	public String goenterstockadd(Model model) {
		List<EnterStockType> enterStockTypeAll = enterStockType.getEnterStockTypeAll();
		List<Employee> employeeAll = employeeService.getEmployeeAll();
		List<StoreHouse> storeHouselist = storeHouseService.getStoreHouselist();
		PageInfo<Product> productAll = productService.getProductAll(1);
		model.addAttribute("estAll", enterStockTypeAll);
		model.addAttribute("employeeAll", employeeAll);
		model.addAttribute("storeHouseAll", storeHouselist);
		model.addAttribute("productAll", productAll);
		return "enterStork/enterStockAdd";
	}

	@RequestMapping("/enterStockInsert")
	public String enterStockInsert(EnterStock enterStock,
			@RequestParam("enterStockProducts") String enterStockProducts) {
		List<EnterStockDetail> parseArray = JSONArray.parseArray(enterStockProducts, EnterStockDetail.class);
		enterStock.setEnterstockdetails(parseArray);
		int enterStockAdd = enterStockService.enterStockAdd(enterStock);
		if (enterStockAdd > 0) { // ��ӳɹ�
			return "redirect:goenterstock";
		} else {
			return "error";
		}
	}

	/**
	 * ͨ��ajaxʵ�ּ������ε���
	 * 
	 * @param type
	 *            �������
	 * @return
	 */
	@RequestMapping("/getUpstreamNo")
	@ResponseBody
	public String getUpstreamNo(String type) {
		if ("1".equals(type)) {
			return JSON.toJSONString(
					purchaseRequestService.getPurchaseRequestByBlurry(1, 10000, null, null, null).getList());
		} else if ("2".equals(type)) {
			return JSON.toJSONString(backSalesService.getBackSalesAll());
		} else if ("3".equals(type)) {
			return JSON.toJSONString(requisitionService.getRequisition(null, null, 1, 1000).getList());
		} else {
			return "";
		}
	}

	/**
	 * ����ѡ�еĶ����� ��ȡ��������
	 * 
	 * @param singleNo
	 * @param type
	 * @return
	 */
	@RequestMapping("/getSingleNoDetail")
	@ResponseBody
	public String getSingleNoDetail(String singleNo, String type) {
		if ("1".equals(type)) { // �ɹ�
			return JSON
					.toJSONString(purchaseRequestDetailService.getPurchaseRequestDetail(singleNo, 1, 10000).getList());
		} else if ("2".equals(type)) { // �˻����
			return JSON.toJSONString(backSalesDetailService.getBackSalesDetailBySingleNo(singleNo));
		} else if ("3".equals(type)) { // �������
			return JSON.toJSONString(requisitionDetailService.requisitionDetailById(singleNo, 1, 10000));
		} else {
			return "";
		}
	}

	/**
	 * ʹ��ajaxʵ�ָ��ݶ����Ų�ѯ��ⵥ ��ⵥ����ʹ�÷�ҳʵ��
	 * 
	 * @param singleNo
	 *            ��ⵥ��
	 * @param pageNo
	 *            ҳ����
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/getEnterStockBySingleNo")
	@ResponseBody
	public String getEnterStockBySingleNo(String singleNo, @RequestParam(value = "pageNo", required = false) Integer pageNo) throws ParseException {
		EnterStock enterStock = enterStockService.getEnterStockBySuless(singleNo, null, null, null, 1, 1000).getList()
				.get(0);
		if (pageNo == null) {
			pageNo = 1;
		}
		PageInfo<EnterStockDetail> enterStockDetailBySingleNo = enterStockDetailService
				.getEnterStockDetailBySingleNo(singleNo, pageNo, 3);
		enterStockDetailBySingleNo.getList().get(0).setEnterstock(enterStock);
		return JSON.toJSONString(enterStockDetailBySingleNo);
	}

}
