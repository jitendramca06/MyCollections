package com.questions.db.jdbc;
import groovy.sql.Sql;
import org.apache.commons.dbcp2.BasicDataSource;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;
import java.sql.SQLException;

public class MySQLConnectionManager {
    private static MySQLConnectionManager instance = new MySQLConnectionManager();
    private static final String h2url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;MODE=MySQL";
    private DBI dbi = null;
    private DataSource dataSource = null;

    private MySQLConnectionManager() {}

    public static MySQLConnectionManager getInstance() {
        return instance;
    }

    public DBI getHandle()  {
        System.out.println("Getting the DB Handle");
        if (dbi == null) {
            dataSource = dataSurce();
            dbi = new DBI(dataSource);
            initDB();
        }
        System.out.println("Got the DB Handle");
        return  dbi;
    }

    private DataSource dataSurce()   {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(h2url);
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");
        return basicDataSource;
    }

    private void initDB() {
        ClassLoader classLoader = getClass().getClassLoader();
        String createSqlFilePath = classLoader.getResource("create.sql").getPath();
        String populateSqlFilePath = classLoader.getResource("populate.sql").getPath();
        System.out.println(createSqlFilePath);
        try {
            Sql.newInstance("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;MODE=MySQL;INIT=RUNSCRIPT FROM '" + createSqlFilePath + "'\\;RUNSCRIPT FROM '" + populateSqlFilePath + "'", "root", "root", "org.h2.Driver");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
