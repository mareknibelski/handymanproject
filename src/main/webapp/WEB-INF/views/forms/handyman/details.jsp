<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marczan
  Date: 14.12.18
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Złota rączka informacje szczegółowe</title>
</head>
<body>
    <a href="/handyman/handymans">Wróć do listy złotych rączek</a>
    <h1>Złota rączka informacje szczegółowe</h1>
    Imię: ${handyman.firstName}<br />
    Nazwisko: ${handyman.lastName}<br />
    E-mail: ${handyman.email}<br />
    Umiejętności: <c:forEach items="${handyman.skills}" var="skill">
                        ${skill.name}<br />
                    </c:forEach>
    Rating: ${handyman.rating}<br />
    <br />
    <a href="/handyman/edit/${handyman.id}">Edytuj</a><br />
    <a href="/handyman/orders">Zobacz wszystkie dostępne zlecenia</a><br />

</body>
</html>
