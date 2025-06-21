package ch07.adapter;

import java.sql.*;

public class MySQLAdapter implements DatabaseAdapter {
    private Connection connection;

    @Override
    public void connect(String url, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
            this.connection.setAutoCommit(true);
            this.connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet executeQuery(String query) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("DB is not connected. Call connect() first.");
        }
        return connection.prepareStatement(query).executeQuery();
    }

    @Override
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
