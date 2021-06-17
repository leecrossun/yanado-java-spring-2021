package com.yanado.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//로그인 성공 후 메인 페이지로 이동
@Controller	
public class LoginToMainController {
	
	@RequestMapping(value="/user/mainPage", method=RequestMethod.GET)
	public String LoginToMain( ) {
		return "/user/mainPage";
	}
}