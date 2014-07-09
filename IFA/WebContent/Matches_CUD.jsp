<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.ifa.bean.MatchesBean, java.util.ArrayList, java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Matches</title>
<link type="text/css" href="style.css" rel="stylesheet">
<script language="JavaScript" src="datepicker.js" type="text/javascript"></script>
<link href="datepicker.css" rel="stylesheet" />
</head>
<body>
<%if(session.getAttribute("username")==null || session.getAttribute("username")==""){
	response.sendRedirect("login.jsp");
} %>
<div id="allcontent">
	<div id="header">
	<%out.print(session.getAttribute("username")); %>
	</div>
	<div class="menuBar">
	<ul>
		<li id="left_item"><a href="select.jsp" title="Go to Updation section"><span>UPDATE</span></a></li>
		<li><a href="login.jsp" title="Login as Admin"><span>LOGIN</span></a></li>
		<li id="right_item"><a href="logoutUser" title="Logout from current session"><span>LOGOUT</span></a></li>
	</ul>
	<div class="divider">&nbsp;</div>
	</div>

<div id="main">
<%
				ArrayList<MatchesBean> MatchesList=(ArrayList<MatchesBean>) request.getAttribute("matchesList");
				Iterator<MatchesBean> it=MatchesList.iterator();
		 	%>
			<p class="subheader">To add a new Match - Fill this form</p>
			<form action="matchCreator" method="post" >
			<table>
				<tr><td><strong>Team A</strong></td><td><strong>Team B</strong></td></tr>
				<tr><td><input type="text" name="team_A"/></td><td><input type="text" name="team_B"/></td></tr>
				<tr><td>Date</td><td><input type="text" name="date" id="SelectedDate" onClick="GetDate(this);" /></td></tr>
				<tr><td>Location</td> <td><input type="text" name="location"/></td></tr>
				<tr><td><input type="submit" value="Add"></td></tr>
			</table>
			</form>
			<hr/>
			
			<%
				MatchesList=(ArrayList<MatchesBean>)request.getAttribute("matchesList");
				it=MatchesList.iterator();
		 	%>
			<p class="subheader">To Add Result of an existing Match - Fill this form</p>			
			<form action="matchUpdater" method="post">
				Matches to be removed <select name="team_A" >
						<option disabled="disabled">Select Match to be removed</option>
				<%
					while(it.hasNext()){
						MatchesBean db=it.next();
			 	%>
						<option value="<%=db.getTeamA()%>,<%=db.getTeamB()%>"><%=db.getTeamA()%> Vs. <%=db.getTeamB() %></option>
				<%
					}
			 	%>			
					</select>
				<br />
				<input type="text" name="result"/>
				<input type="submit" value="Update">
			</form>
			<hr />
			<%
				MatchesList=(ArrayList<MatchesBean>)request.getAttribute("matchesList");
				it=MatchesList.iterator();
		 	%>
			<p class="subheader">To delete an existing Match - Fill this form</p>			
			<form action="matchRemover" method="post">
				Matches to be removed <select name="team_A" >
						<option disabled="disabled">Select Match to be removed</option>
				<%
					while(it.hasNext()){
						MatchesBean db=it.next();
			 	%>
						<option value="<%=db.getTeamA()%>,<%=db.getTeamB()%>"><%=db.getTeamA()%> Vs. <%=db.getTeamB() %></option>
				<%
					}
			 	%>			
					</select>
				<br />
				<input type="submit" value="Delete">
			</form>
		</div>
		<div id="footer">
		<div class="divider">&nbsp;</div>
		Author Nirupam Singh<br/>
		&copy; 2014 Netcamp&#64;LNMIIT
	</div>
	</div>
</body>
</html>