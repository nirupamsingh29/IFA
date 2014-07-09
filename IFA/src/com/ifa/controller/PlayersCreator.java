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
 * Servlet implementation class PlayersCreatorr
 */
@WebServlet("/PlayersCreator")
public class PlayersCreator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")==null || session.getAttribute("username")==""){
			response.sendRedirect("login.jsp");
		}		
		String playerName=request.getParameter("p_name");
		String teamCode=request.getParameter("t_code");
		int mPlayed=Integer.parseInt(request.getParameter("m_played"));
		int goals=Integer.parseInt(request.getParameter("goals"));
		
		Boolean flag=false;
		RequestDispatcher rd;		
		Model model=new Model();
		flag=model.insertPlayer(playerName, teamCode, mPlayed, goals);
		rd=request.getRequestDispatcher("response.jsp");
		if(flag){
			request.setAttribute("message", "Player added successfully.");
		} else{
			request.setAttribute("message", "Error occurred while adding player. Player not added. Please retry.");
		}
		rd.forward(request, response);
	}

}
