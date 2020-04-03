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
		}
	}
	
	
})(); 