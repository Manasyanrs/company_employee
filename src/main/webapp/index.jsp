<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Company Employee</title>
</head>
<body>
<h1><%= "Welcome Company Employee page" %>
</h1>
<br/>
<ul>
    <h3>You can</h3>
    <li>Register new company <a href="/register_company">Register</a> </li><br>
    <li>Change company data <a href="/change_company_data">Change</a></li><br>

    <li>Register new employee <a href="/register_employee">Register</a></li><br>
    <li>Change employee data <a href="/change_employee_data">Change</a></li>

</ul>
</body>
</html>