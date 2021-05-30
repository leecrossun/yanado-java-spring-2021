package com.yanado.controller.shopping;

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

import com.yanado.dao.ShoppingDAO;
import com.yanado.dto.Product;
import com.yanado.dto.Shopping;

@Controller
@SessionAttributes("shopping")
@RequestMapping("shopping/update")
public class UpdateShoppingController {
	
	@Autowired
	private ShoppingDAO shoppingDAO;
	
	@ModelAttribute("shopping")
	public Shopping formBacking(HttpServletRequest request) {
		// 상품 연결과정에서 문제있을 경우 수정
		Shopping shopping = new Shopping();
		Product product = new Product();
		shopping.setProduct(product);
		return shopping;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String form() {
		return "shopping/form";
	}


	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String createShopping(@Valid @ModelAttribute("shopping") Shopping shopping, BindingResult result,
			SessionStatus status) {

		if (result.hasErrors()) {
			return "shopping/form";
		}

		status.setComplete();
		shoppingDAO.updateShopping(shopping);
		return "shopping/list";
	}

}
