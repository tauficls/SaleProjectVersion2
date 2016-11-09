<%-- 
    Document   : register
    Created on : Nov 7, 2016, 10:36:41 AM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Register</title>
	<script type = "text/javascript" src="Register.js"></script>
	<link rel="stylesheet" type="text/css" href="style/style.css">
</head>

<body id="wrapper">
	<div class="heading">
		<img src="img/logo.png" width= ="60" height="60">
	</div>	
	<div class = "content">
		<div class="bold">Please Register</div>
		<hr />
		<form id = "Register" name="Registers" onsubmit="return ValidationForm()" method ="post" action="\saleProject\identityService">
			<div class="input-list style-1 clearfix">
				Full Name
				<input type = "text" name = "fullname" onblur="return ValidationFullName()"><div id = "alertFullName" class="red"></div>
				<br>

				Username
				<input type = "text" name = "username" onblur="return ValidationUserName()"><div id = "alertUserName" class="red"><?php if($isUsernameExist) echo 'Username has already taken!'?></div>
				<br>
				
				Email
				<input type = "text" name = "email" onblur="return ValidationEmail()"><div id = "alertEmail" class="red"><?php if($isEmailExist) echo 'Email has already used!'?></div>
				<br>

				Password
				<input type = "password" name = "password" onblur="return ValidationPassword()"><div id = "alertPassword" class="red"></div> 			
				<br>

				Confirm Password
				<input type = "password" name = "confirm" onblur="return ValidationConfirm()"><div id = "alertConfirm" class="red"></div> 
				<br>

				Full Address
				<input type = "text" name = "address" onblur="return ValidationAddress()"><div id = "alertAddress" class="red"></div>
				<br>

				Postal Code
				<input type = "text" name = "postal" onblur="return ValidationPostal()" onkeydown="return LimitationText(6, this.form.postal)" onkeypress="return keyPressAlphabetLock(event)"><div id = "alertPostal" class="red"></div>
				<br>

				Phone Number
				<input type = "text" name = "number" onblur="return ValidationNumber();" onkeypress="return keyPressAlphabetLock(event);" onkeydown="return LimitationText(13, this.form.number);"><div id = "alertNumber" class="red"></div>
				<br>

				<button type = "submit" form="Register" value="Register" class="btnSubmit">
					Register
				</button>
			</div>
		</form>

	</div>
	<div class="register">
		Already registered? Login <a href ="index.php" class="one">here</a>
	</div>	
</body>

