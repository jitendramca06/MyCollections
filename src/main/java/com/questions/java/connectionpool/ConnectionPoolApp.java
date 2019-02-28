package com.questions.java.connectionpool;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Jitendra Kumar : 28/2/19
 */
public class ConnectionPoolApp {
    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool(2, 4, "com.mysql.jdbc.Driver", "root", "password", "jdbc:mysql://localhost:3306/mysqljdbc", 3);
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0 ; i < 100 ; i++) {
            Runnable runnable = () -> {
                Connection connection = null;
                try {
                    connection = connectionPool.getConnection();
                    System.out.println("Total connections in pool-" + connectionPool.totalAvailableConnections());
                    Thread.sleep(100);
                    connectionPool.free(connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            service.execute(runnable);
        }

        service.shutdown();
    }
}
