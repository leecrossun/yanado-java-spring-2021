package com.yanado.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yanado.service.UserService;

//회원 삭제 작업
@Controller
public class UserDeleteController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/delete")
	public String userDelete(@RequestParam String userId) {
		userService.deleteUser(userId);
		
		return "redirect:/user/mainPage";
	}
}