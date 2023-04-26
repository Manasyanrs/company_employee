<%--
  Created by IntelliJ IDEA.
  User: radik
  Date: 25.04.23
  Time: 00:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Company</title>
</head>
<body>
    <form method="post" action="/register_company">
        <input type="text" name="name" placeholder="Input company name:" required>
        <input type="text" name="country" placeholder="Input company country:" required>
        <input type="text" name="city" placeholder="Input company city:" required>
        <input type="text" name="street" placeholder="Input company street:" required>
        <button type="submit">Create</button>
    </form>
</body>
</html>
