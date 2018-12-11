<%--
  Created by IntelliJ IDEA.
  User: marczan
  Date: 11.12.18
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profil użytkownika</title>
</head>
<body>
    <a href="/user/logon">Wróć do strony głównej</a>
    <h1>Profil uzytkownika</h1>
    Witaj ${logged.name} ${logged.lastName}<br />
    <h4>Twoje dane profilowe to:</h4><br />
    Imię: ${logged.name}<br />
    Nazwisko: ${logged.lastName}<br />
    E-mail: ${logged.email}<br/>
    <br />
    <br />
    <a href="/user/edit/${logged.id}">Edytuj profil</a>
</body>
</html>
