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
import com.yanado.dto.Common;
import com.yanado.dto.CommonJoin;
import com.yanado.dto.Item;
import com.yanado.dto.Order;
import com.yanado.dto.Product;
import com.yanado.dto.Shopping;
import com.yanado.dto.User;
import com.yanado.service.CommonService;
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


	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CommonService commonService;

	@ModelAttribute("order")
	public Order formBacking(HttpServletRequest request) {
		Order order = new Order();

		return order;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView form(@Valid @ModelAttribute("order") Order order,
			@RequestParam(defaultValue = "1") int quentity, @RequestParam String productId,
			@RequestParam(defaultValue = "1") int type, BindingResult result, SessionStatus status) {
		
		ModelAndView mav = new ModelAndView();
		// UserSessionUtils uSession = new UserSessionUtils();
		// String userId = uSession.getLoginUserId(request.getSession());

		Product product = productDAO.getProductByProductId(productId);

		User buyer = userDAO.getUserByUserId("admin");
		User seller = userDAO.getUserByUserId(product.getSupplierId());

		List<Item> items = new ArrayList<Item>();
		Item item = new Item(null, product, seller, product.getPrice() * quentity, quentity, null, null, null, 0);
		items.add(item);

		// Total Price
		int total = 0;
		for (Item i : items) {
			total += i.getUnitcost();
		}

		order = new Order(null, buyer, items, seller.getUserName(), seller.getPhoneNumber(), seller.getAddress(),
				buyer.getUserName(), buyer.getPhoneNumber(), buyer.getAddress(), total, new Date(), null, 0, null,
				null);

		mav.addObject("order", order);
		mav.setViewName("order/form");
	
		if(type == 2) {
			System.out.println("TYPE 2");
			Common common = commonService.findCommonByProductId(productId);
			System.out.println("commonId " + common.getCommonId());
			CommonJoin join = new CommonJoin(common.getCommonId(), buyer.getUserId(), 1);
			int res = commonService.updatePayment(join);
			System.out.println("result : " + res);
		}
		
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createOrder(@Valid @ModelAttribute("order") Order order, BindingResult result, SessionStatus status) {

		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "shopping/form";
		}
		System.out.println("createOrder Log");
		orderDAO.createOrder(order, order.getItem());
		return "redirect:/order/view/result";
	}

}
