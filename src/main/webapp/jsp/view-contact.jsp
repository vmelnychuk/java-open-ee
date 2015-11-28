<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact details</title>
</head>
<body>
 <ul>
     <li>name: ${contact.name}</li>
     <li>street: ${address.street}</li>
     <li>city: ${address.city}</li>
 </ul>
 <a href="contact?edit=true&id=${contact.id}">Edit</a>
 <a href="contacts">Back to contacts list</a>
</body>
</html>
