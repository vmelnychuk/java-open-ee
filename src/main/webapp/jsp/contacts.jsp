<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contacts</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Contacts</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="contact" items="${contacts}">
        <tr>
            <td>
                <a href="/contact?id=${contact.id}">${contact.name}</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
