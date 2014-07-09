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

@WebServlet("/teamCreator")
public class TeamCreator extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public TeamCreator() {
    	super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")==null || session.getAttribute("username")==""){
			response.sendRedirect("login.jsp");
		}		
		String teamName=request.getParameter("t_name");
		String teamCode=request.getParameter("t_code");
		int mPlayed=Integer.parseInt(request.getParameter("m_played"));
		int mWon=Integer.parseInt(request.getParameter("m_won"));
		int mLost=Integer.parseInt(request.getParameter("m_lost"));
		int mTie=Integer.parseInt(request.getParameter("m_tie"));
		
		Boolean flag=false;
		RequestDispatcher rd;		
		Model model=new Model();
		flag=model.insertTeam(teamName, teamCode, mPlayed, mWon, mLost, mTie);
		rd=request.getRequestDispatcher("response.jsp");
		if(flag){
			request.setAttribute("message", "Team added successfully.");
		} else{
			request.setAttribute("message", "Error occurred while adding team. team not added. Please retry.");
		}
		rd.forward(request, response);
	}

}
