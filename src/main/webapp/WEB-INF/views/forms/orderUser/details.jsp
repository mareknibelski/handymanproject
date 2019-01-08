<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marczan
  Date: 13.12.18
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Szczegóły zlecenia</title>
</head>
<body>
    <h1>Szczegóły zlecenia</h1><br />
    Tytuł zlecenia: ${order.get().title}<br />
    Treść zlecenia: ${order.get().orderText}<br />
    Data wystawienie zlecenia: ${order.get().time}<br />
    Proponowana cena za wykonanie zlecenia: ${order.get().price} zł<br />
    Potrzebne umiejętności do wykonania zlecenia: <c:forEach items="${order.get().skills}" var="skill">
                                                        ${skill.name}<br />
                                                    </c:forEach>
    <br />
    <br />
    <a href="/user/order/edit/${order.get().id}">Edytuj zlecenie</a> <a href="/user/logon">Wróć do strony głównej</a>
</body>
</html>
