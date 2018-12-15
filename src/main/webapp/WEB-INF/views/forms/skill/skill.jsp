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
    <title>Dodawanie umiejętności</title>
</head>
<body>
    <h1>Dodawanie umiejętności</h1>
    <form:form method="post" modelAttribute="skill">
        Nazwa umiejętności: <form:input path="name" /><form:errors path="name" /><br />
        <form:hidden path="id" />
        <input type="submit" value="Dodaj umiejętność">
    </form:form>
</body>
</html>
