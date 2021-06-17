package com.yanado.controller.common;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;
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
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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

	@RequestMapping(value = "/product/create", method = RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,
			MultipartFile file, HttpServletRequest request, SessionStatus status) {

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
		} catch (IllegalStateException | IOException e) {
			System.out.println(e.getMessage());
		}

		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "common/product";
		}

		status.setComplete();
		product.setImage("../static/productImage/" + file.getOriginalFilename());
		productDao.createProduct(product);

		request.setAttribute("productId", product.getProductId());
		request.setAttribute("type", 1);

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