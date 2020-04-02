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
					location.href = "/Intereses.html";
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("El Usuario ya esta registrado, intente nuevamente"); 
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
		}
		
	}
		
})();
