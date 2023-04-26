package arnara.am.companyEmployee.companyServlets;

import arnara.am.companyEmployee.manager.AddressManager;
import arnara.am.companyEmployee.manager.CompanyManager;
import arnara.am.companyEmployee.model.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update_company")
public class UpdateCompanyServlet extends HttpServlet {
    private final CompanyManager COMPANY_MANAGER = new CompanyManager();
    private final AddressManager ADDRESS_MANAGER = new AddressManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int companyId = Integer.parseInt(req.getParameter("id"));
        Company company = COMPANY_MANAGER.getCompanyById(companyId);
        req.setAttribute("company", company);
        req.getRequestDispatcher("WEB-INF/update_company.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        int addressId = Integer.parseInt(req.getParameter("address_id"));
        COMPANY_MANAGER.updateCompanyName(id, name);
        ADDRESS_MANAGER.updateAddress(addressId, country, city, street);
        resp.sendRedirect("/change_company_data");
    }
}
