
package marketplaceservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for product complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="product"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="deskripsi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hargabarang" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="imgpath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="jumlahbeli" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="jumlahlike" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="namabarang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="usernama" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product", propOrder = {
    "deskripsi",
    "hargabarang",
    "imgpath",
    "jumlahbeli",
    "jumlahlike",
    "namabarang",
    "usernama"
})
public class Product {

    protected String deskripsi;
    protected double hargabarang;
    protected String imgpath;
    protected int jumlahbeli;
    protected int jumlahlike;
    protected String namabarang;
    protected String usernama;

    /**
     * Gets the value of the deskripsi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeskripsi() {
        return deskripsi;
    }

    /**
     * Sets the value of the deskripsi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeskripsi(String value) {
        this.deskripsi = value;
    }

    /**
     * Gets the value of the hargabarang property.
     * 
     */
    public double getHargabarang() {
        return hargabarang;
    }

    /**
     * Sets the value of the hargabarang property.
     * 
     */
    public void setHargabarang(double value) {
        this.hargabarang = value;
    }

    /**
     * Gets the value of the imgpath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImgpath() {
        return imgpath;
    }

    /**
     * Sets the value of the imgpath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImgpath(String value) {
        this.imgpath = value;
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
     * Gets the value of the jumlahlike property.
     * 
     */
    public int getJumlahlike() {
        return jumlahlike;
    }

    /**
     * Sets the value of the jumlahlike property.
     * 
     */
    public void setJumlahlike(int value) {
        this.jumlahlike = value;
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
     * Gets the value of the usernama property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsernama() {
        return usernama;
    }

    /**
     * Sets the value of the usernama property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsernama(String value) {
        this.usernama = value;
    }

}
