<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marczan
  Date: 02.12.18
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona główna</title>
</head>
<body>
    Witaj ${logged.name} ${logged.lastName}, zalogowałeś się jako użytkownik. <a href="/logout">Wyloguj się</a><br />
    <br />
    <br />
    <a href="/user/profile">Zobacz swój profil użytkownika</a><br />
</body>
</html>