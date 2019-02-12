<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.Connection" %> 
<%@ page import="java.sql.PreparedStatement" %> 
<%@ page import="java.sql.ResultSet" %> 
<%@ page import="javax.xml.XMLConstants" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="lt.help.desk.bd.mySql.connection.MySqlConnect" %>
<%@ page import="lt.help.desk.bd.service.Naudotojai" %>
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
<div id="pasirinktoMenuPunktoDefaultSettings">
--| Redaguoti naudotoją |--
</div>
<br>


<table id="lentele">
<colgroup>
	<col style="width:5%">
    <col style="width:10%">
    <col style="width:15%">
     <col style="width:15%">
     <col style="width:7%">
      <col style="width:25%">
       <col style="width:20%">
       <col style="width:10%">
  </colgroup> 
  <thead>
  <tr >
  	<th>ID</th>
    <th>Prisijungimo vardas</th>
    <th>Vardas</th>
    <th>Pavardė</th>
    <th>El.paštas</th>
    <th>Skyrius</th>
    <th>Pareigos</th>
    <th>Vaidmuo</th>
  </tr>
              <tbody>
            <tr class="item">
  <%
Naudotojai naudotojai = new Naudotojai();
for (int i=0; i<naudotojai.gautiNaudotojuSarasa().size(); i++){
	%>
	<tr>
	<td><%= naudotojai.gautiNaudotojuSarasa().get(i).getId()%></td>
	<td><%= naudotojai.gautiNaudotojuSarasa().get(i).getLoginName()%></td>
	<td><%= naudotojai.gautiNaudotojuSarasa().get(i).getName()%></td>
	<td><%= naudotojai.gautiNaudotojuSarasa().get(i).getSurname()%></td>
	<td><%= naudotojai.gautiNaudotojuSarasa().get(i).getEmail()%></td>
	<td><%= naudotojai.gautiNaudotojuSarasa().get(i).getSkyriausPavadinimas()%></td>
	<td><%= naudotojai.gautiNaudotojuSarasa().get(i).getPareigos()%></td>
	<td><%= naudotojai.gautiNaudotojuSarasa().get(i).getVaidmuo()%></td>
	</tr>
	<%
}


            %>
            <tbody>
            <tr class="item">

            </tr>
            </tbody>
            
            
            
            
            
        </table>
        
        
        
</body>
</html>