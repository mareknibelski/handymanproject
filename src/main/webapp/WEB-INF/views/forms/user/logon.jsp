<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marczan
  Date: 02.12.18
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona główna</title>
</head>
<body>
    Witaj ${logged.name} ${logged.lastName}, zalogowałeś się jako użytkownik.
    <a href="/admin">Przełącz na profil admina</a> <a href="/logout">Wyloguj się</a><br />
    <br />
    <br />
    <a href="/user/profile">Zobacz swój profil użytkownika</a><br />
    <a href="/user/order/add">Dodaj zlacenie</a><br />
    <h4>Zlecenia użytkownika</h4>
    <table>
        <tr>
            <th>Tytuł zlecenia</th>
            <th>Data dodania zlecenia</th>
            <th>Opcje</th>
        </tr>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.title}</td>
                <td>${order.time}</td>
                <td>
                    <a href="/user/order/${order.id}/details">Szczegóły</a>
                    <a href="/user/order/edit/${order.id}">Edytuj zlecenie</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
