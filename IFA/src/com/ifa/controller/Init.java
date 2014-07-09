package com.ifa.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifa.bean.MatchesBean;
import com.ifa.bean.TeamsBean;
import com.ifa.model.Model;

@WebServlet("/init")
public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Init() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model model=new Model();
		ArrayList<TeamsBean> teamsList=model.selectTeam();
		ArrayList<MatchesBean> prevMatches=model.prevMatches();
		ArrayList<MatchesBean> nextMatches=model.nextMatches();
		request.setAttribute("teamsList", teamsList);
		request.setAttribute("prevMatches", prevMatches);
		request.setAttribute("nextMatches", nextMatches);
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
}
