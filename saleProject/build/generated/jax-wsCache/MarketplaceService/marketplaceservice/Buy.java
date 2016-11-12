
package marketplaceservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buy"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="alamatpenerima" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="date" type="{http://MarketplaceService/}date" minOccurs="0"/&gt;
 *         &lt;element name="hargabarang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idpenjual" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="imagepath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="jumlahbeli" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="kodepos" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="namabarang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="namapenerima" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="notelp" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="time" type="{http://MarketplaceService/}time" minOccurs="0"/&gt;
 *         &lt;element name="totalharga" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buy", propOrder = {
    "alamatpenerima",
    "date",
    "hargabarang",
    "idpenjual",
    "imagepath",
    "jumlahbeli",
    "kodepos",
    "namabarang",
    "namapenerima",
    "notelp",
    "time",
    "totalharga"
})
public class Buy {

    protected String alamatpenerima;
    protected Date date;
    protected String hargabarang;
    protected int idpenjual;
    protected String imagepath;
    protected int jumlahbeli;
    protected int kodepos;
    protected String namabarang;
    protected String namapenerima;
    protected int notelp;
    protected Time time;
    protected Double totalharga;

    /**
     * Gets the value of the alamatpenerima property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlamatpenerima() {
        return alamatpenerima;
    }

    /**
     * Sets the value of the alamatpenerima property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlamatpenerima(String value) {
        this.alamatpenerima = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setDate(Date value) {
        this.date = value;
    }

    /**
     * Gets the value of the hargabarang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHargabarang() {
        return hargabarang;
    }

    /**
     * Sets the value of the hargabarang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHargabarang(String value) {
        this.hargabarang = value;
    }

    /**
     * Gets the value of the idpenjual property.
     * 
     */
    public int getIdpenjual() {
        return idpenjual;
    }

    /**
     * Sets the value of the idpenjual property.
     * 
     */
    public void setIdpenjual(int value) {
        this.idpenjual = value;
    }

    /**
     * Gets the value of the imagepath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImagepath() {
        return imagepath;
    }

    /**
     * Sets the value of the imagepath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImagepath(String value) {
        this.imagepath = value;
    }

    /**
     * Gets the value of the jumlahbeli property.
     * 
     */
    public int getJumlahbeli() {
        return jumlahbeli;
    }

    /**
     * Sets the value of the jumlahbeli property.
     * 
     */
    public void setJumlahbeli(int value) {
        this.jumlahbeli = value;
    }

    /**
     * Gets the value of the kodepos property.
     * 
     */
    public int getKodepos() {
        return kodepos;
    }

    /**
     * Sets the value of the kodepos property.
     * 
     */
    public void setKodepos(int value) {
        this.kodepos = value;
    }

    /**
     * Gets the value of the namabarang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamabarang() {
        return namabarang;
    }

    /**
     * Sets the value of the namabarang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamabarang(String value) {
        this.namabarang = value;
    }

    /**
     * Gets the value of the namapenerima property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamapenerima() {
        return namapenerima;
    }

    /**
     * Sets the value of the namapenerima property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamapenerima(String value) {
        this.namapenerima = value;
    }

    /**
     * Gets the value of the notelp property.
     * 
     */
    public int getNotelp() {
        return notelp;
    }

    /**
     * Sets the value of the notelp property.
     * 
     */
    public void setNotelp(int value) {
        this.notelp = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link Time }
     *     
     */
    public Time getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link Time }
     *     
     */
    public void setTime(Time value) {
        this.time = value;
    }

    /**
     * Gets the value of the totalharga property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalharga() {
        return totalharga;
    }

    /**
     * Sets the value of the totalharga property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalharga(Double value) {
        this.totalharga = value;
    }

}
