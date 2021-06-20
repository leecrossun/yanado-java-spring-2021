package com.yanado.controller.auc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.yanado.dto.Auc;
import com.yanado.service.AucService;

@Controller
public class ReadAucController {
	@Autowired
	private AucService aucService;
	
	@RequestMapping("/auc/read")
	public ModelAndView read(HttpServletRequest request, @RequestParam String aucNo) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("auc/read");
		
		List<Auc> auc = aucService.findAucByaucNo(aucNo);
		mav.addObject("auc",auc);
		
		return mav;
	}
	
}
