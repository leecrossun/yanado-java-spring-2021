package com.yanado.controller.order;

import java.util.ArrayList;
import java.util.List;

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

import com.yanado.dao.ProductDAO;
import com.yanado.dao.ShoppingDAO;
import com.yanado.dao.UserDAO;
import com.yanado.dto.Item;
import com.yanado.dto.Order;
import com.yanado.dto.Product;
import com.yanado.dto.Shopping;
import com.yanado.dto.User;
import com.yanado.service.ShoppingService;

@Controller
@SessionAttributes("order")
@RequestMapping("order/create")
public class CreateOrdercontroller {

		@Autowired
		private ShoppingService service;
		
		@Autowired
		private UserDAO userDAO;
		
		@Autowired
		private ShoppingDAO shoppingDAO;
		
		@Autowired
		private ProductDAO productDAO;
		
		@ModelAttribute("order")
		public Order formBacking(HttpServletRequest request) {
			Order order = new Order();
			
			/*
			 * String userId = "admin"; user.setUserId(userId);
			 * 
			 * order.setUser(user); order.setItem(item);
			 */
		
			return order;
		}

		@RequestMapping(method = RequestMethod.GET)
		public ModelAndView form(@Valid @ModelAttribute("order") Order order1, @RequestParam int quentity, @RequestParam String shoppingId, BindingResult result,  SessionStatus status) {
			ModelAndView mav = new ModelAndView();
			// UserSessionUtils uSession = new UserSessionUtils();
			// String userId = uSession.getLoginUserId(request.getSession());
			
			Product product = shoppingDAO.getShoppingByshoppingId(shoppingId).getProduct();
			Order order = new Order();
			order.setUser(userDAO.getUserByUserId("admin"));
			mav.addObject("order",order);
			mav.setViewName("order/form");
			return mav;
		}


		@RequestMapping(method = RequestMethod.POST)
		public String createOrder(@Valid @ModelAttribute("shopping") Shopping shopping, BindingResult result, SessionStatus status) {

			if (result.hasErrors()) {
				System.out.println(result.getAllErrors());
				return "shopping/form";
			}

			service.createShopping(shopping);
			status.setComplete();
			return "redirect:/shopping/view/all";
		}

	}


