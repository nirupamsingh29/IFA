package com.ifa.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifa.bean.TeamsBean;
import com.ifa.model.Model;

@WebServlet("/Team")
public class Team extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model model=new Model();
		String teamCode=request.getParameter("t_code");
		TeamsBean team=model.selectOneTeam(teamCode);
		request.setAttribute("team", team);
		RequestDispatcher rd=request.getRequestDispatcher("team.jsp");
		rd.forward(request, response);
	}
}
