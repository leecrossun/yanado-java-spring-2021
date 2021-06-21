package com.yanado.controller.auc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yanado.controller.user.UserSessionUtils;
import com.yanado.dao.AucDAO;
import com.yanado.dto.Auc;
import com.yanado.service.AucService;
import com.yanado.service.UserService;

@Controller
public class WinningAucContrller {
	private AucService aucService;
	private UserService userService;
	
	@RequestMapping("auc/winning")
	public String win(HttpServletRequest request, @RequestParam String aucNo) {
		return null;
	}
	
}
