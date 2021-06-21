package com.yanado.controller.auc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dto.Auc;
import com.yanado.service.AucService;

@Controller
public class GetAucController {
	@Autowired
	private AucService aucService;
	
	@RequestMapping("auc/list")
	public ModelAndView getAucList(@RequestParam int page, @RequestParam String aucNo) {
		List<Auc> auclist = aucService.findAucByaucNo(aucNo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("auc/list");
		mav.addObject("allaucList", auclist);
		
		return mav;
	}
}
