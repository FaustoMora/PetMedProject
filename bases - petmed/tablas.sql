create table if not exists Cliente (id integer auto_increment primary key,
									nombre varchar(45),
									direccion varchar(45),
									telefono integer,
									fecha_registro date);/*en el modelo lógico fecha_registro está como tipo varchar*/

create table if not exists Mascota(id integer auto_increment primary key,
									nombre varchar(45),
									especie varchar(45),
									raza varchar(45),
									fecha_nacimiento date,
									sexo char);

create table if not exists Cliente_mascota(id integer auto_increment primary key,
											cliente_id integer not null,
											mascota_id integer not null,
											foreign key (cliente_id) REFERENCES Cliente(id),
											foreign key (mascota_id) references Mascota(id));

create table if not exists Caracteristica(id integer auto_increment primary key,
											mascota_id integer not null,
											foreign key(mascota_id) references Mascota(id));

create table if not exists Fisiologia(id integer auto_increment primary key,
										tamaño integer not null,
										peso integer not null,
										fecha_ingreso date not null,
										mascota_id integer not null,
										foreign key(mascota_id) references Mascota(id));

create table if not exists Cita(id integer auto_increment primary key,
								fecha_cita date not null,
								hora timestamp not null,
								cliente_id integer not null,
								foreign key (cliente_id) references Cliente(id));

create table if not exists Medico(id integer auto_increment primary key,
									nombre varchar(45)not null,
									telefono int not null);

create table if not exists Tratamiento(id integer auto_increment primary key,
										descripcion varchar(90)not null);

create table if not exists Consulta(id integer auto_increment primary key,
									fecha_consulta date not null,
									hora time not null,
									motivo varchar(45),
									medico_id integer not null,
									tratamiento_id integer null,
									mascota_id integer not null,
									foreign key(medico_id) references Medico(id),
									foreign key(tratamiento_id) references Tratamiento(id),
									foreign key(mascota_id) references Mascota(id));

create table if not exists Vacuna(id integer auto_increment primary key,
									fecha_vacuancion date not null,
									tipo varchar(39) not null,
									mascota_id integer not null,
									foreign key (mascota_id) references Mascota(id));

create table if not exists Sintoma(id integer auto_increment primary key,
									descripcion varchar(30) not null);

create table if not exists Consulta_sintoma(id integer auto_increment primary key,
											consulta_id integer not null,
											sintoma_id integer not null,
											foreign key (consulta_id) references Consulta(id),
											foreign key (sintoma_id) references Sintoma(id));

create table if not exists Diagnostico (id integer auto_increment primary key,
										patologia varchar(45) not null);		

create table if not exists Diagnostico_consulta(id integer auto_increment primary key,
												consulta_id integer not null,
												diagnostico_id integer not null,
												foreign key (consulta_id) references Consulta(id),
												foreign key (diagnostico_id) references Diagnostico(id));

create table if not exists Farmaco (id integer auto_increment primary key,
									nombre varchar(45) not null,
									presentacion varchar(45)not null,
									concentracion varchar(45)not null);

create table if not exists Tratamiento_farmaco(id integer auto_increment primary key,
												tratamiento_id integer not null,
												farmaco_id integer not null,
												foreign key(tratamiento_id) references Tratamiento(id),
												foreign key(farmaco_id) references Farmaco(id));

												
/*---------------------PROCEDURE PARA INSERCION EN TABLA CLIENTE--------------*/
delimiter //
create procedure insert_cliente (in id integer ,in nombre varchar(45),in direccion varchar(45),in telefono integer,in fecha_registro date)
begin
INSERT INTO cliente VALUES(id,nombre,direccion,telefono,fecha_registro); 
END ; 
//
delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA UPDATE CLIENTE--------------*/

delimiter //
create procedure update_cliente(in nom VARCHAR(45), in direc varchar(45), in tlf integer)
begin
UPDATE cliente SET direccion=direc, telefono=tlf WHERE nombre like nom;
END ;
// delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA ENCONTRAR CLIENTE--------------*/

delimiter //
create procedure find_cliente(in nom VARCHAR(45))
begin
SELECT count(*) from cliente WHERE nombre like nom;
END ;
// delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA INGRESAR FARMACO--------------*/

delimiter //
create procedure insert_farmaco(in id integer, in nom varchar(45), in pres varchar(45),	in concen varchar(45),in fecha_registro date)
begin
INSERT INTO Farmaco VALUES(id,nom,pres,concen,fecha_registro); 
END ;
// delimiter ;
/*----------------------------------------------------------------------------*/