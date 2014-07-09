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

@WebServlet("/teamRemover")
public class TeamRemover extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")==null || session.getAttribute("username")==""){
			response.sendRedirect("login.jsp");
		}		
		String tcode=request.getParameter("t_code");
		Boolean flag=false;
		RequestDispatcher rd;		
		Model model=new Model();
		flag=model.deleteTeam(tcode);
		rd=request.getRequestDispatcher("response.jsp");
		if(flag){
			request.setAttribute("message", "team deleted successfully.");
		} else{
			request.setAttribute("message", "Error occurred while deleting team. team not deleted. Please retry.");
		}
		rd.forward(request, response);
	}

}
