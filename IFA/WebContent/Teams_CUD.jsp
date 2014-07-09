<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.ifa.bean.TeamsBean, java.util.ArrayList, java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="style.css" rel="stylesheet">
<title>Edit Teams</title>
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
			<p class="subheader">To add a new Team - Fill this form</p>
			<form action="teamCreator" method="post" >
			<table>
				<tr><td>Team Name</td> <td><input type="text" name="t_name"/></td></tr>
				<tr><td>Code Name</td> <td><input type="text" name="t_code"/></td></tr>
				<tr><td>Matches Played</td> <td><input type="text" name="m_played"/></td></tr>
				<tr><td>Wins</td> <td><input type="text" name="m_won"/></td></tr>
				<tr><td>Losses</td> <td><input type="text" name="m_lost"/></td></tr>
				<tr><td>Tie</td> <td><input type="text" name="m_tie"/></td></tr>
				<tr><td><input type="submit" value="Add"></td></tr>
			</table>
			</form>
			<hr/>
			<%
				ArrayList<TeamsBean> TeamsList=(ArrayList<TeamsBean>) request.getAttribute("teamsList");
				Iterator<TeamsBean> it=TeamsList.iterator();
		 	%>
			<p class="subheader">To update an existing Team - Fill this form</p>
			<form action="teamUpdater" method="post" >
				Teams to be updated &nbsp;<select name="t_code" >
						<option disabled="disabled">Select Teams to be updated</option>
				<%
					while(it.hasNext()){
						TeamsBean db=it.next();
			 	%>
						<option value="<%=db.getTeamCode()%>"><%=db.getTeamName()%></option>
				<%
					}
			 	%>					
					</select>
				<br />
				<table>
					<tr><td>Team Name</td> <td><input type="text" name="t_name"/></td></tr>
					<tr><td>Matches Played</td> <td><input type="text" name="m_played"/></td></tr>
					<tr><td>Wins</td> <td><input type="text" name="m_won"/></td></tr>
					<tr><td>Losses</td> <td><input type="text" name="m_lost"/></td></tr>
					<tr><td>Tie</td> <td><input type="text" name="m_tie"/></td></tr>
					<tr><td><input type="submit" value="Update"></td></tr>
				</table>
			</form>
			<hr />
			<%
				TeamsList=(ArrayList<TeamsBean>)request.getAttribute("teamsList");
				it=TeamsList.iterator();
		 	%>
			<p class="subheader">To delete an existing Team - Fill this form</p>			
			<form action="teamRemover" method="post">
				Teams to be removed <select name="t_code" >
						<option disabled="disabled">Select Teams to be removed</option>
				<%
					while(it.hasNext()){
						TeamsBean db=it.next();
			 	%>
						<option value="<%=db.getTeamCode()%>"><%=db.getTeamName()%></option>
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