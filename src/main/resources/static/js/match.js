var match = (function(){
	
	var usuario = sessionStorage.getItem('UserLogin');
	var correoUser ;
	var usuarios = [];
	var matchs = [];
	var matchsPar = [];
	var personas = [];
	var indice = 0;
	
	var getMatch = function (){
		
		apiInteracciones.getNotification(interacciones,usuario);
		
	};
	
	var interacciones = function (datos){
		if(datos.length > 0 ){
			for(var i=0; i < datos.length; i++){
				var dato = JSON.stringify(datos[i]);
				var dat = JSON.parse(dato);
				usuarios.push(dat);
			}
		}		
		apiMatch.getMatch(matches,usuario);
		
	};
	
	var matchesPareja = function(datos){
		if(datos.length > 0){
			for(var i=0; i < datos.length; i++){
				var dato = JSON.stringify(datos[i]);
				var dat = JSON.parse(dato);
				matchsPar.push(dat);
			}
		}
		mostrar();
	}
	
	var matches = function(datos){
		
		if(datos.length > 0){
			for(var i=0; i < datos.length; i++){
				var dato = JSON.stringify(datos[i]);
				var dat = JSON.parse(dato);
				matchs.push(dat);
			}
		}
		apiMatch.getMatchPareja(matchesPareja,usuario);
		
	};
	
	var verInfoUsuario = function(){
		if (indice === 0){
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
		if (indice === 0){
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
                
		if (matchs.length === 0 && matchsPar.length === 0){
			verInfoUsuario();
		}
		else{
			//cuando el usuario ha hecho match
			if(matchs.length > 0 && matchsPar.length === 0){
				var temp = [];
				for(var i=0; i < matchs.length; i++){
					temp.push(matchs[i].pareja);
				}
				
				for(var i=0; i < usuarios.length; i++){
					var ind = temp.indexOf(usuarios[i].usuario);
					if(ind === -1){
						personas.push(usuarios[i]);
					}
				}
				InfoUsuario();
			}
			//cuando al usuario le hicieron match
			else if(matchs.length === 0 && matchsPar.length > 0){
				var temp = [];
				for(var i=0; i < matchsPar.length; i++){
					temp.push(matchsPar[i].usuario);
				}
				
				for(var i=0; i < usuarios.length; i++){
					var ind = temp.indexOf(usuarios[i].usuario);
					if(ind === -1){
						personas.push(usuarios[i]);
					}
				}
				InfoUsuario();
			}
			else{
				// Cuando el usuario hace match y le han hecho match
				var temp = [];
				var tempM = [];
				for(var i=0; i < matchsPar.length; i++){
					tempM.push(matchsPar[i].usuario);
				}
				
				for(var i=0; i < matchs.length; i++){
					temp.push(matchs[i].pareja);
				}
				
				for(var i=0; i < usuarios.length; i++){
					var ind = temp.indexOf(usuarios[i].usuario);
					var indi = tempM.indexOf(usuarios[i].usuario); 
					if(ind === -1 && indi === -1 ){
						personas.push(usuarios[i]);
					}
				}
				InfoUsuario();
			}
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
		document.getElementById("tprel").innerHTML = datos.tipoRel;
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
                document.getElementById('celu').innerHTML = datos.celular;
                document.getElementById('Igram').innerHTML = datos.cuentaig;
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

		document.getElementById("nomb").style.display  = "none";
		document.getElementById("ed").style.display  = "none";
		document.getElementById("altu").style.display  = "none";
		document.getElementById("carrer").style.display  = "none";
		document.getElementById("semest").style.display  = "none";

		document.getElementById("nom").style.display  = "none";
		document.getElementById("eda").style.display  = "none";
		document.getElementById("alt").style.display  = "none";
		document.getElementById("carr").style.display  = "none";
		document.getElementById("sem").style.display  = "none";
		document.getElementById("tiprela").style.display  = "none";
		document.getElementById("tprel").style.display  = "none";

		
		document.getElementById("gusta").style.display  = "none";
		document.getElementById("nogusta").style.display  = "none";
		document.getElementById("pelicul").style.display  = "none";
		document.getElementById("music").style.display  = "none";
		document.getElementById("comid").style.display  = "none";
		
		document.getElementById("gusta").style.display  = "none";
		document.getElementById("nogusta").style.display  = "none";
		
		document.getElementById("cardPeliculas").style.display  = "none";
		document.getElementById("cardmusica").style.display  = "none";
		document.getElementById("cardcomida").style.display  = "none";
		
		document.getElementById("imagenes").style.display  = "none";
		
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
		
		var chat = {
			"pareja": correoUser,
			"usuario": usuario	
		}
		apiMatch.addMatch(match1);
		apichat.addChats(chat);
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