package com.yanado.controller.auc;

import com.yanado.dto.Auc;
import com.yanado.service.AucService;

@Controller
@SessionAtrributes("auc")
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
	   
	   @RequestMapping(value='/auc/create',method=RequestMethod.GET)
	   public String from() {
	      return 'auc/form';
	   }
	   
	   @RequestMapping(value = "/auc/create", method = RequestMethod.POST)
	   public String createShopping(@Valid @ModelAttribute("auc") Auc auc, BindingResult result,
	         SessionStatus status) {

	      if (result.hasErrors()) {
	         return "auc/form";
	      }
	      aucService.createAuc(auc);
	      status.setComplete();
	      return "redirect:/auc/";
	   }

}
