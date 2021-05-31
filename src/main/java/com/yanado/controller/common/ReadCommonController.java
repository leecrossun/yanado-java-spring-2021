package com.yanado.controller.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dto.Common;
import com.yanado.dto.CommonDTO;
import com.yanado.dto.CommonJoin;
import com.yanado.dto.Product;
import com.yanado.service.CommonService;

@Controller

public class ReadCommonController {

	@Autowired
	private CommonService commonService;

	// 공동구매 보기
	@RequestMapping("/common/read")
	public ModelAndView read(HttpServletRequest request, @RequestParam String commonId) {
		//UserSessionUtils uSession = new UserSessionUtils();
		//String userId = uSession.getLoginUserId(request.getSession());
		String userId = "admin";
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/read");
		
		Common common = commonService.findCommonByCommonId(commonId);
		Product product = commonService.findProduct(common.getProductId()); // 나중에 수정
		
		int join = commonService.findCommonJoin(new CommonJoin(common.getCommonId(), userId));
		System.out.println("join : " + join);
		
		mav.addObject("join", join);
		mav.addObject("common", new CommonDTO(common, product));

		return mav;
	}
}
