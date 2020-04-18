var apiInteracciones = (function() {

	return {

		addInteraccion : function(interaccion, info) {

			jQuery.ajax({
				url : "/Interacciones/",
				type : "POST",
				data : JSON.stringify(interaccion),
				contentType : "application/json",
				success : function() {
					if (info == 1) {
						alert("Se ha enviado su me gusta.");
					} else {
						alert("Se ha enviado su No gracias.");
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("intente nuevamente");
				}
			});
		},

		getNotification: function(callback,correo){
			jQuery.ajax({
				url:  "/Interacciones/notification/" + correo,
				type: "GET",
				success: function(datos){
					callback(datos);
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("El Usuario no existe"); 
                }
				
			});
		},
		
		getInteraccionesUser : function(callback,correo){
			jQuery.ajax({
				url:  "/Interacciones/" + correo,
				type: "GET",
				success: function(datos){
					callback(datos);
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("El Usuario no existe"); 
                }
				
			});
		}
	}

})();