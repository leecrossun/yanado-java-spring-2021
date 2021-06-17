package com.yanado.controller.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yanado.dao.ReviewDAO;
import com.yanado.dao.ShoppingDAO;
import com.yanado.dto.Review;

@Controller
public class DeleteReviewController {
	@Autowired	
	private ReviewDAO reviewDAO;
	
	// 공동구매 파기하기
	@RequestMapping("review/delete")
	public String delete(@RequestParam String reviewId, @RequestParam String shoppingId) {
		
		Review review = reviewDAO.getReviewByReviewId(reviewId, shoppingId);
		reviewDAO.deleteReview(review);
		return "redirect:/review/view/all?shoppingId=" + shoppingId;

	}
}
