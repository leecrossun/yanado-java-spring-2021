package com.yanado.controller.user;

import javax.servlet.annotation.WebServlet;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.dto.User;
import com.yanado.service.UserService;

//회원 정보 업데이트
@WebServlet("/user/update")
public class UserUpdateController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/update", method=RequestMethod.GET)
	public String userUpdate(@Valid @ModelAttribute("user") User user, BindingResult result,
			SessionStatus status, RedirectAttributes red) {
		
		red.addAttribute("type", 2);
		
		if (result.hasErrors()) {
			return "redirect:/user/update?userId="+user.getUserId();
		}
		
		userService.updateUser(user);
		status.setComplete();
		red.addAttribute("userId", user.getUserId());
		
		return "redirect:/user/mainPage";
	}
}