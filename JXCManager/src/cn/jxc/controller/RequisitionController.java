package cn.jxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jxc.pojo.ReviewStatus;
import cn.jxc.service.ReviewStatusService;

@Controller
public class RequisitionController {
	
	
	
	@Autowired
	private ReviewStatusService rsmapperservice;
	
	//�����ѯ
	@RequestMapping("/gorequisition")
	public String gorequisition(Model model) {
		//���״̬
		List<ReviewStatus> rslist = rsmapperservice.getReviewStatus();
		model.addAttribute("rslist", rslist);
		System.out.println(rslist.size());
		//��ҳ��ѯ
		
		return "resuisition/requisition";
	}
	//��ת������
	@RequestMapping("/gorequisitionadd")
	public String gorequisitionadd() {
		return "resuisition/requisitionAdd";
	}
	//��ת���޸�
	@RequestMapping("/gorequisitionupdate")
	public String gorequisitionupdate() {
		return "resuisition/requisitionUpdate";
	}
	
	
	
}
