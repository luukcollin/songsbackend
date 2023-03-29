package org.example;
import java.sql.*;

public class DBConnection {
    private static Statement connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/music", "root", "root");
            return con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e.getException().getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return connection().getConnection();
    }
}



