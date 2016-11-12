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
        
            <jsp:include page="header.jsp" />
            <h1>What are you going to sell today?</h1>
            <hr />
            <form  method="post" id="formFilter" enctype="multipart/form-data">
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
                // TODO process result here
                java.util.List<marketplaceservice.Produk> result = port.viewproduct(username, password);
                out.println("Result = "+ result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
            %>


        
    </body>
</html>

