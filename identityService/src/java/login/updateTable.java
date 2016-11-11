/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import ConnectDB.ConnectDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Asus
 */
public class updateTable {
    public void updateToken (int idUser, String token) {
        // create a java calendar instance
        Calendar calendar = Calendar.getInstance();

        long t = calendar.getTimeInMillis();
        Date expire_date = new Date (t + 20000);
        DateFormat expdate_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

        String query = "update user set token = \"" + token + "\", expire_date = \"" + expdate_format.format(expire_date) + "\" where idUser = \"" + idUser + "\"";
        try{  
            ConnectDB connectdb = new ConnectDB();
            Connection con = connectdb.getConnection();
            Statement stmt=con.createStatement();  
            stmt.executeUpdate(query);  
      
            con.close();  
        }
        catch(SQLException e){ 
            System.out.println(e);
        }
    }
}
