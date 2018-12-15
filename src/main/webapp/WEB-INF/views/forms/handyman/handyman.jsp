<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marczan
  Date: 14.12.18
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj złotą rączkę</title>
</head>
<body>
    <h1>Dodaj złotą rączkę</h1>
    <form:form method="post" modelAttribute="handyman">
        Imię: <form:input path="firstName" /><form:errors path="firstName" /><br />
        Nazwisko: <form:input path="lastName" /><form:errors path="lastName" /><br />
        E-mail: <form:input path="email" /><form:errors path="email" /><br />
        Hasło: <form:password path="password" /><form:errors path="password" /><br />
        Umiejętności: <form:select path="skills" items="${skills}" itemValue="id" itemLabel="name"/><br />
        <form:hidden path="id" />
        <input type="submit" value="Dodaj złotą rączkę">
    </form:form>
</body>
</html>
