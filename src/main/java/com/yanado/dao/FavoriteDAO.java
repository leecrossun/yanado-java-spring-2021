package com.yanado.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.yanado.dto.Favorite;
import com.yanado.dto.Product;
import com.yanado.dto.User;

@Mapper
@Transactional
public interface FavoriteDAO {

	void insertFavorite(Favorite favorite);

	void deleteFavorite(Favorite favorite);

	List<Favorite> findFavoriteByUserId(String userId);
	List<Favorite> findUserByFavorite(String productId);
	
	List<Product> findFavoriteByTop();
	
	List<User> findSimilarListByUser(User user);
	
	Favorite findFavorite(Favorite favorite);
}
