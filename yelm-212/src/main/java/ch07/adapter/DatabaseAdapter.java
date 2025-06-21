package ch07.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseAdapter {
    void connect(String url, String username, String password);
    ResultSet executeQuery(String query) throws SQLException;
    void disconnect();
}
