package com.yanado.controller.order;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dao.OrderDAO;
import com.yanado.dao.ProductDAO;
import com.yanado.dao.ShoppingDAO;
import com.yanado.dto.Common;
import com.yanado.dto.CommonJoin;
import com.yanado.dto.Order;
import com.yanado.dto.Product;
import com.yanado.service.CommonService;

@Controller
@RequestMapping("payment/kakao")
public class PaymentController {

	@Autowired
	OrderDAO orderDAO;

	@Autowired
	ShoppingDAO shoppingDAO;

	@Autowired
	CommonService commonService;

	@RequestMapping("/main")
	@ModelAttribute("order")
	public ModelAndView viewKakaoPayment(@RequestParam String orderId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("payment/kakao");
		mav.addObject("order", orderDAO.getOrderByOrderId(orderId));
		mav.addObject("spath", request.getContextPath() + "/payment/kakao/success?orderId=" + orderId);
		mav.addObject("fpath", request.getContextPath() + "/payment/kakao/fail?orderId=" + orderId);
		return mav;

	}

	@RequestMapping("/success")
	public ModelAndView viewSuccessResult(@RequestParam String orderId) {

		ModelAndView mav = new ModelAndView();
		// shoppingDAO.updateStockByShoppingId(shoppingId);
	
		Order order = orderDAO.getOrderByOrderId(orderId);
		int type = 1;

		if (order.getItem().size() == 1) {
			Product p = order.getItem().get(0).getProduct();
			String cate = p.getCategory();

			if (cate.equals("common")) {
				Common common = commonService.findCommonByProductId(p.getProductId());
				CommonJoin join = new CommonJoin(common.getCommonId(), order.getUser().getUserId(), 1);
				int res = commonService.updatePayment(join);
				
				type = 2;
			}
		}

		mav.setViewName("payment/success");

		return mav;

	}

	@RequestMapping("/fail")
	public ModelAndView viewFailResult(@RequestParam String orderId) {

		ModelAndView mav = new ModelAndView();
		Order order = orderDAO.getOrderByOrderId(orderId);
		orderDAO.deleteOrder(order, order.getItem());
		
		int type = 1;
		

		if (order.getItem().size() == 1) {
			Product p = order.getItem().get(0).getProduct();
			String cate = p.getCategory();

			if (cate.equals("common")) {
				type = 2;
			}
		}

		mav.setViewName("payment/fail");
		mav.addObject("type", type);
		return mav;

	}

}
