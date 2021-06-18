package com.yanado.controller.order;

import java.util.ArrayList;
import java.util.Date;
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

import com.yanado.dao.OrderDAO;
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
		private UserDAO userDAO;
		
		@Autowired
		private ShoppingDAO shoppingDAO;
		
		@Autowired
		private OrderDAO orderDAO;
		
		@ModelAttribute("order")
		public Order formBacking(HttpServletRequest request) {
			Order order = new Order();

			return order;
		}

		@RequestMapping(method = RequestMethod.GET)
		public ModelAndView form(@Valid @ModelAttribute("order") Order order, @RequestParam int quentity, @RequestParam String shoppingId, BindingResult result,  SessionStatus status) {
			ModelAndView mav = new ModelAndView();
			// UserSessionUtils uSession = new UserSessionUtils();
			// String userId = uSession.getLoginUserId(request.getSession());
			
			Product product = shoppingDAO.getShoppingByshoppingId(shoppingId).getProduct();
			
			ArrayList<Item> items = new ArrayList<Item>();
			Item item = new Item();
			item.setProduct(product);
			item.setQuentity(quentity);
			item.setUnitcost(product.getPrice() * quentity);
			item.setStatus(0);
			items.add(item);
			order.setItem(items);
			
			
			// Total Price
			int total = 0;
			for (Item i : items) {
			    total += i.getUnitcost();
			}
			order.setTotalPrice(total);
			User buyer = userDAO.getUserByUserId("admin");
			User seller = userDAO.getUserByUserId(product.getSupplierId());
			
			item.setUser(seller);
			order.setUser(buyer);
			order.setOrderDate(new Date());
			
			mav.addObject("order",order);
			mav.addObject("buyer", buyer);
			mav.addObject("seller", seller);
			mav.setViewName("order/form");
			return mav;
		}


		@RequestMapping(method = RequestMethod.POST)
		public String createOrder(@Valid @ModelAttribute("order") Order order, BindingResult result, SessionStatus status) {

			if (result.hasErrors()) {
				System.out.println(result.getAllErrors());
				return "shopping/form";
			}
			System.out.println("createOrder Log");
			System.out.println(order.getItem().get(0).getProduct().getProductName());
			System.out.println(order.getItem().get(0).getProduct().getPrice());
			orderDAO.createOrder(order, order.getItem());
			
			status.setComplete();
			return "redirect:/shopping/view/all";
		}

	}


