var comidas = (function(){
	
	var user ;
	
	var insertComida = function(){
		user = sessionStorage.getItem('User');		
		var adicional = check();
				
		var gusto = {"descripciongusto": check(),"tipgusto":3,"usuario": user};
		
		apiComida.addComidas(gusto);
	}
	var check = function(){
		var adicional= "";
		var checkedHamb = document.getElementById("Hamburguesa").checked;
		var checkedEnsal = document.getElementById("Ensalada").checked;
		var checkedPizza = document.getElementById("Pizza").checked;
		var checkedCommar = document.getElementById("Comidademar").checked;
		var checkedhot = document.getElementById("HotDog").checked;
		var checkedTacos = document.getElementById("Tacos").checked;
		var checkedTorTL = document.getElementById("Tortatresleches").checked;
		var checkedMilhoja = document.getElementById("Milhoja").checked;
		var checkedBrazo = document.getElementById("BrazodeReina").checked;
		var checkedCho = document.getElementById("Chocolate").checked;
		var checkedChee = document.getElementById("Cheesecake").checked;
		var checkedMer = document.getElementById("Merengon").checked;
		
		
		if (checkedHamb){adicional = adicional + "," + "Hambuerguesa";}
		if (checkedEnsal){adicional = adicional + "," + "Ensalada";}
		if (checkedPizza){adicional = adicional + "," + "Pizza";}
		if (checkedCommar){adicional = adicional + "," + "Comidademar";}
		if (checkedhot){adicional = adicional + "," + "HotDog";}
		if (checkedTacos){adicional = adicional + "," + "Tacos";}
		if (checkedTorTL){adicional = adicional + "," + "Tortatresleches";}
		if (checkedMilhoja){adicional = adicional + "," + "Rap";}
		if (checkedBrazo){adicional = adicional + "," + "BrazodeReina";}
		if (checkedCho){adicional = adicional + "," + "Chocolate";}
		if (checkedChee){adicional = adicional + "," + "Cheesecake";}
		if (checkedMer){adicional = adicional + "," + "Merengon";}
		
		
		return adicional;
	}	
	
	return {
		
		insertarGusComida : insertComida
		
	}
	
})(); 


