<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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


<table id="customers" onload="selectedRowToInput();">
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
  <%


Class.forName("com.mysql.jdbc.Driver");
  MySqlConnect mySqlConnect = new MySqlConnect();
  Connection connection = mySqlConnect.getConnection();

String sql = "SELECT id, login_name, user_name, user_surname, email, skyrius, pareigos, vaidmuo FROM users";

try {
    PreparedStatement pst = connection.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
    while (rs.next()) {
            %>
            <tbody>
            <tr class="item">
                       
	        	<td><%=rs.getString("id")%></td>
                <td><%=rs.getString("login_name")%></td>
                <td><%=rs.getString("user_name")%></td>
                <td><%=rs.getString("user_surname")%></td>
                <td><%=rs.getString("email")%></td>
                <td><%=rs.getString("skyrius")%></td>
                <td><%=rs.getString("pareigos")%></td>
                <td><%=rs.getString("vaidmuo")%></td>
            </tr>
            </tbody>
            <%
                    }
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
            
            
            
            
        </table>
        
        
        
</body>
</html>