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
    
    var registraCarrera = function(){
    	
    	var carrera = {"nombre": document.getElementById("carrera").value,"semestre": document.getElementById("semestre").value,"usuario":sessionStorage.getItem('User')};
    	apiCarrera.addCarrera(carrera);
    }

    var irRegistrar = function () {
        location.href = "/user-form.html";
    };

    var login = function () {
        var user = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        apiUser.loginUser(user, password);
        sessionStorage.setItem('UserLogin',document.getElementById("username").value);
        recrgaue();
    };
    
    var recargue = function(){
        apiUser.getUser(infoUser, user);
        apiCarrera.getCarrera(infoCarrera, user);
        apiIntereses.getUserInteres(infoIntereses, user);
        apiMusical.getgustosUser(infoGustos, user);
    };
    
    var infoUser = function(datos){
	 var nombre = datos.nombre;
         var apellido = datos.apellido;
         var genero = datos.sexo;
         var altura = datos.altura;
         var celular = datos.celular;
         var instagram = datos.cuentaig;
         var fechaNacimiento = datos.fechaNacimiento;
         sessionStorage.setItem('Nombre',nombre + " " +apellido);
         sessionStorage.setItem('Genero',genero);
         sessionStorage.setItem('Altura',altura);
         sessionStorage.setItem('Celular',celular);
         sessionStorage.setItem('Instagram',instagram);
         sessionStorage.setItem('Nacimiento',fechaNacimiento);
    };
    
    var infoCarrera = function(datos){
	 var carrera = datos.nombre;
         var semestre = datos.semestre;
         sessionStorage.setItem('Carrera',carrera);
         sessionStorage.setItem('Semestre',semestre);
    };
    
    var infoIntereses = function(datos){
	 var generoInt = datos.sexoInteres;
         var tipRel = datos.tipoRel;
         var intereses = datos.apectosImportantes;
         sessionStorage.setItem('GeneroInt',generoInt);
         sessionStorage.setItem('TipRel',tipRel);
         sessionStorage.setItem('Intereses', intereses);
    };
    
    var infoGustos = function(datos){
        var peliculas = datos[0].descripciongusto;
        var musicales = datos[1].descripciongusto;
        var comidas = datos[2].descripciongusto;
        sessionStorage.setItem('GPeliculas',peliculas);
        sessionStorage.setItem('GMusicales',musicales);
        sessionStorage.setItem('GComidas', comidas);
    };
    
    var cargueInfo = function(){
	var correo = sessionStorage.getItem('UserLogin');
        var nombre = sessionStorage.getItem('Nombre');
        var genero = sessionStorage.getItem('Genero');
        var altura = sessionStorage.getItem('Altura');
        var celular = sessionStorage.getItem('Celular');
        var instagram = sessionStorage.getItem('Instagram');
        var fechaNacimiento = sessionStorage.getItem('Nacimiento');
        var carrera = sessionStorage.getItem('Carrera');
        var semestre = sessionStorage.getItem('Semestre');
        var fechaActual = new Date();
        var fechaN= new Date(fechaNacimiento);
        var r1 = fechaN.getTime();
        var r2 = fechaActual.getTime();
        var fecha = r2-r1
        var edad = Math.floor(fecha / 32000000000);
        var generoInt = sessionStorage.getItem('GeneroInt');
        var tipRel = sessionStorage.getItem('TipRel');
        var intereses = sessionStorage.getItem('Intereses');
        var peliculas = sessionStorage.getItem('GPeliculas');
        var musicales = sessionStorage.getItem('GMusicales');
        var comidas = sessionStorage.getItem('GComidas');
        document.getElementById('email').innerHTML = correo;
        document.getElementById('nombre').innerHTML = nombre;
        document.getElementById('gene').innerHTML = genero;
        document.getElementById('altura').innerHTML = altura;
        document.getElementById('celu').innerHTML = celular;
        document.getElementById('Igram').innerHTML = instagram;
        document.getElementById('edad').innerHTML = edad;
        document.getElementById('carrera').innerHTML = carrera;
        document.getElementById('semestre').innerHTML = semestre;
        document.getElementById('genInt').innerHTML = generoInt;
        document.getElementById('tprel').innerHTML = tipRel;
        document.getElementById('intereses').innerHTML = intereses;
        document.getElementById('peliculas').innerHTML = peliculas;
        document.getElementById('musica').innerHTML = musicales;
        document.getElementById('comidas').innerHTML = comidas;
    };
    
    return {

        crearcuenta: crearcuentas,
        pageRegistrar: irRegistrar,
        ingresoApp: login,
        crearCarrera : registraCarrera,
        info: infoUser,
        infoC: infoCarrera,
        infoI: infoIntereses,
        cargue: cargueInfo

    };
})();