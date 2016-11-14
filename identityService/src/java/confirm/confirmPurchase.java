/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confirm;

import ConnectDB.ConnectDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author Innocent
 */
public class confirmPurchase extends HttpServlet {

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
        String query = "select * from user where idUser = \"" + request.getParameter("idUser") + "\"";
        JSONObject js = new JSONObject();
        
        try{  
            ConnectDB connectdb = new ConnectDB();
            Connection con = connectdb.getConnection();
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery(query);  
            if(rs.next()) {
                js.put("namaLengkap", rs.getString("namaLengkap"));
                js.put("kodepos",rs.getString("kodepos_user"));
                js.put("noTelp",rs.getString("noTelp_user"));
                js.put("alamat", rs.getString("alamat_user"));
                System.out.println(rs.getString("namaLengkap") + "pisang ");
            }
            con.close();  
        }
        catch(Exception e){ 
            System.out.println(e);
        }
        
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(js);
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
