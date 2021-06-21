package com.yanado.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dao.ShoppingDAO;
import com.yanado.dto.Order;
import com.yanado.dto.Product;
import com.yanado.dto.Shopping;
@Controller
@RequestMapping("/product/view")
public class FindUserProductController {
	
	@Autowired
	ShoppingDAO shoppingDAO;
	
	// 내 판매 리스트
	@RequestMapping("/my")
	public ModelAndView viewOrderByUserId(HttpServletRequest request){
		UserSessionUtils uSession = new UserSessionUtils();
		String userId = uSession.getLoginUserId(request.getSession());
		
		List<Shopping> shopping = shoppingDAO.getShoppingByUserId(userId);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("product/myList");
		mav.addObject("shoppingList", shopping);
		return mav;
		
	}

}
