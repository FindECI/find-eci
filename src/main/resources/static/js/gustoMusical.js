var musicales = (function(){
	
	var user ;
	
	var insertMusica = function(){
		user = sessionStorage.getItem('User');		
		var adicional = check();
				
		var gusto = {"descripciongusto": check(),"tipgusto":2,"usuario": user};
		
		apiMusical.addMusicales(gusto);
	}
	var check = function(){
		var adicional= "";
		var checkedRock = document.getElementById("Rock").checked;
		var checkedMetal = document.getElementById("Metal").checked;
		var checkedBlues = document.getElementById("Blues").checked;
		var checkedJazz = document.getElementById("Jazz").checked;
		var checkedElectro = document.getElementById("Electronica").checked;
		var checkedDup = document.getElementById("Dup-step").checked;
		var checkedPunk = document.getElementById("Punk").checked;
		var checkedRap = document.getElementById("Rap").checked;
		var checkedClasica = document.getElementById("Clasica").checked;
		var checkedReg = document.getElementById("Reggaeton").checked;
		var checkedTrap = document.getElementById("Trap").checked;
		var checkedSalsa = document.getElementById("Salsa").checked;
		var checkedMeren = document.getElementById("Merengue").checked;
		var checkedBach = document.getElementById("Bachata").checked;
		var checkedPop = document.getElementById("Pop").checked;
		var checkedVall = document.getElementById("Vallenato").checked;
		var checkedDance = document.getElementById("Dancehall").checked;
		var checkedHouse = document.getElementById("House").checked;
		var checkedOtro = document.getElementById("Otro").checked;
		
		if (checkedRock){adicional = adicional + "," + "Rock";}
		if (checkedMetal){adicional = adicional + "," + "Metal";}
		if (checkedBlues){adicional = adicional + "," + "Blues";}
		if (checkedJazz){adicional = adicional + "," + "Jazz";}
		if (checkedElectro){adicional = adicional + "," + "Electronica";}
		if (checkedDup){adicional = adicional + "," + "Dup-step";}
		if (checkedPunk){adicional = adicional + "," + "Punk";}
		if (checkedRap){adicional = adicional + "," + "Rap";}
		if (checkedClasica){adicional = adicional + "," + "Clasica";}
		if (checkedReg){adicional = adicional + "," + "Reggaeton";}
		if (checkedTrap){adicional = adicional + "," + "Trap";}
		if (checkedSalsa){adicional = adicional + "," + "Salsa";}
		if (checkedMeren){adicional = adicional + "," + "Merengue";}
		if (checkedBach){adicional = adicional + "," + "Bachata";}
		if (checkedPop){adicional = adicional + "," + "Pop";}
		if (checkedVall){adicional = adicional + "," + "Vallenato";}
		if (checkedDance){adicional = adicional + "," + "Dancehall";}
		if (checkedHouse){adicional = adicional + "," + "House";}
		if (checkedOtro){adicional = adicional + "," + "Otro";}
		
		return adicional;
	}	
	
	return {
		
		insertarGusMusica : insertMusica
		
	}
	
})(); 
