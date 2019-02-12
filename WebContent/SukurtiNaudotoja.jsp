<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import = "vaidmenys.Vaidmuo" %>
        <%@ page import = "pareigos.Pareigos" %>
        <%@ page import = "service.Skyriai" %>
        <%@ page import="java.sql.Connection" %> 
<%@ page import="java.sql.PreparedStatement" %> 
<%@ page import="java.sql.ResultSet" %> 
<%@ page import="javax.xml.XMLConstants" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="mySql.connection.MySqlConnect" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HELP</title>
<link rel="stylesheet" href="Style.css"/>

<%
	Vaidmuo vaidmuo = new Vaidmuo();
Skyriai skyriai = new Skyriai();

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

--| Sukurti naudotoją |--



<form action="SukurtiDBNaudotoja" method="post">
<div id="pasirinktoMenuPunktoDefaultDefaultSettingsKeitimas">
Prisijungimo vardas*:
<input type="text" name="userLoginName" class="inputas" placeholder="pvz. vc000">
Slaptažodis**:
<input type="password" name="passw" class="inputas">
Pakartoti slaptažodį:
<input type="password" name="passwConf" class="inputas">
Vardas:
<input type="text" name="userName" class="inputas">
Pavardė:
<input type="text" name="userSurname" class="inputas">
El.paštas:
<input type="text" name="email" class="inputas">
Skyrius:
<select class="inputas" name="userSkyrius">
<option value="-1">Pasirinkite</option>

  <%
  for (int i=0; i<skyriai.gautiSarasa().size(); i++){
	  %>
	  <option value="<%= i %>"><%= skyriai.gautiSarasa().get(i).getPavadinimas() %></option>
	  <%
  }

  
%>


</select>
Pareigos:
<select class="inputas" name="userPareigos">
<option value="-1">Pasirinkite</option>
<option value="<%= Pareigos.Vedėjas %>"><%= Pareigos.Vedėjas %></option>
<option value="<%= Pareigos.Vyriausiasis_specialistas %>"><%= Pareigos.Vyriausiasis_specialistas %></option>
<option value="<%= Pareigos.Vyresnysis_specialistas %>"><%= Pareigos.Vyresnysis_specialistas %></option>
<option value="<%= Pareigos.Specialistas %>"><%= Pareigos.Specialistas %></option>
</select>
Vaidmuo:
<select class="inputas" name="userVaidmuo">
<option value="-1">Pasirinkite</option>
<option value="<%= vaidmuo.getVaidmuo().darbuotojas_it %>"><%= vaidmuo.getVaidmuo().darbuotojas_it %></option>
<option value="<%= vaidmuo.getVaidmuo().user %>"><%= vaidmuo.getVaidmuo().user %></option>
</select>
<div id="btnSukurtiNaudotoja">
<input type="submit" value="Sukurti">
</div>
<div id="pastabos">
*galima tik unikali 6 simbolių kombinacija;
<br>
**iki 10 simbolių;
</div>

</div>

</form>
</div>


</body>
</html>