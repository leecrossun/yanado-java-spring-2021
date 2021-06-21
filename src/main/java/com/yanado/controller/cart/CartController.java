package com.yanado.controller.cart;

import java.io.IOException;
import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yanado.controller.user.UserSessionUtils;
import com.yanado.dao.ProductDAO;
import com.yanado.dao.UserDAO;
import com.yanado.dto.Product;
import com.yanado.dto.User;
import com.yanado.service.UserService;

@Controller
public class CartController {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	protected String service(HttpServletRequest request, RedirectAttributes red) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("userId");
		String pwd = request.getParameter("password");

		User dto = userDAO.getUserByUserId(id);
		List<Product> product = productDAO.selectShoppingList();

		HttpSession session = request.getSession();
		session.setAttribute(UserSessionUtils.USER_SESSION_KEY, id);
		session.setAttribute(UserSessionUtils.USER_SESSION_KEY, product);
		
		return "redirect:/";
	}

	@RequestMapping(value = "/cart/list", method = RequestMethod.GET)
	public String form() {
		return "cart/list";
	}

}