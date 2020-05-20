var apiIntereses = (function(){
	
	return{
		
		addInteres : function(interes){
			
			jQuery.ajax({
				url: "/Intereses/",
				type: "POST",
				data: JSON.stringify(interes),
				contentType: "application/json",
				success: function(){
					alert("se ha agregado sus intereses correctamente.");
					location.href = "/GustosPeliculas.html"
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("intente nuevamente"); 
                }
			});			
		},
	
		allUsersInteres : function(callback,correo){
			jQuery.ajax({
				url: "/Intereses/allusers/" + correo,
				success: function(alluser){
					callback(alluser);
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("No hay informacion suficiente"); 
                }			
				
			});
		},
		
		getUserInteres : function(callback,correo){
			jQuery.ajax({
				url: "/Intereses/" + correo,
				success: function(alluser){
					callback(alluser);
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("No hay informacion suficiente"); 
                }			
				
			});
		},
                
                updateIntereses : function(interes){
			
			jQuery.ajax({
				url: "/Intereses/",
				type: "PUT",
				data: JSON.stringify(interes),
				contentType: "application/json",
				success: function(){
					alert("se ha actuaizado sus intereses correctamente.");
                                        usuario.recargueIntereses();
                                        setTimeout(function(){  
                                            location.href = "/perfilUsuario.html"}, 1000);
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("intente nuevamente"); 
                }
			});			
		}
	}
	
})(); 