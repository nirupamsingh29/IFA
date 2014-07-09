<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.ifa.bean.* , java.util.ArrayList, java.util.Iterator, com.ifa.model.Model, java.sql.SQLException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>i-League</title>
<link type="text/css" href="main_style.css" rel="stylesheet">
</head>
<body>
<%
	ArrayList<TeamsBean> teamsList=(ArrayList<TeamsBean>)request.getAttribute("teamsList");
	ArrayList<MatchesBean> prevMatches=(ArrayList<MatchesBean>)request.getAttribute("prevMatches");
	ArrayList<MatchesBean> nextMatches=(ArrayList<MatchesBean>)request.getAttribute("nextMatches");
	Iterator<TeamsBean> it=teamsList.iterator();
	Iterator<MatchesBean> pm=prevMatches.iterator();
	Iterator<MatchesBean> nm=nextMatches.iterator();
%>
	<div id="head">
	<div id="header">
	<img src="logo.jpg" style="height:150px"/>
	</div>
	<div id="title"><p>Indian Football Association</p>
	</div>
	</div>
	<div id="panel">
	<div id="pane">
	<input type="button" id="login" onclick='window.open("login.jsp")' value='Login'/></div>
	<div id=teams>
		<table id="tt">
			<tr><th>Teams</th>
			<%
			while(it.hasNext()){
					TeamsBean tb=it.next();%>
				<tr><td><form action="Team" method="post">
				<input type="hidden" name="t_code" value="<%=tb.getTeamCode()%>"/>
				<input type="submit" id="teamName" value="<%=tb.getTeamName()%>"/></form>
				</td></tr>
			<%} %>
		</table>
	</div>
	</div>
	<div id="prevMatches">
		<table>
			<tr><th>Previous Matches</th>
			<th></th><th></th><th></th>
			<%
			while(pm.hasNext()){
				MatchesBean mpb=pm.next();%>
				<tr>
					<td><%=mpb.getTeamA() %></td>
					<td><%=mpb.getTeamB() %></td>
					<td><%=mpb.getLocation() %></td>
					<td><%=mpb.getResult() %></td>
				</tr>
			<%} %>
		</table>
	</div>
	
	<div id="nextMatches">
		<table>
			<tr><th>Next Matches</th>
			<th></th><th></th><th></th>
			<%
			while(nm.hasNext()){
				MatchesBean npb=nm.next();%>
				<tr>
					<td><%=npb.getTeamA() %></td>
					<td><%=npb.getTeamB() %></td>
					<td><%=npb.getLocation() %></td>
					<td><%=npb.getDate() %></td>
				</tr>
			<%} %>
		</table>
	</div>
		
	
	
</body>
</html>