package ch07.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("=== PostgreSQL 테스트 ===");
        testPostgreSQL();
        
        System.out.println("\n=== MySQL 테스트 ===");
        testMySQL();
    }
    
    private static void testPostgreSQL() throws SQLException {
        DatabaseAdapter postgresAdapter = new PostgreSQLAdapter();
        postgresAdapter.connect("jdbc:postgresql://localhost:5555/postgres", "admin", "1234");

        ResultSet resultSet = postgresAdapter.executeQuery("SELECT * FROM users");
        while (resultSet.next()) {
            System.out.println("PostgreSQL - " + resultSet.getString("name"));
        }

        postgresAdapter.disconnect();
    }
    
    private static void testMySQL() throws SQLException {
        DatabaseAdapter mysqlAdapter = new MySQLAdapter();
        mysqlAdapter.connect("jdbc:mysql://localhost:3333/mydb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "1234");
        
        ResultSet resultSet = mysqlAdapter.executeQuery("SELECT * FROM users");
        while (resultSet.next()) {
            System.out.println("MySQL - " + resultSet.getString("name"));
        }

        mysqlAdapter.disconnect();
    }
}
