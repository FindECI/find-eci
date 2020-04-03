var usuario = (function () {

    var crearcuentas = function () {

        var cont = document.getElementById("contrasena").value;
        var contr = document.getElementById("contrasena2").value;

        if (cont === contr) {
            var usuario = {"correo": document.getElementById("email").value, "altura": document.getElementById("altura").value,
                "apellido": document.getElementById("apellido").value, "celular": document.getElementById("celular").value,
                "contrasena": contr, "cuentaig": document.getElementById("cntig").value, "fechaNacimiento": document.getElementById("fechana").value,
                "nombre": document.getElementById("nombre").value, "sexo": document.getElementById("sexo").value};
           
            apiUser.addUser(usuario);
            //apiUser.addImgUser(usuario,document.getElementById("imagen1").value);
            sessionStorage.setItem('User',document.getElementById("email").value);
            
        } else {
            alert("las contraseñas no son iguales");
        }

    };

    var irRegistrar = function () {
        location.href = "/user-form.html";
    };

    var login = function () {
        var user = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        apiUser.loginUser(user, password);
        
    };

    return {

        crearcuenta: crearcuentas,
        pageRegistrar: irRegistrar,
        ingresoApp: login

    };
})();