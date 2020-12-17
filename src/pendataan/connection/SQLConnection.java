/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataan.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aldy
 */
public class SQLConnection {
    private static Connection conn = null ;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = (DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                    + "databaseName=pendataan;"
                    + "user=Aldy;"
                    + "password=12345678;"));
            System.out.println("Connected to database !");
                    
        }
        catch(SQLException sqle) {
            System.out.println("Sql Exception :"+sqle.getMessage());    
        }
        catch(ClassNotFoundException e) {
            System.out.println("Class NotFound Exception :"+ e.getMessage());    
        }
        return conn ;
    }
    
    
}