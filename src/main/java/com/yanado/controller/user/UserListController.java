package com.yanado.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yanado.dao.UserDAO;
import com.yanado.dto.User;

@Controller
@RequestMapping("/user/list")
public class UserListController {
	
	@Autowired
	public UserDAO userDAO;
	
	@RequestMapping
	public ModelAndView viewUserList() {
		List<User> user = userDAO.selectList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("userList", user);
		
		return mav;
	}
}
