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
public class buy {
    private Date date;
    private Time time;
    private String imagepath;
    private String namabarang;
    private String hargabarang;
    private Double totalharga;
    private int jumlahbeli;
    private String namapenerima;
    private String alamatpenerima;
    private int kodepos;
    private int notelp;
    private int idpenjual;
    
    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public void setHargabarang(String hargabarang) {
        this.hargabarang = hargabarang;
    }

    public void setTotalharga(Double totalharga) {
        this.totalharga = totalharga;
    }

    public void setJumlahbeli(int jumlahbeli) {
        this.jumlahbeli = jumlahbeli;
    }

    public void setNamapenerima(String namapenerima) {
        this.namapenerima = namapenerima;
    }

    public void setAlamatpenerima(String alamatpenerima) {
        this.alamatpenerima = alamatpenerima;
    }

    public void setKodepos(int kodepos) {
        this.kodepos = kodepos;
    }

    public void setNotelp(int notelp) {
        this.notelp = notelp;
    }

    public void setIdpenjual(int idpenjual) {
        this.idpenjual = idpenjual;
    }
    
    
    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getImagepath() {
        return imagepath;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public String getHargabarang() {
        return hargabarang;
    }

    public Double getTotalharga() {
        return totalharga;
    }

    public int getJumlahbeli() {
        return jumlahbeli;
    }

    public String getNamapenerima() {
        return namapenerima;
    }

    public String getAlamatpenerima() {
        return alamatpenerima;
    }

    public int getKodepos() {
        return kodepos;
    }

    public int getNotelp() {
        return notelp;
    }

    public int getIdpenjual() {
        return idpenjual;
    }

    public buy(Date date, Time time, String imagepath, String namabarang, String hargabarang, Double totalharga, int jumlahbeli, String namapenerima, String alamatpenerima, int kodepos, int notelp, int idpenjual) {
        this.date = date;
        this.time = time;
        this.imagepath = imagepath;
        this.namabarang = namabarang;
        this.hargabarang = hargabarang;
        this.totalharga = totalharga;
        this.jumlahbeli = jumlahbeli;
        this.namapenerima = namapenerima;
        this.alamatpenerima = alamatpenerima;
        this.kodepos = kodepos;
        this.notelp = notelp;
        this.idpenjual = idpenjual;
    }
}
