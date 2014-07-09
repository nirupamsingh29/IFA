<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.ifa.bean.* , java.util.ArrayList, java.util.Iterator, com.ifa.model.Model, java.sql.SQLException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="main_style.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<table>
<div>
<%TeamsBean tb=(TeamsBean)request.getAttribute("team");
%>
	<tr><td>Team Name</td><td><%=tb.getTeamName()%></td></tr>
	<tr><td>Code</td><td><%=tb.getTeamCode() %></td></tr>
	<tr><td>Matches Played</td><td><%=tb.getmPlayed() %></td></tr>
	<tr><td>Won</td><td><%=tb.getmWon() %></td></tr>
	<tr><td>Lost</td><td><%=tb.getmLost() %></td></tr>
	<tr><td>Tie</td><td><%=tb.getmTie() %></td></tr>
	<tr><td>Players</td><td><form action="Player" method="post">
	<input type="hidden" name="t" value="<%=tb.getTeamCode()%>"/>
	<input type="submit" id="players" value="<%=tb.getTeamName()%> Players"/></form>
	</td></tr>
</table>
</div>
</body>
</html>
</body>
</html>