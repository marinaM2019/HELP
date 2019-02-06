<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ page import = "gedimai.GedimoRusis" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%
String username=String.valueOf(session.getAttribute("loginName"));

GedimoRusis gedimoRusis = new GedimoRusis();

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



<form action="pateiktiGedima" method="post">
<div id="pasirinktoMenuPunktoDefaultDefaultSettingsKeitimas">



Pasirinkite gedimą:
<select class="inputas" name="gedimoTema">
<option value="-1">Pasirinkite</option>
<option value="<%= gedimoRusis.getGedimoRusis().Elektroninio_pašto_nesklandumai %>"><%= gedimoRusis.getGedimoRusis().Elektroninio_pašto_nesklandumai.toString().replace("_", " ") %></option>
<option value="<%= gedimoRusis.getGedimoRusis().Spausdintūvo_nesklandumai %>"><%= gedimoRusis.getGedimoRusis().Spausdintūvo_nesklandumai.toString().replace("_", " ") %></option>
<option value="<%= gedimoRusis.getGedimoRusis().Naršyklės_klaidos %>"><%= gedimoRusis.getGedimoRusis().Naršyklės_klaidos.toString().replace("_", " ") %></option>
<option value="<%= gedimoRusis.getGedimoRusis().Programinės_įrangos_instaliavimas %>"><%= gedimoRusis.getGedimoRusis().Programinės_įrangos_instaliavimas.toString().replace("_", " ") %></option>
<option value="<%= gedimoRusis.getGedimoRusis().Kiti_darbai %>"><%= gedimoRusis.getGedimoRusis().Kiti_darbai.toString().replace("_", " ") %></option>
</select>

Aprašymas:
<textarea name="gedimoAprasymas" class="inputas"></textarea>

<input type="submit" value="Pateikti">

</div>

</form>

</body>
</html>