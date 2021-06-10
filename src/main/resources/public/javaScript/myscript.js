var para = document.getElementById("id4711");
para.textContent = "Hello from JavaScript";

//  fetch("http://localhost:8080/personen.json");


// var cell = document.getElementById("IdSabine");

//	fetch("personen.json")
//		.then( irgendwas => irgendwas.json() )
//		.then(myjson => console.log(myjson.personen[0].vorname));


// json einlesen
function getJson(irgendwas) { 	// irgendwas beinhaltet json mit allen kommunikations-metadaten 
	return irgendwas.json();	// irgendwas.json ist der rheine json-inhalt
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
			+ `<td> ${laufvariable.anrede} </td>`		// formatierte Form der eingebundenen Strings
			+ "<td>" + laufvariable.vorname + "</td>"	// Strings einbinden mit +
			+ "<td>" + laufvariable.nachname + "</td>"
			+ "</tr>")
		//		document.getElementById("id003").textContent = laufvariable.anrede;
		//		document.getElementById("id001").textContent = laufvariable.vorname;
		//		document.getElementById("id002").textContent = laufvariable.nachname;
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
}

fetch("personen.json")
	.then(getJson) 								//  entspricht: .then( irgendwas => irgendwas.json() ) 
	.then(getTxtFromJsonUndPackInsHTML) 		// entpricht: cell.textContent = myjson.personen[0].vorname);
