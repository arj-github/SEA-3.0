// json einlesen
function getJson(irgendwas) {  
	return irgendwas.json();
}

// celle ersetzen
function getTxtFromJsonUndPackInsHTML(myjson) {
	var tabelle = document.getElementById("tid001");
	var i = 0;
	for (var laufvariable of myjson.personen) {
		// neue Zeile am Ende der exist. Tabelle anfügen
		tabelle.insertAdjacentHTML("beforeend",
			"<tr>"
			+ `<td> ${++i} </td>`
			+ `<td><img src= ${getIcon(laufvariable.anrede)} ></td>`
			+ `<td> ${laufvariable.anrede} </td>`
			+ "<td>" + laufvariable.vorname + "</td>"
			+ "<td>" + laufvariable.nachname + "</td>"
			+ "</tr>")
	}
}

function getIcon(anrede) {
	switch (anrede) {
		case "Herr":
			return 'images/man.png'
		case "Frau":
			return 'images/woman.png'
		default:
			return 'images/woman.png'
	}
}

function oninputclick(event){
	event.preventDefault(); // verhindert das std.verhalten des Browsers - GET 
	console.log("click");
	
	var vorname = document.getElementById("vorname").value;
	console.log(vorname);
	var nachname = document.getElementById("nachname").value;
	console.log(nachname);
	var anrede = document.getElementById("anrede").value;
	console.log(anrede);
	
}

var input = document.getElementById("button");

input.addEventListener("click", oninputclick);

fetch("personen.json")
	.then(getJson) 
	.then(getTxtFromJsonUndPackInsHTML)


/*function getQueryVariable(variable) {
	var query = window.location.search.substring(1);
	console.log("Query anzeigen: " + query);  //fname=FN&lname=LN&salut=ST
	var vars = query.split("&");              //  trennung nach &
	for (var i = 0; i < vars.length; i++) {   //  fname=FN    lname=LN   salut=ST
		var pair = vars[i].split("=");        //  trennung nach = 
		console.log("Vars i: " + vars[i]);    //  fname=FN    lname=LN   salut=ST
		console.log("pair: " + pair[0]);      // fname
		console.log("pair: " + pair[1]);      // FN
		if (pair[0] == variable) { return pair[1]; }
	}
	return (false);
}*/



