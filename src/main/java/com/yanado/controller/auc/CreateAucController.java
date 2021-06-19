package com.yanado.controller.auc;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.yanado.dto.Auc;
import com.yanado.service.AucService;

@Controller
@SessionAttributes("auc")
@RequestMapping("/auc/create")
public class CreateAucController {
	   @Autowired
	   private AucService aucService;
	   
	   @ModelAttribute("auc")
	   public Auc formBacking(HttpServletRequest request) {
	      Auc auc = new Auc();
	      String userId = "admin";
	      auc.setuserId(userId);
	      auc.setstatus(0);

	      return auc;
	   }
	   
	   @RequestMapping(value="/auc/create",method=RequestMethod.GET)
	   public String from() {
	      return "auc/form";
	   }
	   
	   @RequestMapping(value = "/auc/create", method = RequestMethod.POST)
	   public String createShopping(@Valid @ModelAttribute("auc") Auc auc, BindingResult result,
	         SessionStatus status) {

	      if (result.hasErrors()) {
	         return "/auc/form";
	      }
	      aucService.createAuc(auc);
	      status.setComplete();
	      return "redirect:/auc/read";
	   }

}
