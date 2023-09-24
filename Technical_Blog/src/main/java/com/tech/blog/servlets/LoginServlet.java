package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entitties.Message;
import com.tech.blog.entitties.User;
import com.tech.blog.helper.ConnectionProvider;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
			try(PrintWriter out=response.getWriter()){
			// fech username and password
			String userEmail=request.getParameter("email");
			String userPassword=request.getParameter("password");
			
			UserDao dao=new UserDao(ConnectionProvider.getConnection());
			
			User u=dao.getUserByEmailAndPassword(userEmail, userPassword);
			
			if(u==null)
			{
				//login.....error
				//out.println("Invalid Details...try again");
				Message msg=new Message("Inavalid details! try with another","error","alert-danger");
				HttpSession s=request.getSession();
				s.setAttribute("msg", msg);
				
				response.sendRedirect("login_page.jsp");
			}
			else {
				//login success
				HttpSession s=request.getSession();
				s.setAttribute("currentUser", u);
				response.sendRedirect("profile.jsp");
			}
			
			}
	}

}
