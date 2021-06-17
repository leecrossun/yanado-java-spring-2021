package com.yanado.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.dto.User;
import com.yanado.service.UserService;

@Controller
@SessionAttributes("user")
public class UserCreateController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result,
			SessionStatus status, RedirectAttributes red) {
		
		red.addAttribute("type", 1);
		
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "user/form";
		}
		
		status.setComplete();
		userService.createUser(user);
		
		red.addAttribute("userId", user.getUserId());
		
		return "redirect:/user/mainPage";
	}
}