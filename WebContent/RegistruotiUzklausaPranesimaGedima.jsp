<%@page import="lt.help.desk.bd.klasifikatoriai.GedimuRusys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%
String username=String.valueOf(session.getAttribute("loginName"));

//GedimoRusis gedimoRusis = new GedimoRusis();

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Progma", "no-cache");
response.setHeader("Expires", "0");
if(session.getAttribute("loginName")==null){
	response.sendRedirect("Login.jsp");
} else if ((session.getAttribute("loginName").equals("help"))){
	response.sendRedirect("Administravimas.jsp");
}
%>

<%@include file="Header.jsp" %>	

<title>Gedimų registravimas</title>
</head>
<body>



<form action="PateiktiGedima" method="post">
<div id="pasirinktoMenuPunktoDefaultDefaultSettingsKeitimas">



Pasirinkite gedimą:
<select class="inputas" name="gedimoTema">
<option value="-1">Pasirinkite</option>
<option value="<%= GedimuRusys.Elektroninio_pašto_nesklandumai %>"><%= GedimuRusys.Elektroninio_pašto_nesklandumai.toString().replace("_", " ") %></option>
<option value="<%= GedimuRusys.Spausdintūvo_nesklandumai %>"><%= GedimuRusys.Spausdintūvo_nesklandumai.toString().replace("_", " ") %></option>
<option value="<%= GedimuRusys.Naršyklės_klaidos %>"><%= GedimuRusys.Naršyklės_klaidos.toString().replace("_", " ") %></option>
<option value="<%= GedimuRusys.Programinės_įrangos_instaliavimas %>"><%= GedimuRusys.Programinės_įrangos_instaliavimas.toString().replace("_", " ") %></option>
<option value="<%= GedimuRusys.Kiti_darbai %>"><%= GedimuRusys.Kiti_darbai.toString().replace("_", " ") %></option>
</select>

Aprašymas:
<textarea name="gedimoAprasymas" class="inputas"></textarea>

<input type="submit" value="Pateikti">

</div>

</form>

</body>
</html>