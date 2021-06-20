package com.yanado.controller.review;

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

import com.yanado.controller.user.UserSessionUtils;
import com.yanado.dao.ReviewDAO;
import com.yanado.dao.ShoppingDAO;
import com.yanado.dto.Review;
import com.yanado.dto.Shopping;
import com.yanado.dto.User;
import com.yanado.service.ReviewService;
import com.yanado.service.ShoppingService;

@Controller
@SessionAttributes("review")
@RequestMapping("review/create")
public class CreateReviewController {
	@Autowired
	private ReviewService service;
	
	@Autowired
	private ShoppingDAO shoppingDAO;
	


	@RequestMapping(method = RequestMethod.POST)
	public String createReview(@Valid @ModelAttribute("review") Review review, @RequestParam String shoppingId, BindingResult result, HttpServletRequest request, SessionStatus status) {

		if (result.hasErrors()) {
			return "redirect:/review/view/all?shoppingId=" + shoppingId;
		}
		review.setShopping(shoppingDAO.getShoppingByshoppingId(shoppingId));
		
		User user = new User();
		user.setUserId( UserSessionUtils.getLoginUserId(request.getSession()));
		review.setUser(user);
		 
		service.createReview(review);
		status.setComplete();
		return "redirect:/review/view/all?shoppingId=" + shoppingId;
	}

}
