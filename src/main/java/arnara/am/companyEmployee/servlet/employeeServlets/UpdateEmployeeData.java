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

@WebServlet("/update_employee")
public class UpdateEmployeeData extends HttpServlet {
    private final CompanyManager COMPANY_MANAGER = new CompanyManager();
    private final AddressManager ADDRESS_MANAGER = new AddressManager();
    private final EmployeeManager EMPLOYEE_MANAGER = new EmployeeManager();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int employeeId = Integer.parseInt(req.getParameter("id"));
        Employee employee = EMPLOYEE_MANAGER.getEmployeeById(employeeId);
        List<Company> companies = COMPANY_MANAGER.getCompanies();

        req.setAttribute("employee", employee);
        req.setAttribute("companies", companies);

        req.getRequestDispatcher("WEB-INF/update_employee_data.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String phone_number = req.getParameter("phone_number");

        String country = req.getParameter("country");
        String city = req.getParameter("city");
        String street = req.getParameter("street");

        int addressId = Integer.parseInt(req.getParameter("address_id"));
        ADDRESS_MANAGER.updateAddress(addressId, country, city, street);
        Address address = ADDRESS_MANAGER.getAddressById(addressId);

        int companyId = Integer.parseInt(req.getParameter("company_id"));
        Company company = COMPANY_MANAGER.getCompanyById(companyId);

        Employee employee = new Employee(id, name, surname, email, phone_number, address, company);
        EMPLOYEE_MANAGER.updateEmployeeData(employee);

        resp.sendRedirect("/change_employee_data");
    }
}
