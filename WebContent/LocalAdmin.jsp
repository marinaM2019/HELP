<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "lt.help.desk.bd.service.Gedimai" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%
String username=String.valueOf(session.getAttribute("loginName"));

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Progma", "no-cache");
response.setHeader("Expires", "0");
if(session.getAttribute("loginName")==null){
	response.sendRedirect("Login.jsp");

}
%>

<%@include file="Header.jsp" %>	

<title>Gedimų registravimas</title>
</head>
<body>

LocalAdmin



<table id="lentele">
<colgroup>
	<col style="width:20%">
    <col style="width:30%">
    <col style="width:40%">
     <col style="width:5%">
     <col style="width:5%">
      
  </colgroup> 
  <thead>
  <tr >
  	<th>Data</th>
    <th>Tema</th>
    <th>Aprašymas</th>
    <th>Pateikė</th>
    <th>Statusas</th>
  </tr>
              <tbody>
            <tr class="item">
  <%
Gedimai gedimai = new Gedimai();
  
for (int i=0; i<gedimai.gautiNepaskirtus().size(); i++){
	%>
	<tr>

	<td><%= gedimai.gautiNepaskirtus().get(i).getData()%></td>
	<td><%= gedimai.gautiNepaskirtus().get(i).getTema()%></td>
	<td><%= gedimai.gautiNepaskirtus().get(i).getAprasymas()%></td>
	<td><%= gedimai.gautiNepaskirtus().get(i).getGedimaPateike()%></td>
	<td><%= gedimai.gautiNepaskirtus().get(i).getStatusas()%></td>
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