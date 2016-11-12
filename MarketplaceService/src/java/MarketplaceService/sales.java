/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarketplaceService;

import java.sql.Time;


/**
 *
 * @author taufic
 */
public class sales {
    private String date;
    private String time;
    private String imagepath;
    private String namabarang;
    private String hargabarang;
    private long totalharga;
    private long jumlahbeli;
    private String namapenerima;
    private String alamatpenerima;
    private long kodepos;
    private long notelp;
    private String namapembeli;

    public String getNamapembeli() {
        return namapembeli;
    }

    public void setNamapembeli(String namapembeli) {
        this.namapembeli = namapembeli;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
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

    public void setTotalharga(long totalharga) {
        this.totalharga = totalharga;
    }

    public void setJumlahbeli(long jumlahbeli) {
        this.jumlahbeli = jumlahbeli;
    }

    public void setNamapenerima(String namapenerima) {
        this.namapenerima = namapenerima;
    }

    public void setAlamatpenerima(String alamatpenerima) {
        this.alamatpenerima = alamatpenerima;
    }

    public void setKodepos(long kodepos) {
        this.kodepos = kodepos;
    }

    public void setNotelp(long notelp) {
        this.notelp = notelp;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
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

    public long getTotalharga() {
        return totalharga;
    }

    public long getJumlahbeli() {
        return jumlahbeli;
    }

    public String getNamapenerima() {
        return namapenerima;
    }

    public String getAlamatpenerima() {
        return alamatpenerima;
    }

    public long getKodepos() {
        return kodepos;
    }

    public long getNotelp() {
        return notelp;
    }

    public sales(String date, String time, String imagepath, String namabarang,
            String hargabarang, long totalharga, long jumlahbeli,
            String namapenerima, String alamatpenerima,
            long kodepos, long notelp, String namapembeli) {
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
        this.namapembeli = namapembeli;
    }
    
}
