package com.questions.java.designpattern.structural.facade;

import java.sql.Connection;

/**
 * Created by jitendra on 27 Feb, 2018
 */

/*
One class has a method that performs a complex process calling several other classes.


Provide a unified interface to a set of interfaces in a subsystem.
Facade Pattern defines a higher-level interface that makes the subsystem easier to use.

Suppose we have an application with set of interfaces to use MySql/Oracle database and to
generate different types of reports, such as HTML report, PDF report etc.

So we will have different set of interfaces to work with different types of database.
Now a client application can use these interfaces to get the required database connection and generate reports.

But when the complexity increases or the interface behavior names are confusing,
client application will find it difficult to manage it.

So we can apply Facade design pattern here and provide a wrapper interface on top of the
existing interface to help client application.
 */
public class MySqlHelper {
    public static Connection getMySqlDBConnection(){
        //get MySql DB connection using connection parameters
        return null;
    }

    public void generateMySqlPDFReport(String tableName, Connection con){
        //get data from table and generate pdf report
    }

    public void generateMySqlHTMLReport(String tableName, Connection con){
        //get data from table and generate pdf report
    }
}
