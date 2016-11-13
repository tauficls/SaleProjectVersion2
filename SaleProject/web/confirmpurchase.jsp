<%-- 
    Document   : confirmpurchase
    Created on : Nov 13, 2016, 9:35:37 AM
    Author     : Innocent
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style/style.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Lato:300" rel="stylesheet"> 
        <title>JSP Page</title>
    </head>
    <body>
       <div id="wrapper">
            <jsp:include page="header.jsp" />		
            <h1>Please Confirm your Purchase</h1>
            <hr />
            <br>
            <form action="" method="POST" id="formConfirm" onsubmit="return clicked()">
                <div class="left">
                    Product &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : <?php echo $namaBarang ?><br>
                    <div class="left">Price</div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :&nbsp;<?php echo $hargaBarang; ?><br>
                    <div class="left"> Quantity &nbsp;&nbsp;&nbsp; : &nbsp;</div>
                            <div class="input-list style-1 clearfix"><input type="text" name="quantity" id="quantity" value=1 onfocus="if(this.value=='1') this.value='';" onblur="calculatePrice(<?php echo $hargaBarang; ?>)" required>
                            </div>
                            <div class="left">pcs</div><br>
                            <div style="clear: both;"></div>

                    <div class="left">Total Price &nbsp;:&nbsp;IDR&nbsp;</div> 
                            <div id="totalPrice"><?php echo number_format($hargaBarang,0); ?></div><br>
                    Delevery to :<br>
                </div>

                <div style="clear: both;"></div>
                <div class="space"></div>
                <label>Consignee</label>
                <div class="input-list style-2 clearfix"><input type="text" name="consignee" id="consignee" value= "<?php echo $namaLengkap; ?>" onblur="return ValidationFullName()" onfocus="if(this.value==<?php echo "'$namaLengkap'"; ?>) this.value='';" required><div id = "alertConsignee" class="red"></div></div>


                <div class="space"></div>
                <label> Full Address </label>
                <div class="input-list style-3 clearfix"><textarea name="fullAddrress" cols="50" rows="4" onblur="return ValidationAddress()" onfocus="if(this.value==<?php echo "'$alamat'"; ?>) this.value='';" style="resize: none;" required><?php echo $alamat; ?></textarea><div id = "alertAddress" class="red"></div></div>

                <div class="space"></div>
                <label>Postal Code</label>
                <div class="input-list style-2 clearfix"><input type="text" name="postalCode" id="postalCode" value="<?php echo $kodepos; ?>" onblur="return ValidationPostal()" onkeypress="return keyPressAlphabetLock(event)" onfocus="if(this.value==<?php echo "'$kodepos'"; ?>) this.value='';" required><div id = "alertPostal" class="red"></div></div>

                <div class="space"></div>
                <label>Phone Number</label>
                <div class="input-list style-2 clearfix"><input type="text" name="phoneNumber" id="phoneNumber" value="<?php echo $noTelp; ?>" onblur="return ValidationNumber()" onkeypress="return keyPressAlphabetLock(event)" onfocus="if(this.value==<?php echo "'$noTelp'";?>) this.value='';" required><div id = "alertNumber" class="red"></div></div>

                <div class="space"></div>
                <label>12 Digits Credit Card Number</label>
                <div class="input-list style-2 clearfix"><input type="text" name="numCard" id="numCard" placeholder="input your credit card number" onblur="return cardNumValidate()" required></div>
                <div id="numCardValidate" class="red"></div>

                <div class="space"></div>
                <label>3 Digits Card  Validation Value</label>
                <div class="input-list style-2 clearfix"><input type="text" name="valCard" id="valCard" placeholder="input 3 digit code behind your card" onblur="return cardValidationVal()" required></div>
                <div id="cardValValidation" class="red"></div>

                <button class="btnCancel" type="reset" onclick="location.href='viewKatalog.php?idUser=<?php echo $idUser_int?>';" value="view katalog"/">Cancel</button>
                <button class="btnSubmit" type="submit" onclick="return ValidationForm()">Confirm</button>
                <p></p>

            </form>
            </div>
	</body>
</html>

