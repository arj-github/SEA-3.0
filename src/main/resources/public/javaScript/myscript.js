// json einlesen
function getJson(irgendwas) {
	return irgendwas.json();
}


// Json-kommt vom Server und wird im Browser ausgegeben
function getTxtFromJsonUndPackInsHTML(myjson) {
	var tabelle = document.getElementById("tbody1");
	for (var laufvariable of myjson.personen) {
		// neue Zeile am Ende der exist. Tabelle anfügen
		tabelle.insertAdjacentHTML("beforeend",
			"<tr>"
			+ `<td> ${laufvariable.id}  </td>`
			+ `<td><img src= ${getIcon(laufvariable.anrede)} ></td>`
			+ `<td> ${laufvariable.anrede} </td>`
			+ "<td>" + laufvariable.vorname + "</td>"
			+ "<td>" + laufvariable.nachname + "</td>"
			+ `<td> ${laufvariable.gebDatum} </td>`
			+ `<td> ${laufvariable.email} </td>`
			+ `<td> ${laufvariable.strasse} </td>`
			+ `<td> ${laufvariable.plz} </td>`
			+ `<td> ${laufvariable.ort} </td>`
			+ `<td> ${laufvariable.version} </td>`
			+ "</tr>"
		)
	}
}

function fillInForm(myjson) {
	var tabelle = document.getElementById("tbody1");
	for (var laufvariable of myjson.personen) {
		// neue Zeile am Ende der exist. Tabelle anfügen
		tabelle.insertAdjacentHTML("beforeend",
			"<tr>"
			+ `<td> ${laufvariable.id}  </td>`
			+ `<td><img src= ${getIcon(laufvariable.anrede)} ></td>`
			+ `<td> ${laufvariable.anrede} </td>`
			+ "<td>" + laufvariable.vorname + "</td>"
			+ "<td>" + laufvariable.nachname + "</td>"
			+ `<td> ${laufvariable.gebDatum} </td>`
			+ `<td> ${laufvariable.email} </td>`
			+ `<td> ${laufvariable.strasse} </td>`
			+ `<td> ${laufvariable.plz} </td>`
			+ `<td> ${laufvariable.ort} </td>`
			+ `<td> ${laufvariable.version} </td>`
			+ "</tr>"
		)	
			
		document.getElementById("id").value = `${laufvariable.id}`;
		document.getElementById("anrede").value = `${laufvariable.anrede}`;
		document.getElementById("vorname").value = `${laufvariable.vorname}`;
		document.getElementById("nachname").value = `${laufvariable.nachname}`;
		document.getElementById("gebDatum").value = `${laufvariable.gebDatum}`;
		document.getElementById("email").value = `${laufvariable.email}`;
		document.getElementById("strasse").value = `${laufvariable.strasse}`;
		document.getElementById("plz").value = `${laufvariable.plz}`;
		document.getElementById("ort").value = `${laufvariable.ort}`;
		document.getElementById("version").value = `${laufvariable.version}`;

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
	tb.innerHTML = "";

	// einem Element eine Class="invisible" hinzufügen
	var sizeElem = document.getElementById('sizeId');
	sizeElem.classList.add("invisible");

	getAllPersons();
}


// Aus dem Browser lesen und auf dem Server "posten"
function oninputclick(event) {
	event.preventDefault(); // verhindert das std.verhalten des Browsers - GET 

	var anrede = document.getElementById("anrede").value;
	var vorname = document.getElementById("vorname").value;
	var nachname = document.getElementById("nachname").value;
	var email = document.getElementById("email").value;
	var strasse = document.getElementById("strasse").value;
	var plz = document.getElementById("plz").value;
	var ort = document.getElementById("ort").value;
	var gebDatum = document.getElementById("gebDatum").value;
	var version = document.getElementById("version").value;

	var jsondata = `{	"anrede": "${anrede}",
						"vorname": "${vorname}",
						"nachname": "${nachname}",
						"gebDatum": "${gebDatum}",
						"email": "${email}",
						"strasse": "${strasse}",
						"plz": "${plz}",
						"ort": "${ort}",
						"version":"${version}"
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
	var gebDatum = document.getElementById("gebDatum").value;
	var email = document.getElementById("email").value;
	var strasse = document.getElementById("strasse").value;
	var plz = document.getElementById("plz").value;
	var ort = document.getElementById("ort").value;
	var version = document.getElementById("version").value;


	var jsondata = `{	"id": "${id}",
						"anrede": "${anrede}",
						"vorname": "${vorname}",
						"nachname": "${nachname}",
						"gebDatum": "${gebDatum}",
						"email": "${email}",
						"strasse": "${strasse}",
						"plz": "${plz}",
						"ort": "${ort}",
						"version": "${version}"
						}`;

	fetch("/json/person/update", {
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


function searchById(id) {

	// Treffer suchen und anzeigen ( hier nur 1 Treffer möglich)	
	fetch(`/json/person/search/${id}`, {
		method: 'GET',
	})

		// Tabellenansich neu aufbauen
		.then(getJson)
		.then(fillInForm);

}

function onsearchById(event) {
	event.preventDefault(); // verhindert das std.verhalten des Browsers - GET 

	var id = document.getElementById("id").value;

	// Tabellenansicht löschen
	var tb = document.getElementById("tbody1");
	tb.innerHTML = "";

	searchById(id);

}


function setInHTML(myjson) {
	var sizeElem = document.getElementById('sizeId');
	var sizetext = `Aktuelle Anzahl Personen: ${myjson.size} `;
	sizeElem.innerHTML = sizetext;
	sizeElem.classList.remove("invisible");

}

function onsize() {
	fetch(`/json/persons/size/`, {
		method: 'GET',
	})
		.then(getJson)
		.then(setInHTML);
}

var input = document.getElementById("button");
input.addEventListener("click", oninputclick);

var input = document.getElementById("deletebutton");
input.addEventListener("click", ondelete);

var input = document.getElementById("refreshbutton");
input.addEventListener("click", onrefresh);

var input = document.getElementById("updatebutton");
input.addEventListener("click", onupdate);

var input = document.getElementById("searchIdButton");
input.addEventListener("click", onsearchById);

var input = document.getElementById("groupSizeButton");
input.addEventListener("click", onsize);

function getAllPersons() {
	fetch("/json/persons/all")
		.then(getJson)
		.then(getTxtFromJsonUndPackInsHTML);
	resetForm();
}

getAllPersons();


