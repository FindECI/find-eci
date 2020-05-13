apiUser = (function(){
	
	return{
		
		addUser: function (usuario){
			jQuery.ajax({
				url: "/userForm/",
				type: "POST",
				data: JSON.stringify(usuario),
				contentType: "application/json",
				success: function(){
					alert("El usuario ha sido creado correctamente.");
					
					location.href = "/carrera.html"
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("El Usuario ya esta registrado, intente nuevamente"); 
                }
			});
			
		},
                
                updateUser: function (usuari){
			jQuery.ajax({
				url: "/userForm/",
				type: "PUT",
				data: JSON.stringify(usuari),
				contentType: "application/json",
				success: function(){
					alert("Su infromacion personal ha sido actualizada correctamente.");
					usuario.recargue();
                                        location.href = "/perfilUsuario.html"
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("Intente nuevamente"); 
                }
			});
			
		},
                
                updateContraseña: function (correo, contraseña){
			jQuery.ajax({
				url: "/userForm/" + correo +"/"+ contraseña,
				type: "PUT",
				success: function(){
					alert("Su contraseña ha sido actualizada correctamente.");
                                        location.href = "/perfilUsuario.html"
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("Intente nuevamente"); 
                }
			});
			
		},
			
		addImgUser: function(usuario,imagen){
			alert("entroooooooooooo imagennnnn");
			jQuery.ajax({
				url: "/imagen/"+imagen,
				type: "POST",
				data: JSON.stringify(usuario),
				contentType: "application/json",
				success: function(){
					alert("se ha agreda correctamente su imagen.");
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("No se pudo agregar la imagen"); 
                }
			});
			
		},
		
		
		getUser: function(callback,correo){
			jQuery.ajax({
				url: "/userForm/"+ correo,
				type: "GET",
				success: function(datos){
					callback(datos);
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("El Usuario no existe"); 
                }
				
			});
		},
	
		loginUser: function(correo,password){
			jQuery.ajax({
				url: "/userForm/"+ correo +"/"+ password,
				type: "GET",
				success: function(){
					alert("Ingreso exito.");
					location.href = "/perfil.html";
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("El Usuario o Contraseña no es correcto"); 
                }
				
			});
		},
		
		irPerfil : function () {
	        location.href = "/perfil.html";
	    },
	    
	    irACBasica : function () {
	        location.href = "/ACBasica.html";
	    },
            irACCarrera : function () {
	        location.href = "/ACCarrera.html";
	    },
            irACFetiches : function () {
	        location.href = "/ACFetiches.html";
	    },
            irACGComida : function () {
	        location.href = "/ACGustosComida.html";
	    },
	    irACGMusica : function () {
	        location.href = "/ACGustosMusicales.html";
	    },
            irACGPeliculas : function () {
	        location.href = "/ACGustosPeliculas.html";
	    },
            irACIntereses : function () {
	        location.href = "/ACIntereses.html";
	    },
            irPerfilUsuario : function () {
	        location.href = "/perfilUsuario.html";
	    },
            irMatch : function () {
	        location.href = "/match.html";
	    },
	    irLogin : function () {
	        location.href = "/index.html";
	        sessionStorage.setItem('UserLogin',"");
                sessionStorage.setItem('Nombre',"");
                sessionStorage.setItem('Genero',"");
                sessionStorage.setItem('Altura',"");
                sessionStorage.setItem('Celular',"");
                sessionStorage.setItem('Instagram',"");
                sessionStorage.setItem('Nacimiento',"");
                sessionStorage.setItem('Carrera',"");
                sessionStorage.setItem('Semestre',"");
                sessionStorage.setItem('GeneroInt',"");
                sessionStorage.setItem('TipRel',"");
                sessionStorage.setItem('Intereses',"");
                sessionStorage.setItem('GPeliculas',"");
                sessionStorage.setItem('GMusicales',"");
                sessionStorage.setItem('GComidas',"");
            },
            
            irChat : function (){

	        location.href = "/ListChat.html";
            },
            
            irACContraseña : function (){

	        location.href = "/ACContraseña.html";
            }
        }
		
})();
