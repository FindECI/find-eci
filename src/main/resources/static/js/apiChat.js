var chat = (function(){
	
	var enviado = [];
	var recidos = [];
	var who=0;
	var cont = 0;
	var coneccion = function(){
		var socket = new SockJS('/chat-messaging');
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function(frame) {
			console.log("connected: " + frame);
			stompClient.subscribe('/chat/messagesU', function(response) {
				
				var data = JSON.parse(response.body);
				//alert(JSON.stringify(data));
				/*for(var i=0; i< data.length; i++){
					recibido
				}*/
				alert("data : "+ data.mensaje);
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
		var f = new Date();
		stompClient.send("/app/messages", {}, JSON.stringify({'mensaje': document.getElementById("mensaje").value,'pareja':sessionStorage.getItem('UserChat'),'usuario':sessionStorage.getItem('UserLogin'),'chat':sessionStorage.getItem('IdChat'),'fecha':f}));
		stompClient.send("/app/messagesP", {}, JSON.stringify({'mensaje': document.getElementById("mensaje").value,'pareja':sessionStorage.getItem('UserChat'),'usuario':sessionStorage.getItem('UserLogin'),'chat':sessionStorage.getItem('IdChat'),'fecha':f}));
		stompClient.send("/app/messagesU", {}, JSON.stringify({'mensaje': document.getElementById("mensaje").value,'pareja':sessionStorage.getItem('UserChat'),'usuario':sessionStorage.getItem('UserLogin'),'chat':sessionStorage.getItem('IdChat'),'fecha':f}));
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
