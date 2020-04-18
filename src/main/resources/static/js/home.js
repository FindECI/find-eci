var home = (function() {

	var indice = 0;
	var correo = sessionStorage.getItem('UserLogin');
	var correoUser;
	// interacciones otros usuarios al usuarios
	var lista = [];
	// toda las interacciones del usuario
	var listUser = [];
	// los posibles parejas del usuario (intereses)
	var dato = [];
	var acomp = [];
	// personas disponibles para match
	var personas = [];

	// interacciones para notificar
	var personasNotif = [];
	

	var ejecutar = function() {
		setInterval(allNotificacion(), 5000);
	};

	var allNotificacion = function() {

		apiInteracciones.getNotification(avisar, correo);
	}

	var allUsers = function() {
		apiInteracciones.getInteraccionesUser(valores, correo);

	};

	var almacenarUsers = function(datos) {
		for (var i = 0; i < datos.length; i++) {
			var usuariojson = JSON.stringify(datos[i]);

			var usuario = JSON.parse(usuariojson);
			dato[i] = usuario;

		}

		verificarMostar();

	};

	var valores = function(datos) {
		if (datos.length > 0) {
			for (var i = 0; i < datos.length; i++) {
				var list = JSON.stringify(datos[i]);
				var listJson = JSON.parse(list);
				if (listUser.length == 0) {
					listUser[i] = listJson;
				} else {
					for (var j = 0; j < listUser.length; j++) {
						if (listUser[j].pareja != listJson.pareja) {
							listUser[i] = listJson;
						}
					}
				}
			}
		}

		apiIntereses.allUsersInteres(almacenarUsers, correo);

	};

	var verificarMostar = function() {
		if (listUser.length == 0) {

			for (var i = 0; i < dato.length; i++) {
				personas[i] = dato[i];
			}
			mostrar();
		} else {
			var temp = []
			for (var i = 0; i < listUser.length; i++) {
				temp[i] = listUser[i].pareja;
			}

			for (var i = 0; i < dato.length; i++) {
				var index = temp.indexOf(dato[i].usuario);
				if (index == -1) {
					personas.push(dato[i]);
				}
			}
			mostrar();
		}
	};

	var mostrar = function() {
		if (indice == 0) {
			if (personas.length > 0) {
				correoUser = personas[indice].usuario;
				methodosuser(personas[indice].usuario);
				document.getElementById("tprel").innerHTML = personas[0].tipoRel;
			} else {
				ocultar();
			}

		} else {
			if (indice < personas.length) {
				correoUser = personas[indice].usuario;
				methodosuser(personas[indice].usuario);
				document.getElementById("tprel").innerHTML = personas[indice].tipoRel;
			} else {
				ocultar();
				indice = 0;
			}
		}
	};

	var methodosuser = function(correo) {
		apiUser.getUser(infousuario, correo);
		apiCarrera.getCarrera(infoCarrerausuario, correo);
		apiMusical.getgustosUser(infoGustosusuario, correo);
	};

	var ocultar = function() {

		document.getElementById("informacion").innerHTML = "¡Estas fueron todas tus posible parejas!. Actualiza tus intereses para conocer más personas";

		document.getElementById("nombre").style.visibility = "hidden";
		document.getElementById("edad").style.visibility = "hidden";
		document.getElementById("altura").style.visibility = "hidden";
		document.getElementById("carrera").style.visibility = "hidden";
		document.getElementById("semestre").style.visibility = "hidden";

		document.getElementById("nom").style.visibility = "hidden";
		document.getElementById("ed").style.visibility = "hidden";
		document.getElementById("alt").style.visibility = "hidden";
		document.getElementById("carr").style.visibility = "hidden";
		document.getElementById("sem").style.visibility = "hidden";
		document.getElementById("tiprel").style.visibility = "hidden";
		document.getElementById("tprel").style.visibility = "hidden";

		document.getElementById("gusta").style.visibility = "hidden";
		document.getElementById("nogusta").style.visibility = "hidden";
		document.getElementById("peliculas").style.visibility = "hidden";
		document.getElementById("musica").style.visibility = "hidden";
		document.getElementById("comidas").style.visibility = "hidden";

		document.getElementById("gusta").style.visibility = "hidden";
		document.getElementById("nogusta").style.visibility = "hidden";

	}

	var infousuario = function(datos) {
		datos = JSON.stringify(datos);
		datos = JSON.parse(datos);
		var fecha = datos.fechaNacimiento.split("-");
		var f = new Date();
		document.getElementById("nombre").innerHTML = datos.nombre + "   "
				+ datos.apellido;
		document.getElementById("edad").innerHTML = parseInt(f.getFullYear())
				- parseInt(fecha[0]);
		document.getElementById("altura").innerHTML = datos.altura + " " + "cm";
	};
	var infoCarrerausuario = function(datos) {
		datos = JSON.stringify(datos);
		datos = JSON.parse(datos);
		document.getElementById("carrera").innerHTML = datos.nombre;
		document.getElementById("semestre").innerHTML = datos.semestre;
	};

	var infoGustosusuario = function(datos) {

		var peliculas = JSON.parse(JSON.stringify(datos[0]));
		var musicales = JSON.parse(JSON.stringify(datos[1]));
		var comidas = JSON.parse(JSON.stringify(datos[2]));
		document.getElementById("peliculas").innerHTML = peliculas.descripciongusto;
		document.getElementById("musica").innerHTML = musicales.descripciongusto;
		document.getElementById("comidas").innerHTML = comidas.descripciongusto;
	};

	var addInteraccion = function() {
		var interacciones = {
			"likes" : 1,
			"pareja" : correoUser,
			"usuario" : correo
		}
		apiInteracciones.addInteraccion(interacciones, 1);
		allUsers();
		indice += 1;

	};

	var addNointeresa = function() {
		var interacciones = {
			"likes" : 0,
			"pareja" : correoUser,
			"usuario" : correo
		}
		apiInteracciones.addInteraccion(interacciones, 0);
		allUsers();
		indice += 1;
	};

	var avisar = function(datos) {

		for (var i = 0; i < datos.length; i++) {
			var list = JSON.stringify(datos[i]);
			var listJson = JSON.parse(list);

			if (lista.length == 0) {
				lista[0] = listJson;

			} else {
				for (var j = 0; j < lista.length; j++) {
					if (lista[j].usuario != listJson.usuario) {
						lista[i] = listJson;

					}
				}
			}
		}

		notificacionesDefinidas();

	};

	var notificacionesDefinidas = function() {
		var temp = []
		for (var i = 0; i < listUser.length; i++) {
			temp.push(listUser[i].usuario);
		}

		for (var i = 0; i < lista.length; i++) {
			var indexPareja = temp.indexOf(lista[i].pareja);
			if (indexPareja == -1) {
				personasNotif.push(lista[i]);
				acomp.push(0);
			}
		}
		viewnotifiaciones();
	};

	var viewnotifiaciones = function() {
		for (var i = 0; i < acomp.length; i++) {
			
			if (acomp[i] == 0) {				
				notificacion(personasNotif[i].usuario);
				acomp[i] = 1;
			}
		}
	}

	var notificacion = function(nombre) {

		alert("¡ " + nombre + " quiere conocerte!");
	};

	var llamarMethodos = function() {
		allUsers();
		ejecutar();
	};

	return {

		agregarinteraccion : addInteraccion,
		agregarNointeraccion : addNointeresa,
		ejecutarNotificaciones : llamarMethodos

	}

})();