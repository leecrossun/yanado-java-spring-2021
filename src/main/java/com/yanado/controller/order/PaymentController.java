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
import com.yanado.dao.ShoppingDAO;
import com.yanado.dto.Order;

@Controller
@RequestMapping("payment/kakao")
public class PaymentController {
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	ShoppingDAO shoppingDAO;
	
	@RequestMapping("/main")
	@ModelAttribute("order")
	public ModelAndView viewKakaoPayment(@RequestParam String orderId, HttpServletRequest request){		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("payment/kakao");
		mav.addObject("order",orderDAO.getOrderByOrderId(orderId));
		mav.addObject("spath", request.getContextPath() + "/payment/kakao/success");
		mav.addObject("fpath", request.getContextPath() + "/payment/kakao/fail?orderId=" + orderId);
		return mav;
	
	}
	
	@RequestMapping("/success")
	public ModelAndView viewSuccessResult(){
		
		ModelAndView mav = new ModelAndView();
		//shoppingDAO.updateStockByShoppingId(shoppingId);
		mav.setViewName("payment/success");
		return mav;
		
	}
	
	@RequestMapping("/fail")
	public ModelAndView viewFailResult(@RequestParam String orderId){
		
		ModelAndView mav = new ModelAndView();
		Order order = orderDAO.getOrderByOrderId(orderId);
		orderDAO.deleteOrder(order, order.getItem());
		mav.setViewName("payment/fail");
		return mav;
		
	}

}
