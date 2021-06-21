package com.yanado.controller.cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.controller.user.UserSessionUtils;
import com.yanado.dao.ProductDAO;
import com.yanado.dao.ShoppingDAO;
import com.yanado.dao.UserDAO;
import com.yanado.dto.Product;
import com.yanado.dto.Shopping;
import com.yanado.dto.User;
import com.yanado.service.UserService;

@Controller
@RequestMapping("/cart")
public class CartController {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ShoppingDAO shoppingDAO;

	@RequestMapping("/add")
	protected String service(@RequestParam String shoppingId, HttpServletRequest request, RedirectAttributes red) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("cart") == null) {
			List<String> cart = new ArrayList<String>();
			session.setAttribute("cart", cart);
			cart.add(shoppingId);
			session.setAttribute("cart", cart);
		}
		else {
			List<String> cart = (List<String>)session.getAttribute("cart");
			cart.add(shoppingId);
			session.setAttribute("cart", cart);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/view")
	protected ModelAndView view(HttpServletRequest request,RedirectAttributes red) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		List<String> cart = (List<String>)session.getAttribute("cart");
		
		if (session.getAttribute("cart") != null) {
			List<Shopping> shoppingList = new ArrayList<Shopping>();
			for(String s: cart) {
				shoppingList.add(shoppingDAO.getShoppingByshoppingId(s));
			}
			
			mav.setViewName("shopping/cart");
			mav.addObject("shoppingList", shoppingList);
			return mav;
		}
		else {
			return null;
		}
		
	}


}