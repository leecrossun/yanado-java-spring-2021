package com.yanado.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@WebServlet("/user/logout")
public class LogoutController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.getSession().invalidate();

		RequestDispatcher disp = request.getRequestDispatcher("/resources/templates/mypage/loginPage.html");
		disp.forward(request, response);
	}
}

//@Controller
//public class LogoutController {
//	
//	@RequestMapping(value="/user/logout", method=RequestMethod.GET)
//	public String LogoutPage() {
//		return "/user/mainPage";
//	}
//}