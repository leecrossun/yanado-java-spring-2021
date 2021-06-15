package com.yanado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.yanado.dao.ShoppingDAO;
import com.yanado.dto.Shopping;
@Service
public class ShoppingService {
	
	@Autowired
	private ShoppingDAO shoppingDAO;
	
	public void createShopping(Shopping shopping)
	{
		// productId, shoppingId 생성
		// 유저아이디 우선 디폴트 admin
		// image 디폴트
		
		shoppingDAO.createShopping(shopping);
	}

}
