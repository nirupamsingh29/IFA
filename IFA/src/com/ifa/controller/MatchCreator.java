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

@WebServlet("/matchCreator")
public class MatchCreator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")==null || session.getAttribute("username")==""){
			response.sendRedirect("login.jsp");
		}		
		String teamA=request.getParameter("team_A");
		String teamB=request.getParameter("team_B");
		String date=request.getParameter("date");
		String location=request.getParameter("location");
		
		Boolean flag=false;
		RequestDispatcher rd;		
		Model model=new Model();
		flag=model.insertMatch(teamA, teamB, date, location);
		rd=request.getRequestDispatcher("response.jsp");
		if(flag){
			request.setAttribute("message", "Match added successfully.");
		} else{
			request.setAttribute("message", "Error occurred while adding match. match not added. Please retry.");
		}
		rd.forward(request, response);
	}

}
