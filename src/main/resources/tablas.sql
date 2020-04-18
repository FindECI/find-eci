create table usuarios(
nombre varchar(100) not null,
apellido varchar(100) not null,
correo varchar(100) not null,
contrasena varchar(100) not null,
fecha_nacimiento date not null,
sexo varchar(20) not null,
altura numeric(3) not null,
celular numeric(10) not null,
cuentaIg varchar(100) not null);

create table carrera(
id numeric(1000) not null,
nombre varchar(100) not null,
semestre numeric(2) not null,
Ingreso numeric(4) not null,
usuario varchar(100)not null);

create table fetiches(
idFetiche numeric(100) not null,
nombre varchar(100) not null,
descripcion varchar(500),
usuario varchar(100) not null);

create table tipo_gusto(
id_tipoGusto numeric(10) not null,
tipogusto varchar(100) not null
);

create table gustos(
descripciongusto varchar(100) not null,
usuario varchar(100) not null,
tipogusto numeric(10) not null
);

create table intereses(
id numeric(1000) not null;
sexoInteres char(100) not null,
tipoRelacion varchar(100) not null,
aspectosImportantes varchar(600),
usuario varchar(100) not null);

create table interacciones(
id numeric (1000) not null,
usuario varchar(100) not null,
pareja varchar(100) not null,
likes numeric(1) not null
);

create table matches(
id numeric(1000) not null,
usuario varchar(100) not null,
pareja varchar(100) not null,
fecha date not null
);

create table imagenes(
id numeric(1000) not null,
imagen bytea not null,
usuario varchar(100) not null
);


/** foreaneas *//

alter table imagenes add constraint fk_imagenes foreign key (usuario) references usuarios(correo);


alter table gustos add constraint fk_gustos1 foreign key (usuario) references usuarios(correo);
alter table gustos add constraint fk_gustos2 foreign key (tipgusto) references tipo_gusto(id_tipo_gusto);


alter table interacciones add constraint fk_interacciones foreign key (usuario) references usuarios(correo);

alter table interacciones add constraint fk_interacciones1 foreign key (pareja) references usuarios(correo);


alter table intereses add constraint fk_intereses foreign key (usuario) references usuarios(correo);

alter table fetiches add constraint fk_fetiches foreign key (usuario) references usuarios(correo);

alter table carrera add constraint fk_carrera foreign key (usuario) references usuarios(correo);

alter table matches add constraint fk_maches foreign key (usuario) references usuarios(correo);



alter table matches add constraint fk_maches1 foreign key (pareja) references usuarios(correo);

