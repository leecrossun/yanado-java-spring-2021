package com.yanado.controller.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.controller.user.UserSessionUtils;
import com.yanado.dao.FavoriteDAO;
import com.yanado.dao.ProductDAO;
import com.yanado.dto.Common;
import com.yanado.dto.CommonDTO;
import com.yanado.dto.CommonJoin;
import com.yanado.dto.Favorite;
import com.yanado.dto.Product;
import com.yanado.service.CommonService;

@Controller

public class ReadCommonController {

	@Autowired
	private CommonService commonService;
	
	@Autowired
	private FavoriteDAO favoritDao;
	
	@Autowired
	private ProductDAO productDao;

	// 공동구매 보기
	@RequestMapping("/common/read")
	public ModelAndView read(HttpServletRequest request, @RequestParam String commonId) {
		UserSessionUtils uSession = new UserSessionUtils();
		String userId = uSession.getLoginUserId(request.getSession());
		userId = "admin";
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/read");
		
		Common common = commonService.findCommonByCommonId(commonId);
		Product product = productDao.getProductByProductId(common.getProductId()); // 나중에 수정
		
		CommonJoin join = commonService.findCommonJoin(new CommonJoin(common.getCommonId(), userId));
		
		Favorite favorit = favoritDao.findFavorite(new Favorite(userId, product.getProductId(), commonId, 3));
		int fav = (favorit == null? 0 : 1); 
		
		mav.addObject("join", join);
		
		mav.addObject("common", new CommonDTO(common, product));
		mav.addObject("fav", fav);

		return mav;
	}
}
