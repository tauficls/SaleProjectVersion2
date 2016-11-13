import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import marketplaceservice.MarketplacceService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
*
* 
 */
public class Upload extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_37177/MarketplacceService/MarketplaceService.wsdl")
    private MarketplacceService service;
    private final String UPLOAD_DIRECTORY = "D:\\Semester 5\\wbd\\TugasBesar2\\TugasBesar2_JavaAndWebService\\SaleProject\\web\\img\\";
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String  nama_barang = null;
        int     harga_barang = -1;
        String  deskripsi = null;
        int     idUser = -1;
        String image = null;
                        
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                int count = 0;
                DiskFileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload servletUpload = new ServletFileUpload( factory);
                List multiparts = null;
                try{
                    multiparts = servletUpload.parseRequest(request);
                }
                catch(Exception ex) {
                    System.out.println("Masuk 4" + ex);
                    request.setAttribute("message", "File Upload Failed due to " + ex);
                }          
                Iterator it = multiparts.iterator();
                while(it.hasNext()){
                    
                    
                        FileItem item = (FileItem)it.next();
                    if(item.getFieldName().equals("GambarBarang")){
                        String name = new File(item.getName()).getName();
                        String mimeType = getServletContext().getMimeType(name);
                        if (mimeType.startsWith("image/")) {
                            image = java.util.UUID.randomUUID().toString();
                            String temp = UPLOAD_DIRECTORY + image;
                            item.write( new File(temp));
                            count++;


                        }
                    }
                    else{
                        
                        System.out.println("HAHA" + item.getFieldName() + " " + item.getString());
                   
                        if("NamaBarang".equals(item.getFieldName()))
                            nama_barang = item.getString();
                        else if("HargaBarang".equals(item.getFieldName()))
                            harga_barang = Integer.parseInt(item.getString());
                        else if("Deskripsi".equals(item.getFieldName()))
                            deskripsi = item.getString();
                        else if("idUser".equals(item.getFieldName())){
                            idUser = Integer.parseInt(item.getString());
                        }
                    }
                    
                }
                
               if(count == 0){
                   
                   request.setAttribute("message", "No File Uploaded");
               }
               else{
                //File uploaded successfully
                    HttpSession session = request.getSession();
                    java.lang.String idUserValidate = session.getAttribute("idUser").toString();
                    java.lang.String token = session.getAttribute("token").toString();
                    try{
                        addProduct(nama_barang,harga_barang, deskripsi, idUser, image, idUserValidate, token);  
                    } catch(Exception e){
                        String nextJSP = "/logout";
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                        dispatcher.forward(request,response);
                    }
                    
                    request.getRequestDispatcher("/yourproduct.jsp").forward(request, response);
               }
               
            } catch (Exception ex) {
                System.out.println("Masuk 3" + ex);
                request.setAttribute("message", "File Upload Failed due to " + ex);
                request.getRequestDispatcher("/AddProduct.jsp").forward(request, response);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
            response.sendRedirect("/index.jsp");
        }
    
        
     
    }

    private void addProduct(String namaBarang, int hargaBarang, String deskripsi, int idUser, String image, String idUserValidate, String token) throws Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        marketplaceservice.MarketplaceService port = service.getMarketplaceServicePort();
        try{
            port.addProduct(namaBarang, hargaBarang, deskripsi, idUser, image,idUserValidate, token);
        }
        catch(Exception e){
            if(e.getMessage().equals("Invalid Token")){
                throw e;
            }
        }
    }


  
}