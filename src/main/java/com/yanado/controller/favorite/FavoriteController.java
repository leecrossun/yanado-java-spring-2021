package com.yanado.controller.favorite;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.controller.user.UserSessionUtils;
import com.yanado.dao.FavoriteDAO;
import com.yanado.dto.Favorite;


@Controller
public class FavoriteController {
	
	@Autowired
	private FavoriteDAO favoriteDao;
	
	@RequestMapping("/favorite/add")
	public String add(@RequestParam String productId, @RequestParam String typeId, @RequestParam int type, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		UserSessionUtils uSession = new UserSessionUtils();
		String userId = uSession.getLoginUserId(request.getSession());
		userId = "admin";
		
		Favorite favorite = new Favorite(userId, productId, typeId, type);
		System.out.println("type : " + favorite.getType());
		favoriteDao.insertFavorite(favorite);
		
		 redirectAttributes.addFlashAttribute("fav", 1);
		String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}
	
	@RequestMapping("/favorite/delete")
	public String delete(@RequestParam String productId, HttpServletRequest request) {
		// UserSessionUtils uSession = new UserSessionUtils();
				// String userId = uSession.getLoginUserId(request.getSession());
				String userId = "admin";
		Favorite favorite = new Favorite(userId, productId, null, 0);
		favoriteDao.deleteFavorite(favorite);
		
		String referer = request.getHeader("Referer");
	    return "redirect:"+ referer;
	}
	
	public List<Favorite> getList(){
		return null;
	}
}
