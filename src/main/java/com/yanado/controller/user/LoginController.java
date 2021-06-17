package com.yanado.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yanado.dto.User;
import com.yanado.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/login", method=RequestMethod.GET)
	public String LoginPage() {
		return "/user/loginPage";
	}
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST) 
	public String Login(@RequestParam("userId") String userId, 
			@RequestParam("password") String password) throws NullPointerException {
		
		String path = "";
		
		User user = new User();
		
		user.setUserId(userId);
		user.setPassword(password);
		
		int result = userService.Login(user);
		
		if (result == 1) {
			path = "/user/mainPage";
		} else {
			path = "/user/LoginPage";
		}
		
		return path;
	}
}