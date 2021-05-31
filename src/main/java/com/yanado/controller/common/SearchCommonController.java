package com.yanado.controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dto.Common;
import com.yanado.dto.Criteria;
import com.yanado.dto.Search;
import com.yanado.service.CommonService;


@Controller

public class SearchCommonController {
	//@Autowired
	private CommonService commonService;

	// 공동구매 찾기
	@RequestMapping("/common/search")
	public ModelAndView searchList(@RequestParam int page, @RequestParam String condition,
			@RequestParam String searchKey) {
		
		int totalcount = commonService.getCount();
		Criteria c = new Criteria(page, totalcount);
		Search search = new Search(condition, searchKey, c.getStartIndex(), c.getEndIndex());

		List<Common> commonList = commonService.findCommonBySearch(search);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/list");
		mav.addObject("commonList", commonList);
		
		return mav;
	}
}
