package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//회원 추가 작업 - 파라미터 받아서 회원 리스트로 넘김
@WebServlet("/user/insert")
public class UserCreateController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		String userId = request.getParameter("name");
		String password = request.getParameter("pasword");
		String userName = request.getParameter("userName");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("birth");
		String address = request.getParameter("request");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
//		int rankCount = request.getParameter("rankCount");
		
		response.sendRedirect("/user/user_login.jsp");
	}
} 