<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import = "statusai.Statusas" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HELP</title>
<link rel="stylesheet" href="Style.css"/>

<%
Statusas statusas = new Statusas();

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
<div id="pasirinktoMenuPunktoDefaultSettings">
--| Sukurti skyrių |-- --| Redaguoti skyrių |--
<div id="pasirinktoMenuPunktoDefaultDefaultSettingsKeitimas">
<form action="SkyriausSukurimas.jsp" method="post">
pavadinimas
<input type="text" class="inputas" id="skyriausPavadinimas">
Statusas
<select class="inputas" id="skyriausStatusas">
<option value="-1">Pasirinkite</option>
<option value="1"><%= statusas.getStatusas().active%></option>
<option value="2"><%= statusas.getStatusas().diactive %></option>
</select>
<div id="btnSukurtiNaudotoja">
<input type="button" value="Sukurti">

</div>
</form>
</div>
</div>



</body>
</html>