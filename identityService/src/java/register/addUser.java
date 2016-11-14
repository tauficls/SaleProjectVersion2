/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import ConnectDB.ConnectDB;
import ConnectDB.ConnectDB1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import login.updateTable;

/**
 *
 * @author Asus
 */
public class addUser {
    String full;
    String email;
    String pass;
    String address;
    int postal;
    int number;
    String user;
    int idUser;
    
    /**
     *
     * @param fullname
     * @param e
     */
    public addUser (String fullname, String e_mail, String password,
            String fulladd, int zipcode, int phone, String username) {
        full = fullname;
        email = e_mail;
        pass = password;
        address = fulladd;
        postal = zipcode;
        number = phone;
        user = username;
    }
    
    public void addNewUser () {
        try{  
            ConnectDB connectdb = new ConnectDB();
            Connection con = connectdb.getConnection();
            PreparedStatement statement = con.prepareStatement("INSERT INTO user (namaLengkap, email, password, alamat_user, kodepos_user, noTelp_user, username) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, full);
            statement.setString(2, email);
            statement.setString(3, pass);
            statement.setString(4, address);
            statement.setInt(5, postal);
            statement.setInt(6, number);
            statement.setString(7, user);
            statement.executeUpdate();
            
            PreparedStatement statement2 = con.prepareStatement("SELECT idUser from user where username = \"" + user + "\"");
            ResultSet rs = statement2.executeQuery();
            
            if (rs.next()) {
                idUser = rs.getInt("idUser");
            }
            
            ConnectDB1 connectdb1 = new ConnectDB1();
            Connection con1 = connectdb1.getConnection();
            PreparedStatement statement1 = con1.prepareStatement("INSERT INTO user (idUser, namaLengkap, username) VALUES (?, ?, ?)");
            statement1.setString(1, Integer.toString(idUser));
            statement1.setString(2, full);
            statement1.setString(3, email);
            statement1.executeUpdate();
            con.close();
        }
        catch(SQLException e){ 
            System.out.println(e);
        }
    }
    
    public int getIdUser() {
        return idUser;
    }
    
    public String getUsername() {
        return user;
    }
}
