apiMatch = (function(){
	
	return{
		
		addMatch: function (match){
			jQuery.ajax({
				url: "/match/",
				type: "POST",
				data: JSON.stringify(match),
				contentType: "application/json",
				success: function(){
					alert("Se ha enviado la solicitud correctamente.");
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("El Usuario ya esta registrado, intente nuevamente"); 
                }
			});
		},
		
		getMatch : function(callback,correo){
			jQuery.ajax({
				url: "/match/" + correo,
				success: function(matches){
					callback(matches);
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("No hay informacion suficiente"); 
                }			
				
			});
		},
		
		getMatchPareja : function(callback,correo){
			jQuery.ajax({
				url: "/match/pareja/" + correo,
				success: function(matches){
					callback(matches);
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("No hay informacion suficiente"); 
                }			
				
			});
		}
		
		
	}
		
})();