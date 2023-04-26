<%@ page import="arnara.am.companyEmployee.model.Employee" %>
<%@ page import="arnara.am.companyEmployee.model.Company" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: radik
  Date: 26.04.23
  Time: 04:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%Employee employee = (Employee) request.getAttribute("employee");
    List<Company> companies = (List<Company>) request.getAttribute("companies");
%>
<%%>

<body>
<h2>Form for register employee data</h2>
<div>
    <a href="/">Home page</a><br>
</div>
<br>
<div>
    <form method="post" action="/register_employee">
        <table>
            <tr>
                <td>Employee name: </td>
                <td>
                    <input type="text" name="name" placeholder="Employee name:" required value="<%=employee.getName()%>">
                </td>
            </tr>
            <tr>
                <td>Employee surname: </td>
                <td>
                    <input type="text" name="surname" placeholder="Employee surname:" required value="<%=employee.getSurname()%>">
                </td>
            </tr>
            <tr>
                <td>Employee email: </td>
                <td>
                    <input type="text" name="email" placeholder="Employee email:" required value="<%=employee.getEmail()%>">
                </td>
            </tr>
            <tr>
                <td>Employee phone number: </td>
                <td>
                    <input type="text" name="phone_number" placeholder="Employee phone_number" required value="<%=employee.getPhoneNumber()%>">
                </td>
            </tr>
            <tr>
                <td>Employee country: </td>
                <td>
                    <input type="text" name="country" placeholder="Employee country:" required value="<%=employee.getAddress().getCountry()%>">
                </td>
            </tr>
            <tr>
                <td>Employee city: </td>
                <td>
                    <input type="text" name="city" placeholder="Employee city:" required value="<%=employee.getAddress().getCity()%>">
                </td>
            </tr>
            <tr>
                <td>Employee street: </td>
                <td>
                    <input type="text" name="street" placeholder="Employee street:" required value="<%=employee.getAddress().getStreet()%>">
                </td>
            </tr>
            <tr>
                <td>Select company: </td>
                <td>
                    <select required name="company_id">
                        <% if (!companies.isEmpty()) {%>
                        <% for (Company company : companies) {%>
                        <option value="<%=company.getId()%>"> <%=company.getCompanyName()%> </option>
                        <%}%>
                        <%}%>

                    </select>
                </td>
            </tr>

        </table>
        <br>

        <button type="submit">Update</button>
    </form>

</div>
</body>
</html>
