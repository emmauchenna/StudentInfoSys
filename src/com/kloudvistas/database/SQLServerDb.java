package com.kloudvistas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerDb {

    private static final String DB_DRIVER =
            "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_URL =
            "jdbc:sqlserver://localhost:1433;encrypt=false;databaseName=Studentinfosystem;integratedSecurity=false;";
    private static final String DB_USERNAME = "kloudvista";
    private static final String DB_PASSWORD = "kloudvista";

    public Connection getSqlDbConnection(){
        Connection connection = null;
        try{
            //Register the JDBC driver
            Class.forName(DB_DRIVER);
            //Open the connection
            connection = DriverManager.
                    getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        }catch (ClassNotFoundException ex){
        System.out.println("Error message: "+ex.getMessage());
    }catch (SQLException ex){
        System.out.println("Error message: "+ex.getMessage());
    }
        return connection;
    }

}
