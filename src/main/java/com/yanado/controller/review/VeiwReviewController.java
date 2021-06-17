package com.yanado.controller.review;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dao.ReviewDAO;
import com.yanado.dto.Review;
import com.yanado.service.ReviewService;

@Controller
@SessionAttributes("review")
@RequestMapping("/review/view")
public class VeiwReviewController {
	
	@Autowired
	public ReviewDAO reviewDAO;
	
	@Autowired
	public ReviewService service;
	
	@ModelAttribute("review")
	public Review formBacking(HttpServletRequest request) {
		Review review = new Review();
		return review;
	}


	@RequestMapping("/all")
	public ModelAndView viewReviewList(@RequestParam String shoppingId){
		ModelAndView mav = new ModelAndView();
		List<Review> review = reviewDAO.getReviewByShoppingId(shoppingId);
		mav.setViewName("shopping/review");
		mav.addObject("shoppingId", shoppingId);
		mav.addObject("reviewList", review);
		return mav;
		
	}

}
