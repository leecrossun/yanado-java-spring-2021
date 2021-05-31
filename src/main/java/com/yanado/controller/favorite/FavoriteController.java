package com.yanado.controller.favorite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yanado.dao.FavoriteDAO;
import com.yanado.dto.Favorite;


@Controller
@RequestMapping("/favorite")
public class FavoriteController {
	
	@Autowired
	private FavoriteDAO favoriteDao;
	
	@RequestMapping("/add")
	public String add(@RequestParam String productId) {
		String userId = null;
		Favorite favorite = new Favorite(userId, productId);
		favoriteDao.insertFavorite(favorite);
		return null;
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String productId) {
		String userId = null;
		Favorite favorite = new Favorite(userId, productId);
		favoriteDao.deleteFavorite(favorite);
		return null;
	}
	
	public List<Favorite> getList(){
		return null;
	}
}