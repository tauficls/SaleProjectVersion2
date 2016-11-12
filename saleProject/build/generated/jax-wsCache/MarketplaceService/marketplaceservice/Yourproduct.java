
package marketplaceservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for yourproduct complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="yourproduct"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="date" type="{http://MarketplaceService/}date" minOccurs="0"/&gt;
 *         &lt;element name="deskripsi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hargabarang" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="idKatalog" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="jumlahbeli" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="jumlahlike" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="namabarang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="time" type="{http://MarketplaceService/}time" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "yourproduct", propOrder = {
    "date",
    "deskripsi",
    "hargabarang",
    "idKatalog",
    "jumlahbeli",
    "jumlahlike",
    "namabarang",
    "time"
})
public class Yourproduct {

    protected Date date;
    protected String deskripsi;
    protected double hargabarang;
    protected int idKatalog;
    protected int jumlahbeli;
    protected int jumlahlike;
    protected String namabarang;
    protected Time time;

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
     * Gets the value of the idKatalog property.
     * 
     */
    public int getIdKatalog() {
        return idKatalog;
    }

    /**
     * Sets the value of the idKatalog property.
     * 
     */
    public void setIdKatalog(int value) {
        this.idKatalog = value;
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

}
