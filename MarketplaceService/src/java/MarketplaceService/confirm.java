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
    
    public confirm(String namabarang, String hargabarang) {
        this.namabarang = namabarang;
        this.hargabarang = hargabarang;
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
}
