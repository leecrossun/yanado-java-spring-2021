package com.yanado.controller.auc;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAtrributes("auc")
public class RegisterAucController {
	@Autowired
	private AucDAO aucDAO;
	
	@ModelAttribute("auc")
	public Auc formBacking(HttpServletRequest request) {
		Auc auc = new Auc();

		return auc;
	}
	@RequestMapping(value='auc/register',method=RequestMethod.GET)
	public String from() {
		return 'auc/form';
	}
	@RequestMapping(value = "auc/register", method = RequestMethod.POST)
	public String createShopping(@Valid @ModelAttribute("auc") Auc auc, BindingResult result,
			SessionStatus status) {

		if (result.hasErrors()) {
			return "auc/form";
		}

		status.setComplete();
		return "auc/created";
	}
}
