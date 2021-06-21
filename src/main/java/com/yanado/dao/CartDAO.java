package com.yanado.dao;

import java.util.List;

import com.yanado.dto.Product;

public interface CartDAO {

	public void insertCart(Product product);
	
	public List<Product> cartList(String productId);
	
	public void updateCart(Product product);
	
	public void deleteCart(Product product);
	
	//장바구니에 있는 상품  총 금액 계산
	public void countSum(String userID);
	
	//동일한 물건인지 확인
	public int checkSameProduct(String productId, String userID);
	
	//동일한 상품이면 수량 변경
	public void updateQuantity(Product product);
}
