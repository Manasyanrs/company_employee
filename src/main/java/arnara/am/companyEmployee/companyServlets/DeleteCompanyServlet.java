package arnara.am.companyEmployee.companyServlets;

import arnara.am.companyEmployee.manager.AddressManager;
import arnara.am.companyEmployee.manager.CompanyManager;
import arnara.am.companyEmployee.manager.EmployeeManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete_company")
public class DeleteCompanyServlet extends HttpServlet {
    private final CompanyManager COMPANY_MANAGER = new CompanyManager();
    private final AddressManager ADDRESS_MANAGER = new AddressManager();
    private final EmployeeManager EMPLOYEE_MANAGER = new EmployeeManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int companyId = Integer.parseInt(req.getParameter("id"));
        int addressId = COMPANY_MANAGER.getCompanyById(companyId).getAddress().getId();

        EMPLOYEE_MANAGER.deleteEmployeeCompanyName(companyId);
        COMPANY_MANAGER.deleteCompanyById(companyId);
        ADDRESS_MANAGER.deleteAddressById(addressId);
        resp.sendRedirect("/change_company_data");

    }
}
