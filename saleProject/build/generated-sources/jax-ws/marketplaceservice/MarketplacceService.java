
package marketplaceservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MarketplacceService", targetNamespace = "http://MarketplaceService/", wsdlLocation = "http://localhost:23132/MarketplacceService/MarketplaceService?wsdl")
public class MarketplacceService
    extends Service
{

    private final static URL MARKETPLACCESERVICE_WSDL_LOCATION;
    private final static WebServiceException MARKETPLACCESERVICE_EXCEPTION;
    private final static QName MARKETPLACCESERVICE_QNAME = new QName("http://MarketplaceService/", "MarketplacceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:23132/MarketplacceService/MarketplaceService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MARKETPLACCESERVICE_WSDL_LOCATION = url;
        MARKETPLACCESERVICE_EXCEPTION = e;
    }

    public MarketplacceService() {
        super(__getWsdlLocation(), MARKETPLACCESERVICE_QNAME);
    }

    public MarketplacceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MARKETPLACCESERVICE_QNAME, features);
    }

    public MarketplacceService(URL wsdlLocation) {
        super(wsdlLocation, MARKETPLACCESERVICE_QNAME);
    }

    public MarketplacceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MARKETPLACCESERVICE_QNAME, features);
    }

    public MarketplacceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MarketplacceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MarketplaceService
     */
    @WebEndpoint(name = "MarketplaceServicePort")
    public MarketplaceService getMarketplaceServicePort() {
        return super.getPort(new QName("http://MarketplaceService/", "MarketplaceServicePort"), MarketplaceService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MarketplaceService
     */
    @WebEndpoint(name = "MarketplaceServicePort")
    public MarketplaceService getMarketplaceServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://MarketplaceService/", "MarketplaceServicePort"), MarketplaceService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MARKETPLACCESERVICE_EXCEPTION!= null) {
            throw MARKETPLACCESERVICE_EXCEPTION;
        }
        return MARKETPLACCESERVICE_WSDL_LOCATION;
    }

}
