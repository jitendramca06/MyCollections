package com.questions.java.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jitendra Kumar : 28/2/19
 */
public class ConnectionPool {
    private String driver;
    private String userName;
    private String password;
    private String url;
    private int maxConnection;
    private int connectionWaitTime;
    private BlockingQueue<Connection> connectionPool;
    private final Object lock = new Object();
    private AtomicInteger connectionCount;

    ConnectionPool(int initialConnection, int maxConnection, String driver, String userName, String password, String url, int connectionWaitTime)   {
        this.connectionPool = new ArrayBlockingQueue<>(maxConnection);
        this.driver = driver;
        this.userName = userName;
        this.password = password;
        this.url = url;
        this.maxConnection = maxConnection;
        this.connectionWaitTime = connectionWaitTime;
        this.connectionCount = new AtomicInteger(initialConnection);
        initialize(initialConnection);
    }

    private void initialize(int initialConnection) {
        for (int i = 0 ; i < initialConnection ;i++) {
            try {
                connectionPool.offer(newConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Connection newConnection() throws SQLException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, userName, password);
    }

    public Connection getConnection() throws Exception {
        Connection connection = null;
        try {
            /**
             * connectionWaitTime- connection timeout
             */
            connection = connectionPool.poll(connectionWaitTime, TimeUnit.SECONDS);
            if (connection == null) {
                synchronized (lock) {
                    /**
                     * If connection pool has not reached at maximum limit then create a new connection if connection is not available in pool
                     */
                    if (connectionCount.get() < maxConnection) {
                        System.out.println("No any connection is available in pool, requesting for new connection");
                        connection = newConnection();
                        connectionPool.offer(connection);
                        connectionCount.getAndIncrement();
                        System.out.println("Created new connection and same connection is added into pool.");
                    }
                }
                if (connection == null) {
                    throw new Exception("Connection is not available");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + " got the connection");
        return connection;
    }

    public void free(Connection connection) {
        connectionPool.offer(connection);
    }

    public int totalAvailableConnections() {
        return connectionPool.size();
    }
}
