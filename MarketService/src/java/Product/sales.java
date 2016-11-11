/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author taufic
 */
public class sales {
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
    private int iduser;

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

    public int getIduser() {
        return iduser;
    }
    public sales(Date date, Time time, String imagepath, String namabarang, String hargabarang, Double totalharga, int jumlahbeli, String namapenerima, String alamatpenerima, int kodepos, int notelp, int iduser) {
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
        this.iduser = iduser;
    }
    
    

    
}
