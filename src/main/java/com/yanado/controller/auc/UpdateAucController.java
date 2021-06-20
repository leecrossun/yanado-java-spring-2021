package com.yanado.controller.auc;

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
import com.yanado.service.AucService;

@Controller
public class UpdateAucController {
	@Autowired
	private AucService aucService;
	
	@RequestMapping(value="auc/update",method=RequestMethod.GET)
	public String form(@ModelAttribute("auc") Auc auc, @RequestParam String aucNo) {
		aucService.updateAuc(auc);
		
		return "auc/form";
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
	      
	      red.addAttribute("aucNo", auc.getaucNo());
	      return "redirect:/auc/read";
	}
}
