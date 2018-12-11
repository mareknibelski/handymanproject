<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marczan
  Date: 02.12.18
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN</title>
</head>
<body>
    <h1>Zaloguj się</h1>
    <form action="/login" method="post">
        <input type="text" id="username" name="email" placeholder="email" /><br>
        <input type="password" id="password" name="password" placeholder="password" /></br>
        <input type="submit" value="Zaloguj się">
    </form>
</body>
</html>
