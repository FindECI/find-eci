var apiPeliculas = (function(){
	
	return{
		
		addPeliculas : function(gusto){
			
			jQuery.ajax({
				url: "/Gustos/",
				type: "POST",
				data: JSON.stringify(gusto),
				contentType: "application/json",
				success: function(){
					alert("se ha agregado sus gustos de peliculas correctamente.");
					location.href = "/GustosMusicales.html"
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("intente nuevamente"); 
                }
			});			
		}
		
		
		
		
	}
	
	
	
	
	
})(); 