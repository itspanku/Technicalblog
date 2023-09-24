package com.tech.blog.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entitties.Message;
import com.tech.blog.entitties.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;

@MultipartConfig
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);

		PrintWriter out = response.getWriter();

		// fetch all data
		String userEmail = request.getParameter("user_email");
		String userName = request.getParameter("user_name");
		String userPassword = request.getParameter("user_password");
		String userAbout = request.getParameter("user_about");
		Part part = request.getPart("image");

		String imageName = part.getSubmittedFileName();

		// get the user from the session

		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentUser");
		user.setEmail(userEmail);
		user.setName(userName);
		user.setPassword(userPassword);
		user.setAbout(userAbout);
		
		String oldFile=user.getProfie();
		user.setProfile(imageName);

		// update database....
		UserDao userDao = new UserDao(ConnectionProvider.getConnection());
		boolean ans = userDao.updateUser(user);
		if (ans) {
			
			String path = request.getRealPath("/") + "pics" + File.separator + user.getProfie();
			
			// delete code
			
			String pathOldFile = request.getRealPath("/") + "pics" + File.separator + oldFile;
			if(!oldFile.equals("default.png")) {
			Helper.deleteFile(pathOldFile);	
			}
			
				if (Helper.saveFile(part.getInputStream(), path)) 
				{
					
					out.println("Profile Updated....");
					Message msg=new Message("Profile Details Updated....","success","alert-success");
					s.setAttribute("msg", msg);
				}
				else
				{
					out.println("Not Updated...");
					Message msg=new Message("Something Went Wrong","error","alert-danger");
					s.setAttribute("msg", msg);
				}
				
			
		} else {
			out.println("Not Updated...");
			Message msg=new Message("Something Went Wrong","error","alert-danger");
			s.setAttribute("msg", msg);
		}
		
		response.sendRedirect("profile.jsp");

	}

}
