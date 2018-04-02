package cn.jxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

import cn.jxc.pojo.Employee;
import cn.jxc.pojo.Product;
import cn.jxc.pojo.Requisition;
import cn.jxc.pojo.RequisitionDetail;
import cn.jxc.pojo.ReviewStatus;
import cn.jxc.pojo.StoreHouse;
import cn.jxc.service.EmployeeService;
import cn.jxc.service.ProductService;
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
	//���������ѯҳ��
	@RequestMapping("/gorequisition")
	public String gorequisition(Integer pageNo,Model model) {
		if(pageNo==null || pageNo==0) {
			pageNo=1;
		}
		//���״̬
		List<ReviewStatus> rslist = rsmapperservice.getReviewStatus();
		//�����������ѯ
		PageInfo<Requisition> reslist = requisitionmapperservice.getRequisition(null,null,pageNo);
		model.addAttribute("rslist", rslist);
		model.addAttribute("reslist", reslist);
		return "resuisition/requisition";
	}
	
	//��������ѯ
	@RequestMapping("getbyrsid")
	public String getByrsid(
			@RequestParam(value="requisitionId",required=false) String requisitionId,
			@RequestParam(value="rs_id",required=false) String rs_id,
			Integer pageNo,
			Model model) {
		if(pageNo==null || pageNo==0) {
			pageNo=1;
		}
		//���״̬
		List<ReviewStatus> rslist = rsmapperservice.getReviewStatus();
		//�����������ѯ	
		Integer rsid =Integer.parseInt(rs_id); 
		if(rsid==0) {
			rsid=null;
		}
		PageInfo<Requisition> reslist = requisitionmapperservice.getRequisition(requisitionId,rsid,pageNo);
		model.addAttribute("rslist", rslist);
		model.addAttribute("reslist", reslist);
		return "resuisition/requisition";
	}
	
	//��ϸ��ѯ
	@RequestMapping("/requisitionId")
	public String requisitionId(String requisitionId,Model model) {
		Requisition requisition = requisitionmapperservice.requisitionByid(requisitionId);
		model.addAttribute("requisition",requisition);
		System.out.println("ѡ�еĶ������ǣ�"+requisition.getRequisitionId());
		return "resuisition/requisition";
	}
	
	//��ת������
	@RequestMapping("/gorequisitionadd")
	public String gorequisitionadd(Model model) {
		//Ա����Ϣ
		List<Employee> employees = employeeservice.getEmployeeAll();
		//�ֿ���Ϣ
		List<StoreHouse> storehouse = storehouseservice.getStoreHouselist();
		//��Ʒ��Ϣ
		PageInfo<Product> productAll = productService.getProductAll(1); 
		model.addAttribute("employees", employees);
		model.addAttribute("storehouse", storehouse);
		model.addAttribute("productAll", productAll);
		return "resuisition/requisitionAdd";
	}
	
	
	//��������
	@RequestMapping("requisitionAdd")
	public String addRequisition(Requisition requisition,String products) {
		List<RequisitionDetail> requisitionDetail = JSONObject.parseArray(products,RequisitionDetail.class);
		requisition.setRequisitiondetails(requisitionDetail);
		int requisitioncount = requisitionmapperservice.Requisitionadd(requisition);
		if(requisitioncount==1) {
			return "gorequisitionadd";
		}else {
			return "redirect:gorequisition";
		}
	}
	
	
	//��ת���޸�
	@RequestMapping("gorequisitionupdate")
	public String gorequisitionupdate(String requisitionId,Model model) {
		Requisition requ = requisitionmapperservice.requisitionByid(requisitionId);
		System.out.println("��������ID�ǣ�"+requisitionId);
		model.addAttribute("requ", requ);
		return "resuisition/requisitionUpdate";
	}
}