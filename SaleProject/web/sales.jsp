<%-- 
    Document   : sales
    Created on : Nov 12, 2016, 7:10:27 PM
    Author     : taufic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style/katalog.css" rel="stylesheet" type="text/css"/>
        <title>Sales</title>
    </head>
    <body>
        <div id="wrapper">
            <jsp:include page="header.jsp" />
            <div class="center">
                <h1>Here are your sales</h1>
            </div>
            <hr />
            <br>
    <%
    try {    
	marketplaceservice.MarketplacceService service = new marketplaceservice.MarketplacceService();
	marketplaceservice.MarketplaceService port = service.getMarketplaceServicePort();
	 // TODO initialize WS operation arguments here
	String idUser = session.getAttribute("idUser").toString();
	// TODO process result here
        out.println(idUser);
	java.util.List<marketplaceservice.Sales> result = port.sale(idUser);
        out.println(result.size());
        if (result.size() > 0) {
        for (int i = 0; i < result.size(); i++) {
                out.println("<div>");
                out.println("<b> " + result.get(i).getDate() + "</b> <br>");
                out.println("at" + result.get(i).getTime());
                out.println("</div>");
                out.println("<hr>");
                out.println("<div class=\"mime_content_type(filename)t\">");                                
                out.println("<div class=\"image\">");                                        
                out.println("<img src=\"" + result.get(i).getImagepath() + "\" />");                                                
                out.println("</div>");                                        
                out.println("<div class=\"description\">");
                out.println("<b>" + result.get(i).getNamabarang() + "</b><br>");                                        
                out.println("IDR&nbsp;" + result.get(i).getHargabarang()+ "<br>");                                                
                out.println(result.get(i).getJumlahbeli() + "&nbsp;pcs <br>");                                                
                out.println(" @IDR " + result.get(i).getHargabarang() + " <br><br>");           
                out.println("<p>bought by <b>" + result.get(i).getNamapembeli()+ " </b> </p>");
                out.println("</div>");                                        
                out.println("<div class =\"interaction\">");
                out.println("Delivery to <b>" + result.get(i).getNamapenerima() + "</b> <br>");      
                //alamat belum                     
                out.println(result.get(i).getKodepos() + "<br>");
                out.println(result.get(i).getNotelp() + "<br>");                    
                out.println("</div>");
                out.println("<div style = \"clear:both\"></div>");
                out.println("</div>");
            }
        } else {
            out.println("No One buy from you. <br> Yet...");
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
            </div>
    </body>
</html>