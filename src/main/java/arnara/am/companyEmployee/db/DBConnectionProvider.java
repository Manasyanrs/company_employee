package arnara.am.companyEmployee.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {

    private static final DBConnectionProvider INSTANCE = new DBConnectionProvider();
    private Connection connection;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/company_employee_servlet?useUnicode=true&characterEncoding=UTF-8";
    private static final String USERNAME = "root";

    private static final String PASSWORD = "root";

    private DBConnectionProvider() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static DBConnectionProvider getINSTANCE() {
        return INSTANCE;
    }

}
