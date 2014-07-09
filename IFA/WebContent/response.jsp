<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="style.css" rel="stylesheet">
<title>Result</title>
</head>
<body>
<div id="allcontent">
	<div id="header">
	<%if(session.getAttribute("username")==null || session.getAttribute("username")==""){
		out.print("Unauthorized Access"); 
	} else {out.print(session.getAttribute("username"));}%>
	</div>
	<div class="menuBar">
	<ul>
		<li id="left_item"><a href="select.jsp" title="Go to Updation section"><span>UPDATE</span></a></li>
		<li><a href="login.jsp" title="Login as Admin"><span>LOGIN</span></a></li>
		<li id="right_item"><a href="logoutUser" title="Logout from current session"><span>LOGOUT</span></a></li>
	</ul>
	<div class="divider">&nbsp;</div>
	</div>
	<br>&nbsp;<br>
	<%if(request.getAttribute("message").equals(null)){
		out.print("Error :(");
	} else {
			out.print(request.getAttribute("message"));
	}%>
	<br>&nbsp;<br>
	<div id="footer">
		<div class="divider">&nbsp;</div>
		Author Nirupam Singh<br/>
		&copy; 2014 Netcamp&#64;LNMIIT
	</div>
</div>

</body>
</html>