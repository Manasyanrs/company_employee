package arnara.am.companyEmployee.servlet.companyServlets;

import arnara.am.companyEmployee.manager.AddressManager;
import arnara.am.companyEmployee.manager.CompanyManager;
import arnara.am.companyEmployee.model.Address;
import arnara.am.companyEmployee.model.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/register_company")
public class CreateCompanyServlet extends HttpServlet {
    private final AddressManager ADDRESS_MANAGER = new AddressManager();
    private final CompanyManager COMPANY_MANAGER = new CompanyManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/register_company.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        Address address = new Address(country, city, street);
        ADDRESS_MANAGER.addAddressToDB(address);

        Company company = new Company(name, address);
        COMPANY_MANAGER.saveCompanyToDB(company, address.getId());
        resp.sendRedirect("/");
    }
}
