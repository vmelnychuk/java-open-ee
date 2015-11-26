<%--
  Created by IntelliJ IDEA.
  User: vmmelnychuk
  Date: 11/26/15
  Time: 11:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add contact</title>
</head>
<body>
<h1>Add new contact</h1>
<form action="contact?add" method="post">
    <input type="hidden" name="add">
    <ul>
        <li>name: <input type="text" name="name"></li>
        <li>street: <input type="text" name="street"></li>
        <li>city: <input type="text" name="city"></li>
    </ul>
    <button type="submit">Add</button>
</form>
<a href="contacts">Back to contacts list</a>
</body>
</html>
