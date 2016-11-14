/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import ConnectDB.ConnectDB;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.sql.*;

/**
 *
 * @author Asus
 */
public class access {
    private String username;
    private String password;
    private String token;
    private int idUser;
    
    public access (String user, String pass) {
        username = user;
        password = pass;
    }
    
    public void setUsername (String user) {
        username = user;
    }
    
    public void setPassword (String pass) {
        password = pass;
    }
    
    public String getToken () {
        Random random = new SecureRandom();
        token = new BigInteger(130, random).toString(32);
        
        return token;
    }
    
    public Boolean isAuthenticate () {
        Boolean authenticate = false;
        String query = "select * from user where username = \"" + username + "\" or email = \"" + username + "\" and password = \"" + password + "\"";
        try{  
            ConnectDB connectdb = new ConnectDB();
            Connection con = connectdb.getConnection();
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery(query);  
            if(rs.next()) {
                authenticate = true;
                idUser = rs.getInt("idUser");
            }
            con.close();  
        }
        catch(Exception e){ 
            System.out.println(e);
        }
        
        return authenticate;
    }
    
    public Boolean isAuthenticateUser () {
        Boolean authenticate = false;
        String query = "select * from user where username = \"" + username + "\"";
        try{  
            ConnectDB connect = new ConnectDB();
            Connection con = connect.getConnection();
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery(query);  
            if(rs.next()) {
                authenticate = true;
                idUser = rs.getInt("idUser");
            }
            con.close();  
        }
        catch(Exception e){ 
            System.out.println(e);
        }
        
        return authenticate;
    }
    
    public int getIdUser() {
        return idUser;
    }
    
    public String getUsername() {
        return username;
    }
}

