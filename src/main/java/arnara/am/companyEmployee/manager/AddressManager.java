package arnara.am.companyEmployee.manager;

import arnara.am.companyEmployee.db.DBConnectionProvider;
import arnara.am.companyEmployee.model.Address;

import java.sql.*;

public class AddressManager {

    private final Connection CONNECTION = DBConnectionProvider.getINSTANCE().getConnection();


    public void addAddressToDB(Address address) {
        String sql = "insert into address(country, city, street) VALUES (?, ?, ?);";
        try (PreparedStatement ps = CONNECTION.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, address.getCountry());
            ps.setString(2, address.getCity());
            ps.setString(3, address.getStreet());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();

            if (generatedKeys.next()) {
                address.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public Address getAddressById(int id) {
        Address address = null;
        String sql = "select * from address where id=?";
        try (PreparedStatement ps = CONNECTION.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                String country = resultSet.getString("country");
                String city = resultSet.getString("city");
                String street = resultSet.getString("street");
                address = new Address(id, country, city, street);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    public void updateAddress(int id, String country, String city, String street) {
        String sql = "update address set country=?, city=?, street=? where id=? ";

        try (PreparedStatement ps = CONNECTION.prepareStatement(sql)) {
            ps.setString(1, country);
            ps.setString(2, city);
            ps.setString(3, street);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteAddressById(int id) {
        String sql = "delete from address where id=?";
        try (PreparedStatement ps = CONNECTION.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
