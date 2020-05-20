apiCarrera = (function(){
	
	return{
		
		addCarrera: function (carrera){
			jQuery.ajax({
				url: "/Carrera/",
				type: "POST",
				data: JSON.stringify(carrera),
				contentType: "application/json",
				success: function(){
					alert("Se ha agregado la carrera correctamente.");
					location.href = "/Intereses.html"
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("El Usuario ya esta registrado, intente nuevamente"); 
                }
			});
		},
		
		getCarrera: function(callback,correo){
			jQuery.ajax({
				url: "/Carrera/"+ correo,
				type: "GET",
				success: function(datos){
					callback(datos);
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("El Usuario no existe"); 
                }
				
			});
		},
                
                updateCarrera: function (carrera){
			jQuery.ajax({
				url: "/Carrera/",
				type: "PUT",
				data: JSON.stringify(carrera),
				contentType: "application/json",
				success: function(){
					alert("Se ha actualizado su carrera correctamente.");
					usuario.recargueCarrera();
                                        setTimeout(function(){  
                                            location.href = "/perfilUsuario.html"}, 1000);
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("El Usuario ya esta registrado, intente nuevamente"); 
                }
			});
		}
		
	}
		
})();