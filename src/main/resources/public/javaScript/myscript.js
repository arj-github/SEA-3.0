// json einlesen
function getJson(irgendwas) {
	return irgendwas.json();
}

// Json-kommt vom Server und wird im Browser ausgegeben
function getTxtFromJsonUndPackInsHTML(myjson) {
	var tabelle = document.getElementById("tbody1");
	var i = 0;
	for (var laufvariable of myjson.personen) {
		// neue Zeile am Ende der exist. Tabelle anfügen
		tabelle.insertAdjacentHTML("beforeend",
			"<tr>"
			+ `<td> ${laufvariable.id}  </td>`
			+ `<td><img src= ${getIcon(laufvariable.anrede)} ></td>`
			+ `<td> ${laufvariable.anrede} </td>`
			+ "<td>" + laufvariable.vorname + "</td>"
			+ "<td>" + laufvariable.nachname + "</td>"
			+ `<td> ${laufvariable.email} </td>`
			+ `<td> ${laufvariable.strasse} </td>`
			+ `<td> ${laufvariable.plz} </td>`
			+ `<td> ${laufvariable.ort} </td>`
			+ "</tr>"
)
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

function resetForm() {
	document.getElementById("form").reset();
}

function resetTable() {
	var tb = document.getElementById("tbody1");
	tb.innerHTML="";
	getAllPersons();
}


// Aus dem Browser lesen und auf dem Server "posten"
function oninputclick(event) {
	event.preventDefault(); // verhindert das std.verhalten des Browsers - GET 
	console.log("click");

	var anrede = document.getElementById("anrede").value;
	var id = document.getElementById("id").value;
	var vorname = document.getElementById("vorname").value;
	var nachname = document.getElementById("nachname").value;
	var email = document.getElementById("email").value;
	var strasse = document.getElementById("strasse").value;
	var plz = document.getElementById("plz").value;
	var ort = document.getElementById("ort").value;
	
	var jsondata = `{	"id": "${id}",
						"anrede": "${anrede}",
						"vorname": "${vorname}",
						"nachname": "${nachname}",
						"email": "${email}",
						"strasse": "${strasse}",
						"plz": "${plz}",
						"ort": "${ort}"
						}`;

	fetch("/json/person", {
		method: 'POST', // or 'PUT' or beim Lesen 'GET'; method muss sein
		body: jsondata,
		headers: {
			'Content-Type': 'application/json'
		}
	})
	.then(resetTable);

}



function ondelete(event) {
	event.preventDefault(); // verhindert das std.verhalten des Browsers - GET 
	
	var id = document.getElementById("id").value;
		
	fetch(`/json/person/${id}`, {
		method: 'DELETE'
	})
	.then(resetTable);

}

function onupdate(event) {
	event.preventDefault(); // verhindert das std.verhalten des Browsers - GET 
	
	var anrede = document.getElementById("anrede").value;
	var id = document.getElementById("id").value;
	var vorname = document.getElementById("vorname").value;
	var nachname = document.getElementById("nachname").value;
	var email = document.getElementById("email").value;
	var strasse = document.getElementById("strasse").value;
	var plz = document.getElementById("plz").value;
	var ort = document.getElementById("ort").value;
	
	var jsondata = `{	"id": "${id}",
						"anrede": "${anrede}",
						"vorname": "${vorname}",
						"nachname": "${nachname}",
						"email": "${email}",
						"strasse": "${strasse}",
						"plz": "${plz}",
						"ort": "${ort}"
						}`;
						
	fetch("/json/person/", {
		method: 'PUT', // or 'PUT' or beim Lesen 'GET'; method muss sein
		body: jsondata,
		headers: {
			'Content-Type': 'application/json'
		}
	})	
	.then(resetTable);

}

function onrefresh(event) {
	resetTable();
}

function ontestdaten(event) {
	event.preventDefault(); // verhindert das std.verhalten des Browsers - GET 
	
	fetch(`/json/person/testdaten`, {})
	.then(resetTable);

}

var input = document.getElementById("button");
input.addEventListener("click", oninputclick);

var input = document.getElementById("deletebutton");
input.addEventListener("click", ondelete);

var input = document.getElementById("refreshbutton");
input.addEventListener("click", onrefresh);

var input = document.getElementById("updatebutton");
input.addEventListener("click", onupdate);

var input = document.getElementById("datenbutton");
input.addEventListener("click", ontestdaten);

function getAllPersons(){
fetch("/json/persons/all")
	.then(getJson)
	.then(getTxtFromJsonUndPackInsHTML);
	resetForm();
}

getAllPersons();
