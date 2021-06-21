package com.yanado.controller.shopping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dao.ReviewDAO;
import com.yanado.dao.ShoppingDAO;
import com.yanado.dto.Shopping;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/shopping/view")
public class ViewShoppingController {
	
	@Autowired
	public ShoppingDAO shoppingDAO;
	
	@Autowired
	public ReviewDAO reviewDAO;
	
	// 모든 쇼핑 리스트
	@RequestMapping("/all")
	public ModelAndView viewShoppingList(){
		
		List<Shopping> shopping = shoppingDAO.getShoppingList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shopping/shoppingList");
		mav.addObject("shoppingList", shopping);
		return mav;
		
	}
	
	// 쇼핑 상품 상세보기
	@RequestMapping("/detail")
	public ModelAndView viewShoppingDetail(@RequestParam String shoppingId){
		ModelAndView mav = new ModelAndView();
		Shopping shopping = shoppingDAO.getShoppingByshoppingId(shoppingId);
		mav.setViewName("shopping/shoppingDetail");
		mav.addObject("shopping", shopping);
		return mav;
		
	}
	
	// 내가 올린 쇼핑 리스트
	@RequestMapping("/search")
	public ModelAndView searchShoppingByProductName(@RequestParam String productName){
		List<Shopping> shopping = shoppingDAO.getShoppingByProductName(productName);
		ModelAndView mav = new ModelAndView("shoppingList");
		mav.setViewName("shopping/myList");
		mav.addObject("shoppingList", shopping);
		return mav;
	}
	
	// 세부 카테고리에 맞는 쇼핑 리스트 (신발, 가방 등)
	@RequestMapping("/category")
	public ModelAndView viewShoppingByCategory(@RequestParam("category") String category){
		List<Shopping> shopping = shoppingDAO.getShoppingByCategory(category);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shopping/shoppingList");
		mav.addObject("shoppingList", shopping);
		return mav;
		
	}
	
	// 내가 올린 쇼핑 리스트
	@RequestMapping("/my")
	public ModelAndView viewShoppingByUserId(@RequestParam String userId){
		List<Shopping> shopping = shoppingDAO.getShoppingByUserId(userId);
		ModelAndView mav = new ModelAndView("shoppingList");
		mav.setViewName("shopping/myList");
		mav.addObject("shoppingList", shopping);
		return mav;
		
	}
}
