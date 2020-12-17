/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataan;

import java.sql.Connection;
import pendataan.connection.SQLConnection;

/**
 *
 * @author Aldy
 */
public class Pendataan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection sql = SQLConnection.getConnection();
    }
    
}
