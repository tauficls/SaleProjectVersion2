<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta content="width=device-width,initial-scale=1.0" name="viewport">
		<title>Add Product</title>
		<link rel="stylesheet" type="text/css" href="style/katalog.css">
		<link href="https://fonts.googleapis.com/css?family=Lato:300" rel="stylesheet">
		<script type = "text/javascript" src="AddProduct.js"></script> 
	</head>

	<body>
		<div id="wrapper">

                    
                        

			<h1> Please add your product here</h1>
				<hr />
				<br><br>
				<form  action="Upload" name="AddProductForm" method="post" id="formBarang" enctype="multipart/form-data"  onsubmit="return ValidationForm()">
                                         <label> Name </label>
					<div style="clear: both;"></div>
					<div class="input-list style-2 clearfix"><input type="text" name="NamaBarang" onblur="return ValidationName(this.form.NamaBarang)"></div>
					<div id="alertName" class="red"></div>
					<br>
					<label> Deskipsi </label>
					<div style="clear: both;"></div>
					<div class="input-list style-3 clearfix"><textarea name="Deskripsi" cols="50" rows="4" style="resize: none;" onkeydown="return LimitationText(this.form.Deskripsi)" onblur="return ValidationDeskripsi(this.form.Deskripsi)"></textarea></div>
					<div style="clear: both;"></div>
					<div id="alertDeskripsi" class="red"></div>
					<br>
                                        <input type="hidden" name="idUser" value="<%=session.getAttribute("idUser")%>">
					
					<label> Price(IDR) </label>
					<div class="input-list style-2 clearfix"><input type="text" name="HargaBarang" onkeypress="return keyPressAlphabetLock(event, this.form.HargaBarang)" onblur="return ValidationPrice(this.form.HargaBarang)"></div>
					<div id="alertPrice" class="red"></div>
					<br>
					<label> Photo </label>
					<div style="clear: both;"></div>
					<input type="file" name="GambarBarang" id="GambarBarang"  >
					<div id="alertFile" class="red"></div>
					<br>
					<div style="clear: both;"></div>	
                                       
				</form>
				
				<div class="top"></div>
				<button class="btnCancel" type="reset" form="formBarang" value="reset" onclick="window.location.replace('YourProduct.php')">CANCEL</button>
				<button class="btnSubmit" type="submit" form="formBarang" value="Submit" >ADD</button>
                                
                                <b><%=session.getAttribute("message")%> </b>
		</div>
	</body>
</html>