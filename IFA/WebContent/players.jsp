<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.ifa.bean.* , java.util.ArrayList, java.util.Iterator, com.ifa.model.Model, java.sql.SQLException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="main_style.css" rel="stylesheet">
<title>i-League</title>
</head>
<body>
<%
ArrayList<PlayersBean> playersList=(ArrayList<PlayersBean>)request.getAttribute("playersList");
Iterator<PlayersBean> it=playersList.iterator();
%>
<table>
<tr><td><strong>Name</strong></td>
<td><strong>Team</strong></td>
<td><strong>Played</strong></td>
<td><strong>Goals</strong></td></tr>
<%
while(it.hasNext()){
		PlayersBean tb=it.next();%>
	<tr><td><%=tb.getName() %></td>
	<td><%=tb.getTeamCode() %></td>
	<td><%=tb.getmPlayed() %></td>
	<td><%=tb.getGoals() %></td></tr>
<%} %>
</table>
</body>
</html>