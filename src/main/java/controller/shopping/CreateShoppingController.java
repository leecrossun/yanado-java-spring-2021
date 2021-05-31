package controller.shopping;

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
import persistence.dao.ShoppingDAO;
import service.dto.Shopping;


@Controller
@SessionAttributes("shopping")
@RequestMapping("shopping/create")
public class CreateShoppingController {
	
	@Autowired
	private ShoppingDAO shoppingDAO;
	
	@ModelAttribute("shopping")
	public Shopping formBacking(HttpServletRequest request) {
		Shopping shopping = new Shopping();
		return shopping;
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String form() {
		return "shopping/form";
	}


	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createShopping(@Valid @ModelAttribute("shopping") Shopping shopping, BindingResult result,
			SessionStatus status) {

		if (result.hasErrors()) {
			return "shopping/form";
		}

		status.setComplete();
		shoppingDAO.createShopping(shopping);
		return "shopping/list";
	}

}
