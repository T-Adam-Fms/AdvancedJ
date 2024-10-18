package fr.Idnr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJdbc {

    public static void main(String[] args) throws Exception {
        
        try {
            Class.forName("org.mariadb.jdbc.Driver"); // Load the driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // Retrieve a connection using URL, login, and password
        String url = "jdbc:mariadb://localhost:3306/shop"; // Fixed the JDBC URL
        String login = "root";
        String password = "fms2024";
        
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            String strSql = "SELECT * FROM T_Articles"; // Correct SQL query
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(strSql)) {
                    while (resultSet.next()) {
                        // Print each row's data directly from ResultSet
                        int rsIdUser = resultSet.getInt(1);
                        String rsDescription = resultSet.getString(2);
                        String rsMarque = resultSet.getString(3);
                        double rsPrixUnitaire = resultSet.getDouble(4);

                        // Print to verify the connection and data retrieval
                        System.out.println("ID: " + rsIdUser + ", Description: " + rsDescription + ", Marque: " + rsMarque + ", Prix Unitaire: " + rsPrixUnitaire);
                    }
                }
            }
        }
    }
}
