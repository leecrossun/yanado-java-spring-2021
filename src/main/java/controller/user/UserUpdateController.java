package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistence.dao.UserDAO;
import service.dto.UserDTO;

// ȸ�� ���� ������Ʈ
@WebServlet("/user/update")
public class UserUpdateController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String updateCode = request.getParameter("updateCode");
		System.out.println("updateCode : " + updateCode);
		
		// ����ȸ���� ȸ������ ������ ���
		if (updateCode.equals("individual")) {
			String userId = request.getParameter("userId");
			String userNewPassword = request.getParameter("userNewPassword");
			String phoneNumber = request.getParameter("phoneNumber");
			String email = request.getParameter("email");
			
			UserDTO dto = new UserDTO(userId, userNewPassword, phoneNumber, email);
			UserDAO.getInstance().updateUser(dto);
			
			RequestDispatcher disp = request.getRequestDispatcher("/main/mainPage.jsp");
			disp.forward(request, response);
		}
		
		// �����ڰ� ȸ����Ͽ��� ��� ������ ���
		else if (updateCode.equals("manager")) { 
			String userId = request.getParameter("userId");
			String userMembership = request.getParameter("userMembership");
			
			UserDTO dto = new UserDTO(userId, userMembership);
			int resultCode = UserDAO.getInstance().updateManager(dto);	// 1�̸� ����, 0�̸� ����
			System.out.println("resultCode: " + resultCode);
			
			//json ��ȯ
			String result = String.format("[{'res' : '%d'}, {'id' : '%s'}]", resultCode, userId);
			response.getWriter().println(result);
		}
	}
}