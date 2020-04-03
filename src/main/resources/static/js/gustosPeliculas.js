/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var peliculas = (function(){
	
	var user ;
	
	var insertPelicula = function(){
		user = sessionStorage.getItem('User');		
		var adicional = check();
				
		var gusto = {"descripciongusto": check(),"tipgusto":1,"usuario": user};
		
		apiPeliculas.addPeliculas(gusto);
	}
	var check = function(){
		var adicional= "";
		var checkedAccion = document.getElementById("Accion").checked;
		var checkedAventura = document.getElementById("Aventura").checked;
		var checkedComedia = document.getElementById("Comedia").checked;
		var checkedComRom = document.getElementById("ComediaRomantica").checked;
		var checkedDrama = document.getElementById("Drama").checked;
		var checkedMusicales = document.getElementById("Musicales").checked;
		var checkedCienciaFiccion = document.getElementById("CienciaFiccion").checked;
		var checkedInfantiles = document.getElementById("Infantiles").checked;
		var checkedDoc = document.getElementById("Documentales").checked;
		var checkedOtro = document.getElementById("Otros").checked;
		
		if (checkedAccion){adicional = adicional + "," + "Accion";}
		if (checkedAventura){adicional = adicional + "," + "Aventura";}
		if (checkedComedia){adicional = adicional + "," + "Comedia";}
		if (checkedComRom){adicional = adicional + "," + "Comedia Romantica";}
		if (checkedDrama){adicional = adicional + "," + "Drama";}
		if (checkedMusicales){adicional = adicional + "," + "Musicales";}
		if (checkedCienciaFiccion){adicional = adicional + "," + "Ciencia Ficcion";}
		if (checkedInfantiles){adicional = adicional + "," + "Infantiles";}
		if (checkedDoc){adicional = adicional + "," + "Documentales";}
		if (checkedOtro){adicional = adicional + "," + "Otro";}
		
		return adicional;
	}	
	
	return {
		
		insertarGusPeli : insertPelicula
		
	}
	
})(); 
