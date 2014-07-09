package com.ifa.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ifa.model.Model;

@WebServlet("/loginUser")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Model m=new Model();
		int flag=0;
		HttpSession session = null;
		RequestDispatcher rd=request.getRequestDispatcher("response.jsp");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		flag=m.checkPassword(username, password);
		switch(flag){
			case 0:
				request.setAttribute("message", "ERROR!");
				break;
			case -1:
				request.setAttribute("message", "INCORRECT password for the given userID.\nPlease check CAPS LOCK");
				break;	
			case -2:
				request.setAttribute("message", "UserID does NOT exist.\nPlease check userID.");
				break;
			case 1:
				session=request.getSession(true);
				session.setAttribute("username", username);
				request.setAttribute("message", "Success!");
				break;
			default:
				request.setAttribute("message", "Unknown...");
		}
		rd.forward(request,response);		
	}
}
