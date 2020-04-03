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
					location.href = "/GustoPeliculas.html";
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("intente nuevamente"); 
                }
			});			
		}
		
		
		
		
	}
	
	
	
	
	
})(); 