package com.yanado.controller.shopping;

import java.io.File;
import java.io.IOException;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dao.ProductDAO;
import com.yanado.dao.ShoppingDAO;
import com.yanado.dto.Product;
import com.yanado.dto.Shopping;
import com.yanado.service.ShoppingService;


@Controller
@SessionAttributes("shopping")
@RequestMapping("shopping/create")
public class CreateShoppingController {
	
	@Autowired
	private ShoppingService service;
	
	@Autowired
	private ProductDAO productDAO;
	
	@ModelAttribute("shopping")
	public Shopping formBacking(HttpServletRequest request) {
		Shopping shopping = new Shopping();
		Product product = new Product();
		
		// UserSessionUtils uSession = new UserSessionUtils();
		// String userId = uSession.getLoginUserId(request.getSession());
		String userId = "admin";
		product.setSupplierId(userId);
		shopping.setProduct(product);
	
		return shopping;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shopping/form");
		mav.addObject("formtype", "create");
		return mav;
	}


	@RequestMapping(method = RequestMethod.POST)
	public String createShopping(@Valid @ModelAttribute("shopping") Shopping shopping, BindingResult result,
			MultipartFile file, HttpServletRequest request, SessionStatus status) {

		// 이미지 처리
		String basePath = "src/main/resources/static/productImage";
		File folder = new File(basePath);

		if (!folder.exists()) {
			try {
				folder.mkdir(); // 폴더 생성합니다.
				
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		String filePath = folder.getAbsolutePath() + "\\" + file.getOriginalFilename();
		System.out.println(filePath);
		File dest = new File(filePath);
		try {
			file.transferTo(dest);
			System.out.println("파일저장");
		} catch (IllegalStateException | IOException e) {
			System.out.println(e.getMessage());
		}

		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "shopping/form";
		}

		Product product = shopping.getProduct();
		product.setImage("../static/productImage/" + file.getOriginalFilename());
		
		shopping.setProduct(product);

		service.createShopping(shopping);
		status.setComplete();
		return "redirect:/shopping/view/all";
	}

}
