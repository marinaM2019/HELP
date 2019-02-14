<%@page import="lt.help.desk.bd.klasifikatoriai.Statusai"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ page import="java.sql.Connection" %> 
<%@ page import="java.sql.PreparedStatement" %> 
<%@ page import="java.sql.ResultSet" %> 
        <%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="lt.help.desk.bd.login.MySqlConnect" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HELP</title>
<link rel="stylesheet" href="Style.css"/>

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

<%@include file="Header.jsp" %>	

<title>Gedimų registravimas</title>
</head>
<body>
<%@include file="SuperAdminMenu.jsp" %>
<div id="menuPunktasSukurtiSkyriu">
--| Sukurti skyrių |--


<div id="pasirinktoMenuPunktoDefaultDefaultSettingsKeitimas">
<form action="SkyriausSukurimas.jsp" method="post">
pavadinimas
<input type="text" class="inputas" name="skyriausPavadinimas">


<select class="inputas" name="skyriausStatusas">
<option value="-1">Pasirinkite</option>
<option value="1"><%= Statusai.active %></option>
<option value="2"><%= Statusai.diactive %></option>
</select>

<div id="btnSukurtiNaudotoja">
<input type="submit" value="Sukurti">

</div>
</form>
</div>


</div> 


<div id="menuPunktasRedaguotiSkyriu">








</body>
</html>