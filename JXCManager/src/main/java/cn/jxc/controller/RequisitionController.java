package cn.jxc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

import cn.jxc.excel.ExportExcel;
import cn.jxc.pojo.Employee;
import cn.jxc.pojo.Product;
import cn.jxc.pojo.PurchaseRequest;
import cn.jxc.pojo.Requisition;
import cn.jxc.pojo.RequisitionDetail;
import cn.jxc.pojo.ReviewStatus;
import cn.jxc.pojo.StoreHouse;
import cn.jxc.service.EmployeeService;
import cn.jxc.service.ProductService;
import cn.jxc.service.RequisitionDetailService;
import cn.jxc.service.RequisitionService;
import cn.jxc.service.ReviewStatusService;
import cn.jxc.service.StoreHouseService;

@Controller
public class RequisitionController {
	
	@Autowired
	private ReviewStatusService rsmapperservice;
	@Autowired
	private RequisitionService requisitionmapperservice;
	@Autowired
	private EmployeeService employeeservice;
	@Autowired
	private StoreHouseService storehouseservice;
	@Autowired
	private ProductService productService;
	@Autowired
	private RequisitionDetailService requisitiondetailservice;
	//���������ѯҳ��
	@RequestMapping("/gorequisition")
	public String gorequisition(Integer pageNo,Model model) {
		if(pageNo==null || pageNo==0) {
			pageNo=1;
		}
		//�����������ѯ
		PageInfo<Requisition> reslist = requisitionmapperservice.getRequisition(null,null,pageNo,10);
		
		model.addAttribute("reslist", reslist);
		return "resuisition/requisition";
	}
	
	//��������ѯ
	@RequestMapping("getbyrsid")
	public String getByrsid(
			@RequestParam(value="requisitionId",required=false) String requisitionId,
			@RequestParam(value="requisitionnameEmp",required=false) String requisitionnameEmp,
			Integer pageNo,
			Model model) {
		if(pageNo==null || pageNo==0) {
			pageNo=1;
		}
		PageInfo<Requisition> reslist = requisitionmapperservice.getRequisition(requisitionId,requisitionnameEmp,pageNo,10);
		model.addAttribute("reslist", reslist);
		model.addAttribute("requisitionId", requisitionId);
		model.addAttribute("requisitionnameEmp", requisitionnameEmp);
		return "resuisition/requisition";
	}
	
	//��ϸ��ѯ
	@RequestMapping("/requisitionId")
	public String requisitionId(String requisitionId,Model model) {
		Requisition requisition = requisitionmapperservice.requisitionByid(requisitionId);
		model.addAttribute("requisition",requisition);
		return "resuisition/requisition";
	}
	
	//��ת������
	@RequestMapping("/gorequisitionadd")
	public String gorequisitionadd(Model model) {
		//Ա����Ϣ
		PageInfo<Employee> employees = employeeservice.getEmployeeAll(1,10000);
		//�ֿ���Ϣ
		List<StoreHouse> storehouse = storehouseservice.getStoreHouselist();
		//��Ʒ��Ϣ
		PageInfo<Product> productAll = productService.getProductAll(1,5); 
		model.addAttribute("employees", employees.getList());
		model.addAttribute("storehouse", storehouse);
		model.addAttribute("productAll", productAll);
		return "resuisition/requisitionAdd";
	}
	
	
	//��������
	@RequestMapping("requisitionAdd")
	public String addRequisition(Requisition requisition,String products) {
		List<RequisitionDetail> requisitionDetail = JSONObject.parseArray(products,RequisitionDetail.class);
		requisition.setRequisitiondetails(requisitionDetail);
		requisition.setRequestTime(new Date());
		int requisitioncount = requisitionmapperservice.Requisitionadd(requisition);
		if(requisitioncount==1) {
			return "gorequisitionadd";
		}else {
			return "redirect:/gorequisition";
		}
	}
	
	
	//��ת���޸�
	@RequestMapping("gorequisitionupdate")
	public String gorequisitionupdate(String requisitionId,Model model) {		
		//����������
		//requisitionId = requisitionId.substring(1, requisitionId.lastIndexOf('\''));
		System.out.println(requisitionId);
		Requisition requisition = requisitionmapperservice.requisitionByid(requisitionId);
		System.out.println(requisition.getRequisitionId());
		System.out.println(requisitionId);
		//�������������
		PageInfo<RequisitionDetail> requisitionDetail = requisitiondetailservice
				.requisitionDetailById(requisitionId, 1, 1000);
		//Ա����Ϣ
		PageInfo<Employee> employees = employeeservice.getEmployeeAll(1,10000);
		//�ֿ���Ϣ
		List<StoreHouse> storehouse = storehouseservice.getStoreHouselist();
		//��Ʒ��Ϣ
		PageInfo<Product> productAll = productService.getProductAll(1,5); 
		model.addAttribute("requisition",requisition);
		model.addAttribute("requisitionDetail",requisitionDetail);
		model.addAttribute("employees",employees.getList());
		model.addAttribute("storehouse",storehouse);
		model.addAttribute("productAll",productAll);
		return "resuisition/requisitionUpdate";
	}
	/**
	 * ʹ��ajaxʵ�ָ���idɾ��һ���ɹ���ϸ
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("delrequisitionDetailById")
	public String delrequisitionByid(int id) {
		int delPurchaseRequestDetail = requisitiondetailservice.delrequisitionByid(id);
		if (delPurchaseRequestDetail > 0) { // ɾ���ɹ�
			return "1";
		} else
			return "0";
	}	
	
	//�޸��ύ
	@RequestMapping("requisitionUpdate")
	public String requisitionUpdate(Requisition requisition, Model model, String products) {
		try {
			// �޸Ļ�����Ϣ
			List<RequisitionDetail> parseArray = JSONObject.parseArray(products, RequisitionDetail.class);
			requisition.setRequisitiondetails(parseArray);// Ϊ��Ʒ���鸳ֵ
			int requisitioncount = requisitionmapperservice.RequisitionUpdate(requisition);
			System.out.println(requisition.getRequisitionId());
			if (requisitioncount > 0) {
				return "redirect:gorequisition";
			} else {
				return "error";
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * ͨ��ajaxʵ�� ���ݵ��Ų�ѯһ���ɹ�����������Ϣ
	 * 
	 * @param singleNo
	 * @return
	 */
	@RequestMapping("getRequisitionBySingleNo")
	@ResponseBody
	public String getPurchaseRequestBySingleNo(@RequestParam("singleNo") String singleNo,
			@RequestParam(value = "pageNo", required = false) Integer pageNo) {
		if (null == pageNo) {
			pageNo = 1;
		}
		Requisition requisition = requisitionmapperservice.requisitionByid(singleNo);
		PageInfo<RequisitionDetail> pageinfos = requisitiondetailservice.requisitionDetailById(singleNo, pageNo, 3);
		System.out.println(requisition.getReason());
		//System.out.println(requisition.getReviewTime());
		pageinfos.getList().get(0).setRequisition(requisition);
		String jsonString = JSON.toJSONString(pageinfos);
		return jsonString;
	}
	/**
	 * ɾ����������
	 * 
	 * */
	@RequestMapping("deleteRequisition")
	public String deleteRequisition(String requisitionid) {
		try {
			String[] single = requisitionid.split("-");
			for (int i = 1; i < single.length; i++) {
				requisitionmapperservice.RequisitionDelete(single[i]);
				System.out.println("id��"+single[i]);
			}
			return "redirect:gorequisition";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping("judgmens")
	@ResponseBody
	public String judgmen(String singleNo) {
		Requisition requisitionByid=requisitionmapperservice.getRequisitionById(singleNo);
		int no = requisitionByid.getReviewstatus().getRsId();
		String num = "";
		System.out.println(no+"\t"+requisitionByid.getReviewstatus().getRsName());
		if (no == 1 || no == 3 ) { // ������״̬����״̬�ſ���ɾ��
			num = "1";
			return num;
		} else {
			num = "0";
			return num; // ������ɾ��
		}
	}
	
	/**
	 * ����excel ��pageNo������ǰ û�е�������
	 * 
	 * @param pageNo
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/requisitionExport")
	public void requisitionExportExcel(
			@RequestParam(value = "pageNo", required = false) Integer pageNo,
			@RequestParam(value = "requisitionId", required = false) String requisitionId,
			@RequestParam(value = "requisitionnameEmp", required = false) String requisitionnameEmp,		
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// ��ȡ����
		List<Requisition> list =null;
		if (null == pageNo) {
			list = requisitionmapperservice.getRequisition(null, null, 1, 100000).getList();
		} else {
			list = requisitionmapperservice.getRequisition(requisitionId, requisitionnameEmp, pageNo, 5).getList();
		}
		// ��ȡ�ļ���
		String fileName = "Requisition" + new SimpleDateFormat("MMddhhmmsss").format(new Date())
				+ String.valueOf((int) (Math.random() * 9 + 1) * 1000) + ".xlsx";
		// ����excel��������
		new ExportExcel(null, Requisition.class, 1).setDataList(list).write(response, fileName).dispose();
	}
	
	//���
	@RequestMapping("requisitionReview")
	public String deptReview(String requisitionId, Integer status, String reason, HttpServletRequest request) {
		Employee employee = (Employee) request.getSession().getAttribute("loginEmp");
		int order = 0;
		if(status==2){
			order = 4;
		}else if(status==3){
			order = 5;
		}
		int updaterequisition = requisitionmapperservice.updaterequisition(requisitionId, employee.getEmpLoginName(),
				new Date(), status,order, reason);
		if (updaterequisition > 0) { // ִ�гɹ�
			return "redirect:/gorequisition";
		} else {
			return "error";
		}
	}
}