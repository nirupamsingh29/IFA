package com.ifa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Select() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")==null || session.getAttribute("username")==""){
			response.sendRedirect("login.jsp");
		}
		RequestDispatcher rd;
		int i=Integer.parseInt(request.getParameter("x"));
		switch(i){
		case 1:
			response.sendRedirect("teams_CUD");
			break;
		case 2:
			response.sendRedirect("players_CUD");
			break;
		case 3:
			response.sendRedirect("matches_CUD");
			break;
		default:
			response.sendRedirect("response.jsp");
			break;
		}
	}
}
