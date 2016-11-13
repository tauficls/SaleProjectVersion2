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
public class yourproduct {
    private long idKatalog;
    private String imagepath;
    private String namabarang;
    private long hargabarang;
    private String deskripsi;
    private long jumlahlike;
    private long jumlahbeli;
    private String date;
    private String time;


    public void setIdKatalog(long idKatalog) {
        this.idKatalog = idKatalog;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public void setHargabarang(long hargabarang) {
        this.hargabarang = hargabarang;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setJumlahlike(long jumlahlike) {
        this.jumlahlike = jumlahlike;
    }

    public void setJumlahbeli(long jumlahbeli) {
        this.jumlahbeli = jumlahbeli;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
    

    public long getIdKatalog() {
        return idKatalog;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public long getHargabarang() {
        return hargabarang;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public long getJumlahlike() {
        return jumlahlike;
    }

    public long getJumlahbeli() {
        return jumlahbeli;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
    
    public yourproduct(long idKatalog, String namabarang, long hargabarang,
            String deskripsi, long jumlahlike, long jumlahbeli, String date,
            String time, String image) {
        this.idKatalog = idKatalog;
        this.namabarang = namabarang;
        this.hargabarang = hargabarang;
        this.deskripsi = deskripsi;
        this.jumlahbeli = jumlahbeli;
        this.jumlahlike = jumlahlike;
        this.date = date;
        this.time = time;
        this.imagepath = image;
    }
}
