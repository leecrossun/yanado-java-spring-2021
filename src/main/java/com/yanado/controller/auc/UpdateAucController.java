package com.yanado.controller.auc;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.dto.Auc;
import com.yanado.dto.Common;
import com.yanado.service.AucService;

@Controller
public class UpdateAucController {
	@Autowired
	private AucService aucService;
	
	@RequestMapping(value="auc/update",method=RequestMethod.GET)
	public String form(HttpServletRequest request) {
		request.setAttribute("type", 2);
		
		return "auc/form";
	}
	
	@ModelAttribute("auc")
	public Auc formBacking(HttpServletRequest request) {
		String aucId = request.getParameter("aucId");
		
		Auc auc = aucService.getAuc(aucId);
		return auc;
	}
	
	
	@RequestMapping(value="auc/update",method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute("auc") Auc auc, BindingResult result,
			   RedirectAttributes red, SessionStatus status) {
		
	      if (result.hasErrors()) {
	    	 System.out.println(result.getAllErrors());
	         return "auc/form";
	      }
	      
	      aucService.updateAuc(auc);
	      status.setComplete();
	      
	      red.addAttribute("aucId", auc.getAucId());
	      return "redirect:/auc/view/detail";
	}
}
