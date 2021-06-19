package com.yanado.controller.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.controller.user.UserSessionUtils;
import com.yanado.dto.Common;
import com.yanado.dto.CommonJoin;
import com.yanado.service.CommonService;


@Controller
public class CancelCommonController {
	
	@Autowired
	private CommonService commonService;
	
	// 공동구매 참여 취소하기
	@RequestMapping("/common/cancel")
	public String join(HttpServletRequest request, @RequestParam String commonId,  RedirectAttributes red)
			throws Exception {
		
		
		UserSessionUtils uSession = new UserSessionUtils();
		String userId = uSession.getLoginUserId(request.getSession());
		userId = "admin";
		
		Common common = commonService.findCommonByCommonId(commonId);
		
		common.setParticipants(common.getParticipants()+1);
		commonService.decreaseJoin(commonId);
		
		CommonJoin join = new CommonJoin(commonId, userId, 0);
		commonService.cancelCommon(join);
		
		if(common.getMin() > common.getParticipants()) {
			commonService.changeStatus(commonId, 2);
		}
		
		red.addAttribute("commonId", common.getCommonId());

		return "redirect:/common/read";
	}
}
