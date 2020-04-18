/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var interes = (function(){
	
	var user ;
	
	var insertInteres = function(){
		user = sessionStorage.getItem('User');		
		var adicional = check();
				
		var intereses = {"sexoInteres": document.getElementById("genInteres").value,
				"apectosImportantes": check(),"tipoRel": document.getElementById("Tiprelacion").value,
				"usuario": user};
		apiIntereses.addInteres(intereses);
	}
	var check = function(){
		var adicional;
		var checkedDeportes = document.getElementById("Deporte").checked;
		var checkedLectura = document.getElementById("lectura").checked;
		var checkedBaile = document.getElementById("baile").checked;
		var checkedMascotas = document.getElementById("mascotas").checked;
		var checkedCine = document.getElementById("cine").checked;
		var checkedTeatro = document.getElementById("Teatro").checked;
		var checkedvideoj = document.getElementById("videojuegos").checked;
		var checkedArte = document.getElementById("arte").checked;
		var checkedFiestas = document.getElementById("fiestas").checked;
		
		if (checkedDeportes){adicional = adicional + "," + "deportes";}
		if (checkedLectura){adicional = adicional + "," + "lectura";}
		if (checkedBaile){adicional = adicional + "," + "baile";}
		if (checkedMascotas){adicional = adicional + "," + "mascotas";}
		if (checkedCine){adicional = adicional + "," + "cine";}
		if (checkedTeatro){adicional = adicional + "," + "teatro";}
		if (checkedvideoj){adicional = adicional + "," + "videojuegos";}
		if (checkedArte){adicional = adicional + "," + "arte";}
		if (checkedFiestas){adicional = adicional + "," + "fiestas";}
		
		alert("adicional:  " + adicional);
		
		return adicional;
	}	
	
	return {
		
		insertarInteres : insertInteres
		
	}
	
})(); 
