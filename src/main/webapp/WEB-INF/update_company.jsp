<%@ page import="arnara.am.companyEmployee.model.Company" %><%--
  Created by IntelliJ IDEA.
  User: radik
  Date: 25.04.23
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update company data</title>
</head>
<%Company company = (Company) request.getAttribute("company");%>
<body>
<h2>Form for update company data</h2>
<form action="/update_company" method="post">
    <input type="hidden" name="id" value="<%=company.getId()%>">
    <input type="text" name="name" value="<%=company.getCompanyName()%>" required><br>
    <input type="text" name="country" value="<%=company.getAddress().getCountry()%>" required> <br>
    <input type="text" name="city" value="<%=company.getAddress().getCity()%>" required> <br>
    <input type="text" name="street" value="<%=company.getAddress().getStreet()%>" required> <br>
    <input type="hidden" name="address_id" value="<%=company.getAddress().getId()%>"> <br>
    <button type="submit">Update</button>
</form>

</body>
</html>
