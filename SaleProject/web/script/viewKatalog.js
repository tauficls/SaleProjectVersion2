function likeDislike(idUser,idKatalog){
	
	if(document.getElementById(idKatalog).innerHTML == "LIKE"){
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById(idKatalog).innerHTML = "LIKED";
				document.getElementById(idKatalog).style.color = "hotpink";
				var value = parseInt(document.getElementById('like'+idKatalog).innerHTML,10) + 1;
				document.getElementById('like'+idKatalog).innerHTML = value;
			}
		};
		xhttp.open("POST", "Addlike.php", true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send("idUser="+idUser+"&idKatalog="+idKatalog);
	}
	else{
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById(idKatalog).innerHTML = "LIKE";
				document.getElementById(idKatalog).style.color = "#4a86e8";
				var value = parseInt(document.getElementById('like'+idKatalog).innerHTML,10) - 1;
				document.getElementById('like'+idKatalog).innerHTML = value;
			}
		};
		xhttp.open("POST", "Dellike.php", true);
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhttp.send("idUser="+idUser+"&idKatalog="+idKatalog);
	}
	
}
