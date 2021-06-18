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

import sun.net.www.content.text.plain;

@Controller
public class FilterCommonController {
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private ProductDAO productDAO;

	
	@RequestMapping("/common/filter")
	public ModelAndView filterList(@RequestParam(required = false, defaultValue = "1") int page, String filterKey) {
		Search filter = new Search(filterKey, page);
		List<Common> common;
		
		filter.setSearchInt(Integer.parseInt(filterKey));
		int total;
		
		System.out.println(filter.getSearchInt());
		
		if(filter.getSearchInt() == 0) {
			common = commonService.findCommonByFilter2(filter);
			total = commonService.getFilterCount2();
		} else {
			common = commonService.findCommonByFilter1(filter);
			total = commonService.getFilterCount1(filter.getSearchInt());
		}
		
		List<CommonDTO> commonList = new ArrayList<CommonDTO>();

		for (Common com : common) {
			String productId = com.getProductId();
			Product product = productDAO.getProductByProductId(productId);
			//Product product = commonService.findProduct(productId);
			commonList.add(new CommonDTO(com, product));
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/list");
		mav.addObject("commonList", commonList);
		mav.addObject("flag", 3);

		mav.addObject("total", total);
		mav.addObject("s", filter);

		return mav;
	}
	
}
