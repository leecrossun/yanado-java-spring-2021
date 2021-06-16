package com.yanado.controller.shopping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dao.ShoppingDAO;
import com.yanado.dto.Product;
import com.yanado.dto.Shopping;
import com.yanado.service.ShoppingService;

@Controller
@SessionAttributes("shopping")
@RequestMapping("shopping/update")
public class UpdateShoppingController {
	
	@Autowired
	private ShoppingDAO shoppingDAO;
	
	@Autowired
	private ShoppingService service;
	
	@ModelAttribute("shopping")
	public Shopping formBacking(HttpServletRequest request) {
		// 상품 연결과정에서 문제있을 경우 수정
		Shopping shopping = new Shopping();
		Product product = new Product();
		shopping.setProduct(product);
		return shopping;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView form(@RequestParam String shoppingId) {
		System.out.println(shoppingId);
		ModelAndView mav = new ModelAndView();
		Shopping shopping = shoppingDAO.getShoppingByshoppingId(shoppingId);
		System.out.println(shopping.getProduct().getProductId());
		mav.setViewName("shopping/form");
		mav.addObject("shopping", shopping);
		mav.addObject("formtype", "update");
		
		return mav;
	}


	@RequestMapping(method = RequestMethod.POST)
	public String updateShopping(@Valid @ModelAttribute("shopping") Shopping shopping, BindingResult result,
			SessionStatus status) {

		if (result.hasErrors()) {
			return "shopping/form";
		}

		status.setComplete();
		service.updateShopping(shopping);
		return "redirect:/shopping/view/detail?shoppingId=" + shopping.getShoppingId();
	}

}
