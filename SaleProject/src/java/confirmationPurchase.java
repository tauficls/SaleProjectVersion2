/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import marketplaceservice.MarketplacceService;

/**
 *
 * @author Innocent
 */
public class confirmationPurchase extends HttpServlet {

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
        HttpSession session = request.getSession();
        String idKatalog = request.getParameter("idKatalog");
        String idUser = session.getAttribute("idUser").toString();
        java.lang.String jumlahbeli = request.getParameter("quantity");
        java.lang.String namaPenerima = request.getParameter("consignee");
        java.lang.String alamatPenerima  = request.getParameter("fullAddrress");
        java.lang.String kodeposPenerima = request.getParameter("postalCode");
        java.lang.String noTelpPenerima = request.getParameter("phoneNumber");
        java.lang.String kartuKredit = request.getParameter("numCard");
        java.lang.String kodeValidasi = request.getParameter("valCard");
        
        confirmpurchase(idKatalog, idUser, idUser, session.getAttribute("token").toString(),  jumlahbeli, namaPenerima, alamatPenerima, kodeposPenerima, noTelpPenerima, kartuKredit, kodeValidasi, idKatalog, namaPenerima);
        
        response.sendRedirect("/saleProject/purchase.jsp");
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

    private java.util.List<marketplaceservice.Confirm> confirmpurchase(java.lang.String idKatalog, java.lang.String iduser, java.lang.String iduservalidate, java.lang.String token, java.lang.String jumlahBeli, java.lang.String namaPenerima, java.lang.String alamatPenerima, java.lang.String kodeposPenerima, java.lang.String noTelpPenerima, java.lang.String kartuKredit, java.lang.String kodeValidasi, java.lang.String hargaBarang, java.lang.String namaBarang) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        marketplaceservice.MarketplaceService port = service.getMarketplaceServicePort();
        return port.confirmpurchase(idKatalog, iduser, iduservalidate, token, jumlahBeli, namaPenerima, alamatPenerima, kodeposPenerima, noTelpPenerima, kartuKredit, kodeValidasi, hargaBarang, namaBarang);
    }

}
