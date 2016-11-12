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
            @WebParam(name = "password") String password) {

        String query = "select * from katalog NATURAL JOIN user ORDER BY date_add DESC";
        
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
    

}