create table usuarios(
nombre varchar(100) not null,
correo varchar(100) primary key,
contraseña varchar(100) not null,
edad numeric(2) not null,
sexo varchar(20) not null,
altura numeric(3) not null,
celular numeric(10) not null,
cuentaIg varchar(100) not null);

create table carrera(
nombre varchar(100) not null,
semestre numeric(2) not null,
añoIngreso numeric(4) not null,
usuario varchar(100) references usuarios(correo));

create table fetiches(
idFetiche serial primary key,
nombre varchar(100) not null,
descripcion varchar(500),
usuario varchar(100) references usuarios(correo));

create table gustosComida(
idGustoComida serial primary key,
nombre varchar(100) not null,
descripcion varchar(500),
usuario varchar(100) references usuarios(correo));

create table gustosPeliculas(
idGustoPelicula serial primary key,
nombre varchar(100) not null,
descripcion varchar(500),
usuario varchar(100) references usuarios(correo));

create table gustosMusica(
idGustoMusica serial primary key,
nombre varchar(100) not null,
descripcion varchar(500),
usuario varchar(100) references usuarios(correo));

create table intereses(
sexoInteres char(1) not null,
tipoRelacion varchar(100) not null,
aspectosImportantes varchar(600),
usuario varchar(100) references usuarios(correo));

create table matches(
correo varchar(100) primary key,
nombre varchar(50) not null,
fechaMatch date not null);
