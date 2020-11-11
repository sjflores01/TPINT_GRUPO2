drop database TPINT_GRUPO2;
create database TPINT_GRUPO2;
use TPINT_GRUPO2;

CREATE TABLE Direcciones (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
calle varchar(100),
numero int,
dpto varchar(10),
localidad varchar(100),
provincia varchar(50)
);

CREATE TABLE Personas (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
dni varchar(10),
cuil varchar(10),
nombre varchar(50),
apellido varchar(50),
sexo char,
idDireccion int,
email varchar(100),
telefono varchar(20),
nacimiento date,
FOREIGN KEY (idDireccion) REFERENCES Direcciones(id)
);

CREATE TABLE TiposDeUsuario (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
descripcion varchar(10)
);

CREATE TABLE Usuarios (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
idPersona int,
estado bool,
nombreUsuario varchar(50),
clave varchar(50),
FOREIGN KEY (idPersona) REFERENCES Personas(id)
);

create table UsuariosAdmin (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
estado bool,
nombreUsuario varchar(50),
clave varchar(50)
);
INSERT INTO UsuariosAdmin (estado, nombreUsuario, clave) VALUES (1,'AdminUser','admin1');

CREATE TABLE TiposDeCuenta (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
descripcion varchar(10));
INSERT INTO tiposdecuenta (descripcion) values ('CA$');
INSERT INTO tiposdecuenta (descripcion) values ('CTA.CTE$');
INSERT INTO tiposdecuenta (descripcion) values ('CAUSD');


CREATE TABLE Cuentas (
id int NOT NULL AUTO_INCREMENT,
idUsuario int NOT NULL,
fechaCreacion datetime,
tipoCta int,
cbu varchar(30) unique,
saldo decimal,
FOREIGN KEY (tipoCta) REFERENCES TiposDeCuenta(id),
FOREIGN KEY (idUsuario) REFERENCES Usuarios(id),
PRIMARY KEY (id)
);
CREATE TABLE TiposDeMovimiento (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
descripcion varchar(50)
);

CREATE TABLE Movimientos (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
fecha date,
detalle varchar(150),
importe decimal,
idTipo int,
FOREIGN KEY (idTipo) REFERENCES TiposDeMovimiento(id)
);

CREATE TABLE Prestamos (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
idUsuario int,
fecha date,
importePedido decimal,
importeTotal decimal,
montoMensual decimal,
cantCuotas int,
plazoPago int,
FOREIGN KEY (idUsuario) REFERENCES Usuarios(id)
);

CREATE TABLE PagosCuotas (
idPrestamo int not null,
importe decimal,
FOREIGN KEY (idPrestamo) REFERENCES Prestamos(id)
);


DELIMITER $$

CREATE PROCEDURE cargaUsuario(
in calle varchar(100),
in numero int,
in dpto varchar(10),
in localidad varchar(100),
in provincia varchar(50),
in dni varchar(10),
in cuil varchar(10),
in nombre varchar(50),
in apellido varchar(50),
in sexo char,
in email varchar(100),
in telefono varchar(20),
in nacimiento date,
in nombreUsuario varchar(50),
in clave varchar(50)

)

BEGIN
	DECLARE idDireccion INT DEFAULT 0;
	DECLARE idPersona INT DEFAULT 0;
    Insert into Direcciones(calle,numero,dpto,localidad,provincia) values (calle,numero,dpto,localidad,provincia);
    
	SELECT  id
    INTO idDireccion
    FROM Direcciones ORDER BY id DESC LIMIT 1;
    
	 
	Insert into Personas(dni,cuil,nacimiento,nombre,apellido,sexo,idDireccion,email,telefono) values (dni,cuil,nacimiento,nombre,apellido,sexo,idDireccion,email,telefono);
	
    SELECT  id
    INTO idPersona
    FROM Personas ORDER BY id DESC LIMIT 1;
    
    Insert into Usuarios(idPersona,estado,nombreUsuario,clave) values (idPersona,true,nombreUsuario,clave);
    
    
	  
END$$
DELIMITER ;

DELIMITER $$

CREATE PROCEDURE leerUsuario(
in idleer int
)

BEGIN
	
    Select * from Usuarios 
    inner join Personas on Usuarios.idPersona = Personas.id
    inner join Direcciones on Personas.idDireccion = Direcciones.id
    where Usuarios.id = idleer;
    
	  
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE listarUsuarios(
in search varchar(30)
)

BEGIN
	
    Select * from Usuarios 
    inner join Personas on Usuarios.idPersona = Personas.id
    inner join Direcciones on Personas.idDireccion = Direcciones.id
    where estado = 1 AND ( apellido like concat('%', search,'%') OR  dni =  search);
    
    
	  
END$$
DELIMITER ;

DELIMITER $$

CREATE PROCEDURE asignarCuenta (
in nuevoIdUsuario int,
in nuevoTipoCta int,
in nuevoCbu varchar(30),
in nuevoSaldo decimal
)
BEGIN

INSERT INTO Cuentas (idUsuario, fechaCreacion, tipoCta, cbu, saldo)
VALUES (nuevoIdUsuario, CURRENT_TIMESTAMP ,nuevoTipoCta, nuevoCbu, nuevoSaldo);

END$$

DELIMITER ;

call cargaUsuario('calle',234,'b','san fernando','buenos aires','123456789','5486113','tomas','dp','m','tom@','542', '1998-01-30','tomUsuario','tomContraseña');
call cargaUsuario('calle',234,'b','san fernando','buenos aires','99','54789553','juan','gonzales','m','tom@','542', '1998-01-30','tomUsuario','tomContraseña');
call asignarCuenta(1,1,'000332312312',10000);
call leerUsuario(1);




