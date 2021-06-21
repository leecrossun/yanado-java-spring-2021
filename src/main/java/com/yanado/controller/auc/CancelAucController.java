package com.yanado.controller.auc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.controller.user.UserSessionUtils;
import com.yanado.dto.Auc;
import com.yanado.dto.AucJoin;
import com.yanado.service.AucService;

@Controller
public class CancelAucController {
	private AucService aucService;
	
	@RequestMapping("auc/cancel")
	public String join(HttpServletRequest request, @RequestParam String aucNo,  RedirectAttributes red) {
		try {
			UserSessionUtils uSession = new UserSessionUtils();
			@SuppressWarnings("static-access")
			String userId = uSession.getLoginUserId(request.getSession());
			
			Auc auc = aucService.findAucByuserId(userId);
			AucJoin aucJoin = new AucJoin(aucNo,userId,0);
			
			auc.setparticipants(auc.getparticipants()-1);
			aucService.cancelAuc(aucJoin);
			
			red.addAttribute("aucNo", auc.getaucNo());
			
			return "redirect:/auc/read";
		}catch (Exception e) {
			e.printStackTrace();
			return "redirect:/auc/read";
		}
	}
}
