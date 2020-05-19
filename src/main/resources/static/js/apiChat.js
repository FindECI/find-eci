var chat = (function() {
	var usuario = sessionStorage.getItem('UserLogin');
	var pareja;
	var list = [];
	var listP = [];
	var lastP = 0;
	var status = false;
	var cont = 0;
	

	var coneccion = function() {
		
		wss = new WebSocket("wss://localhost:8080/chat-messaging");
		
		apiUser.getUser(verUser,sessionStorage.getItem('UserChat'));
				
		var socket = new SockJS('/chat-messaging');
		stompClient = Stomp.over(wss);

		stompClient.connect({}, onConected, onError);
	}
	
	var verUser = function(usuario){
		document.getElementById("parejaChat").innerHTML= usuario.nombre + " " + usuario.apellido;
	}

	var onError = function(error) {
		
		connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
		connectingElementj.style.color = 'red';
	}

	var onConected = function() {
		var f = new Date();
		var message = {
			'mensaje' : document.getElementById("mensaje").value,
			'pareja' : sessionStorage.getItem('UserChat'),
			'usuario' : sessionStorage.getItem('UserLogin'),
			'chat' : sessionStorage.getItem('IdChat'),
			'fecha' : f
		};

		stompClient.subscribe("/chat/messagesUser", onMessageReceived);
		stompClient.subscribe("/chat/messagesAll", onMessageAll);

		stompClient.send("/app/chat.saveUser", {}, JSON.stringify(message));
		stompClient.send("/app/chat.messangesAll", {},JSON.stringify(message));
	}

	var sendMessage = function() {
		var f = new Date();
		if (stompClient) {

			var message = {
				'mensaje' : document.getElementById("mensaje").value,
				'pareja' : sessionStorage.getItem('UserChat'),
				'usuario' : sessionStorage.getItem('UserLogin'),
				'chat' : sessionStorage.getItem('IdChat'),
				'fecha' : f,
				'bandera': 0
			};

			stompClient.send("/app/chat.messages", {}, JSON.stringify(message));
			draw("right", message.mensaje);
			document.getElementById("mensaje").value = "";
		}
	}

	var onMessageReceived = function(data) {
		var message = JSON.parse(data.body);
		if(message.pareja == usuario){
			if(message.mensaje != ""){
				draw("left", message.mensaje);
			}			
		} 
	}

	var onMessageAll = function(data) {
		var message = JSON.parse(data.body);
		if (status == false){
			if (message.length > 0) {
				for (var i = 0; i < message.length; i++) {
					if(message[i].usuario == usuario){
						draw("right",message[i].mensaje);
					}
					else{
						draw("left",message[i].mensaje);
					}
				}

			}
			status = true;
		}
		
		//mostrarAllMessage();
	}

	var draw = function draw(side, text) {
		console.log("drawing...");
		var $message;
		$message = $($('.message_template').clone().html());
		$message.addClass(side).find('.text').html(text);
		$('.messages').append($message);
		return setTimeout(function() {
			return $message.addClass('appeared');
		}, 0);

	}
	return {

		conectar : coneccion,
		mensaje : sendMessage
	}

})();

var apichat = (function() {

	return {

		addChats : function(chat) {
			jQuery.ajax({
				url : "/chats/",
				type : "POST",
				data : JSON.stringify(chat),
				contentType : "application/json",
				success : function() {
					alert("¡Inicia una conversacion con tu nuevo match!");
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("El Usuario ya esta registrado, intente nuevamente");
				}
			});
		},

		getChatUser : function(callback, correo) {
			jQuery.ajax({
				url : "/chats/usuario/" + correo,
				success : function(alluser) {
					callback(alluser);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("No hay informacion suficiente");
				}

			});
		},

		getChatPareja : function(callback, correo) {
			jQuery.ajax({
				url : "/chats/pareja/" + correo,
				success : function(alluser) {
					callback(alluser);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert("No hay informacion suficiente");
				}

			});
		}
	}

})();
