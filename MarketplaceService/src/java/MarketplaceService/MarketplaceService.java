/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarketplaceService;

import ConnectDB.ConnectDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
@WebService(serviceName = "MarketplacceService")
@Stateless()
public class MarketplaceService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "viewproduct")
    public ArrayList<product> viewproduct(
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password,
            @WebParam(name = "search") String search,
            @WebParam(name = "filter") String filter) {
        String query;
        if(filter.equals("product"))
            query = "select * from katalog NATURAL JOIN user WHERE nama_barang like '%"+search+"%' ORDER BY date_add DESC";
        else if(filter.equals("store"))
            query = "select * from katalog NATURAL JOIN user WHERE namaLike like '%"+search+"%' ORDER BY date_add DESC";
        else
            query = "select * from katalog NATURAL JOIN user ORDER BY date_add DESC";
        
        ArrayList<product> view = new ArrayList<>();
        
        ConnectDB connectdb = new ConnectDB();
        String hasil = "";
        try (Connection con = connectdb.getConnection()) {
            Statement stmt = null;
            stmt = con.createStatement();
            
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
                
                product Product = new product(usernama, img_path, nama_barang,
                        harga_barang, deskripsi, jumlah_like, jumlah_beli);
                view.add(Product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarketplaceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return view;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "productmu")
    public ArrayList<yourproduct> yourProduct(
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password) {
        
        String query = "select * from katalog WHERE idUser = " + username;
        
        ArrayList<yourproduct> view = new ArrayList<>();
        
        ConnectDB connectdb = new ConnectDB();
        String hasil = "";
        try (Connection con = connectdb.getConnection()) {
            Statement stmt = null;
            try {
                stmt = con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(MarketplaceService.class.getName()).log(Level.SEVERE, null, ex);
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
                idKatalog = rs.getInt("idKatalog");
                nama_barang = rs.getString("nama_barang");
                harga_barang = rs.getDouble("harga_barang");
                deskripsi = rs.getString("deskripsi");
                jumlah_like = rs.getInt("jumlah_like");
                jumlah_beli = rs.getInt("jumlah_beli");
                date = rs.getDate("date_add");
                time = rs.getTime("time_add");
                
                yourproduct product = new yourproduct(idKatalog, nama_barang,
                harga_barang, deskripsi, jumlah_like, jumlah_beli, date, time);
                view.add(product);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MarketplaceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return view;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "sale")
    public ArrayList<sales> Sales(
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        String query = "select * from katalog WHERE idUser = " + username;
        
        ArrayList<sales> view = new ArrayList<>();
        
        ConnectDB connectdb = new ConnectDB();
        String hasil = "";
        try (Connection con = connectdb.getConnection()) {
            Statement stmt = null;
            try {
                stmt = con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(MarketplaceService.class.getName()).log(Level.SEVERE, null, ex);
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
                date = rs.getDate("date_add");
                time = rs.getTime("time_add");
                imagepath = rs.getString("image");
                namabarang = rs.getString("namaBarang_beli");
                hargabarang = rs.getString("hargaBarang_beli");
                totalharga = rs.getDouble("total_harga");
                jumlahbeli = rs.getInt("jumlah_beli");
                namapenerima = rs.getString("nama_penerima");
                alamatpenerima = rs.getString("alamat_penerima");
                kodepos = rs.getInt("kodepos_penerima");
                notelp = rs.getInt("noTelp_penerima");
                iduser = rs.getInt("idUser");
                sales sales = new sales(date, time, imagepath, namabarang, hargabarang,
                totalharga, jumlahbeli, namapenerima, alamatpenerima, kodepos,
                notelp, iduser);
                
                view.add(sales);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MarketplaceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return view;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "beli")
    public ArrayList<buy> Buy(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        String query = "select * from katalog WHERE idUser = " + username;
        
        ArrayList<buy> view = new ArrayList<>();
        
        ConnectDB connectdb = new ConnectDB();
        String hasil = "";
        try (Connection con = connectdb.getConnection()) {
            Statement stmt = null;
            try {
                stmt = con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(MarketplaceService.class.getName()).log(Level.SEVERE, null, ex);
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
            int idpenjual;
            while(rs.next()) {
                date = rs.getDate("date_add");
                time = rs.getTime("time_add");
                imagepath = rs.getString("image");
                namabarang = rs.getString("namaBarang_beli");
                hargabarang = rs.getString("hargaBarang_beli");
                totalharga = rs.getDouble("total_harga");
                jumlahbeli = rs.getInt("jumlah_beli");
                namapenerima = rs.getString("nama_penerima");
                alamatpenerima = rs.getString("alamat_penerima");
                kodepos = rs.getInt("kodepos_penerima");
                notelp = rs.getInt("noTelp_penerima");
                idpenjual = rs.getInt("idPenjual");
                buy buy = new buy(date, time, imagepath, namabarang, hargabarang,
                totalharga, jumlahbeli, namapenerima, alamatpenerima, kodepos,
                notelp, idpenjual);
                
                view.add(buy);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MarketplaceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return view;
    }
    
    /**
     *
     * @param nama_barang
     * @param harga_barang
     * @param deskripsi
     * @param id_user
     * @param image
     * @throws java.sql.SQLException
     */
    @WebMethod(operationName = "AddProduct")
    public void AddBarang(
            @WebParam(name = "nama_barang")  String nama_barang,
            @WebParam(name = "harga_barang") int harga_barang,
            @WebParam(name = "deskripsi")    String deskripsi,
            @WebParam(name = "id_user")      int id_user,
            @WebParam(name = "image")       String image) 
            {
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	    java.util.Date  date = new java.util.Date();
	    
            String query = "INSERT INTO katalog(nama_barang, harga_barang, deskripsi,jumlah_like,jumlah_beli,date_add, idUser,image,time_add) "
                           + "VALUES('"+ nama_barang + "','" + harga_barang + "','" + deskripsi + "','0','0','"+ dateFormat.format(date) +"',"+ id_user +",'"+image+"','" + timeFormat.format(date) + "');";
                System.out.println("QUERY : " + query);
                           
            ConnectDB connectdb = new ConnectDB();
            try (Connection con = connectdb.getConnection()) {
                Statement stmt;
                stmt = con.createStatement();

                stmt.executeUpdate(query);
                
            } catch (SQLException ex) {
                Logger.getLogger(MarketplaceService.class.getName()).log(Level.SEVERE, null, ex);
            }
                
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "EditProduct")
    public yourproduct EditProduct(@WebParam(name = "idUser") final int idUser, @WebParam(name = "idKatalog") final int idKatalog) {
        
        String query = "select * from katalog WHERE idUser = " + idUser + " AND idKatalog = " + idKatalog + ";";
        System.out.println(query);
        
        yourproduct view = null;
        
        ConnectDB connectdb = new ConnectDB();
        String hasil = "";
        try (Connection con = connectdb.getConnection()) {
            Statement stmt = null;
            stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            String nama_barang = rs.getString("nama_barang");
            Double harga_barang = rs.getDouble("harga_barang");
            String deskripsi = rs.getString("deskripsi");
            int jumlah_like = rs.getInt("jumlah_like");
            int jumlah_beli = rs.getInt("jumlah_beli");
            Date date = rs.getDate("date_add");
            Time time = rs.getTime("time_add");

            yourproduct product = new yourproduct(idKatalog, nama_barang,
            harga_barang, deskripsi, jumlah_like, jumlah_beli, date, time);
            view = product;
        } catch (SQLException ex) {
            Logger.getLogger(MarketplaceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return view;
    }
    
    

}