/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delete;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import marketplaceservice.MarketplacceService;

/**
 *
 * @author taufic
 */
public class deleteProduct extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_23132/MarketplacceService/MarketplaceService.wsdl")
    private MarketplacceService service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String status = "";
        HttpSession session = request.getSession();
        java.lang.String idUserValidate = session.getAttribute("idUser").toString();
        java.lang.String token = session.getAttribute("token").toString();
        try{
            status = deleteProduk(request.getParameter("idUser"), request.getParameter("idKatalog"), idUserValidate, token);
            response.sendRedirect("/viewKatalog.jsp");
        } catch(Exception e){
            String nextJSP = "/logout";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
        }
       
        if("ok".equals(status)){
            response.sendRedirect("/saleProject/yourproduct.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String deleteProduk(String idUser, String idKatalog, String idUserValidate, String token) throws Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        marketplaceservice.MarketplaceService port = service.getMarketplaceServicePort();
        try{
            return port.deleteProduk(idUser, idKatalog, idUserValidate, token);
            
        }
        catch(Exception e){
            if(e.getMessage().equals("Invalid Token")){
                throw e;
            }
        }
        return "";
    }

}
