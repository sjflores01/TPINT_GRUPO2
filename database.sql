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
nombre varchar(50),
apellido varchar(50),
sexo char,
idDireccion int,
email varchar(100),
telefono varchar(20),
nacimiento datetime,
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
clave varchar(10),
FOREIGN KEY (idPersona) REFERENCES Personas(id)

);



CREATE TABLE TiposDeCuenta (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
descripcion varchar(10));

CREATE TABLE Cuentas (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
idUsuario int,
numero int,
fechaCreacion date,
tipoCta int,
cbu varchar(20),
saldo decimal,
FOREIGN KEY (tipoCta) REFERENCES TiposDeCuenta(id),
FOREIGN KEY (idUsuario) REFERENCES Usuarios(id)
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

Select * from Usuarios;
Select * from Direcciones;
Select * from Personas;


