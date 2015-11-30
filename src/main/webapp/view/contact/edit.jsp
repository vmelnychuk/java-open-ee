<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit contact</title>
</head>
<body>
<h1>Edit contact</h1>
<form action="contact" method="post">
    <input type="hidden" name="edit">
    <input type="hidden" name="id" value="${contact.id}">
    <ul>
        <li>name: <input type="text" name="name" value="${contact.name}"></li>
        <li>street: <input type="text" name="street" value="${contact.address.street}"></li>
        <li>city: <input type="text" name="city" value="${contact.address.city}"></li>
    </ul>
    <button type="submit">Edit</button>
</form>
<a href="contacts">Back to contacts list</a>
</body>
</html>
