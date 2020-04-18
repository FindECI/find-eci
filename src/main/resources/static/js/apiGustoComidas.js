var apiComida = (function(){
	
	return{
		
		addComidas : function(gusto){
			
			jQuery.ajax({
				url: "/Gustos/",
				type: "POST",
				data: JSON.stringify(gusto),
				contentType: "application/json",
				success: function(){
					alert("se ha agregado sus gustos de comidas correctamente.");
					alert("GRACIAS POR REGISTRARTE,¡BIENVENIDO A FIND-ECI!")
					location.href = "/index.html"
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("intente nuevamente"); 
                }
			});			
		}
	}
	
	
})(); 