package com.yanado.controller.auc;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class DeleteAucController {
	@Autowired
	private AucService aucService;
	
	@RequestMapping("/auc/delete")
	public String delete(@RequestParam String aucNo) {
		aucService.deleteAuc(aucNo);
		return "redirect:/auc/list";
	}
}
