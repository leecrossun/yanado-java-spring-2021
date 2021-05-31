package com.yanado.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yanado.dao.UserDAO;
import com.yanado.dto.User;

// 해당 회원 아이디로 정보 가져와서 마이페이지로 이동
@WebServlet("/user/mypage")
public class MypageController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userIid");
		
		User dto = UserDAO.getInstance().getUserByUserId(userId);
		
		request.setAttribute("dto", dto);
		
		RequestDispatcher disp = request.getRequestDispatcher("/user/user_mypage.jsp");
		disp.forward(request, response);
	}
}