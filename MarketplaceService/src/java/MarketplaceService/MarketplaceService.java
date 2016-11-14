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
import javax.jws.Oneway;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

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
            @WebParam(name = "idUser") String idUser,
            @WebParam(name = "iduservalidate") String idUserVal,
            @WebParam(name = "token") String token
    ) throws InvalidTokenException {
        try{
            checktoken(idUserVal,token);
        } catch(InvalidTokenException e){
            throw e;
        }
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
        @WebParam(name = "iduser") String idUser,
        @WebParam(name = "iduservalidate") String idUserVal,
        @WebParam(name = "token") String token) throws InvalidTokenException 
    {
        try{
            checktoken(idUserVal,token);
        } catch(InvalidTokenException e){
            throw e;
        }
        String query = "select * from katalog WHERE idUser = " + idUser;
        
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
                idKatalog = rs.getLong("idKatalog");
                System.out.println("IDKATALOG : "+idKatalog);
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
            @WebParam(name = "idpembeli") String iduser,
            @WebParam(name = "iduservalidate") String idUserVal,
            @WebParam(name = "token") String token) throws InvalidTokenException {
        //TODO write your implementation code here:
        try{
            checktoken(idUserVal,token);
        } catch(InvalidTokenException e){
            throw e;
        }
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
        @WebParam(name = "idpenjual") String iduser,
        @WebParam(name = "iduservalidate") String idUserVal,
        @WebParam(name = "token") String token
        ) throws InvalidTokenException {
        //TODO write your implementation code here:
        try{
            checktoken(idUserVal,token);
        } catch(InvalidTokenException e){
            throw e;
        }
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
    public String addLike(
            @WebParam(name = "idKatalog") String idKatalog, 
            @WebParam(name = "idUser") String idUser,
            @WebParam(name = "iduservalidate") String idUserVal,
            @WebParam(name = "token") String token) throws InvalidTokenException {
        try{
            checktoken(idUserVal,token);
        } catch(InvalidTokenException e){
            throw e;
        }
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
    public String addUnlike(
            @WebParam(name = "idKatalog") String idKatalog, 
            @WebParam(name = "idUser") String idUser,
            @WebParam(name = "iduservalidate") String idUserVal,
            @WebParam(name = "token") String token) throws InvalidTokenException {
        try{
            checktoken(idUserVal,token);
        } catch(InvalidTokenException e){
            throw e;
        }
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
    @WebMethod(operationName = "confirmpurchase")
    public ArrayList<confirm> confirmpurchase(
            @WebParam(name = "idKatalog") String idKatalog,
            @WebParam(name = "iduser") String iduser,
            @WebParam(name = "iduservalidate") String idUserVal,
            @WebParam(name = "token") String token) {
        /*
        try {
            String query, query1, query2;
            query = "select * from user where idUser =" + iduser;
            ConnectDB connectdb = new ConnectDB();
            Connection con = connectdb.getConnection();
            Statement stmt = null;
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            String namaLengkap = rs.getString("namaLengkap");
            //String email = rs.getString("email");
            String kodepos = rs.getString("kodepos_user");
            String noTelp = rs.getString("noTelp_user");
            String alamat = rs.getString("alamat_user");
            query1 = "select * from katalog where idKatalog =" + idKatalog;
            stmt = null;
            stmt = con.createStatement();
            rs = stmt.executeQuery(query1);
            rs.next();
            String namaBarang = rs.getString("nama_barang");
            long hargaBarang = rs.getLong("harga_barang");
            long idPenjual = rs.getLong("idUser");
            String image = rs.getString("image");
            long jumlah_purchase = rs.getLong("jumlah_beli");
            long jumlah_beli = rs.getLong("quantity");
            String nama_penerima = rs.getString("consignee");
            String alamat_penerima = rs.getString("fullAddrress");
            long kodepos_penerima = rs.getLong("postalCode");
            String noTelp_penerima = rs.getString("phoneNumber");
            String kartuKredit = rs.getString("numCard");
            String kodeValidasi = rs.getString("valCard");
            long jumlah_purchase = jumlah_purchase + jumlah_beli;
            long total_harga = jumlah_beli * hargaBarang;
            query2 = "INSERT INTO Purchase(idUser, jumlah_beli, idKatalog, "
                    + "total_harga, nama_penerima, alamat_penerima, kodepos_penerima,"
                    + " noTelp_penerima, kartuKredit, kodeValidasi, date_add,"
                    + " time_add, namaBarang_beli, hargaBarang_beli, idPenjual, image)"
                    + "VALUES("+ iduser + ',' + jumlah_beli + ',' + idKatalog + ',' + total_harga + ","
                    + nama_penerima + ',' + alamat_penerima + ',' + kodepos_penerima + ',' + noTelp_penerima + ', ' + kartu
                    + Kredit + ', ' + kodeValidasi + ', CURDATE(), CURTIME(), '+ namaBarang
                    + ", " + hargaBarang +', ' + idPenjual +', ' + image + '); 
            
        } catch (SQLException ex) {
            Logger.getLogger(MarketplaceService.class.getName()).log(Level.SEVERE, null, ex);
        } 
        */
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "UpdateProduct")
    public void UpdateProduct(
            @WebParam(name = "nama_barang")  String nama_barang,
            @WebParam(name = "harga_barang") int harga_barang,
            @WebParam(name = "deskripsi")    String deskripsi,
            @WebParam(name = "id_katalog")   int id_katalog,
            @WebParam(name = "iduservalidate") String idUserVal,
            @WebParam(name = "token") String token) 
    throws InvalidTokenException
    {
        try{
            checktoken(idUserVal,token);
        } catch(InvalidTokenException e){
            throw e;
        }
        String query ="UPDATE katalog "
                + "SET nama_Barang = '"+nama_barang+"', harga_barang = '"+harga_barang+"', deskripsi='"+deskripsi+ "' WHERE idKatalog='"+id_katalog+"';  ";
        System.out.println("QUERY : "+query);
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
    @WebMethod(operationName = "deleteProduk")
    public String deleteProduct(
            @WebParam(name = "idUser") String idUser, 
            @WebParam(name = "idKatalog") String idKatalog,
            @WebParam(name = "iduservalidate") String idUserVal,
            @WebParam(name = "token") String token) throws InvalidTokenException {
        try{
            checktoken(idUserVal,token);
        } catch(InvalidTokenException e){
            throw e;
        }
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
            @WebParam(name = "image")       String image,
            @WebParam(name = "iduservalidate") String idUserVal,
            @WebParam(name = "token") String token) throws InvalidTokenException 
            {
            try{
                checktoken(idUserVal,token);
            } catch(InvalidTokenException e){
                throw e;
            }
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
    public yourproduct EditProduct(
            @WebParam(name = "idUser") final int idUser, 
            @WebParam(name = "idKatalog") final int idKatalog,
            @WebParam(name = "iduservalidate") String idUserVal,
            @WebParam(name = "token") String token) throws InvalidTokenException {
        try{
            checktoken(idUserVal,token);
        } catch(InvalidTokenException e){
            throw e;
        }
        
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
            DateFormat df = new SimpleDateFormat("EEEE, d MMMM yyyy");
            DateFormat df1 = new SimpleDateFormat("HH:mm");
            String nama_barang = rs.getString("nama_barang");
            long harga_barang = rs.getLong("harga_barang");
            String deskripsi = rs.getString("deskripsi");
            int jumlah_like = rs.getInt("jumlah_like");
            int jumlah_beli = rs.getInt("jumlah_beli");
            String date = df.format(rs.getDate("date_add"));
            String time = df1.format(rs.getTime("time_add"));
            
            yourproduct product = new yourproduct(idKatalog, nama_barang,
            harga_barang, deskripsi, jumlah_like, jumlah_beli, date, time,"");
            view = product;
        } catch (SQLException ex) {
            Logger.getLogger(MarketplaceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return view;
    }
    
    void checktoken(String idUser, String token)
    throws InvalidTokenException
    {
        JSONObject result_data;
        loginConnector filter = new loginConnector("validateToken");
        try {
            filter.validateToken(token, idUser);
        } catch (Exception ex) {

        }
        result_data = filter.getData();

            //Parse data from JSON
        String str_token = (String) result_data.get("is_token");
        String str_expire = (String) result_data.get("is_expire");
            
        //Validate token and Expire time
        if ("true".equals(str_token)) {
            if ("true".equals(str_expire)) {
                Throwable t = new IllegalArgumentException("token");
                throw new InvalidTokenException("Expired Token", t);
            }
        }
        else {
            Throwable t = new IllegalArgumentException("Empty name");
            throw new InvalidTokenException("Invalid Token", t);
        }
    }
    

}