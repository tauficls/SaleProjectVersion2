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
    private long hargabarang;
    private String deskripsi;
    private long jumlahlike;
    private long jumlahbeli;
    private String date;
    private String time;
    private Boolean isLiked;
    private long idKatalog;

    public long getIdKatalog() {
        return idKatalog;
    }

    public void setIdKatalog(long idKatalog) {
        this.idKatalog = idKatalog;
    }

    public Boolean getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(Boolean isLiked) {
        this.isLiked = isLiked;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public void setUsernama(String usernama) {
        this.usernama = usernama;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
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

    public String getUsernama() {
        return usernama;
    }

    public String getImgpath() {
        return imgpath;
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

    public product(String usernama, String imgpath, String namabarang,
            long hargabarang, String deskripsi, long jumlahlike,
            long jumlahbeli, String date, String time, long idKatalog, Boolean isLiked ) {
        this.usernama = usernama;
        this.imgpath = imgpath;
        this.namabarang = namabarang;
        this.deskripsi = deskripsi;
        this.hargabarang = hargabarang;
        this.jumlahlike = jumlahlike;
        this.jumlahbeli = jumlahbeli;
        this.date = date;
        this.time = time;
        this.isLiked = isLiked;
        this.idKatalog = idKatalog;
    }
    
    
}
