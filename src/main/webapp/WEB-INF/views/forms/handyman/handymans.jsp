<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marczan
  Date: 14.12.18
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista złotych rączek</title>
</head>
<body>
    <h1>Lista złotych rączek</h1>
    <table>
        <tr>
            <th>Imię:</th>
            <th>Nazwisko:</th>
            <th>E-mail:</th>
            <th>Umiejętności:</th>
            <th>Rating:</th>
            <th>Opcje</th>
        </tr>
        <c:forEach items="${handymans}" var="handyman">
            <tr>
                <td>${handyman.firstName}</td>
                <td>${handyman.lastName}</td>
                <td>${handyman.email}</td>
                <td>
                    <c:forEach items="${handyman.skills}" var="skill">
                        ${skill.name}<br />
                    </c:forEach>
                </td>
                <td>${handyman.rating}</td>
                <td>
                    <a href="/handyman/${handyman.id}/details">Szczegóły</a>
                    <a href="/handyman/edit/${handyman.id}">Edytuj</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
