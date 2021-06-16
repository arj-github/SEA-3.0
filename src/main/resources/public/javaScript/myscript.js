// json einlesen
function getJson(irgendwas) {
	return irgendwas.json();
}

// Json-kommt vom Server und wird im Browser ausgegeben
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

function resetForm() {
	document.getElementById("form").reset();
}

function resetTable() {
	var tb = document.querySelectorAll('td');
	console.log(tb);
  	for (var i = 0; i < tb.length; i++) {
		tb[i].parentNode.removeChild(tb[i]);
    }
}


// Aus dem Browser lesen und auf dem Server "posten"
function oninputclick(event) {
	event.preventDefault(); // verhindert das std.verhalten des Browsers - GET 
	console.log("click");

	var id = document.getElementById("id").value;
	var vorname = document.getElementById("vorname").value;
	var nachname = document.getElementById("nachname").value;
	var anrede = document.getElementById("anrede").value;
	
	var jsondata = `{"id": "${id}","vorname": "${vorname}","nachname": "${nachname}","anrede": "${anrede}"}`;

	fetch("http://localhost:8080/json/person", {
		method: 'POST', // or 'PUT' or beim Lesen 'GET'; method muss sein
		body: jsondata,
		headers: {
			'Content-Type': 'application/json'
		}
	});

}



function ondelete(event) {
	event.preventDefault(); // verhindert das std.verhalten des Browsers - GET 
	
	var id = document.getElementById("id").value;
		
	fetch(`http://localhost:8080/json/person/${id}`, {
		method: 'DELETE'
	});

}

function onupdate(event) {
	event.preventDefault(); // verhindert das std.verhalten des Browsers - GET 
	
	var id = document.getElementById("id").value;
	var vorname = document.getElementById("vorname").value;
	var nachname = document.getElementById("nachname").value;
	var anrede = document.getElementById("anrede").value;
	
	var jsondata = `{"id": "${id}","vorname": "${vorname}","nachname": "${nachname}","anrede": "${anrede}"}`;

	fetch("http://localhost:8080/json/person/", {
		method: 'PUT', // or 'PUT' or beim Lesen 'GET'; method muss sein
		body: jsondata,
		headers: {
			'Content-Type': 'application/json'
		}
	});

}

function onrefresh(event) {
	resetTable();
	getAllPersons();

}

var input = document.getElementById("button");
input.addEventListener("click", oninputclick);

var input = document.getElementById("deletebutton");
input.addEventListener("click", ondelete);

var input = document.getElementById("refreshbutton");
input.addEventListener("click", onrefresh);

var input = document.getElementById("updatebutton");
input.addEventListener("click", onupdate);

function getAllPersons(){
fetch("http://localhost:8080/json/persons/all")
	.then(getJson)
	.then(getTxtFromJsonUndPackInsHTML);
	resetForm();
}


getAllPersons();
