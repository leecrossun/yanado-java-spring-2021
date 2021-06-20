package com.yanado.dao;
import java.util.List;

import javax.transaction.Transactional;
import org.apache.ibatis.annotations.Mapper;

import com.yanado.dto.Product;

@Mapper
@Transactional
public interface ProductDAO {
	
	// 물품 목록 조회 시 사용
	public List<Product> selectList();
	
	public List<Product> selectShoppingList();

	public int createProduct(Product dto);

	public int updateProduct(Product dto);

	public int deleteProduct(String productId);
	
	public int isCommonProduct(String productId);

	//public int updateManager(Product dto);

	// productId 로 물품 정보 가져오기
	public Product getProductByProductId(String productId);
}
