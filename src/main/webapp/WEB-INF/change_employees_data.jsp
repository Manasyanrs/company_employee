<%@ page import="java.util.List" %>
<%@ page import="arnara.am.companyEmployee.model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: radik
  Date: 26.04.23
  Time: 01:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel='stylesheet' type='text/css' href='../styles/tableStyle.css'/>
    <title>Employees page</title>

</head>
<%List<Employee> employees = (List<Employee>) request.getAttribute("employees");%>
<body>
    <h2>Registered Employees</h2>
    <a href="/">Home Page</a><br><br>
    <%if (employees != null && !employees.isEmpty()) {%>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Email</th>
                <th>Phone number</th>

                <th>Country</th>
                <th>City</th>
                <th>Street</th>

                <th>Company name</th>

                <th>Action</th>
            </tr>

            <%for (Employee employee : employees) {%>
            <tr>
                <td><%=employee.getId()%></td>
                <td><%=employee.getName()%></td>
                <td><%=employee.getSurname()%></td>
                <td><%=employee.getEmail()%></td>
                <td><%=employee.getPhoneNumber()%></td>

                <td><%=employee.getAddress().getCountry()%></td>
                <td><%=employee.getAddress().getCity()%></td>
                <td><%=employee.getAddress().getStreet()%></td>

                <% if (employee.getCompany() != null) {%>
                    <td><%=employee.getCompany().getCompanyName()%></td>
                    <input type="hidden" name="company_id" value="<%=employee.getCompany().getId()%>">

                <%} else { %>
                    <td>Null</td>
                    <input type="hidden" name="company_id" value="null">

                <%}%>
                <input type="hidden" name="address_id" value="<%=employee.getAddress().getId()%>">
                <td><a href="/delete_employee?id=<%=employee.getId()%>">Delete</a>
                    / <a href="/update_employee?id=<%=employee.getId()%>">Update</a> </td>
            </tr>
            <%}%>
            <%} else {%>
                <h4>Data base is empty</h4>
                <a href="/register_employee"> Register employee</a>
            <%}%>
        </table>
</body>
</html>
