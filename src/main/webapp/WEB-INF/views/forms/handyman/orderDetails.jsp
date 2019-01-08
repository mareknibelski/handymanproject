<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marczan
  Date: 14.12.18
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szczegółowe informacje o zleceniu</title>
</head>
<body>
    <h1>Szczegóły zlecenia</h1><br />
    Tytuł zlecenia: ${order.get().title}<br />
    Treść zlecenia: ${order.get().orderText}<br />
    Data wystawienie zlecenia: ${order.get().time}<br />
    Proponowana cena za wykonanie zlecenia: ${order.get().price} zł<br />
    <br />
    <br />
    <a href="/handyman/orders">Wróć do strony ze zleceniami</a>
</body>
</html>
