var para = document.getElementById("id4711");
para.textContent = "Hello from JavaScript";

//  fetch("http://localhost:8080/personen.json");


// var cell = document.getElementById("IdSabine");

//	fetch("personen.json")
//		.then( irgendwas => irgendwas.json() )
//		.then(myjson => console.log(myjson.personen[0].vorname));


// json einlesen
function getJson(irgendwas) {
	return irgendwas.json();
}

// celle ersetzen
function getTxtFromJsonUndPackInsHTML(myjson) {
	var cell_vorname = document.getElementById("id001");
	cell_vorname.textContent = myjson.personen[0].vorname;
	var cell_nachname = document.getElementById("id002");
	cell_nachname.textContent = myjson.personen[0].nachname;
	document.getElementById("id003").textContent =myjson.personen[0].anrede; 
}

fetch("personen.json")
	.then(getJson) 								//  entspricht: .then( irgendwas => irgendwas.json() ) 
	.then(getTxtFromJsonUndPackInsHTML) 		// entpricht: cell.textContent = myjson.personen[0].vorname);
