var para = document.getElementById("id4711");
para.textContent = "Hello from JavaScript";
  fetch("http://localhost:8080/personen.json")
 	
// 	fetch("personen.json")
 		.then( irgendwas => irgendwas.json() )
 		.then(myjson => console.log(myjson.Personen[0])); 