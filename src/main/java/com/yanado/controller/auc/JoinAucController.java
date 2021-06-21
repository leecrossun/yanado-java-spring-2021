package com.yanado.controller.auc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.controller.user.UserSessionUtils;
import com.yanado.dto.Auc;
import com.yanado.dto.AucJoin;
import com.yanado.service.AucService;

@Controller
public class JoinAucController {
	@Autowired
	private AucService aucService;
	
	@RequestMapping("auc/join")
	public String join(HttpServletRequest request, @RequestParam String aucNo,@RequestParam int bidprice, RedirectAttributes red) {
		  UserSessionUtils uSession = new UserSessionUtils();
		  @SuppressWarnings("static-access")
		  String userId = uSession.getLoginUserId(request.getSession());
		  AucJoin aucJoin = new AucJoin(aucNo,userId,bidprice);
		  Auc auc = aucService.findAucByuserId(userId);
		  auc.setparticipants(auc.getparticipants()+1);
		  aucService.joinAuc(aucJoin);
		  
		  red.addAttribute("aucNo", auc.getaucNo());
		  
		  return "redirect:/auc/read";
	}
}
