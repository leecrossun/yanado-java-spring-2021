package com.yanado.controller.common;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.dto.Common;
import com.yanado.service.CommonService;

@Controller
public class UpdateCommonController {
	@Autowired
	private CommonService commonService;
	
	// 공동구매 수정 폼으로 가기
	@RequestMapping(value = "/common/update", method = RequestMethod.GET)
	public String form(@ModelAttribute("common") Common common, @RequestParam String commonId, Model model) {
		common = commonService.findCommonByCommonId(commonId);
		model.addAttribute("type", 2);
		model.addAttribute("common", common);
		return "common/form";
	}

	// 공동구매 수정하기
	@RequestMapping(value = "/common/update", method = RequestMethod.POST)
	public String updateCommon(@Valid @ModelAttribute("common") Common common, BindingResult result, SessionStatus status,  RedirectAttributes red) {
		red.addAttribute("type", 2);
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "redirect:/common/update?commonId=" + common.getCommonId();
		}

		commonService.updateCommon(common);
		status.setComplete();
		red.addAttribute("commonId", common.getCommonId());

		return "redirect:/common/read";
	}

}
