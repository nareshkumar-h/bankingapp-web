package com.naresh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naresh.bankingapp.dao.UserDAO;
import com.naresh.bankingapp.dao.impl.UserDAOImpl;
import com.naresh.bankingapp.exception.DBException;
import com.naresh.bankingapp.model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String email = request.getParameter("email");//"john@gmail.com";
			String password  = request.getParameter("password");//"pass123";
			System.out.println("Email:" + email +",password:" + password);
			UserDAO userDAO = new UserDAOImpl();
			User user = userDAO.login(email, password);
			if( user == null) {
				System.out.println("Invalid Email/Password");
			}
			else {
				System.out.println("Valid Email/Password");
			}
			System.out.println(user);
		} catch (DBException e) {
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}
