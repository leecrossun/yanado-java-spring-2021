package com.yanado.controller.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dao.ProductDAO;
import com.yanado.dto.Common;
import com.yanado.dto.CommonDTO;
import com.yanado.dto.Product;
import com.yanado.dto.Search;
import com.yanado.service.CommonService;

@Controller

public class SearchCommonController {
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private ProductDAO productDao;

	// 공동구매 찾기
	@RequestMapping("/common/search")
	public ModelAndView searchList(@RequestParam(required = false, defaultValue = "1") int page, String searchKey) {
		Search search = new Search(searchKey, page);

		List<Common> common = commonService.findCommonBySearch(search);
		List<CommonDTO> commonList = new ArrayList<CommonDTO>();

		for (Common com : common) {
			String productId = com.getProductId();
			Product product = productDao.getProductByProductId(productId);
			//Product product = commonService.findProduct(productId);
			commonList.add(new CommonDTO(com, product));
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/list");
		mav.addObject("commonList", commonList);
		mav.addObject("flag", 1);
		
		int total = commonService.getSearchCount(searchKey);
		
		mav.addObject("total", total);
		mav.addObject("s", search);
		

		return mav;
	}
}
