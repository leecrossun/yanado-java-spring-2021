package com.yanado.controller.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dto.Common;
import com.yanado.dto.CommonDTO;
import com.yanado.dto.Product;
import com.yanado.dto.Search;
import com.yanado.service.CommonService;

@Controller
public class SortCommonController {

	@Autowired
	private CommonService commonService;

	@RequestMapping("/common/sort")
	public ModelAndView sortList(@RequestParam(required = false, defaultValue = "1") int page, String sortKey) {
		Search sort = new Search(sortKey, page);

		List<Common> common = commonService.findCommonBySort(sort);
		List<CommonDTO> commonList = new ArrayList<CommonDTO>();
	

		for (Common com : common) {
			String productId = com.getProductId();
			// Product product = productDAO.getProductByProductId(productId);
			Product product = commonService.findProduct(productId);
			commonList.add(new CommonDTO(com, product));
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/list");
		mav.addObject("commonList", commonList);
		mav.addObject("flag", 2);

		int total = commonService.getCount();

		mav.addObject("total", total);
		mav.addObject("s", sort);
		

		return mav;
	}

}
