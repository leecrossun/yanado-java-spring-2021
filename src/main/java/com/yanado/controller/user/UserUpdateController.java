package com.yanado.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.dao.UserDAO;
import com.yanado.dto.User;
import com.yanado.service.UserService;

//회원 정보 업데이트
@Controller
@WebServlet("/user/update")
public class UserUpdateController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDAO userDAO;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String newPwd = request.getParameter("new_password");
		String address = request.getParameter("address");
		String phone = request.getParameter("phoneNumber");
		String email = request.getParameter("email");

		User user = new User(newPwd, address, phone, email);
		userDAO.updateUser(user);

		RequestDispatcher disp = request.getRequestDispatcher("/resources/templates/mypage/loginPage.html");
		disp.forward(request, response);

	}
}
//@WebServlet("/user/update")
//public class UserUpdateController {
//	
//	@Autowired
//	private UserService userService;
//	
//	@RequestMapping(value="/user/update", method=RequestMethod.GET)
//	public String userUpdate(@Valid @ModelAttribute("user") User user, BindingResult result,
//			SessionStatus status, RedirectAttributes red) {
//		
//		red.addAttribute("type", 2);
//		
//		if (result.hasErrors()) {
//			return "redirect:/user/update?userId="+user.getUserId();
//		}
//		
//		userService.updateUser(user);
//		status.setComplete();
//		red.addAttribute("userId", user.getUserId());
//		
//		return "redirect:/user/mainPage";
//	}
//}