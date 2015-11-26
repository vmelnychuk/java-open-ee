<%--
  Created by IntelliJ IDEA.
  User: vmmelnychuk
  Date: 11/26/15
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact details</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>attribute</th>
        <th>value</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>name</td>
        <td>${contact.name}</td>
    </tr>
    <tr>
        <td>street</td>
        <td>${address.street}</td>
    </tr>
    <tr>
        <td>city</td>
        <td>${address.city}</td>
    </tr>
    </tbody>
</table>
</body>
</html>
