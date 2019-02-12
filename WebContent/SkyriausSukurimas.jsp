<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import = "lt.help.desk.bd.service.Skyriai" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HELP</title>
<link rel="stylesheet" href="Style.css"/>

<title>Gedimų registravimas</title>
</head>

<%

String username=String.valueOf(session.getAttribute("loginName"));

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Progma", "no-cache");
response.setHeader("Expires", "0");
if(session.getAttribute("loginName")==null){
	response.sendRedirect("Login.jsp");
} else if (!(session.getAttribute("loginName").equals("help"))){
	response.sendRedirect("Home.jsp");
}
%>
<body>
<%

String skyriausPavadinimas = request.getParameter("skyriausPavadinimas");
String skyriausStatusas = request.getParameter("skyriausStatusas");

if (skyriausPavadinimas.isEmpty() || (skyriausStatusas.equals("-1"))){
	return;
}

Skyriai skyriai = new Skyriai();
skyriai.sukurtiNauja(skyriausPavadinimas, skyriausStatusas);
response.sendRedirect("SkyriuAdministravimas.jsp");

%>


</body>
</html>