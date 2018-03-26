package cn.jxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.jxc.pojo.Requisition;
import cn.jxc.pojo.ReviewStatus;
import cn.jxc.service.RequisitionService;
import cn.jxc.service.ReviewStatusService;

@Controller
public class RequisitionController {
	
	@Autowired
	private ReviewStatusService rsmapperservice;
	@Autowired
	private RequisitionService resmapperservice;
	//���������ѯҳ��
	@RequestMapping("/gorequisition")
	public String gorequisition(Model model) {
		//���״̬
		List<ReviewStatus> rslist = rsmapperservice.getReviewStatus();
		//�����������ѯ
		List<Requisition> reslist = resmapperservice.getRequisition(null,null);
		model.addAttribute("rslist", rslist);
		model.addAttribute("reslist", reslist);
		//��ҳ��ѯ
		
		return "resuisition/requisition";
	}
	//��������ѯ
	@RequestMapping("getbyrsid")
	public String getByrsid(
			@RequestParam(value="requisitionId",required=false) String requisitionId,
			@RequestParam(value="rs_id",required=false) String rs_id,
			Model model) {
		//���״̬
		List<ReviewStatus> rslist = rsmapperservice.getReviewStatus();
		//�����������ѯ
		Integer rsid =Integer.parseInt(rs_id); 
		if(rsid==0) {
			rsid=null;
		}
		List<Requisition> reslist = resmapperservice.getRequisition(requisitionId,rsid);
		model.addAttribute("rslist", rslist);
		model.addAttribute("reslist", reslist);
		return "resuisition/requisition";
	}
	
	//��ת������
	@RequestMapping("/gorequisitionadd")
	public String gorequisitionadd() {
		return "resuisition/requisitionAdd";
	}
	//��ת���޸�
	@RequestMapping("/gorequisitionupdate")
	public String gorequisitionupdate(String requisitionId,Model model) {
		
		Requisition requ = resmapperservice.requisitionByid(requisitionId);
		model.addAttribute("requ", requ);
		return "resuisition/requisitionUpdate";
	}
	
	
	
}
