var match = (function(){
	
	var usuario = sessionStorage.getItem('UserLogin');
	var correoUser ;
	var usuarios = [];
	var matchs = [];
	var personas = [];
	var indice = 0;
	
	var getMatch = function (){
		
		apiInteracciones.getNotification(interacciones,usuario);
		
	};
	
	var interacciones = function (datos){
		apiMatch.getMatch(matches,usuario);
		for(var i=0; i < datos.length; i++){
			var dato = JSON.stringify(datos[i]);
			var dat = JSON.parse(dato);
			usuarios.push(dat);
		}
		
	};
	
	var matches = function(datos){
		if(datos.length > 0){
			for(var i=0; i < datos.length; i++){
				var dato = JSON.stringify(datos[i]);
				var dat = JSON.parse(dato);
				matchs.push(dat);
			}
		}
		
		mostrar();
	};
	
	var verInfoUsuario = function(){
		if (indice == 0){
			correoUser = usuarios[indice].usuario;
			methodosuser(usuarios[indice].usuario);
			apiIntereses.getUserInteres(intereses,correoUser);
		}
		else{
			if(indice < usuarios.length){
				correoUser = usuarios[indice].usuario;
				methodosuser(usuarios[indice].usuario);
				apiIntereses.getUserInteres(intereses,correoUser);
			}
			else{
				ocultar();
				indice=0;
			}
		}
	};
	
	var InfoUsuario = function(){
		if (indice == 0){
			if (personas.length > 0){
				correoUser = personas[indice].usuario;
				methodosuser(personas[indice].usuario);
				apiIntereses.getUserInteres(intereses,correoUser);
			}
			else{
				ocultar();
				indice=0;
			}
			
		}
		else{
			if(indice < personas.length){
				correoUser = personas[indice].usuario;
				methodosuser(personas[indice].usuario);
				apiIntereses.getUserInteres(intereses,correoUser);
			}
			else{
				ocultar();
				indice=0;
			}
		}
	};
	
	var mostrar = function(){
		
		if (matchs.length == 0){
			verInfoUsuario();
		}
		else{
			var temp = [];
			for(var i=0; i < matchs.length; i++){
				temp.push(matchs[i].pareja);
			}
			
			for(var i=0; i < usuarios.length; i++){
				var ind = temp.indexOf(usuarios[i].usuario);
				if(ind == -1){
					personas.push();
				}
			}
			InfoUsuario();
		}
		
	};	
	
	var methodosuser = function(correo) {
		apiUser.getUser(infousuario, correo);
		apiCarrera.getCarrera(infoCarrerausuario, correo);
		apiMusical.getgustosUser(infoGustosusuario, correo);
	};
	
	var intereses = function(datos){
		datos = JSON.stringify(datos);
		datos = JSON.parse(datos);
		document.getElementById("tprela").innerHTML = datos.tipoRel;
	};
	
	///informacion basica del usuario
	var infousuario = function(datos) {
		datos = JSON.stringify(datos);
		datos = JSON.parse(datos);
		var fecha = datos.fechaNacimiento.split("-");
		var f = new Date();
		document.getElementById("nomb").innerHTML = datos.nombre + "   "
				+ datos.apellido;
		document.getElementById("ed").innerHTML = parseInt(f.getFullYear())
				- parseInt(fecha[0]);
		document.getElementById("altu").innerHTML = datos.altura + " " + "cm";
	};
	///informacion de la carrera del usuario
	var infoCarrerausuario = function(datos) {
		datos = JSON.stringify(datos);
		datos = JSON.parse(datos);
		document.getElementById("carrer").innerHTML = datos.nombre;
		document.getElementById("semest").innerHTML = datos.semestre;
	};
	
	///informacion de los gustos del usuario
	var infoGustosusuario = function(datos) {

		var peliculas = JSON.parse(JSON.stringify(datos[0]));
		var musicales = JSON.parse(JSON.stringify(datos[1]));
		var comidas = JSON.parse(JSON.stringify(datos[2]));
		document.getElementById("pelicul").innerHTML = peliculas.descripciongusto;
		document.getElementById("music").innerHTML = musicales.descripciongusto;
		document.getElementById("comid").innerHTML = comidas.descripciongusto;
	};
	
	var ocultar = function() {

		document.getElementById("informacion").innerHTML = "¡Actualmente no hay personas interesadas en ti. Pronto encontraras tu match ideal!";

		document.getElementById("nomb").style.visibility = "hidden";
		document.getElementById("ed").style.visibility = "hidden";
		document.getElementById("altu").style.visibility = "hidden";
		document.getElementById("carrer").style.visibility = "hidden";
		document.getElementById("semest").style.visibility = "hidden";

		document.getElementById("nom").style.visibility = "hidden";
		document.getElementById("eda").style.visibility = "hidden";
		document.getElementById("alt").style.visibility = "hidden";
		document.getElementById("carr").style.visibility = "hidden";
		document.getElementById("sem").style.visibility = "hidden";
		document.getElementById("tiprel").style.visibility = "hidden";
		document.getElementById("tprela").style.visibility = "hidden";

		
		document.getElementById("gusta").style.visibility = "hidden";
		document.getElementById("nogusta").style.visibility = "hidden";
		document.getElementById("pelicul").style.visibility = "hidden";
		document.getElementById("music").style.visibility = "hidden";
		document.getElementById("comid").style.visibility = "hidden";
		
		document.getElementById("gusta").style.visibility = "hidden";
		document.getElementById("nogusta").style.visibility = "hidden";
	};
	
	
	var addMatch = function() {
		var f = new Date();
		var interacciones = {
			"likes" : 1,
			"pareja" : correoUser,
			"usuario" : usuario
		}
		
		var match1 = {
			"fechaMatch": f,
			"pareja": correoUser,
			"usuario": usuario
		}
		apiMatch.addMatch(match1);
		apiInteracciones.addInteraccion(interacciones, 1);
		getMatch();
		indice += 1;

	};

	var addNointeresa = function() {
		var interacciones = {
			"likes" : 0,
			"pareja" : correoUser,
			"usuario" : usuario
		}
		apiInteracciones.addInteraccion(interacciones, 0);
		getMatch();
		indice += 1;
	};
 	
	
	
	return {
		
		agregarMatch : addMatch,
		noAgregarMatch : addNointeresa,
		ver : getMatch
	}	
	
})();