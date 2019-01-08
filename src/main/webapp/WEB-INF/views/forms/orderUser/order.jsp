<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marczan
  Date: 12.12.18
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie zlecenia</title>
</head>
<body>
    <h1>Dodawanie zlecenia</h1>
    <a href="/user/logon">Wróć do strony głownej</a>
    <form:form method="post" modelAttribute="order">
        Tytuł zlecenia: <form:input path="title" /><form:errors path="title" /><br />
        Treść zlecenia: <from:textarea path="orderText" rows="3" cols="120" /><form:errors path="orderText" /><br />
        Proponowana cena za wykonanie zlecenia: <form:input path="price" /> zł<form:errors path="price" /><br />
        Potrzebne umiejętności do wykonania zlecenia: <form:select path="skills" items="${skills}" itemValue="id" itemLabel="name"/><br />
        <form:hidden path="id" />
        <input type="submit" value="Wystaw zlecenie">
    </form:form>
</body>
</html>
