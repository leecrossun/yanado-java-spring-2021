package com.yanado.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.yanado.dao.UserDAO;
import com.yanado.dto.User;
import com.yanado.service.UserService;

//회원 추가 작업 - 파라미터 받아서 회원 리스트로 넘김
@Controller
//@WebServlet("/user/create")
public class UserCreateController {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/user/create", method = RequestMethod.POST)
	protected String service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("userId");
		String pwd = request.getParameter("password");
		String name = request.getParameter("userName");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("birth");
		String address = request.getParameter("address");
		String phone = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		
		User dto = new User(id, pwd, name, gender, birth, address, phone, email);
		
		userDAO.createUser(dto);
		
		return "redirect:mypage/loginPage";
	}
	
	@RequestMapping(value="/user/create", method = RequestMethod.GET)
	public String form() {
		return "user/loginPage";
	}
} 

//@Controller
//@SessionAttributes("user")
//public class UserCreateController {
//	
//	@Autowired
//	private UserService userService;
//	
//	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
//	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result,
//			SessionStatus status, RedirectAttributes red) {
//		
//		red.addAttribute("type", 1);
//		
//		if (result.hasErrors()) {
//			System.out.println(result.getAllErrors());
//			return "user/form";
//		}
//		
//		status.setComplete();
//		userService.createUser(user);
//		
//		red.addAttribute("userId", user.getUserId());
//		
//		return "redirect:/user/mainPage";
//	}
//}