package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.dao.UserDAO;

//회원 삭제 작업
@WebServlet("/user/delete")
public class UserDeleteController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String userId = request.getParameter("userId");
		int deleteCode = UserDAO.getInstance().deleteUser(userId);	// 1�̸� ����, 0�̸� ����
		System.out.println("deleteCode: " + deleteCode);

		//json 반환
		String result = String.format("[{'res' : '%d'}, {'id' : '%s'}]", deleteCode, userId);
		response.getWriter().println(result);
	}
}