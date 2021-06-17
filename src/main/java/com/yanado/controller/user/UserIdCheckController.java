package com.yanado.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.yanado.dao.UserDAO;
import com.yanado.dto.User;

@WebServlet("/user/checkId")
public class UserIdCheckController extends HttpServlet {
	
	@Autowired
	UserDAO userDAO;
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		User dto = userDAO.getUserByUserId(id); 
		String res = "no";	//가입 불가

		if (dto == null) {	//null 이면 조회 안 됨
			res="yes";	//조회 됨 > 가입 가능
		}

		response.setContentType("text/plain;charset=utf-8"); 
		String resultStr = String.format("[{'result':'%s'},{'id':'%s'}]", res, id);
		response.getWriter().println(resultStr);
	}
}
