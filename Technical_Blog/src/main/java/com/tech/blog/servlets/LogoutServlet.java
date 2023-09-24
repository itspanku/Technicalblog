package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.entitties.Message;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LogoutServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("hii");

		HttpSession s=request.getSession();
		s.removeAttribute("currentUser");
		
		Message m=new Message("Logout Successfully", "success", "alert-success");
		s.setAttribute("msg", m);
		response.sendRedirect("login_page.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
		HttpSession s=request.getSession();
		s.removeAttribute("currentUser");
		
		Message m=new Message("Logout Successfully", "success", "alert-success");
		s.setAttribute("msg", m);
		response.sendRedirect("login_page.jsp");
	}

}
