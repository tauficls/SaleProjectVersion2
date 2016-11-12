/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarketplaceService;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author taufic
 */
public class yourproduct {
    private int idKatalog;
    private String namabarang;
    private double hargabarang;
    private String deskripsi;
    private int jumlahlike;
    private int jumlahbeli;
    private Date date;
    private Time time;
    public void setIdKatalog(int idKatalog) {
        this.idKatalog = idKatalog;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    

    public int getIdKatalog() {
        return idKatalog;
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

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }
    
    public yourproduct(int idKatolog, String namabarang, double hargabarang,
            String deskripsi, int jumlahlike, int jumlahbeli, Date date,
            Time time) {
        this.idKatalog = idKatalog;
        this.namabarang = namabarang;
        this.hargabarang = hargabarang;
        this.deskripsi = deskripsi;
        this.jumlahbeli = jumlahbeli;
        this.jumlahlike = jumlahlike;
        this.date = date;
        this.time = time;
    }
}
