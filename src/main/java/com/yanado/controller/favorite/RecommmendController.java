package com.yanado.controller.favorite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.controller.user.UserSessionUtils;
import com.yanado.dao.FavoriteDAO;
import com.yanado.dao.ProductDAO;
import com.yanado.dao.UserDAO;
import com.yanado.dto.Favorite;
import com.yanado.dto.FavoriteDTO;
import com.yanado.dto.Product;
import com.yanado.dto.User;
import com.yanado.service.CommonService;

@Controller

public class RecommmendController {

	@Autowired
	private FavoriteDAO favoriteDao;

	@Autowired
	private ProductDAO productDao;

	@Autowired
	private CommonService commonService;

	@RequestMapping("/")
	public ModelAndView recommend(HttpServletRequest request) {
		UserSessionUtils uSession = new UserSessionUtils();
		String userId = uSession.getLoginUserId(request.getSession());

		List<FavoriteDTO> fList = new ArrayList<FavoriteDTO>();

		if (userId == null) {
			List<Favorite> favList = favoriteDao.findFavoriteByTop();

			int i = 0;
			for (Favorite fav : favList) {
				if (i == 10) {
					break;
				}
				
				if(isin(fList, fav.getProductId())) {
					continue;
				}

				FavoriteDTO f = new FavoriteDTO(fav, productDao.getProductByProductId(fav.getProductId()));

				String path = f.getProduct().getImage();
				path = path.replaceFirst("../", "");
				f.getProduct().setImage(path);

				fList.add(f);
				i++;

			}
		} else {

			List<Favorite> favList1 = favoriteDao.findFavoriteByUserId(userId);
			List<Favorite> userList = new ArrayList<Favorite>();

			Collections.shuffle(favList1);

			// 유저가 좋아요를 누른 목록에서 좋아요를 누른 사람
			for (Favorite fav : favList1) {
				userList.addAll(favoriteDao.findUserByFavorite(fav.getProductId()));
			}

			Collections.shuffle(userList);

			// 그 사람들이 좋아요를 누른 목록
			List<Favorite> favoriteList = new ArrayList<Favorite>();
			for (Favorite user : userList) {
				favoriteList.addAll(favoriteDao.findFavoriteByUserId(user.getUserId()));

			}

			Collections.shuffle(favoriteList);

			int i = 0;
			for (Favorite fav : favoriteList) {

				if (i == 10) {
					break;
				}
				
				if(isin(fList, fav.getProductId())) {
					continue;
				}

				FavoriteDTO f = new FavoriteDTO(fav, productDao.getProductByProductId(fav.getProductId()));

				String path = f.getProduct().getImage();
				path = path.replaceFirst("../", "");
				f.getProduct().setImage(path);

				fList.add(f);
				i++;
			}

		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("favoriteList", fList);
		mav.setViewName("index");

		return mav;
	}
	
	public boolean isin(List<FavoriteDTO> a, String pId) {
		
		for(FavoriteDTO f : a) {
			if(f.getProduct().getProductId().equals(pId)) {
				return true;
			}
		}
		
		return false;
	}
}
