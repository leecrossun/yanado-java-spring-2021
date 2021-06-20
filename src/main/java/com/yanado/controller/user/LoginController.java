package com.yanado.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yanado.dao.UserDAO;
import com.yanado.dto.User;
import com.yanado.service.UserService;

@Controller
@WebServlet("/user/login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDAO userDAO;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		User dto = userDAO.getUserByUserId(id);
		
		String param = "";
		String resultStr = "";
		

		if (dto == null || dto.getUserId().equals(id) == false) {
			param = "no_id";
		} else if (dto.getPassword().equals(pwd) == false) {
			param = "no_pwd";
		} else {
			param = "clear";
			
			HttpSession session = request.getSession();
			session.setAttribute(UserSessionUtils.USER_SESSION_KEY, id);
		}

		resultStr = String.format("[{'param':'%s'}]", param);
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().println( resultStr );
	}
	
//@WebServlet("/user/loginPage")
//@Controller
//public class LoginController extends HttpServlet {
//	
//	@Autowired
//	private UserService userService;
//	
//	@RequestMapping(value="/user/loginPage", method=RequestMethod.GET)
//	public String LoginPage() {
//		return "/user/loginPage";
//	}
//	
//	@RequestMapping(value="/user/loginPage", method=RequestMethod.POST) 
//	public String Login(@RequestParam("userId") String userId, 
//			@RequestParam("password") String password) throws NullPointerException {
//		
//		String path = "";
//		
//		User user = new User();
//		
//		user.setUserId(userId);
//		user.setPassword(password);
//		
//		int result = userService.Login(user);
//		
//		if (result == 1) {
//			path = "/user/mainPage";
//		} else {
//			path = "/user/loginPage";
//		}
//		
//		return path;
//	}
	
}