var chat = (function(){
	var who=0;
	var cont = 0;
	var coneccion = function(){
		var socket = new SockJS('/chat-messaging');
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function(frame) {
			console.log("connected: " + frame);
			stompClient.subscribe('/chat/messages', function(response) {
				var data = JSON.parse(response.body);
				draw("left", data.mensaje);
			});
		});
	}
	
	var draw = function draw(side, text) {
		console.log("drawing...");
	    var $message;
	    $message = $($('.message_template').clone().html());
	    $message.addClass(side).find('.text').html(text);
	    $('.messages').append($message);
	    return setTimeout(function () {
	        return $message.addClass('appeared');
	    }, 0);

	}
	
	
	var desconectar = function disconnect(){
		stompClient.disconnect();
	}
	
	var enviarMensaje = function sendMessage(){
		stompClient.send("/app/message", {}, JSON.stringify({'mensaje': document.getElementById("mensaje").value}));
		draw("right", document.getElementById("mensaje").value);
		who = 1;
	}

	return {
		
		conectar : coneccion,
		mensaje : enviarMensaje
	}
	
})();

var apichat = (function(){
	
	return{
		
		addChats: function (chat){
			jQuery.ajax({
				url: "/chats/",
				type: "POST",
				data: JSON.stringify(chat),
				contentType: "application/json",
				success: function(){
					alert("¡Inicia una conversacion con tu nuevo match!");
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("El Usuario ya esta registrado, intente nuevamente"); 
                }
			});
		},
		
		getChatUser : function(callback,correo){
			jQuery.ajax({
				url: "/chats/usuario/" + correo,
				success: function(alluser){
					callback(alluser);
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("No hay informacion suficiente"); 
                }			
				
			});
		},
		
		
		getChatPareja : function(callback,correo){
			jQuery.ajax({
				url: "/chats/pareja/" + correo,
				success: function(alluser){
					callback(alluser);
				},error: function(XMLHttpRequest, textStatus, errorThrown) { 
                    alert("No hay informacion suficiente"); 
                }			
				
			});
		}
	}
	
	
})();
