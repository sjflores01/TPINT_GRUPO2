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
eliminada bool,
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

CREATE PROCEDURE modificarUsuario(
in idUsuario int,
in idPersona int,
in idDireccion int,
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
in clave varchar(50)

)

BEGIN
	Update Direcciones set calle = calle, numero = numero, dpto = dpto, localidad = localidad, provincia = provincia where id = idDireccion;
    Update Personas set dni = dni, cuil = cuil, nacimiento = nacimiento, nombre = nombre, apellido = apellido, sexo = sexo, email = email, telefono = telefono where id = idPersona;
    Update Usuarios set clave = clave where id = idUsuario;

   
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
in search varchar(30),
in inicio int,
in total int
)

BEGIN
	
    Select * from Usuarios
    inner join Personas on Usuarios.idPersona = Personas.id
    inner join Direcciones on Personas.idDireccion = Direcciones.id
    where estado = 1 AND ( apellido like concat('%', search,'%') OR  dni =  search)
	limit inicio,total;
    
    
	  
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE eliminarUsuario(
in idUsuario int
)

BEGIN
	
    Update Usuarios set estado = false where id = idUsuario;
    
    
	  
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

INSERT INTO Cuentas (idUsuario, fechaCreacion, tipoCta, cbu, saldo, eliminada)
VALUES (nuevoIdUsuario, CURRENT_TIMESTAMP ,nuevoTipoCta, nuevoCbu, nuevoSaldo, 1);

END$$

DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `cargaCuenta`(
in idUsuario int,
in tipoCta int
)
BEGIN
    Insert into Cuentas(idUsuario, fechaCreacion, tipoCta, cbu, saldo, eliminada) 
                values (idUsuario, NOW(), tipoCta, FLOOR(RAND() * 9999999999), 10000, false);
END$$

DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `listarCuentas`(
in search varchar(30),
in inicio int,
in total int
)
BEGIN
    Select * from Cuentas
    inner join Tiposdecuenta on Cuentas.tipoCta = Tiposdecuenta.id
    inner join Usuarios on Cuentas.idUsuario = Usuarios.id
    inner join Personas on Usuarios.idPersona = Personas.id
    inner join Direcciones on Personas.idDireccion = Direcciones.id
    where Cuentas.eliminada = 0 AND ( Cuentas.id like concat('%', search,'%') OR  search =  "")
	limit inicio,total;
END$$

DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `getCuenta`(
in idcuenta int
)
BEGIN
	
    Select * from Cuentas
    inner join Tiposdecuenta on Cuentas.tipoCta = Tiposdecuenta.id
    inner join Usuarios on Cuentas.idUsuario = Usuarios.id
    inner join Personas on Usuarios.idPersona = Personas.id
    inner join Direcciones on Personas.idDireccion = Direcciones.id
    where Cuentas.id = idcuenta;
	  
END$$

DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `eliminarCuenta`(
n id int
)
BEGIN
    Update Cuentas set eliminada = true where Cuentas.id = id;
END$$

DELIMITER ;



call cargaUsuario('calle',234,'b','san fernando','buenos aires','123456789','5486113','tomas','dp','m','tom@','542', '1998-01-30','tomUsuario','tomContraseña');
call cargaUsuario('calle',234,'b','san fernando','buenos aires','99','54789553','juan','gonzales','m','tom@','542', '1998-01-30','tomUsuario','tomContraseña');
call modificarUsuario(1,1,1,'dbdbdbdbdbdbd',23454,'e','san isidro','catamarca','99554','5478945','pedro','rodrigues','f','tom@sdd','542', '1998-01-30','nueva contraseña');
call asignarCuenta(1,1,'000332312312',10000);
call leerUsuario(1);

call listarUsuarios("",1,10)