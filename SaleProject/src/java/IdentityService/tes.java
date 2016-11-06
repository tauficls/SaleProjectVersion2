/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IdentityService;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:identity
 * [/IdentityService]<br>
 * USAGE:
 * <pre>
 *        tes client = new tes();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Asus
 */
public class tes {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/SaleProject/webresources";

    public tes() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("IdentityService");
    }
    
    public String hello() throws ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED).post(null, String.class);
    }

    public void close() {
        client.close();
    }
}
