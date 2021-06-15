package com.yanado.controller.auc;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping('auc/view')
public class SearchAucController {
	
	@Autowired
	public AucDAO aucDAO;
	
	//경매 보기
	@RequestMapping("auc/view")
	public ModelAndView viewAuc(@RequestParam String aucNo) {
		System.out.println(aucNo);
		
		ModelAndView mav = new ModelAndView("view/auc/view");
		mav.setViewName("auc/view");
		
		Auc auc = aucDAO.findAucById;
		Auc auc = aucDAO.findAucByProduct;
		
		mav.addObject("allaucList", auc);
	}
}
