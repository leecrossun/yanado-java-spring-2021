package com.yanado.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.yanado.dao.ShoppingDAO;
import com.yanado.dto.Product;
import com.yanado.dto.Shopping;
@Service
public class ShoppingService {
	
	@Autowired
	private ShoppingDAO shoppingDAO;
	
	public void createShopping(Shopping shopping)
	{
		Product product = shopping.getProduct();
		
		// 테스트용 기본값 (로그인, 이미지업로드 추가 시 삭제)
		//product.setImage("test.png");
		shopping.setPublished(new Date());
		shopping.setProduct(product);
		
		shoppingDAO.createShopping(shopping, product);
	}
	
	public void updateShopping(Shopping shopping)
	{
		Product product = shopping.getProduct();
		shoppingDAO.updateShopping(shopping, product);
	}

}
