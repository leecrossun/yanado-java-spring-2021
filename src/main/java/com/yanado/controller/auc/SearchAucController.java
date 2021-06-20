package com.yanado.controller.auc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dao.AucDAO;
import com.yanado.dto.Auc;

@Controller
@RequestMapping("auc/view")
public class SearchAucController {
	
	@Autowired
	public AucDAO aucDAO;
	
	//경매 보기
	@RequestMapping("auc/view")
	public ModelAndView viewAuc(@RequestParam String aucNo) {
		System.out.println(aucNo);
		
		ModelAndView mav = new ModelAndView("view/auc/view");
		mav.setViewName("auc/view");
		
		List<Auc> auc = aucDAO.findAucByAucNo(aucNo);
		
		mav.addObject("allaucList", auc);
		
		return mav;
	}
}
