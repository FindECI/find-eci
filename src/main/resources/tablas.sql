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

alter table usuarios add constraint pk_usuarios primary key (correo);

create table carrera(
id numeric(1000) not null,
nombre varchar(100) not null,
semestre numeric(2) not null,
Ingreso numeric(4) not null,
usuario varchar(100)not null);


alter table carrera add constraint pk_carrera primary key (id);
alter table carrera add constraint fk_carrera foreign key (usuario) references usuarios(correo);

create table fetiches(
idFetiche numeric(100) not null,
nombre varchar(100) not null,
descripcion varchar(500),
usuario varchar(100) not null);

alter table fetiches add constraint pk_fetiches primary key (idfetiche);
alter table fetiches add constraint fk_fetichesf foreign key (usuario) references usuarios(correo);

create table tipo_gusto(
id_tipoGusto numeric(10) not null,
tipogusto varchar(100) not null
);

alter table tipo_gusto add constraint pk_tgusto primary key (id_tipoGusto);


create table gustos(
descripciongusto varchar(100) not null,
usuario varchar(100) not null,
tipogusto numeric(10) not null
);

alter table gustos add constraint fk_gustos1 foreign key (usuario) references usuarios(correo);
alter table gustos add constraint fk_gustos2 foreign key (tipogusto) references tipo_gusto(id_tipoGusto);



create table intereses(
id numeric(1000) not null;
sexoInteres char(100) not null,
tipoRelacion varchar(100) not null,
aspectosImportantes varchar(600),
usuario varchar(100) not null);




alter table intereses add constraint fk_intereses foreign key (usuario) references usuarios(correo);


create table interacciones(
id numeric (1000) not null,
usuario varchar(100) not null,
pareja varchar(100) not null,
likes numeric(1) not null
);

alter table interacciones add constraint pk_inter primary key (id);
alter table interacciones add constraint fk_interacciones1 foreign key (usuario) references usuarios(correo);
alter table interacciones add constraint fk_interacciones2 foreign key (pareja) references usuarios(correo);

create table matches(
id numeric(1000) not null,
usuario varchar(100) not null,
pareja varchar(100) not null,
fecha date not null
);


alter table matches add constraint pk_match primary key (id);
alter table matches add constraint fk_matches1 foreign key (usuario) references usuarios(correo);
alter table matches add constraint fk_matches2 foreign key (pareja) references usuarios(correo);


create table imagenes(
id numeric(1000) not null,
imagen bytea not null,
usuario varchar(100) not null
);

alter table imagenes add constraint pk_img primary key (id);

alter table imagenes add constraint fk_imagenes1 foreign key (usuario) references usuarios(correo);
