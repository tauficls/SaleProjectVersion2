/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarketplaceService;

/**
 *
 * @author taufic
 */
public class product {
    private String usernama;
    private String imgpath;
    private String namabarang;
    private double hargabarang;
    private String deskripsi;
    private int jumlahlike;
    private int jumlahbeli;

    public void setUsernama(String usernama) {
        this.usernama = usernama;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public void setHargabarang(double hargabarang) {
        this.hargabarang = hargabarang;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setJumlahlike(int jumlahlike) {
        this.jumlahlike = jumlahlike;
    }

    public void setJumlahbeli(int jumlahbeli) {
        this.jumlahbeli = jumlahbeli;
    }

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

    public product(String usernama, String imgpath, String namabarang,
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
