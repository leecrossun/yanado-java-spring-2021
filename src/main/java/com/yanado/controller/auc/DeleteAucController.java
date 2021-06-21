package com.yanado.controller.auc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yanado.service.AucService;

@Controller
public class DeleteAucController {
	@Autowired
	private AucService aucService;
	
	@RequestMapping("auc/delete")
	public String delete(@RequestParam String aucId) {
		aucService.deleteAuc(aucId);
		return "redirect:/auc/view/all";
	}
}
