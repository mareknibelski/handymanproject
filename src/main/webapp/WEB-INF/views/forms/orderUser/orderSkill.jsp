<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MaRcZaN
  Date: 08.01.2019
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista wszystkich zleceń wg umiejetnosci złotej rączki</title>
</head>
<body>
<h1>Lista wszystkich zleceń wg umiejetnosci złotej rączki</h1>
<table>
    <tr>
        <th>Tytuł zlecenia</th>
        <th>Data dodania zlecenia</th>
        <th>Cena</th>
        <th>Umiejętności</th>
        <th>Opcje</th>
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.title}</td>
            <td>${order.time}</td>
            <td>${order.price} zł</td>
            Potrzebne umiejętności do wykonania zlecenia: <c:forEach items="${order.skills}" var="skill">
                                                                 ${skill.name}<br />
                                                            </c:forEach>
            <td>
                <a href="/handyman/order/${order.id}/details">Szczegóły</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
