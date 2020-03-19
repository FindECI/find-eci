var app = (function(){
	
	function comparatePassword(pass1,pass2){
		return console.log(pass1 == pass2);
	}
	
	
	return {
		
		comparate : function(){
			ps1 = document.getElementById("password");
			ps2 = document.getElementById("cpassword");
			if (comparatePassword(ps1,ps2)){
				return "contraseña correcta";
			}
			else{
				return "verifique la contraseña ingresada, es incorrecta";
			}
		}
		
	}
	
})();