function ValidationForm() {
	var next = false;
	var xnext = true;
	var name = document.AddProductForm.NamaBarang;
	var deskripsi = document.AddProductForm.Deskripsi;
	var price = document.AddProductForm.HargaBarang;
	if (ValidationName(name)) {
		next = true;
	} else {
		xnext = false;
	}
	if (ValidationDeskripsi(deskripsi)) {
		next = true;
	} else {
		xnext = false;
	}
	if (ValidationPrice(price)) {
		next = true;
	} else {
		xnext = false;
	}
	if (ValidationImages()) {
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
function ValidationFormTanpaImage() {
	var next = false;
	var xnext = true;
	var name = document.AddProductForm.NamaBarang;
	var deskripsi = document.AddProductForm.Deskripsi;
	var price = document.AddProductForm.HargaBarang;
	if (ValidationName(name)) {
		next = true;
	} else {
		xnext = false;
	}
	if (ValidationDeskripsi(deskripsi)) {
		next = true;
	} else {
		xnext = false;
	}
	if (ValidationPrice(price)) {
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
function ValidationName(name) {
	if (name.value == "") {
		document.getElementById("alertName").innerHTML = "Silahkan mengisi nama barang";
		document.getElementById("alertName").style.color = "hotpink";
		name.style.borderColor = "hotpink";
		return false;
	} else {
		document.getElementById("alertName").innerHTML = "";
		name.style.borderColor = "#000000";
		return true;
	}
}

function ValidationDeskripsi(deskripsi) {
	if (deskripsi.value == "") {
		document.getElementById("alertDeskripsi").innerHTML = "Silahkan mengisi deskripsi barang";
		document.getElementById("alertDeskripsi").style.color = "hotpink";
		deskripsi.style.borderColor = "hotpink";
		return false;
	} else {
		document.getElementById("alertDeskripsi").innerHTML = "";
		deskripsi.style.borderColor = "#000000";
		return true;
	}
}

function ValidationPrice(price) {
	if (price.value == "") {
		document.getElementById("alertPrice").innerHTML = "Silahkan mengisi harga barangnya";
		document.getElementById("alertPrice").style.color = "hotpink";
		price.style.borderColor = "hotpink";
		return false;
	} else {
		document.getElementById("alertPrice").innerHTML = "";
		price.style.borderColor = "#000000";
		return true;
	}
}

function CleanError(name, deskripsi, price) {
	document.getElementById("alertName").innerHTML = "";
	document.getElementById("alertDeskripsi").innerHTML = "";
	document.getElementById("alertPrice").innerHTML = "";
	name.style.borderColor = "#000000";
	deskripsi.style.borderColor = "#000000";
	price.style.borderColor = "#000000";

}

function ValidationImages() {
	var image = document.AddProductForm.GambarBarang;
	var valid = false;
	var extension = [".jpg", ".jpeg", ".gif", ".bmp", ".png"];

	if (image.value.length > 0) {
		for (var i = 0;  i < extension.length; i++) {
			if (image.value.substr(image.value.length - extension[i].length, extension[i].length).toLowerCase()
				== extension[i].toLowerCase()) {
				valid = true;
			}
		}	
	}
	
	if (!valid) {
		document.getElementById("alertFile").innerHTML = "foto tersebut tidak valid";
		document.getElementById("alertFile").style.color = "hotpink";
		return false;
	} else {
		document.getElementById("alertFile").innerHTML = "";
		document.getElementById("alertFile").style.color = "#000000";
		return true;
	}

}

function LimitationText(field) {
	if (field.value.length > 200) {
		field.value = field.value.substring(0, 200);
		document.getElementById("alertDeskripsi").innerHTML = "deskripsi tidak boleh lebih dari 200";
	} else {
		document.getElementById("alertDeskripsi").innerHTML = "";
	}
	return true;
}

function keyPressAlphabetLock(evt, price) {
	var key = (evt.which) ? evt.which : event.keyCode;
	if ((key > 64 && key < 91) || (key > 96 && key < 122)) {
		document.getElementById("alertPrice").innerHTML = "silahkan masukan angka"
		document.getElementById("alertPrice").style.color = "hotpink";
		price.style.borderColor = "hotpink";
		return false;
	} else {
		document.getElementById("alertPrice").innerHTML = "";
		price.style.borderColor = "#000000";
		return true;
	}
}

