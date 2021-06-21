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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.dao.UserDAO;
import com.yanado.dto.User;
import com.yanado.service.UserService;

//회원 정보 업데이트
@Controller
@RequestMapping("/user")
public class UserUpdateController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDAO userDAO;
	@RequestMapping("/updateInfo")
	protected ModelAndView service(HttpServletRequest request)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		/*
		 * String newPwd = request.getParameter("new_password"); String address =
		 * request.getParameter("address"); String phone =
		 * request.getParameter("phoneNumber"); String email =
		 * request.getParameter("email");
		 */
		ModelAndView mav = new ModelAndView();
		UserSessionUtils uSession = new UserSessionUtils();
		String userId = uSession.getLoginUserId(request.getSession());
		User user = userDAO.getUserByUserId(userId);
		userDAO.updateUser(user);
		mav.setViewName("user/mypageUpdate");
		mav.addObject("user", user);
		return mav;

		/*
		 * RequestDispatcher disp =
		 * request.getRequestDispatcher("/resources/templates/user/mypageUpdate.html");
		 * disp.forward(request, response);
		 */

	}
}