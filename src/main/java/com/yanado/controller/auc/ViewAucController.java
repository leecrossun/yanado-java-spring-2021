package com.yanado.controller.auc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.controller.user.UserSessionUtils;
import com.yanado.dao.AucDAO;
import com.yanado.dto.Auc;
import com.yanado.dto.AucDTO;
import com.yanado.dto.Common;
import com.yanado.dto.CommonDTO;
import com.yanado.dto.Favorite;
import com.yanado.dto.Product;
import com.yanado.dto.Shopping;

@Controller
@RequestMapping("/auc/view")
public class ViewAucController {
	
	@Autowired
	AucDAO aucDAO;
	
	
	// 모든 경매
	@RequestMapping("/all")
	public ModelAndView viewAucList(){
		
		List<Auc> auc = aucDAO.getAllAucList();
		List<AucDTO> aucList = new ArrayList<AucDTO>();
		
		for (Auc a : auc) {
			Product product = aucDAO.findProductByAuc(a.getProductId());
			aucList.add(new AucDTO(a, product));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("auc/aucList");
		mav.addObject("aucList", aucList);
		return mav;
		
	}
	
	// 쇼핑 상품 상세보기
	@RequestMapping("/detail")
	public ModelAndView viewShoppingDetail( @RequestParam String aucId, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		// 좋아요 기능
		/*
		 * if (userId != null) { Favorite favorit = favoriteDAO.findFavorite(new
		 * Favorite(userId, shopping.getProduct().getProductId(), shoppingId, 2)); int
		 * fav = (favorit == null ? 0 : 1); mav.addObject("fav", fav); }
		 */
		
		Auc auc = aucDAO.getAuc(aucId);
		Product product = aucDAO.findProductByAuc(auc.getProductId());
		
		mav.setViewName("auc/aucDetail");
		mav.addObject("auc", auc);
		mav.addObject("product", product);
		return mav;
		
	}
	
	// 내가 참여한 경매
	@RequestMapping("/my")
	public ModelAndView viewMyAucList(HttpServletRequest request) {
		UserSessionUtils uSession = new UserSessionUtils();
		String userId = uSession.getLoginUserId(request.getSession());
		
		List<Auc> auc = aucDAO.getMyAuc(userId);
		List<AucDTO> aucList = new ArrayList<AucDTO>();
		
		for (Auc a : auc) {
			Product product = aucDAO.findProductByAuc(a.getProductId());
			aucList.add(new AucDTO(a, product));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("auc/aucList");
		mav.addObject("aucList", auc);
		return mav;
	}

}
