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
import com.ifa.model.Model;

@WebServlet("/matches_CUD")
public class Matches_CUD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model model=new Model();
		ArrayList<MatchesBean> matchesList=model.selectMatches();
		request.setAttribute("matchesList", matchesList);
		RequestDispatcher rd=request.getRequestDispatcher("Matches_CUD.jsp");
		rd.forward(request, response);}
}
