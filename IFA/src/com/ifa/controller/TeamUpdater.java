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

@WebServlet("/teamUpdater")
public class TeamUpdater extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public TeamUpdater() {
    	super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")==null || session.getAttribute("username")==""){
			response.sendRedirect("login.jsp");
		}		
		
		String tname=request.getParameter("t_name");
		String tcode=request.getParameter("t_code");
		int pld=Integer.parseInt(request.getParameter("m_played"));
		int won=Integer.parseInt(request.getParameter("m_won"));
		int lost=Integer.parseInt(request.getParameter("m_lost"));
		int tie=Integer.parseInt(request.getParameter("m_tie"));
		
		Boolean flag=false;
		RequestDispatcher rd;		
		Model model=new Model();
		flag=model.updateTeam(tname,tcode,pld,won,lost,tie);
		rd=request.getRequestDispatcher("response.jsp");
		if(flag){
			request.setAttribute("message", "Team updated successfully.");
		} else{
			request.setAttribute("message", "Error occurred while updating team. team not updated. Please retry.");
		}
		rd.forward(request, response);
	}

}
