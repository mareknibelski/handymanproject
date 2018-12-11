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
    <title>Rejestracja</title>
</head>
<body>
    Użytkownik ${user.name} ${user.lastName} zarejestrował się w naszej bazie.<br>
    Przejdz do strony logowania
    <a href="/login">Zaloguj sie</a>
</body>
</html>
