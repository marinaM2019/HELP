<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "lt.help.desk.bd.login.LoginData" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>HELP</title>
<link rel="stylesheet" href="Style.css"/>
</head>
<body>

<form class="loginForm" action="LoginAction" method="post">

<fieldset><div id="login">Gedimų registravimas<br><br></div>
<div id="loginPrisijungimas">
Prisijungimas<br>

<h2>
<input type="text" name="loginName" placeholder="Prisijungimo vardas" required><br>
<input type="password" name="loginPassword" placeholder="Slaptažodis" required><br>
<input type="submit" name="login" value="PRISIJUNGTI" class="button button2">
</div>
</h2>
</fieldset>


</form>
</body>
</html>