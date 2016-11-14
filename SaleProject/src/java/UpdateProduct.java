/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import marketplaceservice.InvalidTokenException;
import marketplaceservice.MarketplacceService;

/**
 *
 * @author Innocent
 */
public class UpdateProduct extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_37177/MarketplacceService/MarketplaceService.wsdl")
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

            
            String nama_barang = request.getParameter("NamaBarang");
            int harga_barang = Integer.parseInt(request.getParameter("HargaBarang"));
            String deskripsi = request.getParameter("Deskripsi");
            int idKatalog = Integer.parseInt(request.getParameter("idKatalog"));
            
            HttpSession session = request.getSession();
            java.lang.String idUserValidate = session.getAttribute("idUser").toString();
            java.lang.String token = session.getAttribute("token").toString();
            try{
                updateProduct(nama_barang, harga_barang,deskripsi, idKatalog, idUserValidate, token);
                response.sendRedirect("/viewKatalog.jsp");
            } catch(Exception e){
               response.sendRedirect("/logout");
            }
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

    private void updateProduct(String namaBarang, int hargaBarang, String deskripsi, int idKatalog, String idUserValidate, String token)
    throws Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        marketplaceservice.MarketplaceService port = service.getMarketplaceServicePort();
        try{
            port.updateProduct(namaBarang, hargaBarang, deskripsi, idKatalog, idUserValidate, token);
        }
        catch(Exception e){
            if(e.getMessage().equals("Invalid Token")){
                throw e;
            }
        }
        
    }

}
