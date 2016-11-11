/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

/**
 *
 * @author taufic
 */
public class Product {
    private String usernama;
    private String imgpath;
    private String namabarang;
    private double hargabarang;
    private String deskripsi;
    private int jumlahlike;
    private int jumlahbeli;

    public String getUsernama() {
        return usernama;
    }

    public String getImgpath() {
        return imgpath;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public double getHargabarang() {
        return hargabarang;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getJumlahlike() {
        return jumlahlike;
    }

    public int getJumlahbeli() {
        return jumlahbeli;
    }

    
    
    public Product(String usernama, String imgpath, String namabarang,
            double hargabarang, String deskripsi, int jumlahlike,
            int jumlahbeli) {
        this.usernama = usernama;
        this.imgpath = imgpath;
        this.namabarang = namabarang;
        this.deskripsi = deskripsi;
        this.hargabarang = hargabarang;
        this.jumlahbeli = jumlahlike;
        this.jumlahbeli = jumlahbeli;
    }
    
    
}
