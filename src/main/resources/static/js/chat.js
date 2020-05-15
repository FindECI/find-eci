var chat = (function(){
	var usuario = sessionStorage.getItem('UserLogin'); 
	var chats = [];
	
	
	var getChat = function() {
		document.getElementById("card").style.display  = "none";
		apichat.getChatUser(mostrarChats,usuario);
	}
	
	
	var mostrarChats = function(datos){
		if(datos.length > 0 ){
			var column;
			for(var i=0; i < datos.length;i++){
				if(datos[i].usuario == usuario){
					column = '<tr><td>'+ datos[i].id + '</td><td>'+ datos[i].pareja +'</td><td> <button type="button" class="btn btn-success" onclick="chat.chatear(\'' + datos[i].pareja +'\''+','+'\''+ datos[i].id +'\')">Ver Chat</button></td></tr>';
				}
				else{
					column = '<tr><td>'+ datos[i].id + '</td><td>'+ datos[i].usuario +'</td><td> <button type="button" class="btn btn-success" onclick="chat.chatear(\'' + datos[i].usuario +'\''+','+'\''+ datos[i].id +'\')">Ver Chat</button></td></tr>';
				}
				$("table tbody").append(column);
			}
		}
		else{
			document.getElementById("card").style.display  = "block";
			document.getElementById("informacion").innerHTML = "¡Actualmente no hay conversaciones activas!";
			document.getElementById("table").style.display  = "none";
		}
	}
	
	var irChat = function(Userchat,id){
		sessionStorage.setItem('UserChat',Userchat);
		sessionStorage.setItem('IdChat',id);
		location.href = "/Chat.html";
	} 
	
	return{
		
		verChats : getChat,
		chatear : irChat
	}
	
})() 