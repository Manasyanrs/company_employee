package arnara.am.companyEmployee.manager;

import arnara.am.companyEmployee.db.DBConnectionProvider;
import arnara.am.companyEmployee.model.Address;
import arnara.am.companyEmployee.model.Company;
import arnara.am.companyEmployee.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private final AddressManager ADDRESS_MANAGER = new AddressManager();
    private final CompanyManager COMPANY_MANAGER = new CompanyManager();
    private final Connection CONNECTION = DBConnectionProvider.getINSTANCE().getConnection();


    public void addEmployee(Employee employee) {
        String sql = "insert into employees(name, surname, email, phone_number, address_id, company_id)" +
                " VALUES (?,?,?,?,?,?);";
        try (PreparedStatement ps = CONNECTION.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getPhoneNumber());
            ps.setInt(5, employee.getAddress().getId());
            ps.setInt(6, employee.getCompany().getId());

            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                employee.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployeeData(Employee employee) {
        String sql = "update employees set name=?, surname=?, email=?, " +
                "phone_number=?, address_id=?, company_id=? where id=?";

        try (PreparedStatement ps = CONNECTION.prepareStatement(sql)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getPhoneNumber());
            ps.setInt(5, employee.getAddress().getId());
            ps.setInt(6, employee.getCompany().getId());
            ps.setInt(7, employee.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Employee getEmployeeById(int id) {
        Employee employee = null;
        String sql = "select * from employees where id=?";
        try (PreparedStatement ps = CONNECTION.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                employee = getEmployeeByResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public List<Employee> getEmployees() {
        String sql = "select * from employees";

        List<Employee> employees = new ArrayList<>();

        try (PreparedStatement ps = CONNECTION.prepareStatement(sql)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Employee employeeByResultSet = getEmployeeByResultSet(resultSet);
                employees.add(employeeByResultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public void deleteEmployeeCompanyName(int id) {
        String sql = "select * from employees where company_id=?";

        try (PreparedStatement ps = CONNECTION.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("id");
                String newSql = "update employees set company_id=null where id=" + employeeId;
                Statement statement = CONNECTION.createStatement();
                statement.executeUpdate(newSql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployeeById(int id) {
        String sql = "delete from employees where id=?";
        try (PreparedStatement ps = CONNECTION.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Employee getEmployeeByResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String email = resultSet.getString("email");
        String phone_number = resultSet.getString("phone_number");
        int addressId = resultSet.getInt("address_id");
        int company_id = resultSet.getInt("company_id");

        Address address = ADDRESS_MANAGER.getAddressById(addressId);
        Company company = COMPANY_MANAGER.getCompanyById(company_id);
        return new Employee(id, name, surname, email, phone_number, address, company);
    }

}
