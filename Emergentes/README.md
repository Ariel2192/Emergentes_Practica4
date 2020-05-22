# Emergentes

-------------------------------SQL DE LA BASE DE DATOS -------------------------------
create database db_blog character set utf8 colate utf8_general_ci;

use bd_biblio;

create table usuarios (
	id int(10) unsigned auto_increment primary key not null,
	usuario varchar(50) not null,
	password varchar(50) not null,
);

create table entradas (
	id int(10) unsigned auto_incremente primary key not null,
	fecha date not null,
	titulo varchar(50) not null,
	contenido varchar(60000) not null,
	autor varchar(20)
);

insert into usuarios (usuario, password) values ('admin', 'admin123');

insert into entradas (fecha, titulo, contenido, autor) values(
	'2020-22-5',
	'Los posibles escenarios y las brechas educativas que deja el coronavirus',
	'A más de un mes y medio desde que los centros educativos cerraron para frenar la propagación del COVID-19, los estudiantes se han visto en la necesidad de continuar su formación a través de medios digitales y con ayuda de docentes que han de realizar la enseñanza-aprendizaje en esta modalidad.',
	'Anónimo'
	);

------------------------ CAPTURAS DE PANTALLA -------------------------------