/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarketplaceService;

import ConnectDB.ConnectDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
            @WebParam(name = "filter") String filter,
            @WebParam(name = "idPengguna") String idUser) {
        /*query*/
        String query;
        String query2 = "SELECT * FROM `like` where idUser=\"" + idUser + "\"";
        
        /*select filter*/
        if(filter.equals("product"))
            query = "select * from katalog NATURAL JOIN user WHERE nama_barang like '%"+search+"%' ORDER BY date_add DESC";
        else if(filter.equals("store"))
            query = "select * from katalog NATURAL JOIN user WHERE namaLike like '%"+search+"%' ORDER BY date_add DESC";
        else
            query = "select * from katalog NATURAL JOIN user ORDER BY date_add DESC";
        
        /*array list*/
        ArrayList<product> view = new ArrayList<>();
        ArrayList<Long> itemLiked = new ArrayList<>();
        /*connect query2*/
        ConnectDB connectdb = new ConnectDB();
        
        Connection con2 = connectdb.getConnection();
        Statement stmt2 = null;
        try {
            stmt2 = con2.createStatement();
            ResultSet rs = stmt2.executeQuery(query2);
            System.out.println("pisang" + query2);
            while (rs.next()) {
                itemLiked.add(rs.getLong("idKatalog"));
                System.out.println(rs.getLong("idKatalog"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarketplaceService.class.getName()).log(Level.SEVERE, null, ex);
        }        
            
        String hasil = "";
        try (Connection con = connectdb.getConnection()) {
            Statement stmt = null;
            stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            String usernama;
            String img_path;
            String nama_barang;
            long harga_barang;
            String deskripsi;
            long jumlah_like;
            long jumlah_beli;
            String date;
            DateFormat df = new SimpleDateFormat("EEEE, d MMMM yyyy");
            String time;
            DateFormat df1 = new SimpleDateFormat("HH:mm");
            long idkatalog;
            while(rs.next()) {
                idkatalog = rs.getLong("idKatalog");
                usernama = rs.getString("namaLengkap");
                img_path = rs.getString("image");
                nama_barang = rs.getString("nama_barang");
                harga_barang = rs.getLong("harga_barang");
                deskripsi = rs.getString("deskripsi");
                jumlah_like = rs.getLong("jumlah_like");
                jumlah_beli = rs.getLong("jumlah_beli");
                date = df.format(rs.getDate("date_add"));
                time = df1.format(rs.getTime("time_add"));
                Boolean isLiked = false;
                for (int i=0;i<itemLiked.size();i++) {
                    if (itemLiked.get(i) == idkatalog ) {
                        System.out.println("true");
                        isLiked = true;
                        break;
                    }
                }
                product Product = new product(usernama, img_path, nama_barang,
                        harga_barang, deskripsi, jumlah_like, jumlah_beli, date, time, idkatalog, isLiked);
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
        @WebParam(name = "iduser") String iduser) {
        
        String query = "select * from katalog WHERE idUser = " + iduser;
        
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
            long idKatalog;
            String imagepath;
            String nama_barang;
            long harga_barang;
            String deskripsi;
            long jumlah_like;
            long jumlah_beli;
            String date;
            DateFormat df = new SimpleDateFormat("EEEE, d MMMM yyyy");
            String time;
            DateFormat df1 = new SimpleDateFormat("HH:mm");
            while(rs.next()) {
                idKatalog = rs.getInt("idKatalog");
                imagepath = rs.getString("image");
                nama_barang = rs.getString("nama_barang");
                harga_barang = rs.getLong("harga_barang");
                deskripsi = rs.getString("deskripsi");
                jumlah_like = rs.getInt("jumlah_like");
                jumlah_beli = rs.getInt("jumlah_beli");
                date = df.format(rs.getDate("date_add"));
                time = df1.format(rs.getTime("time_add"));
                
                yourproduct product = new yourproduct(idKatalog, nama_barang,
                harga_barang, deskripsi, jumlah_like, jumlah_beli, date, time, imagepath);
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
            @WebParam(name = "idpembeli") String iduser) {
        //TODO write your implementation code here:
        String query = "select * from purchase where purchase.idPenjual =" + iduser;
        
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
            String date;
            DateFormat df = new SimpleDateFormat("EEEE, d MMMM yyyy");
            String time;
            DateFormat df1 = new SimpleDateFormat("HH:mm");
            String imagepath;
            String namabarang;
            String hargabarang;
            long totalharga;
            long jumlahbeli;
            String namapenerima;
            String alamatpenerima;
            long kodepos;
            long notelp;
            long idbuyer;
            String query2;
            String namapembeli;
            Statement stmt2 = null;
            ResultSet rs2;
            while(rs.next()) {
                date = df.format(rs.getDate("date_add"));
                time = df1.format(rs.getTime("time_add"));
                imagepath = rs.getString("image");
                namabarang = rs.getString("namaBarang_beli");
                hargabarang = rs.getString("hargaBarang_beli");
                totalharga = rs.getLong("total_harga");
                jumlahbeli = rs.getLong("jumlah_beli");
                namapenerima = rs.getString("nama_penerima");
                alamatpenerima = rs.getString("alamat_penerima");
                kodepos = rs.getLong("kodepos_penerima");
                notelp = rs.getLong("noTelp_penerima");
                idbuyer = rs.getLong("idUser");
                query2 = "select namaLengkap from user where idUser =" + idbuyer;
                stmt2 = con.createStatement();
                rs2 = stmt2.executeQuery(query2);
                rs2.next();
                namapembeli = rs2.getString("namaLengkap");
                sales sales = new sales(date, time, imagepath, namabarang, hargabarang,
                totalharga, jumlahbeli, namapenerima, alamatpenerima, kodepos,
                notelp, namapembeli);
                
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
    public ArrayList<buy> Buy(
        @WebParam(name = "idpenjual") String iduser) {
        //TODO write your implementation code here:
        String query = "SELECT * FROM purchase where purchase.idUser=" +iduser;
        
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
            String date;
            DateFormat df = new SimpleDateFormat("EEEE, d MMMM yyyy");
            String time;
            DateFormat df1 = new SimpleDateFormat("HH:mm");
            String imagepath;
            String namabarang;
            String hargabarang;
            long totalharga;
            long jumlahbeli;
            String namapenerima;
            String alamatpenerima;
            long kodepos;
            long notelp;
            long idpenjual;
            String query2;
            String namapenjual;
            Statement stmt2 = null;
            ResultSet rs2;
            while(rs.next()) {
                date = df.format(rs.getDate("date_add"));
                time = df1.format(rs.getTime("time_add"));
                imagepath = rs.getString("image");
                namabarang = rs.getString("namaBarang_beli");
                hargabarang = rs.getString("hargaBarang_beli");
                totalharga = rs.getLong("total_harga");
                jumlahbeli = rs.getLong("jumlah_beli");
                namapenerima = rs.getString("nama_penerima");
                alamatpenerima = rs.getString("alamat_penerima");
                kodepos = rs.getLong("kodepos_penerima");
                notelp = rs.getLong("noTelp_penerima");
                idpenjual = rs.getLong("idPenjual");
                query2 = "select namaLengkap from user where idUser =" + idpenjual;
                stmt2 = con.createStatement();
                rs2 = stmt2.executeQuery(query2);
                rs2.next();
                namapenjual = rs2.getString("namaLengkap");
                buy buy = new buy(date, time, imagepath, namabarang, hargabarang,
                totalharga, jumlahbeli, namapenerima, alamatpenerima, kodepos,
                notelp, namapenjual);
                
                view.add(buy);
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
    @WebMethod(operationName = "addLiked")
    public String addLike(@WebParam(name = "idKatalog") String idKatalog, @WebParam(name = "idUser") String idUser) {
        ConnectDB connectdb = new ConnectDB();
        Connection con = connectdb.getConnection();
        PreparedStatement statement;
        String status = "error";
        try {
            statement = con.prepareStatement("INSERT INTO `like` values(?,?)");
            statement.setString(1, idUser);
            statement.setString(2, idKatalog);
            statement.executeUpdate();
            
            status = "ok";
        } catch (SQLException ex) {
            Logger.getLogger(MarketplaceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUnliked")
    public String addUnlike(@WebParam(name = "idKatalog") String idKatalog, @WebParam(name = "idUser") String idUser) {
        ConnectDB connectdb = new ConnectDB();
        Connection con = connectdb.getConnection();
        PreparedStatement statement;
        String status = "error";
        try {
            statement = con.prepareStatement("DELETE FROM `like` where idKatalog = ? and idUser = ?");
            statement.setString(1, idKatalog);
            statement.setString(2, idUser);
            statement.executeUpdate();
            
            status = "ok";
        } catch (SQLException ex) {
            Logger.getLogger(MarketplaceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteProduk")
    public String deleteProduct(@WebParam(name = "idUser") String idUser, @WebParam(name = "idKatalog") String idKatalog) {
        ConnectDB connectdb = new ConnectDB();
        Connection con = connectdb.getConnection();
        PreparedStatement statement;
        String status = "error";
        try {
            statement = con.prepareStatement("DELETE FROM katalog where idKatalog = ? and idUser = ?");
            statement.setString(1, idKatalog);
            statement.setString(2, idUser);
            statement.executeUpdate();
            System.out.println(statement);
            
            status = "ok";
        } catch (SQLException ex) {
            Logger.getLogger(MarketplaceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }
}