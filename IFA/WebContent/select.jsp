<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose one</title>
<link type="text/css" href="style.css" rel="stylesheet">
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
	<form action="Select" method="post">
	<table>
	<tr><td><input type="radio" name="x" value="1"/></td><td>Update Team</td></tr>
	<tr><td><input type="radio" name="x" value="2"/></td><td>Update Players</td></tr>
	<tr><td><input type="radio" name="x" value="3"/></td><td>Update Match Fixtures</td></tr>
	<tr><td><input type="submit" value="Go"></td></tr>
	</table>
	</form>
	<div id="footer">
		<div class="divider">&nbsp;</div>
		Author Nirupam Singh<br/>
		&copy; 2014 Netcamp&#64;LNMIIT
	</div>
</div>
</body>
</html>