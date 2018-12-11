<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marczan
  Date: 11.12.18
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja użytkownika</title>
</head>
<body>
    <h1>Edycja użytkownika</h1>
    <form:form method="post" modelAttribute="logged">
        Imię: <br><form:input path="name"/><form:errors path="name" /> <br />
        Nazwisko: <br><form:input path="lastName"/><form:errors path="lastName" /> <br />
        Email: <br><form:input path="email"/><form:errors path="email" /> <br />
        Hasło: <br><form:password path="password"/><form:errors path="password" /> <br />
        <form:hidden path="id" />
        <input type="submit" value="Zapisz"/>
    </form:form>
</body>
</html>
