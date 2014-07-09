package com.ifa.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifa.bean.TeamsBean;
import com.ifa.model.Model;

/**
 * Servlet implementation class Teams_CUD
 */
@WebServlet("/teams_CUD")
public class Teams_CUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	Model model=new Model();
		ArrayList<TeamsBean> teamsList=model.selectTeam();
		request.setAttribute("teamsList", teamsList);
		RequestDispatcher rd=request.getRequestDispatcher("Teams_CUD.jsp");
		rd.forward(request, response);
    }
}
