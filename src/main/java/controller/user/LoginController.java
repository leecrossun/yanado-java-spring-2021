package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistence.dao.UserDAO;
import service.dto.UserDTO;

@WebServlet("/user/login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		UserDTO dto = UserDAO.getInstance().getUserByUserId(userId);
		
		String param = ""; // param의 값
		String resultStr = ""; // 전송될 json 문자열
		

		if (dto == null || dto.getUserId().equals(userId) == false) {
			param = "no_userId";
		}

		else if (dto.getPassword().equals(password) == false) {
			param = "no_password";
		}
		
		else {
			param = "clear";
			HttpSession session = request.getSession();

			session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
			
			// 멤버십 추가됨
			session.setAttribute("membership", dto.getUserMembership());
		}

		resultStr = String.format("[{'param':'%s'}]", param);
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().println(resultStr);
	}
}