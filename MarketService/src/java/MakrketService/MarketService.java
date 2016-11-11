/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MakrketService;

import ConnectDB.ConnectDB;
import Product.Product;
import Product.sales;
import Product.yourproduct;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author taufic
 */
@WebService(serviceName = "HelloWebService")
@Stateless()
public class MarketService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public ArrayList<Product> viewproduct(
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password) {

        String query = "select * from katalog NATURAL JOIN user ORDER BY date_add DESC";
        
        ArrayList<Product> view = new ArrayList<Product>();
        
        ConnectDB connectdb = new ConnectDB();
        String hasil = "";
        try (Connection con = connectdb.getConnection()) {
            Statement stmt = null;
            try {
                stmt = con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(MarketService.class.getName()).log(Level.SEVERE, null, ex);
            }
            ResultSet rs = stmt.executeQuery(query);
            String usernama;
            String img_path;
            String nama_barang;
            double harga_barang;
            String deskripsi;
            int jumlah_like;
            int jumlah_beli;
            while(rs.next()) {
                usernama = rs.getString("namaLengkap");
                img_path = rs.getString("image");
                nama_barang = rs.getString("nama_barang");
                harga_barang = rs.getDouble("harga_barang");
                deskripsi = rs.getString("deskripsi");
                jumlah_like = rs.getInt("jumlah_like");
                jumlah_beli = rs.getInt("jumlah_beli");
                
                Product product = new Product(usernama, img_path, nama_barang,
                harga_barang, deskripsi, jumlah_like, jumlah_beli);
                view.add(product);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MarketService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return view;
    

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "yourproduct")
    public ArrayList<yourproduct> yourproduct(
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password) {
        
        String query = "select * from katalog WHERE idUser = " + username;
        
        ArrayList<yourproduct> view = new ArrayList<yourproduct>();
        
        ConnectDB connectdb = new ConnectDB();
        String hasil = "";
        try (Connection con = connectdb.getConnection()) {
            Statement stmt = null;
            try {
                stmt = con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(MarketService.class.getName()).log(Level.SEVERE, null, ex);
            }
            ResultSet rs = stmt.executeQuery(query);
            int idKatalog;
            String nama_barang;
            double harga_barang;
            String deskripsi;
            int jumlah_like;
            int jumlah_beli;
            Date date;
            Time time;
            while(rs.next()) {
                idKatalog = rs.getInt("id");
                nama_barang = rs.getString("nama_barang");
                harga_barang = rs.getDouble("harga_barang");
                deskripsi = rs.getString("deskripsi");
                jumlah_like = rs.getInt("jumlah_like");
                jumlah_beli = rs.getInt("jumlah_beli");
                date = rs.getDate("date");
                time = rs.getTime("time");
                
                yourproduct product = new yourproduct(idKatalog, nama_barang,
                harga_barang, deskripsi, jumlah_like, jumlah_beli, date, time);
                view.add(product);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MarketService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return view;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "sales")
    public ArrayList<sales> sales(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        String query = "select * from katalog WHERE idUser = " + username;
        
        ArrayList<sales> view = new ArrayList<sales>();
        
        ConnectDB connectdb = new ConnectDB();
        String hasil = "";
        try (Connection con = connectdb.getConnection()) {
            Statement stmt = null;
            try {
                stmt = con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(MarketService.class.getName()).log(Level.SEVERE, null, ex);
            }
            ResultSet rs = stmt.executeQuery(query);
            Date date;
            Time time;
            String imagepath;
            String namabarang;
            String hargabarang;
            Double totalharga;
            int jumlahbeli;
            String namapenerima;
            String alamatpenerima;
            int kodepos;
            int notelp;
            int iduser;
            while(rs.next()) {
                imagepath = rs.getString("image");
                namabarang = rs.getString("image");
                hargabarang = rs.getString("image");
                totalharga = rs.getDouble("image");
                jumlahbeli = rs.getInt("image");
                namapenerima = rs.getString("image");
                alamatpenerima = rs.getString("image");
                kodepos = rs.getInt("image");
                notelp = rs.getInt("image");
                iduser = rs.getInt("image");
//                sales(Date date, Time time, String imagepath, String namabarang, String hargabarang, Double totalharga, int jumlahbeli, String namapenerima, String alamatpenerima, int kodepos, int notelp, int iduser)
//                sales sales = new sales(imagepath, namabarang, hargabarang,
//                totalharga, jumlahbeli, namapenerima, alamatpenerima, kodepos,
//                notelp, iduser);
                
//                view.add(sales);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MarketService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return view;
        
    }

    
    
}