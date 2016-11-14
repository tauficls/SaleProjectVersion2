/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author taufic
 */
public class ConnectDB1 {
    private Connection con;
    public ConnectDB1() {
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://"
                    + "localhost:3306/SaleProject_MP","root","13514022");
        }
        catch(Exception e){ 
            System.out.println(e);
        }
        
    }
    
    public Connection getConnection() {
        return con;
    }
}
