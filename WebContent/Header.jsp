<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HELP</title>
<link rel="stylesheet" href="Style.css"/>
</head>
<body>






<div id=header>

Prisijungė:
<a class="headerTop"><%= session.getAttribute("name") %></a>
<a class="headerTop"><%= session.getAttribute("surname") %></a><br>
<a class="headerTop"><%= session.getAttribute("skyrius") %></a>
<a class="headerTop"><%= session.getAttribute("pareigos") %></a><br>





<form action="Logout">
<input type="submit" class="atsijungti" value="atsijungti">
<a class="atsijungti"></a>
</form>
</div>







</body>
</html>