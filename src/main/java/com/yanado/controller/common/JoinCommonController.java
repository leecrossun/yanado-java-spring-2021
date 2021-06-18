package com.yanado.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.dto.Common;
import com.yanado.dto.CommonJoin;
import com.yanado.service.CommonService;

@Controller
public class JoinCommonController {
	
	@Autowired
	private CommonService commonService;

	// 공동구매 참여하기
	@RequestMapping("/common/join")
	public String join(HttpServletRequest request, @RequestParam String commonId,  RedirectAttributes red)
			throws Exception {
		
		
		//UserSessionUtils uSession = new UserSessionUtils();
		//String userId = uSession.getLoginUserId(request.getSession());
		String userId = "admin";
		
		Common common = commonService.findCommonByCommonId(commonId);
		common.setParticipants(common.getParticipants()+1);
		commonService.increaseJoin(commonId);
		
		CommonJoin join = new CommonJoin(commonId, userId, 0);
		commonService.joinCommon(join);
		
		if(common.getMin() <= common.getParticipants()) {
			commonService.changeStatus(commonId, 3);
		}
		
		red.addAttribute("commonId", common.getCommonId());

		return "redirect:/common/read";
	}

}
