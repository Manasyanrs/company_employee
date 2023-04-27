package arnara.am.companyEmployee.servlet.companyServlets;

import arnara.am.companyEmployee.manager.CompanyManager;
import arnara.am.companyEmployee.model.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/change_company_data")
public class ChangesCompaniesServlet extends HttpServlet {
    private final CompanyManager COMPANY_MANAGER = new CompanyManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> companies = COMPANY_MANAGER.getCompanies();
        req.setAttribute("companies", companies);
        req.getRequestDispatcher("WEB-INF/change_company.jsp").forward(req, resp);
    }
}
