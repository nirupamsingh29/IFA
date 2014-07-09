<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.ifa.bean.PlayersBean, java.util.ArrayList, java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Players</title>
<link type="text/css" href="style.css" rel="stylesheet">
</head>
<body>
<div id="main">
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

<%
				ArrayList<PlayersBean> PlayersList=(ArrayList<PlayersBean>) request.getAttribute("playersList");
				Iterator<PlayersBean> it=PlayersList.iterator();
		 	%>
			<p class="subheader">To add a new Player - Fill this form</p>
			<form action="PlayersCreator" method="post" >
			<table>
				<tr><td>Player Name</td> <td><input type="text" name="p_name"/></td></tr>
				<tr><td>Team</td> <td><input type="text" name="t_code"/></td></tr>
				<tr><td>Matches Played</td> <td><input type="text" name="m_played"/></td></tr>
				<tr><td>Goals</td> <td><input type="text" name="goals"/></td></tr>
				<tr><td><input type="submit" value="Add"></td></tr>
			</table>
			</form>
			<hr/>
			<%
				PlayersList=(ArrayList<PlayersBean>)request.getAttribute("playersList");
				it=PlayersList.iterator();
		 	%>
			<p class="subheader">To update an existing Player - Fill this form</p>
			<form action="PlayersUpdater" method="post" >
				Players to be updated &nbsp;<select name="p_name" >
						<option disabled="disabled">Select Players to be updated</option>
				<%
					while(it.hasNext()){
						PlayersBean db=it.next();
			 	%>
						<option value="<%=db.getName()%>"><%=db.getName()%> - <%=db.getTeamCode() %></option>
				<%
					}
			 	%>					
					</select>
				<br />
				<table>
					<tr><td>Team</td> <td><input type="text" name="t_code"/></td></tr>
					<tr><td>Matches Played</td> <td><input type="text" name="m_played"/></td></tr>
					<tr><td>Goals</td> <td><input type="text" name="goals"/></td></tr>
					<tr><td><input type="submit" value="Update"></td></tr>
				</table>
			</form>
			<hr />
			<%
				PlayersList=(ArrayList<PlayersBean>)request.getAttribute("playersList");
				it=PlayersList.iterator();
		 	%>
			<p class="subheader">To delete an existing Player - Fill this form</p>			
			<form action="PlayersRemover" method="post">
				Players to be removed <select name="p_name" >
						<option disabled="disabled">Select Players to be removed</option>
				<%
					while(it.hasNext()){
						PlayersBean db=it.next();
			 	%>
						<option value="<%=db.getName()%>"><%=db.getName()%> - <%=db.getTeamCode() %></option>
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