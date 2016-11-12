/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import ConnectDB.ConnectDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

/**
 *
 * @author Asus
 */
public class validateToken extends HttpServlet {

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
        String token = request.getParameter("token");
        String idUser = request.getParameter("idUser");
        System.out.println("pisang" + idUser);
        String dateTime = "";
        Boolean authenticate = false;
        JSONObject response_data = new JSONObject();
        
        //Connect Databases
        String query = "select * from user where idUser = \"" + idUser + "\" and token = \"" + token + "\"";
        try{  
            ConnectDB connectdb = new ConnectDB();
            Connection con = connectdb.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery(query);  
            if(rs.next()) {
                authenticate = true;
                dateTime = rs.getString("expire_date");
            }
            con.close();  
        }
        catch(Exception e){ 
            System.out.println(e);
        }
        
        //Validate Token
        if (authenticate) {
            Date now = new Date ();
            DateFormat date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
            response_data.put("is_token", "true");
            Date expDate;
            try {
                expDate = date_format.parse(dateTime);
                if(now.before(expDate)) {
                    response_data.put("is_expire", "false");
                }
                else {
                    response_data.put("is_expire", "true");
                }
            } catch (ParseException ex) {
                Logger.getLogger(validateToken.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else {
            response_data.put("is_token", "false");
            response_data.put("is_expire", "false");
        }
        
        //Response
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(response_data);
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
