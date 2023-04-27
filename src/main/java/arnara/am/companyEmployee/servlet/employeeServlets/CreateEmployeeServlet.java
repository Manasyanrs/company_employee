package arnara.am.companyEmployee.servlet.employeeServlets;

import arnara.am.companyEmployee.manager.AddressManager;
import arnara.am.companyEmployee.manager.CompanyManager;
import arnara.am.companyEmployee.manager.EmployeeManager;
import arnara.am.companyEmployee.model.Address;
import arnara.am.companyEmployee.model.Company;
import arnara.am.companyEmployee.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/register_employee")
public class CreateEmployeeServlet extends HttpServlet {
    private final CompanyManager COMPANY_MANAGER = new CompanyManager();
    private final EmployeeManager EMPLOYEE_MANAGER = new EmployeeManager();
    private final AddressManager ADDRESS_MANAGER = new AddressManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> companyNames = COMPANY_MANAGER.getCompanies();

        req.setAttribute("companyNames", companyNames);
        req.getRequestDispatcher("WEB-INF/register_employee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String phone_number = req.getParameter("phone_number");

        String country = req.getParameter("country");
        String city = req.getParameter("city");
        String street = req.getParameter("street");

        int companyId = Integer.parseInt(req.getParameter("company_id"));

        Address address = new Address(country, city, street);
        ADDRESS_MANAGER.addAddressToDB(address);
        Company company = COMPANY_MANAGER.getCompanyById(companyId);

        Employee employee = new Employee(name, surname, email, phone_number, address, company);
        EMPLOYEE_MANAGER.addEmployee(employee);

        resp.sendRedirect("/");
    }
}
