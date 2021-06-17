package com.yanado.controller.common;

import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.dao.ProductDAO;
import com.yanado.dto.Product;

@Controller
@SessionAttributes("product")
public class CreateCommonProductController {

	@Autowired
	private ProductDAO productDao;

	// 공동구매 생성 폼으로 가기
	@ModelAttribute("product")
	public Product formBacking(HttpServletRequest request) {
		Product p = new Product();
		// UserSessionUtils uSession = new UserSessionUtils();
		// String userId = uSession.getLoginUserId(request.getSession());
		String userId = "admin";
		p.setSupplierId(userId);
		p.setCategory("common");
		return p;
	}

	@RequestMapping(value = "/product/create", method = RequestMethod.GET)
	public String form() {
		return "common/product";
	}

	// 공동구매 생성하기
	@RequestMapping(value = "/product/create", method = RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,
			SessionStatus status, RedirectAttributes red) {

		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "common/product";
		}

		status.setComplete();
		productDao.createProduct(product);

		red.addAttribute("productId", product.getProductId());
		red.addAttribute("type", 1);

		return "common/product";
	}

	@RequestMapping("/product/find")
	public ModelAndView findProduct() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/productList");

		// 리스트 가져오기
		// Listt<Product> = productDao.

		return mav;
	}

}