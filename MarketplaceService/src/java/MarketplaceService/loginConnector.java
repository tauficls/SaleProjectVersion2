package IdentityService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class loginConnector {
    private String serviceName;
    private JSONObject processData;
    private byte[] data;
    
    public loginConnector(String servletName) {
        serviceName = servletName;
    }
    
    public void sendData () throws IOException, ParseException {
        String urlName = "http://localhost:6765/identityService/" + serviceName;
        URL url;
        HttpURLConnection connection = null;  
        
        try {
            //Create connection
            url = new URL(urlName);
            connection = (HttpURLConnection)url.openConnection();
            //add request header
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            connection.setUseCaches(false);
            connection.setAllowUserInteraction(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            
            //Send Request
            try (OutputStream out = connection.getOutputStream()){
                out.write(data);
                out.close();
            }
            
            //Start Connection
            connection.connect();
            //Recieve Response
            StringBuilder sb = new StringBuilder();
            BufferedReader rd = new BufferedReader (new InputStreamReader(connection.getInputStream()));
            String line;
            while((line = rd.readLine()) != null) {
                sb.append(line);
            }
            
            connection.disconnect();
            processData = (JSONObject) new JSONParser().parse(sb.toString());
        }
        catch (IOException e) {
            
        } 
    }
    
    public void validateLogin(String username, String password) throws IOException, ParseException {
        String utf8 = java.nio.charset.StandardCharsets.UTF_8.name();
        String query = "";

        try {
            query = String.format("username=%s&password=%s", URLEncoder.encode(username, utf8), URLEncoder.encode(password, utf8));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(loginConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        data = query.getBytes();
        sendData();
    }
    
    public void validateToken (String token, String idUser) throws IOException, ParseException {
        String utf8 = java.nio.charset.StandardCharsets.UTF_8.name();
        String query = "";

        try {
            query = String.format("token=%s&idUser=%s", URLEncoder.encode(token, utf8), URLEncoder.encode(idUser, utf8));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(loginConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        data = query.getBytes();
        sendData();
    }
    
    public void validateRegister (String fullname, String email, String password, String address, String postal, String number, String username) throws IOException, ParseException {
        String utf8 = java.nio.charset.StandardCharsets.UTF_8.name();
        String query = "";

        try {
            query = String.format("fullname=%s&email=%s&password=%s&address=%s&postal=%s&number=%s&username=%s", URLEncoder.encode(fullname, utf8), URLEncoder.encode(email, utf8), URLEncoder.encode(password, utf8), URLEncoder.encode(address, utf8), URLEncoder.encode(postal, utf8), URLEncoder.encode(number, utf8), URLEncoder.encode(username, utf8));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(loginConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        data = query.getBytes();
        sendData();
    }
    
    public JSONObject getData() {
        return processData;
    }
}
