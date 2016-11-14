<%-- 
    Document   : editProduct
    Created on : Nov 13, 2016, 5:01:21 AM
    Author     : Innocent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
		<meta content="width=device-width,initial-scale=1.0" name="viewport">
		<title>Add Product</title>
		<link rel="stylesheet" type="text/css" href="style/katalog.css">
		<link href="https://fonts.googleapis.com/css?family=Lato:300" rel="stylesheet">
		<script type = "text/javascript" src="EditProduct.js"></script> 
    </head>
    <body>    <%-- start web service invocation --%><hr/>
        <%
       int idKatalog = -1;
        marketplaceservice.Yourproduct hasil = null;
        try {
            marketplaceservice.MarketplacceService service = new marketplaceservice.MarketplacceService();
            marketplaceservice.MarketplaceService port = service.getMarketplaceServicePort();
             // TODO initialize WS operation arguments here
            String temp = session.getAttribute("idUser").toString();
            int idUser = Integer.parseInt(temp);
            idKatalog = Integer.parseInt(request.getParameter("idKatalog"));
            System.out.println(idUser + " " +idKatalog);
            // TODO process hasil here
            java.lang.String idUserValidate = session.getAttribute("idUser").toString();
            java.lang.String token = session.getAttribute("token").toString();
                
            hasil = port.editProduct(idUser, idKatalog, idUserValidate, token);
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        %>

        <div id="wrapper">
        <form  name="AddProductForm" method="post" action="UpdateProduct" id="formBarang"  onsubmit="return ValidationFormTanpaImage()">
                <label> Name </label>
                <div style="clear: both;"></div>
                <div class="input-list style-2 clearfix"><input type="text" name="NamaBarang" value="<%=hasil.getNamabarang()%>" onblur="return ValidationName(this.form.NamaBarang)">
                <div id ="alertName"></div>
                <br>
                
                <input type="hidden" name="idKatalog" value="<%=idKatalog%>">
                <label> Deskripsi </label>
                <div style="clear: both;"></div>
                <div class="input-list style-3 clearfix"><textarea name="Deskripsi" cols="50" rows="4" style="resize: none;" onkeydown="return LimitationText(this.form.Deskripsi)"onblur="return ValidationDeskripsi(this.form.Deskripsi)"><%= hasil.getDeskripsi() %></textarea>
                <div id="alertDeskripsi"></div>
                <br>
                <label> Price(IDR) </label>
                <div style="clear: both;"></div>
                <div class="input-list style-2 clearfix"><input type="text" name="HargaBarang" value="<%=hasil.getHargabarang()%>" onkeypress="return keyPressAlphabetLock(event, this.form.HargaBarang)" onblur="return ValidationPrice(this.form.HargaBarang)">
                <div id="alertPrice"></div>
                <br>
                <label> Photo </label>
                <div style="clear: both;"></div>
                <div class="input-list style-2 clearfix"><input type="button" name="GambarBarang" id="GambarBarang" disabled value="Choose File">
                <div id="alertFile"></div>
                
                <div style="clear: both;"></div>	
                <div class="top"></div>
                			
                <button class="btnSubmit" type="submit" form="formBarang" value="Submit">Update</button>	
        </form>
        </div>
        
                
        

        
    </body>
</html>
