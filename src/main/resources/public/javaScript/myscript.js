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

function oninputclick(event) {
	event.preventDefault(); // verhindert das std.verhalten des Browsers - GET 
	console.log("click");

	var vorname = document.getElementById("vorname").value;
	console.log(vorname);
	var nachname = document.getElementById("nachname").value;
	console.log(nachname);
	var anrede = document.getElementById("anrede").value;
	console.log(anrede);
	var jsondata = `{"vorname": "${vorname}","nachname": "${nachname}","anrede": "${anrede}"}`;
	console.log(jsondata);

	fetch("http://localhost:8080/json/person", {
		method: 'POST', // or 'PUT' or beim Lesen 'GET'; method muss sein
		body: jsondata,
		headers: {
			'Content-Type': 'application/json'
		}
	});

}


var input = document.getElementById("button");
input.addEventListener("click", oninputclick);

fetch("http://localhost:8080/json/persons/all")
	.then(getJson)
	.then(getTxtFromJsonUndPackInsHTML)



