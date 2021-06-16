package com.yanado.controller.auc;

@Controller
public class BidAucController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "auc/aucFrom";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String submit(AucCommand aucCommand) {
		return "auc/aucCompletion";
	}
}
