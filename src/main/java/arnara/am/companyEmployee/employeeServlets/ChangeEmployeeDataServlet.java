package arnara.am.companyEmployee.employeeServlets;

import arnara.am.companyEmployee.manager.EmployeeManager;
import arnara.am.companyEmployee.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/change_employee_data")
public class ChangeEmployeeDataServlet extends HttpServlet {
    private final EmployeeManager EMPLOYEE_MANAGER = new EmployeeManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = EMPLOYEE_MANAGER.getEmployees();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("WEB-INF/change_employees_data.jsp").forward(req, resp);
    }
}
