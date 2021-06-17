package com.yanado.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yanado.dao.ReviewDAO;
import com.yanado.dto.Product;
import com.yanado.dto.Review;
import com.yanado.dto.Shopping;
import com.yanado.dto.User;

@Service
public class ReviewService {
	@Autowired
	ReviewDAO reviewDAO;
	
	public void createReview(Review review)
	{
		// 테스트용 기본값 (로그인, 이미지업로드 추가 시 삭제)
		review.setPublished(new Date());
		User user = new User();
		user.setUserId("admin");
		review.setUser(user);
		reviewDAO.createReview(review);
	}
	
	

}
