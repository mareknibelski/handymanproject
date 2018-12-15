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
    Witaj ${logged.name} ${logged.lastName}, zalogowałeś się jako administrator.
    <a href="/user/logon">Przełącz na profil użytkownika</a> <a href="/logout">Wyloguj</a><br />
    <br />
    <h4>Dodaj konto administratora</h4>
    <form action="/admin/registration" method="post">
        <button>Dodaj konto admina</button>
    </form>
    <h4>Wykaz umiejętności złotych rączek</h4> <a href="/admin/skill/add">Dodaj umiejętność</a>
    <table>
        <tr>
            <th>Nazwa umiejętności</th>
            <th>Opcje</th>
        </tr>
        <c:forEach items="${skills}" var="skill">
            <tr>
                <td>${skill.name}</td>
                <td>
                    <a href="/admin/skill/edit/${skill.id}">Edytuj</a>
                    <a href="/admin/skill/delete/${skill.id}">Usuń</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
