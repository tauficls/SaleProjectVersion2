function ValidationForm() {
	var next = false;
	var xnext = true;
	if (ValidationFullName()) {
		next = true;
	} else {
		xnext = false;
	}
	if (ValidationUserName()) {
		next = true;
	} else {
		xnext = false;
	}
	if (ValidationEmail()) {
		next = true;
	} else {
		xnext = false;
	}
	if (ValidationPassword()) {
		next = true;
	} else {
		xnext = false;
	}
	if (ValidationConfirm()) {
		next = true;
	} else {
		xnext = false;
	}
	if (ValidationAddress()) {
		next = true;
	} else {
		xnext = false;
	}
	if (ValidationPostal()) {
		next = true;
	} else {
		xnext = false;
	}
	if (ValidationNumber()) {
		next = true;
	} else {
		xnext = false;
	}
	if (next && !xnext) {
		return xnext;
	} else {
		return next;
	}
}

	
function ValidationFullName() {
	var name = document.Registers.fullname;
	if (name.value == "")
	{
		document.getElementById("alertFullName").innerHTML = "Silahkan mengisi nama lengkap anda";
		name.style.borderColor = "hotpink";
		return false;
	} else {
		document.getElementById("alertFullName").innerHTML = "";
		name.style.borderColor = "#000000";
		return true;
	}
}

function ValidationUserName() {
	var user = document.Registers.username;
	if (user.value == "") {
		document.getElementById("alertUserName").innerHTML = "Silahkan mengisi username";
		user.style.borderColor = "hotpink";
		return false;
	} else if (user.value.indexOf(" ") > 0) {
		document.getElementById("alertUserName").innerHTML = "Tidak boleh menggunakan spasi";
		user.style.borderColor = "hotpink";
		//user.focus();
		return false;
	} else {
		document.getElementById("alertUserName").innerHTML = "";
		user.style.borderColor = "#000000";
		return true;
	}
}

function ValidationEmail() {
	var email = document.Registers.email;
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if (!filter.test(email.value))
	{
		document.getElementById("alertEmail").innerHTML = "Silahkan mengisi email anda dengan benar";
		email.style.borderColor = "hotpink";
		//email.focus();
		return false;
	} else {
		document.getElementById("alertEmail").innerHTML = "";
		email.style.borderColor = "#000000";
		return true;
	}
}

function ValidationPassword() {
	var pass = document.Registers.password;
	if (pass.value == "")
	{
		document.getElementById("alertPassword").innerHTML = "Silahkan mengisi password anda";
		pass.style.borderColor = "hotpink";
		return false;
	} else {
		document.getElementById("alertPassword").innerHTML = "";
		pass.style.borderColor = "#000000";
		return true;
	}
}

function ValidationConfirm() {
	var pass = document.Registers.password;
	var confirm = document.Registers.confirm;
	if (confirm.value == "") {
		document.getElementById("alertConfirm").innerHTML = "Silahkan konfiramsi password anda";
		confirm.style.borderColor = "hotpink";
		return false;
	} else if (pass.value != confirm.value) {
		document.getElementById("alertConfirm").innerHTML = "Silahkan konfirmasi kembali password anda dengan benar";
		confirm.style.borderColor = "hotpink";
		return false;
	} else {
		document.getElementById("alertConfirm").innerHTML = "";
		confirm.style.borderColor = "#000000";
		return true;
	}
	
}

function ValidationAddress() {
	var address = document.Registers.address;
	if (address.value == "") 
	{
		document.getElementById("alertAddress").innerHTML = "Silahkan mengisi address anda";
		address.style.borderColor = "hotpink";
		//address.focus();
		return false;
	} else {
		document.getElementById("alertAddress").innerHTML = "";
		address.style.borderColor = "#000000";
		return true;
	}
}

function ValidationPostal() {
	var postal = document.Registers.postal;
	if (postal.value == "") {
		document.getElementById("alertPostal").innerHTML = "Silahkan mengisi kembali postal anda";
		postal.style.borderColor = "hotpink";
		//postal.focus();
		return false;
	} else {
		document.getElementById("alertPostal").innerHTML = "";
		postal.style.borderColor = "#000000";
		return true;
	}
}

function ValidationNumber() {
	var number = document.Registers.number;
	if (number.value == "") 
	{
		document.getElementById("alertNumber").innerHTML = "Silahkan mengisi no telp anda";
		number.style.borderColor = "hotpink";
		//number.focus();
		return false;
	} else {
		document.getElementById("alertNumber").innerHTML = "";
		number.style.borderColor = "#000000";
		return true;
	}
	
}

function keyPressAlphabetLock(evt) {
	
	var key = evt.which ? evt.which : event.keyCode;

	
	if ((key > 64 && key < 91) || (key > 96 && key < 122)) {
		return false;
	} else {
		return true;
	}
}

function LimitationText(numlimit, field) {
	if (field.value.length > numlimit) {
		field.value = field.value.substring(0, numlimit);
	}
}
