<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add contact</title>
</head>
<body>
<h1>Add new contact</h1>
<form action="contact" method="post">
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
