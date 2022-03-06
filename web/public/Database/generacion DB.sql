drop DATABASE if EXISTS adoptame;

CREATE DATABASE adoptame;

use adoptame;

drop TABLE if EXISTS usuario;

CREATE TABLE usuario(
	id INTEGER PRIMARY KEY not null auto_increment,
	nombrep VARCHAR(40) not null,
	apellidop VARCHAR(40) not null,
	telefonop INTEGER not null,
	correop VARCHAR(40) not null,
	edadp INTEGER not null,
	direccionp VARCHAR(40) not null,
	ciudadp VARCHAR(40) not null,
	generop VARCHAR(40) not null	
);

drop TABLE if EXISTS mascota;

CREATE TABLE mascota(
	id INTEGER PRIMARY KEY not null auto_increment,
	nombre VARCHAR(40) not null,
	categoria VARCHAR(40) not null,
	raza VARCHAR(40) not null,
	edad INTEGER not null,
	descripcion VARCHAR(255) not null,
	genero VARCHAR(40) not null
);

drop TABLE if EXISTS usuario_mascota;

CREATE TABLE usuario_mascota(
	id INTEGER PRIMARY KEY not null auto_increment,
	id_usuario INTEGER not null,
	id_mascota INTEGER not null,
	fecha_de_adopcion datetime DEFAULT CURRENT_TIMESTAMP not null,
	FOREIGN KEY (id_usuario) REFERENCES usuario(id),
	FOREIGN KEY (id_mascota) REFERENCES mascota(id)
);

INSERT into usuario (nombre, apellido, telefono, correo, edad, direccion, ciudad, genero)
	values ("Alan", "Rodriguez",3026082193,"RodAlan@gmail.com",18,"cra 10 - 7","caldas","Masculino"),
	("Jacinto", "Gomez",3251685848,"GomJacinto@gmail.com",28,"cra 110 - 9","medellin","Masculino"),
	("Alicia", "Gonzalez",3283314914,"GonAlicia@gmail.com",15,"cra 70 - 28","bogota","Femenino"),
	("Jesus", "García",3006466274,"GarJesus@gmail.com",31,"cra 90 - 78","cota","Masculino");
	
INSERT into mascota (nombre,categoria,raza,edad, descripcion,genero)
	values ("Truns","Perro","Criollo",5,"Es un fiel amigo jugeton","Macho"),
	("Niculas","Perro","Criollo",3,"Es enano","Macho"),
	("Nala","Gata","Siamesez",1,"Le agrada mucho dormir","Hembra"),
	("Sombra","Gata","Ruso azul",4,"Esta Gorada","Hembra");
	
INSERT into usuario_mascota(id_usuario, id_mascota)
	values (3,2),
	(1,4),
	(2,1),
	(4,3);