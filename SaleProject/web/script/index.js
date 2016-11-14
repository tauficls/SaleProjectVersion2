function validateUsername() {
	var username = document.getElementById("username");
	if (username.value == "")
	{
		document.getElementById("alertUsername").innerHTML = "Silahkan mengisi username/email anda";
		username.style.borderColor = "#FF9494";
	} else {
		document.getElementById("alertUsername").innerHTML = "";
		username.style.borderColor = "#12c1d6";
	}
}

function validatePassword() {
	var password = document.getElementById("password");
	if (password.value == "")
	{
		document.getElementById("alertPassword").innerHTML = "Silahkan mengisi password anda";
		password.style.borderColor = "#FF9494";
	} else {
		document.getElementById("alertPassword").innerHTML = "";
		password.style.borderColor = "#12c1d6";
	}
}

function validateForm() {
	var password = document.getElementById("password");
	var username = document.getElementById("username");

	if (password.value == "") {
		if (username.value == "") {
			validateUsername();
			validatePassword();
			return false;
		}
		else {
			validatePassword();
			return false;
		}
	}
	else {
		if (username.value == "") {
			validateUsername();
			return false;
		}
		else {
			return true;
		}
	}
		
}