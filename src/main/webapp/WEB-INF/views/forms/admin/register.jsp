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
    <title>Zarejestruj się</title>
</head>
<body>
    <h1>Formularz rejestracji</h1>
    <form:form method="post" modelAttribute="user">
        Imię: <form:input path="name" /><form:errors path="name"/> <br />
        Nazwisko: <form:input path="lastName" /><form:errors path="lastName" /><br />
        Email: <form:input path="email" /><form:errors path="email" /><br />
        Hasło: <form:password path="password" /><form:errors path="password"/> <br />
        <input type="submit" value="Rejestruj">
    </form:form>
</body>
</html>
