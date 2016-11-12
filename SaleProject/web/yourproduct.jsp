<%-- 
    Document   : yourproduct
    Created on : Nov 12, 2016, 4:04:48 PM
    Author     : taufic
--%>

<%@page import="marketplaceservice.Time"%>
<%@page import="marketplaceservice.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style/katalog.css" rel="stylesheet" type="text/css"/>
        <title>Your Product</title>
    </head>
    <body>
        <div id="wrapper">
            
            <h1>What are you going to sell today?</h1>
            <hr />
            <br><br>
                <%-- start web service invocation --%><hr/>
    <%
    try {
	marketplaceservice.MarketplacceService service = new marketplaceservice.MarketplacceService();
	marketplaceservice.MarketplaceService port = service.getMarketplaceServicePort();
	 // TODO initialize WS operation arguments here
	java.lang.String username = "";
	java.lang.String password = "";
	// TODO process result here
	java.util.List<marketplaceservice.Yourproduct> result = port.productmu(username, password);
	out.println("Result = "+result);
        for (int i = 0; i < result.size(); i++) {
            int idKatalog;
            String namabarang;
            double hargabarang;
            String deskripsi;
            int jumlahlike;
            int jumlahbeli;
            Date date;
            Time time;
            out.println("<div>");
                                                        <b> ".date('l, j F Y', strtotime($date))." </b> <br>
                                                        at ".date("H:i", strtotime($time))."
            out.println("</div>");
            out.println("<hr>")                                    <hr>
                                                <div class=\"content\">
                                                        <div class=\"image\">
                                                                <img src=\"".$image_path."\" />
                                                        </div>

                                                        <div class=\"description\">
                                                                <div class=\"head\"><b>".$nama_barang." </b><br></div>
                                                                        IDR ". number_format($harga_barang, 0)."
                                                                <p>".$deskripsi." </p>

                                                        </div>

                                                        <div class =\"interaction\">
                                                                <br>
                                                                ".$jumlah_like." likes <br>
                                                                ".$jumlah_beli." purchases <br> <br>
                                                                <a class=\"three\" href=\"EditProduct.php?idUser=".$idUser_int."&idKatalog=".$idKatalog."\">EDIT</a> &nbsp;&nbsp;&nbsp; 
                                                                <a onclick='return AreYouSure()' class=\"four\" href=\"YourProduct.php?idKatalog=".$idKatalog."&idUser=".$idUser_int."\">DELETE</a>
                                                        </div>
                                                        <div style = \"clear:both\"></div>
                                                        <hr>
                                                        <br>
                                                </div>
                                                 ";


                                }

                        }
                ?>



    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>


        </div>
    </body>
</html>
