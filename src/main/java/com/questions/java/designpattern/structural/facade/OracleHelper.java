package com.questions.java.designpattern.structural.facade;

import java.sql.Connection;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public class OracleHelper {
    public static Connection getOracleDBConnection(){
        //get Oracle DB connection using connection parameters
        return null;
    }

    public void generateOraclePDFReport(String tableName, Connection con){
        //get data from table and generate pdf report
    }

    public void generateOracleHTMLReport(String tableName, Connection con){
        //get data from table and generate pdf report
    }
}
