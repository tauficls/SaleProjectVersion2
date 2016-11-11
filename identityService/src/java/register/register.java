/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import login.access;
import login.updateTable;
import org.json.simple.JSONObject;

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
           {
        String full = request.getParameter("fullname");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String address = request.getParameter("address");
        String postal = request.getParameter("postal");
        String number = request.getParameter("number");
        String user = request.getParameter("username");
        JSONObject receive = new JSONObject();
        
        access connect = new access (user, pass);
        if (!connect.isAuthenticateUser()) {
            addUser addNew = new addUser(full, email, pass, address, Integer.parseInt(postal), Integer.parseInt(number), user);
            addNew.addNewUser();
            String token = connect.getToken();
            updateTable update = new updateTable();
            update.updateToken(addNew.getIdUser(), token);
            receive.put("status", "ok");
            receive.put("idUser", addNew.getIdUser());
            receive.put("token", token);
            System.out.println("ok");
        }
        else {
            receive.put("status", "error");
            System.out.println("error");
        }
        System.out.println("ss");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        System.out.println("dd");
        out.print(receive);
        out.close();
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

}
