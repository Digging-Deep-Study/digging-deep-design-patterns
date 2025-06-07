package ch05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;

public class ConnectionPool {

    private static final ConnectionPool instance = new ConnectionPool();
    private Queue<Connection> connectionPool;

    private static final int DEFAULT_SIZE = 10;
    private static final int DEFAULT_TIMEOUT = 1000;

    private ConnectionPool() {
        System.out.println("init connection pool");

        initializeConnectionPool();

        System.out.println("connection pool size : " + connectionPool.size());
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    private void initializeConnectionPool() {
        try {
            connectionPool = new ArrayDeque<>();

            for (int i=0; i<DEFAULT_SIZE; i++) {
                connectionPool.add(createConnection());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {

        }
    }

    private Connection createConnection() throws SQLException, ClassNotFoundException {
        return DriverManager.getConnection(ConnectionInfo.url.getValue(), ConnectionInfo.username.getValue(), ConnectionInfo.password.getValue());
    }

    public synchronized Connection getConnection() throws SQLException, InterruptedException {
        long startTime = System.currentTimeMillis();

        while (connectionPool.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " : waiting for return connection...");

            long elapsedTime = System.currentTimeMillis() - startTime;

            if (elapsedTime > DEFAULT_TIMEOUT) {
                System.out.println(Thread.currentThread().getName() + ": Timeout");
                throw new SQLException("Timeout waiting for connection");
            }

            wait();
        }

        Connection connection = connectionPool.poll();
        System.out.println(Thread.currentThread().getName() + " : 커넥션 획득");

        return connection;
    }

    public synchronized void returnConnection(Connection connection) {
        connectionPool.offer(connection);
        System.out.println(Thread.currentThread().getName() + " : 커넥션 반납");
        notify();
    }

}
