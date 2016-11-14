function ValidationForm() {
	var next = false;
	var xnext = true;
	if (ValidationFullName()) {
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
	if (cardNumValidate()) {
		next = true;
	} else {
		xnext = false;
	}
	if (cardValidationVal()) {
		next = true;
	} else {
		xnext = false;
	}
	if (cardValValidation()) {
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
	var name = document.confirmPurchase.consignee;
	if (name.value == "")
	{
		document.getElementById("alertConsignee").innerHTML = "Silahkan mengisi nama lengkap anda";
		name.style.borderColor = "hotpink";
		return false;
	} else {
		document.getElementById("alertConsignee").innerHTML = "";
		name.style.borderColor = "#000000";
		return true;
	}
}
function ValidationAddress() {
	var address = document.confirmPurchase.fullAddrress;
	if (address.value == "") 
	{
		document.getElementById("alertAddress").innerHTML = "Silahkan mengisi address anda";
		address.style.borderColor = "hotpink";
		return false;
	} else {
		document.getElementById("alertAddress").innerHTML = "";
		address.style.borderColor = "#000000";
		return true;
	}
}
function ValidationPostal() {
	var postal = document.confirmPurchase.postalCode;
	if (postal.value == "") {
		document.getElementById("alertPostal").innerHTML = "Silahkan mengisi kembali postal anda";
		postal.style.borderColor = "hotpink";
		return false;
	} else {
		document.getElementById("alertPostal").innerHTML = "";
		postal.style.borderColor = "#000000";
		return true;
	}
}

function ValidationNumber() {
	var number = document.confirmPurchase.phoneNumber;
	if (number.value == "") 
	{
		document.getElementById("alertNumber").innerHTML = "Silahkan mengisi no telp anda";
		number.style.borderColor = "hotpink";
		return false;
	} else {
		document.getElementById("alertNumber").innerHTML = "";
		number.style.borderColor = "#000000";
		return true;
	}
	
}


function cardNumValidate() {
	var cardNum,text;

	cardNum = document.getElementById("numCard");
	if (isNaN(cardNum.value)) {
        text = "Input must a number";
        cardNum.value = "";
    } 
    else {
    	if (cardNum.value.length < 12) {
        	text = "Your card number less than 12 digits";
        	cardNum.value = "";
        }
        else if (cardNum.value.length > 12) {
        	text = "Your card number more than 12 digits";
        	cardNum.value = "";
        }
        else {
        	text = "";
        }
    }
    document.getElementById("numCardValidate").innerHTML = text;
}


function cardValidationVal() {
	var cardVal,text;

	cardVal = document.getElementById("valCard");
	if (isNaN(cardVal.value)) {
        text = "Input must a number";
        cardVal.value = "";
    } 
    else {
    	if (cardVal.value.length < 3) {
        	text = "Your card number less than 3 digits";
        	cardVal.value = "";
        }
        else if (cardVal.value.length > 3) {
        	text = "Your card number more than 3 digits";
        	cardVal.value = "";
        }
        else {
        	text = "";
        }
    }
    document.getElementById("cardValValidation").innerHTML = text;
}
Number.prototype.formatMoney = function(c, d, t) {
	var n = this, 
	    c = isNaN(c = Math.abs(c)) ? 2 : c, 
	    d = d == undefined ? "." : d, 
	    t = t == undefined ? "," : t, 
	    s = n < 0 ? "-" : "", 
	    i = String(parseInt(n = Math.abs(Number(n) || 0).toFixed(c))), 
	    j = (j = i.length) > 3 ? j % 3 : 0;
	   return s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t) + (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
 };

function calculatePrice(x) {
	var quantity, price, sum;

	quantity = parseInt(document.getElementById("quantity").value);
	price = x;

	sum = quantity*price;

	document.getElementById("totalPrice").innerHTML = sum;
}

function clicked() {
	var text;
	if (confirm('Do you want to buy?') == true) {		
		return true;
	} else {
	   return false;
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
