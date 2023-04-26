<%@ page import="java.util.List" %>
<%@ page import="arnara.am.companyEmployee.model.Company" %><%--
  Created by IntelliJ IDEA.
  User: radik
  Date: 25.04.23
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel='stylesheet' type='text/css' href='../styles/tableStyle.css'/>
    <title>Change Company</title>
</head>
<%List<Company> companies = (List<Company>) request.getAttribute("companies");%>
<body>
<h2>Register Companies</h2>
<a href="/">Home page</a>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Country</th>
        <th>City</th>
        <th>Street</th>
        <th>Action</th>
    </tr>
    <%if (companies != null && !companies.isEmpty()) {%>
    <%for (Company company : companies) {%>
        <tr>
            <td><%=company.getId()%></td>
            <td><%=company.getCompanyName()%></td>
            <td><%=company.getAddress().getCountry()%></td>
            <td><%=company.getAddress().getCity()%></td>
            <td><%=company.getAddress().getStreet()%></td>
            <input type="hidden" name="address_id" value="<%=company.getAddress().getId()%>"> <br>
            <td><a href="/delete_company?id=<%=company.getId()%>">Delete</a>
                / <a href="/update_company?id=<%=company.getId()%>">Update</a> </td>
        </tr>
    <%}%>
    <%}%>
</table>
</body>
</html>
