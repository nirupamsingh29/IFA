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

/**
 * Servlet implementation class MatchUpdater
 */
@WebServlet("/matchUpdater")
public class MatchUpdater extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")==null || session.getAttribute("username")==""){
			response.sendRedirect("login.jsp");
		}		
		
		String teamA=request.getParameter("team_A");
		String[] teams=teamA.split(",");
		teamA=teams[0];
		String teamB=teams[1];
		String result=request.getParameter("result");
		System.out.println(teamA+teamB);
		Boolean flag=false;
		RequestDispatcher rd;		
		Model model=new Model();
		flag=model.updateMatch(teamA, teamB, result);
		rd=request.getRequestDispatcher("response.jsp");
		if(flag){
			request.setAttribute("message", "Match updated successfully.");
		} else{
			request.setAttribute("message", "Error occurred while updating match. match not updated. Please retry.");
		}
		rd.forward(request, response);
	}

}
