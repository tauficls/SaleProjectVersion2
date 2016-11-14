<%-- 
    Document   : confirmpurchase
    Created on : Nov 13, 2016, 9:35:37 AM
    Author     : Innocent
--%>

<%@page import="java.util.logging.Logger"%>
<%@page import="org.json.simple.parser.ParseException"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="IdentityService.loginConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    
    <%
    JSONObject receive = new JSONObject();
    marketplaceservice.Confirm result = new marketplaceservice.Confirm();
    try {
	marketplaceservice.MarketplacceService service = new marketplaceservice.MarketplacceService();
	marketplaceservice.MarketplaceService port = service.getMarketplaceServicePort();
        
        java.lang.String idUser = session.getAttribute("idUser").toString();
        java.lang.String idKatalog = request.getParameter("idKatalog");
         
	// TODO process result here
	result = port.preProcessConfirm(idUser, idKatalog);
	out.println("Result = "+result);
        
        loginConnector loginRequest = new loginConnector("confirmPurchase");
        receive = new JSONObject();
        
         try {
            loginRequest.confirmPurchaseData(session.getAttribute("idUser").toString());
            receive = loginRequest.getData();
        } catch (ParseException ex) {
            out.println(ex.getMessage());
        }
        
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    
<!DOCTYPE html>
<html>    
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width,initial-scale=1.0" name="viewport">
        <title>Confirmation Purchase</title>
        <link rel="stylesheet" type="text/css" href="style/stylePurchase.css">
        <link href="https://fonts.googleapis.com/css?family=Lato:300" rel="stylesheet"> 
        <script>    
            <%@include file="script/confirmPurchase.js"%>
        </script>
    </head>
    <body>
       <div id="wrapper">
            <jsp:include page="header.jsp" />       
            <h1>Please Confirm your Purchase</h1>
            <hr />
            <br>
            <form action="confirmationPurchase" method="POST" id="formConfirm" onsubmit="return clicked()">
                <div class="left">
                    Product &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : <% out.print(result.getNamabarang()); %><br>
                    <div class="left">Price</div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :&nbsp;<% out.print(result.getHargabarang()); %><br>
                    <div class="left"> Quantity &nbsp;&nbsp;&nbsp; : &nbsp;</div>
                            <div class="input-list style-1 clearfix"><input type="text" name="quantity" id="quantity" value=1 onfocus="if(this.value=='1') this.value='';" onblur="calculatePrice(<?php echo $hargaBarang;)" required>
                            </div>
                            <div class="left">pcs</div><br>
                            <div style="clear: both;"></div>

                    <div class="left">Total Price &nbsp;:&nbsp;IDR&nbsp;</div> 
                            <div id="totalPrice"></div><br>
                    Delivery to :<br>
                </div>

                <div style="clear: both;"></div>
                <div class="space"></div>
                <label>Consignee</label>
                <div class="input-list style-2 clearfix"><input type="text" name="consignee" id="consignee" value= "<% out.print(receive.get("namaLengkap"));%>" onblur="return ValidationFullName()" onfocus="if(this.value==<% out.print(receive.get("namaLengkap"));%>) this.value='';" required><div id = "alertConsignee" class="red"></div></div>


                <div class="space"></div>
                <label> Full Address </label>
                <div class="input-list style-3 clearfix"><textarea name="fullAddrress" cols="50" rows="4" onblur="return ValidationAddress()" onfocus="if(this.value==<% out.print(receive.get("alamat"));%>) this.value='';" style="resize: none;" required><% out.print(receive.get("alamat"));%></textarea><div id = "alertAddress" class="red"></div></div>

                <div class="space"></div>
                <label>Postal Code</label>
                <div class="input-list style-2 clearfix"><input type="text" name="postalCode" id="postalCode" value="<% out.print(receive.get("kodepos"));%>" onblur="return ValidationPostal()" onkeypress="return keyPressAlphabetLock(event)" onfocus="if(this.value==<% out.print(receive.get("kodepos"));%>) this.value='';" required><div id = "alertPostal" class="red"></div></div>

                <div class="space"></div>
                <label>Phone Number</label>
                <div class="input-list style-2 clearfix"><input type="text" name="phoneNumber" id="phoneNumber" value="<% out.print(receive.get("noTelp"));%>" onblur="return ValidationNumber()" onkeypress="return keyPressAlphabetLock(event)" onfocus="if(this.value==<% out.print(receive.get("noTelp"));%>) this.value='';" required><div id = "alertNumber" class="red"></div></div>

                <div class="space"></div>
                <label>12 Digits Credit Card Number</label>
                <div class="input-list style-2 clearfix"><input type="text" name="numCard" id="numCard" placeholder="input your credit card number" onblur="return cardNumValidate()" required></div>
                <div id="numCardValidate" class="red"></div>

                <div class="space"></div>
                <label>3 Digits Card  Validation Value</label>
                <div class="input-list style-2 clearfix"><input type="text" name="valCard" id="valCard" placeholder="input 3 digit code behind your card" onblur="return cardValidationVal()" required></div>
                <div id="cardValValidation" class="red"></div>
                
                <input type="hidden" name="idKatalog" id="idKatalog" value="<% out.print(request.getParameter("idKatalog"));%>">

                <button class="btnCancel" type="reset" onclick="location.href='viewKatalog.php?idUser=<?php echo $idUser_int?>';" value="view katalog"/">Cancel</button>
                <button class="btnSubmit" type="submit" onclick="return ValidationForm()">Confirm</button>
                <p></p>

            </form>
            </div>
    </body>
</html>

