package ch05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Runnable task = () -> {

            try {
                Connection connection = ConnectionPool.getInstance().getConnection();

                PreparedStatement stmt = connection.prepareStatement("SELECT name from member where id = 1");
                ResultSet resultSet = stmt.executeQuery();

                resultSet.next();
                String name = resultSet.getString("name");
                System.out.println(Thread.currentThread().getName() + " : " + name);

                resultSet.close();
                stmt.close();

                ConnectionPool.getInstance().returnConnection(connection);

            } catch (SQLException e) {
                throw new RuntimeException("Failed to Connect");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        final int THREAD_SIZE = 30;

        IntStream.range(0, THREAD_SIZE).forEach(i -> new Thread(task).start());

    }
}
