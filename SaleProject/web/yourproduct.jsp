
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
            <jsp:include page="header.jsp" />
            <h1>What are you going to sell today?</h1>
            <hr />
            <br><br>


             <%
                try{
                marketplaceservice.MarketplacceService service = new marketplaceservice.MarketplacceService();
                marketplaceservice.MarketplaceService port = service.getMarketplaceServicePort();
                String idUser = session.getAttribute("idUser").toString();
                // TODO process result here
                java.util.List<marketplaceservice.Yourproduct> result = port.productmu(idUser);
                for (int i = 0; i < result.size(); i++) {
                    out.println("<div>");
                    out.println("<b> " + result.get(i).getDate() + " </b> <br>");
                    out.println("at " + result.get(i).getTime());
                    out.println("</div>");
                    out.println("<hr>");
                    out.println("<div class =\"content\">");
                    out.println("<div class=\"image\">");
                    out.println("<img src=\"img\\"+ result.get(i).getImagepath() + "\" />");
                    out.println("</div>");
                    out.println("<div class=\"description\">");
                    out.println("<div class=\"head\"><b>"+ result.get(i).getNamabarang() +" </b><br></div>");
                    out.println("IDR " + result.get(i).getHargabarang());
                    out.println("<p>"+ result.get(i).getDeskripsi() +" </p>");
                    out.println("</div>");
                    out.println("<div class =\"interaction\">");
                    out.println("<br>");
                    out.println(result.get(i).getJumlahlike() + "likes <br>");
                    out.println(result.get(i).getJumlahbeli() +" purchases <br> <br>");
                    out.println("<a class=\"three\" href=\"editproduct.jsp" + result.get(i).getIdKatalog() + "\">EDIT</a> &nbsp;&nbsp;&nbsp; ");
                    out.println("<a onclick='return AreYouSure()' class=\"four\" href=\"\">DELETE</a>");
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
