var apiMusical = (function(){
	
	return{
		
		addMusicales : function(gusto){	
			jQuery.ajax({
				url: "/Gustos/",
				type: "POST",
				data: JSON.stringify(gusto),
				contentType: "application/json",
				success: function(){
					alert("se ha agregado sus gustos musicales correctamente.");
					location.href = "/GustosComida.html"
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("intente nuevamente"); 
                }
			});			
		},
		
		
		
		getgustosUser: function(callback,correo){
			jQuery.ajax({
				url: "/Gustos/"+ correo,
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