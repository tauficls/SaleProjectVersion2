/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

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
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/saleProject_user","root","malvin");  
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
            
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){ 
            System.out.println(e);
        }
    }
    
    public int getIdUser() {
        return idUser;
    }
}
