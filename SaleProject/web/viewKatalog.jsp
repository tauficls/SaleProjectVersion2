<%-- 
    Document   : viewKatalog
    Created on : Nov 7, 2016, 10:21:25 AM
    Author     : Asus
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta content="width=device-width,initial-scale=1.0" name="viewport">
    <title>View Katalog</title>
    <link rel="stylesheet" type="text/css" href="style/katalog.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:300" rel="stylesheet"> 
    <script type="text/javascript" src="viewKatalog.js"></script>
</head>
    <body>
    <div id="wrapper">
            <jsp:include page="header.jsp" />
            <h1>What are you going to sell today?</h1>
            <hr />
            <form  method="get" action="" id="formFilter" enctype="multipart/form-data">
                    <div class="input-list style-1">
                            <input type="text"	name="search" placeholder="Search Catalog ...">
                            <button class="btnSubmit" type="submit" form="formFilter" value ="submit">Go</button> <br>
                    </div>
                    <br>
                    by
                    <div class="left">
                            <input type="radio" name="filter" value ="product" checked>product<br>
                            <input type="radio" name="filter" value="store">store<br>
                    </div>
            </form>


            <%
            try {
                marketplaceservice.MarketplacceService service = new marketplaceservice.MarketplacceService();
                marketplaceservice.MarketplaceService port = service.getMarketplaceServicePort();
                 // TODO initialize WS operation arguments here
                java.lang.String username = "";
                java.lang.String password = "";
                java.lang.String search = "";
                java.lang.String filter = "";
                java.lang.String idUser = session.getAttribute("idUser").toString();
                java.lang.String token = session.getAttribute("token").toString();
                if (request.getParameter("search") != null){
                    search = request.getParameter("search");
                    filter = request.getParameter("filter");
                    
                }
                
                // TODO process result here
                
                java.util.List<marketplaceservice.Product> result = port.viewproduct(username, password, search, filter, idUser, idUser, token);
                String usernama;
                String img_path;
                String nama_barang;
                long harga_barang;
                String deskripsi;
                long jumlah_like;
                long jumlah_beli;

                for (int i = 0; i < result.size(); i++) {
                    //out.println(result.get(i).getUsernama() + "<br>" + result.get(i).getImgpath());
                    out.println("<div>");
                    out.println("<b>" + result.get(i).getUsernama() + "</b> <br>");
                    out.println("added this on " + result.get(i).getDate() + "at" + result.get(i).getTime() );
                    out.println("</div>");
                    out.println("<hr>");
                    out.println("<div class=\"content\">");
                    out.println("<div class=\"image\">");
                    out.println("<img src=\"img\\" + result.get(i).getImgpath()+"\" />");
                    out.println("</div>");
                    out.println("<div class=\"description\">");
                    out.println("<div class=\"head\"><b>" + result.get(i).getNamabarang() + " </b><br></div>");
                    out.println("IDR " + result.get(i).getHargabarang() + "");
                    out.println("<p>" + result.get(i).getDeskripsi() + "</p>");
                    out.println("</div>");
                    out.println("<div class =\"interaction\">");
                    out.println("<br>");
                    out.println("<span id=\"like$idKatalog\">" + result.get(i).getJumlahlike() +"</span> likes <br>");
                    out.println(result.get(i).getJumlahbeli() + " purchases <br> <br>");
                    if(result.get(i).isIsLiked()) {
                        out.println("<a class=\"two\" href=\"unlike?idKatalog=" + result.get(i).getIdKatalog() +"&idUser=" + session.getAttribute("idUser").toString() + "\">DISLIKE</a>");
                    }
                    else {
                        out.println("<a class=\"one\" href=\"like?idKatalog=" + result.get(i).getIdKatalog() +"&idUser=" + session.getAttribute("idUser").toString() + "\">LIKE</a>");
                    }
                    out.println("</div>");
                    out.println("<div style = \"clear:both\"></div>");
                    out.println("<hr>");
                    out.println("<br>");
                    out.println("</div>");
                }
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
            %>
    </div>
           
    </body>
</html>

