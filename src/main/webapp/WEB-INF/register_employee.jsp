<%@ page import="java.util.List" %>
<%@ page import="arnara.am.companyEmployee.model.Company" %><%--
  Created by IntelliJ IDEA.
  User: radik
  Date: 25.04.23
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register employee</title>
</head>
<%List<Company> companyNames = (List<Company>) request.getAttribute("companyNames");%>
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
                        <input type="text" name="name" placeholder="Employee name:" required>
                    </td>
                </tr>
                <tr>
                    <td>Employee surname: </td>
                    <td>
                        <input type="text" name="surname" placeholder="Employee surname:" required>
                    </td>
                </tr>
                <tr>
                    <td>Employee email: </td>
                    <td>
                        <input type="text" name="email" placeholder="Employee email:" required>
                    </td>
                </tr>
                <tr>
                    <td>Employee phone number: </td>
                    <td>
                        <input type="text" name="phone_number" placeholder="Employee phone_number" required>
                    </td>
                </tr>
                <tr>
                    <td>Employee country: </td>
                    <td>
                        <input type="text" name="country" placeholder="Employee country:" required>
                    </td>
                </tr>
                <tr>
                    <td>Employee city: </td>
                    <td>
                        <input type="text" name="city" placeholder="Employee city:" required>
                    </td>
                </tr>
                <tr>
                    <td>Employee street: </td>
                    <td>
                        <input type="text" name="street" placeholder="Employee street:" required>
                    </td>
                </tr>
                <tr>
                    <td>Select company: </td>
                    <td>
                        <select required name="company_id">
                            <% if (companyNames != null && !companyNames.isEmpty()) {%>
                            <% for (Company companyName : companyNames) {%>
                            <option value="<%=companyName.getId()%>"> <%=companyName.getCompanyName()%> </option>
                            <%}%>
                            <%}%>

                        </select>
                    </td>
                </tr>

            </table>
            <br>

            <button type="submit">Create</button>
        </form>

    </div>
</body>
</html>
