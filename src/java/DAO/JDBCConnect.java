package DAO;

import java.sql.*;

public class JDBCConnect {

    public static Connection getJDBCConnection() throws SQLException {
        final String url = "jdbc:sqlserver://SAMURISEEE:1433;databaseName = Product";
        final String userName = "sa";
        final String password = "cabber123";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
//NAZIJESUS

