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

@WebServlet("/players_CUD")
public class Players_CUD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model model=new Model();
		ArrayList<PlayersBean> playersList=model.selectPlayers();
		request.setAttribute("playersList", playersList);
		RequestDispatcher rd=request.getRequestDispatcher("Players_CUD.jsp");
		rd.forward(request, response);}
}
