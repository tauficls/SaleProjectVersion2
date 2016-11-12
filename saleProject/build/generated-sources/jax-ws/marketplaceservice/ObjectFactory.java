
package marketplaceservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the marketplaceservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Beli_QNAME = new QName("http://MarketplaceService/", "beli");
    private final static QName _BeliResponse_QNAME = new QName("http://MarketplaceService/", "beliResponse");
    private final static QName _Produkmu_QNAME = new QName("http://MarketplaceService/", "produkmu");
    private final static QName _ProdukmuResponse_QNAME = new QName("http://MarketplaceService/", "produkmuResponse");
    private final static QName _Sale_QNAME = new QName("http://MarketplaceService/", "sale");
    private final static QName _SaleResponse_QNAME = new QName("http://MarketplaceService/", "saleResponse");
    private final static QName _Viewproduct_QNAME = new QName("http://MarketplaceService/", "viewproduct");
    private final static QName _ViewproductResponse_QNAME = new QName("http://MarketplaceService/", "viewproductResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: marketplaceservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Beli }
     * 
     */
    public Beli createBeli() {
        return new Beli();
    }

    /**
     * Create an instance of {@link BeliResponse }
     * 
     */
    public BeliResponse createBeliResponse() {
        return new BeliResponse();
    }

    /**
     * Create an instance of {@link Produkmu }
     * 
     */
    public Produkmu createProdukmu() {
        return new Produkmu();
    }

    /**
     * Create an instance of {@link ProdukmuResponse }
     * 
     */
    public ProdukmuResponse createProdukmuResponse() {
        return new ProdukmuResponse();
    }

    /**
     * Create an instance of {@link Sale }
     * 
     */
    public Sale createSale() {
        return new Sale();
    }

    /**
     * Create an instance of {@link SaleResponse }
     * 
     */
    public SaleResponse createSaleResponse() {
        return new SaleResponse();
    }

    /**
     * Create an instance of {@link Viewproduct }
     * 
     */
    public Viewproduct createViewproduct() {
        return new Viewproduct();
    }

    /**
     * Create an instance of {@link ViewproductResponse }
     * 
     */
    public ViewproductResponse createViewproductResponse() {
        return new ViewproductResponse();
    }

    /**
     * Create an instance of {@link Yourproduct }
     * 
     */
    public Yourproduct createYourproduct() {
        return new Yourproduct();
    }

    /**
     * Create an instance of {@link Produk }
     * 
     */
    public Produk createProduk() {
        return new Produk();
    }

    /**
     * Create an instance of {@link Buy }
     * 
     */
    public Buy createBuy() {
        return new Buy();
    }

    /**
     * Create an instance of {@link Sales }
     * 
     */
    public Sales createSales() {
        return new Sales();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Beli }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MarketplaceService/", name = "beli")
    public JAXBElement<Beli> createBeli(Beli value) {
        return new JAXBElement<Beli>(_Beli_QNAME, Beli.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BeliResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MarketplaceService/", name = "beliResponse")
    public JAXBElement<BeliResponse> createBeliResponse(BeliResponse value) {
        return new JAXBElement<BeliResponse>(_BeliResponse_QNAME, BeliResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Produkmu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MarketplaceService/", name = "produkmu")
    public JAXBElement<Produkmu> createProdukmu(Produkmu value) {
        return new JAXBElement<Produkmu>(_Produkmu_QNAME, Produkmu.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProdukmuResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MarketplaceService/", name = "produkmuResponse")
    public JAXBElement<ProdukmuResponse> createProdukmuResponse(ProdukmuResponse value) {
        return new JAXBElement<ProdukmuResponse>(_ProdukmuResponse_QNAME, ProdukmuResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sale }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MarketplaceService/", name = "sale")
    public JAXBElement<Sale> createSale(Sale value) {
        return new JAXBElement<Sale>(_Sale_QNAME, Sale.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MarketplaceService/", name = "saleResponse")
    public JAXBElement<SaleResponse> createSaleResponse(SaleResponse value) {
        return new JAXBElement<SaleResponse>(_SaleResponse_QNAME, SaleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Viewproduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MarketplaceService/", name = "viewproduct")
    public JAXBElement<Viewproduct> createViewproduct(Viewproduct value) {
        return new JAXBElement<Viewproduct>(_Viewproduct_QNAME, Viewproduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewproductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://MarketplaceService/", name = "viewproductResponse")
    public JAXBElement<ViewproductResponse> createViewproductResponse(ViewproductResponse value) {
        return new JAXBElement<ViewproductResponse>(_ViewproductResponse_QNAME, ViewproductResponse.class, null, value);
    }

}
