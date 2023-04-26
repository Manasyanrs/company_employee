package arnara.am.companyEmployee.manager;

import arnara.am.companyEmployee.db.DBConnectionProvider;
import arnara.am.companyEmployee.model.Address;
import arnara.am.companyEmployee.model.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyManager {
    private final AddressManager ADDRESS_MANAGER = new AddressManager();
    private final Connection CONNECTION = DBConnectionProvider.getINSTANCE().getConnection();

    public void saveCompanyToDB(Company company, int address_id) {

        String sql = "insert into company(name, address_id) VALUES (?,?);";
        try (PreparedStatement ps = CONNECTION.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, company.getCompanyName());
            ps.setInt(2, address_id);

            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                company.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Company> getCompanies() {
        String sql = "select * from company";
        List<Company> companies = new ArrayList<>();

        try (PreparedStatement ps = CONNECTION.prepareStatement(sql)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int addressId = resultSet.getInt("address_id");

                Address addressById = ADDRESS_MANAGER.getAddressById(addressId);
                Company company = new Company(id, name, addressById);
                companies.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

    public void deleteCompanyById(int id) {
        String sql = "delete from company where id=?";
        try (PreparedStatement ps = CONNECTION.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Company getCompanyById(int id) {
        Company company = null;
        String sql = "select * from company where id=?";
        try (PreparedStatement ps = CONNECTION.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int addressId = resultSet.getInt("address_id");
                Address companyAddress = ADDRESS_MANAGER.getAddressById(addressId);
                company = new Company(id, name, companyAddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    public void updateCompanyName(int id, String companyName) {
        String sql = "UPDATE company SET `name`=? WHERE id=?";
        try (PreparedStatement ps = CONNECTION.prepareStatement(sql)) {
            ps.setString(1, companyName);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
