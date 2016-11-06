/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IdentityService;

import java.io.IOException;
import javax.jws.WebService;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Asus
 */
@Path("/IdentityService")
@WebService(serviceName = "identity")
public class identity {

    /**
     * This is a sample web service operation
     */
    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public String validate(@FormParam("username") String user, @FormParam("password") String pass) throws IOException {
        access connect = new access (user, pass);
        
        if (connect.isAuthenticate()) {
            return "monyet";
        }
        else {
            return "pisang";
        }
    }
}
