/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import IdentityService.access;
import IdentityService.loginConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Asus
 */
public class register extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        String full = request.getParameter("fullname");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String address = request.getParameter("address");
        String postal = request.getParameter("postal");
        String number = request.getParameter("number");
        String user = request.getParameter("username");
        JSONObject receive = new JSONObject();
        
        loginConnector loginRequest = new loginConnector("register");
        loginRequest.validateRegister(full,email,pass,address,postal,number,user);
        receive = loginRequest.getData();
        
        String status = (String) receive.get("status");
        HttpSession session = request.getSession();
        
        if ("ok".equals(status)) {
            long idUser = (long) receive.get("idUser");
            String token = (String) receive.get("token");
            session.setAttribute("message", status);  
            session.setAttribute("token", token);  
            session.setAttribute("idUser", idUser);  
            System.out.println("pisang monyet");
            response.sendRedirect("/saleProject/viewKatalog.jsp");
        }
        else {
            session.setAttribute("message", status);  
            System.out.println("sungguh mederita");
            response.sendRedirect("/saleProject/register.jsp");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
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

}
