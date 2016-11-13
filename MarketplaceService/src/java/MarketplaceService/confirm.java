/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarketplaceService;

/**
 *
 * @author Innocent
 */
public class confirm {
    private String namabarang;
    private String hargabarang;
    private String namalengkap;
    private String alamat;
    private String kodepos;
    
    public confirm(String namabarang, String hargabarang, String namalengkap, String alamat, String kodepos) {
        this.namabarang = namabarang;
        this.hargabarang = hargabarang;
        this.namalengkap = namalengkap;
        this.alamat = alamat;
        this.kodepos = kodepos;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getHargabarang() {
        return hargabarang;
    }

    public void setHargabarang(String hargabarang) {
        this.hargabarang = hargabarang;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKodepos() {
        return kodepos;
    }

    public void setKodepos(String kodepos) {
        this.kodepos = kodepos;
    }
    
    
    
    
}
