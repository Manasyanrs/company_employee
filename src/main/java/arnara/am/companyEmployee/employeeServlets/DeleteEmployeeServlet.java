package arnara.am.companyEmployee.employeeServlets;

import arnara.am.companyEmployee.manager.EmployeeManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete_employee")
public class DeleteEmployeeServlet extends HttpServlet {
    private final EmployeeManager EMPLOYEE_MANAGER = new EmployeeManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int employeeId = Integer.parseInt(req.getParameter("id"));
        EMPLOYEE_MANAGER.deleteEmployeeById(employeeId);
        resp.sendRedirect("/change_employee_data");

    }
}
