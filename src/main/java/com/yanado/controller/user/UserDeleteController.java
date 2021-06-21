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
import org.springframework.web.bind.annotation.RequestParam;

import com.yanado.dao.UserDAO;
import com.yanado.service.UserService;

//회원 삭제 작업
@Controller
@WebServlet("/user/delete")
public class UserDeleteController {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/user/delete")
	protected String service(HttpServletRequest request, HttpSession session) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		UserSessionUtils uSession = new UserSessionUtils();
		String userId = uSession.getLoginUserId(request.getSession());
		int flag = userDAO.deleteUser(userId);	//1이면 성공, 0이면 실패
		System.out.println("res: " + flag);
		
		session.invalidate();

		return "redirect:/";
	}
}
