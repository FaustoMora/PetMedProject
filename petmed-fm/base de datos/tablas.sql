create database petmed;
use petmed;

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
									sexo char,
									cliente_id integer not null,
									foreign key(cliente_id) references cliente(id));


create table if not exists Fisiologia(id integer auto_increment primary key,
										temperatura integer not null,
										peso integer not null,
										fecha_ingreso date not null,
										mascota_id integer not null,
										foreign key(mascota_id) references Mascota(id));


create table if not exists Cita(id integer auto_increment primary key,
								fecha_cita date not null,
								hora time not null,
								cliente_id integer not null,
								foreign key (cliente_id) references Cliente(id));

create table if not exists Medico(id integer auto_increment primary key,
									nombre varchar(45)not null,
									telefono integer not null);
									
create table if not exists Tratamiento(id integer auto_increment primary key,
									descripcion varchar(90)not null);

create table if not exists Consulta(id integer auto_increment primary key,
									fecha_consulta date not null,
									hora time not null,
									motivo varchar(45),
                                    diagnositoc varchar(100),
									medico_id integer not null,
									tratamiento_id integer null,
									mascota_id integer not null,
									foreign key(medico_id) references Medico(id),
									foreign key(tratamiento_id) references Tratamiento(id),
									foreign key(mascota_id) references Mascota(id));



create table if not exists Sintoma(id integer auto_increment primary key,
									descripcion varchar(30) not null);

create table if not exists Consulta_sintoma(id integer auto_increment primary key,
											consulta_id integer not null,
											sintoma_id integer not null,
											foreign key (consulta_id) references Consulta(id),
											foreign key (sintoma_id) references Sintoma(id));


create table if not exists Farmaco (id integer auto_increment primary key,
									nombre varchar(45) not null,
									presentacion varchar(45)not null,
									concentracion varchar(45)not null);

create table if not exists Tratamiento_farmaco(id integer auto_increment primary key,
												tratamiento_id integer not null,
												farmaco_id integer not null,
												foreign key(tratamiento_id) references Tratamiento(id),
												foreign key(farmaco_id) references Farmaco(id));



/*---------------------PROCEDURE PARA INSERCION Tratamiento/Farmaco--------------*/
delimiter //
create procedure insert_tratamiento_farmaco (in id integer ,in trat_id integer, in farm_id integer)
begin
INSERT INTO tratamiento_farmaco VALUES(id,trat_id,farm_id); 
END ; 
//
delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA ELIMINAR Tratamiento/Farmaco--------------*/
delimiter //
create procedure delete_tratamiento_farmaco (in trat_id integer)
begin
delete from tratamiento_farmaco where tratamiento_id= trat_id; 
END ; 
//
delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA ENCONTRAR Tratamiento/Farmaco-------------*/
delimiter //
create procedure find_tratamiento_farmaco (in trat_id integer, in farm_id integer)
begin
select id from tratamiento_farmaco where tratamiento_id= trat_id and farmaco_id = farm_id;
END ; 
//
delimiter ;
/*----------------------------------------------------------------------------*/
/*---------------------PROCEDURE PARA INSERCION Tratamiento--------------*/
delimiter //
create procedure insert_tratamiento (in id integer ,in des varchar(90))
begin
INSERT INTO tratamiento VALUES(id,des); 
END ; 
//
delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA ELIMINAR Tratamiento--------------*/
delimiter //
create procedure delete_tratamiento (in des varchar(90))
begin
delete from tratamiento where descripcion like des;
END ; 
//
delimiter ;
/*----------------------------------------------------------------------------*/
/*---------------------PROCEDURE PARA ENCONTRAR Tratamiento--------------*/
delimiter //
create procedure find_tratamiento (in des varchar(90))
begin
select id from tratamiento where descripcion like des;
END ; 
//
delimiter ;
/*----------------------------------------------------------------------------*/
												
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

/*---------------------PROCEDURE PARA ELIMINAR CLIENTE--------------*/
delimiter //
create procedure delete_cliente(in nom VARCHAR(45))
begin
delete from cliente where nombre like nom;
END ;
// delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA BUSCAR CLIENTE--------------*/
delimiter //
create procedure find_cliente(in nom VARCHAR(45))
begin
SELECT distinct id from cliente WHERE nombre like nom;
END ;
// delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA INGRESAR MASCOTA--------------*/
delimiter //
create procedure insert_mascota(in id integer,in nom varchar(45), in esp varchar(45), in raza varchar(45), in birth date, in sexo char, in id_dueno integer)
begin 
insert into mascota values (id,nom,esp,raza,birth,sexo,id_dueno);
end;
//delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA UPDATE MASCOTA--------------*/
delimiter //
create procedure update_mascota( in nom varchar(45), in esp varchar(45), in rz varchar(45), in birth date, in sx char, in id_dueno integer)
begin 
update mascota set especie=esp , raza = rz , fecha_nacimiento = birth , sexo = sx where (nombre like nom) and cliente_id = id_dueno;
end;
//delimiter ;
/*----------------------------------------------------------------------------*/
/*---------------------PROCEDURE PARA ELIMINAR MASCOTA--------------*/
delimiter //
create procedure delete_mascota( in nom varchar(45), in id_dueno integer)
begin
delete from mascota where nombre like nom and cliente_id = id_dueno; 
end;
//delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA ENCONTRAR MASCOTA--------------*/
delimiter //
create procedure find_mascota(in nom varchar(45),in id_dueno integer)
begin
select distinct id from mascota where (cliente_id =  id_dueno) and (nombre like nom);
end;
// delimiter ;


/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA INGRESAR MEDICO--------------*/
delimiter //
create procedure insert_medico(in id integer, in nombre varchar(45), in telefono integer)
begin
insert into medico values(id,nombre,telefono);
end;
// delimiter ;
/*----------------------------------------------------------------------------*/
/*---------------------PROCEDURE PARA MODIFICAR MEDICO--------------*/
delimiter //
create procedure update_medico(in nom varchar(45), in tlf integer)
begin
update medico set telefono=tlf where nombre like nom;
end;
// delimiter ;
/*----------------------------------------------------------------------------*/
/*---------------------PROCEDURE PARA ELIMINAR MEDICO--------------*/
delimiter //
create procedure delete_medico(in nom varchar(45))
begin
delete from medico where nombre like nom;
end;
// delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA BUSCAR MEDICO--------------*/
delimiter //
create procedure find_medico(in nom varchar(45))
begin
select id from medico where nombre like nom;
end;
// delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA INGRESAR CITA--------------*/
delimiter //
create procedure insert_cita(in id int, in fecha_reg date, in hora_reg time, in cliente_id integer)
begin
insert into cita values(id,fecha_reg,hora_reg,cliente_id);
end;
// delimiter ;

/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA MODIFICAR CITA--------------*/
delimiter //
create procedure update_cita(in fecha_reg date, in hora_reg time, in cliente integer)
begin
update cita set fecha_cita=fecha_reg, hora = hora_reg where cliente_id=cliente;
end;
// delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA ELIMINAR CITA--------------*/
delimiter //
create procedure delete_cita(in cliente integer)
begin
delete from cita where cliente_id=cliente;
end;
// delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA ENCONTRAR CITA--------------*/
delimiter //
create procedure find_cita(in cliente integer)
begin
select id from cita where cliente_id = cliente;
end;
// delimiter ;
/*----------------------------------------------------------------------------*/


/*---------------------PROCEDURE PARA INGRESAR FARMACO--------------*/

delimiter //
create procedure insert_farmaco(in id integer, in nom varchar(45), in pres varchar(45),	in dosis varchar(45))
begin
INSERT INTO Farmaco VALUES(id,nom,pres,dosis); 
END ;
// delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA UPDATE FARMACO--------------*/

delimiter //
create procedure update_farmaco(in nom varchar(45), in pres varchar(45), in dosis varchar(45))
begin
update farmaco set concentracion=dosis where nombre like nom and presentacion like pres;
END ;
// delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA ELIMINAR FARMACO--------------*/

delimiter //
create procedure delete_farmaco(in nom varchar(45), in pres varchar(45))
begin
delete from farmaco where nombre like nom and presentacion like pres;
END ;
// delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA ENCONTRAR FARMACO--------------*/

delimiter //
create procedure find_farmaco(in nom varchar(45), in pres varchar(45))
begin
select id from farmaco where nombre like nom and presentacion like pres;
END ;
// delimiter ;
/*----------------------------------------------------------------------------*/

/*--------------------PROCEDURE PARA CONSULTAR MASCOTA POR NOMBRE-------------------*/
delimiter //
create procedure consult_cliente_mascota(in nom varchar(45))
begin
select c.nombre, c.direccion, c.fecha_registro, m.nombre, m.especie from cliente c, mascota m where c.nombre like nom;
end;
// delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA INGRESAR SINTOMA--------------*/

delimiter //
create procedure insert_sintoma(in id integer, in nombre varchar(30))
begin
insert into sintoma values (id,nombre);
END ;
// delimiter ;
/*----------------------------------------------------------------------------*/
/*---------------------PROCEDURE PARA ELIMINAR SINTOMA--------------*/

delimiter //
create procedure delete_sintoma(in nombre varchar(30))
begin
delete from sintoma where descripcion like nombre;
end;
// delimiter ;
/*----------------------------------------------------------------------------*/
/*---------------------PROCEDURE PARA ENCONTRAR SINTOMA--------------*/

delimiter //
create procedure find_sintoma(in nombre varchar(30))
begin
select id from sintoma where descripcion like nombre;
END ;
// delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA INGRESAR FISIOLOGIA--------------*/

delimiter //
create procedure insert_fisiologia(in id integer, in temperatura integer, in peso integer, in fecha_ing date, in mascota_id integer)
begin
insert into fisiologia value(id,temperatura,peso,fecha_ing,mascota_id);
END ;
// delimiter ;
/*----------------------------------------------------------------------------*/
/*---------------------PROCEDURE PARA MODIFICAR FISIOLOGIA--------------*/

delimiter //
create procedure update_fisiologia(in tem integer, in w integer, in fecha date, in masc_id integer)
begin
update fisiologia set temperatura=tam, peso=w where mascota_id=masc_id and fecha_ingreso = fecha;
END ;
// delimiter ;

/*----------------------------------------------------------------------------*/
/*---------------------PROCEDURE PARA ELIMINAR FISIOLOGIA--------------*/

delimiter //
create procedure delete_fisiologia(in masc_id integer, in fecha date)
begin
delete from fisiologia where mascota_id=masc_id and fecha_ingreso =fecha;
END ;
// delimiter ;
/*----------------------------------------------------------------------------*/
/*---------------------PROCEDURE PARA ENCONTRAR FISIOLOGIA--------------*/

delimiter //
create procedure find_fisiologia(in masc_id integer, in fecha date)
begin
select id from fisiologia where mascota_id=masc_id and fecha_ingreso = fecha;
END ;
// delimiter ;
/*----------------------------------------------------------------------------*/

/*---------------------PROCEDURE PARA INGRESAR CONSULTA/SINTOMA--------------*/ç
delimiter //
create procedure insert_consulta_sintoma(in id integer, in consul_id integer, in sint_id integer)
begin
insert into consulta_sintoma values (id,consul_id,sint_id);
END;
// delimiter ;
/*----------------------------------------------------------------------------*/
/*---------------------PROCEDURE PARA DELETE CONSULTA/SINTOMA--------------*/ç
delimiter //
create procedure delete_consulta_sintoma(in consul_id integer, in sint_id integer)
begin
delete from consulta_sintoma where consulta_id=consul_id and sintoma_id=sint_id;
END;
// delimiter ;
/*----------------------------------------------------------------------------*/
/*---------------------PROCEDURE PARA ENCONTRAR CONSULTA/SINTOMA--------------*/ç
delimiter //
create procedure find_consulta_sintoma(in consul_id integer, in sint_id integer)
begin
select * from consulta_sintoma where consulta_id=consul_id and sintoma_id=sint_id;
END;
// delimiter ;
/*----------------------------------------------------------------------------*/
/*---------------------PROCEDURE PARA INSERTAR CONSULTA--------------*/ç
delimiter //
create procedure insert_consulta(in id integer, in fecha date, in hora time, in motivo varchar(45), in diagnos varchar(100), in medico_id integer, in trat_id integer, in mascota_id integer)
begin
insert into consulta values(id,fecha,hora,motivo,diagnos,medico_id,trat_id,mascota_id);
END;
// delimiter ;
/*----------------------------------------------------------------------------*/
/*---------------------PROCEDURE PARA ELIMINAR CONSULTA--------------*/ç
delimiter //
create procedure delete_consulta(in fecha date, in med_id integer, in masc_id integer)
begin
delete from  consulta where fecha_consulta=fecha and medico_id =med_id and mascota_id=masc_id;
END;
// delimiter ;
/*----------------------------------------------------------------------------*/
/*---------------------PROCEDURE PARA ENCONTRAR CONSULTA--------------*/ç
delimiter //
create procedure find_consulta(in fecha date, in med_id integer, in masc_id integer)
begin
select id from consulta where fecha_consulta=fecha and medico_id =med_id and mascota_id=masc_id;
END;
// delimiter ;
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------*/