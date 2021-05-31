package com.yanado.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.dto.Common;
import com.yanado.service.CommonService;

@Controller
@SessionAttributes("common")
public class CreateCommonController {

	@Autowired
	private CommonService commonService;

	// 공동구매 생성 폼으로 가기
	@ModelAttribute("common")
	public Common formBacking(HttpServletRequest request) {
		Common common = new Common();
		// UserSessionUtils uSession = new UserSessionUtils();
		// String userId = uSession.getLoginUserId(request.getSession());
		String userId = "admin";
		common.setUserId(userId);
		common.setStatus(1);
		common.setMin(0);
		return common;
	}

	@RequestMapping(value = "/common/create", method = RequestMethod.GET)
	public String form() {
		return "common/form";
	}

	// 공동구매 생성하기
	@RequestMapping(value = "/common/create", method = RequestMethod.POST)
	public String createCommon(@Valid @ModelAttribute("common") Common common, BindingResult result,
			SessionStatus status, RedirectAttributes red) {

		red.addAttribute("type", 1);
		
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "common/form";
		}

		status.setComplete();
		commonService.insertCommon(common);

		red.addAttribute("commonId", common.getCommonId());

		return "redirect:/common/read";
	}

}
