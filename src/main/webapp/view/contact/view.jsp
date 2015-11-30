<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact details</title>
</head>
<body>
 <ul>
     <li>name: ${contact.name}</li>
     <li>street: ${contact.address.street}</li>
     <li>city: ${contact.address.city}</li>
 </ul>
 <a href="contact?edit=true&id=${contact.id}">Edit</a>

 <form action="contact" method="post">
     <input type="hidden" name="delete">
     <input type="hidden" name="id" value="${contact.id}">
     <input type="submit" value="Delete">
 </form>
 <a href="contacts">Back to contacts list</a>
</body>
</html>
