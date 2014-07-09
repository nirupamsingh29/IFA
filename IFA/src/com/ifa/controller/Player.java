package com.ifa.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifa.bean.PlayersBean;
import com.ifa.model.Model;

@WebServlet("/Player")
public class Player extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model model=new Model();
		String teamCode=request.getParameter("t");
		ArrayList<PlayersBean> playersList=model.selectPlayers(teamCode);
		request.setAttribute("playersList", playersList);
		RequestDispatcher rd=request.getRequestDispatcher("players.jsp");
		rd.forward(request, response);
	}

}
