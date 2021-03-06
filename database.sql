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
cuil varchar(20),
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
INSERT INTO UsuariosAdmin (estado, nombreUsuario, clave) VALUES (1,'a','a');
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
saldo float,
eliminada bool,
FOREIGN KEY (tipoCta) REFERENCES TiposDeCuenta(id),
FOREIGN KEY (idUsuario) REFERENCES Usuarios(id),
PRIMARY KEY (id)
);
CREATE TABLE TiposDeMovimiento (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
descripcion varchar(50)
);
INSERT INTO TiposDeMovimiento (descripcion) VALUES ('Debito');
INSERT INTO TiposDeMovimiento (descripcion) VALUES ('Credito');

CREATE TABLE Movimientos (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
idDestino int not null,
fecha datetime,
detalle varchar(150),
importe float,
idTipo int,
idOrigen int,
FOREIGN KEY (idDestino) REFERENCES Cuentas(id),
FOREIGN KEY (idTipo) REFERENCES TiposDeMovimiento(id),
FOREIGN KEY (idOrigen) REFERENCES Cuentas(id)
);

CREATE TABLE Prestamos (
id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
idUsuario int,
fecha date,
importePedido float,
importeTotal float,
montoMensual float,
cantCuotas int,
cuotasPagas int,
plazoPago int,
aprobado bool,
rechazado bool,
cbu varchar(30),
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
in cuil varchar(20),
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
in nuevoSaldo float
)
BEGIN

INSERT INTO Cuentas (idUsuario, fechaCreacion, tipoCta, cbu, saldo, eliminada)
VALUES (nuevoIdUsuario, CURRENT_TIMESTAMP ,nuevoTipoCta, nuevoCbu, nuevoSaldo, 0);

END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE contarMails (
in mail varchar (100)
)
BEGIN

Select count(*) from Personas where email = mail;

END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE contarDni (
in inDni varchar (100)
)
BEGIN

Select count(*) from Personas where dni = inDni;

END$$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE contarUsuario (
in nombre varchar (100)
)
BEGIN

Select count(*) from Usuarios where nombreUsuario = nombre;

END$$

DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `modificarCuenta`(
in tipoCta int,
in saldo float,
in id int
)
BEGIN
	Update Cuentas set Cuentas.tipoCta = tipoCta,
                       Cuentas.saldo = saldo
			where Cuentas.id = id;
END$$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE Login_Admin(
in nombre varchar(50),
in contraseña varchar(50)

)
BEGIN

select * from usuariosadmin
where (nombreUsuario = nombre and clave = contraseña and estado = 1);

END$$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE Login_User(
in nombre varchar(50),
in contraseña varchar(50)

)
BEGIN



Select * from Usuarios 
    inner join Personas on Usuarios.idPersona = Personas.id
    inner join Direcciones on Personas.idDireccion = Direcciones.id
    where (nombreUsuario = nombre and clave = contraseña and estado = 1);



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
in id int
)
BEGIN
    Update Cuentas set eliminada = true where Cuentas.id = id;
END$$

DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `listarCuentas`(
in search varchar(30)
)
BEGIN
    Select * from Cuentas
    inner join Tiposdecuenta on Cuentas.tipoCta = Tiposdecuenta.id
    inner join Usuarios on Cuentas.idUsuario = Usuarios.id
    inner join Personas on Usuarios.idPersona = Personas.id
    inner join Direcciones on Personas.idDireccion = Direcciones.id
    where Cuentas.eliminada = 0 AND ( Cuentas.id like concat('%', search,'%') OR  search =  "");
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
CREATE PROCEDURE `listarPrestamos`()
BEGIN
    Select * from Prestamos
    inner join Usuarios on Prestamos.idUsuario = Usuarios.id
    inner join Personas on Usuarios.idPersona = Personas.id
    where Prestamos.aprobado = 0 and Prestamos.rechazado = 0 and cantCuotas > cuotasPagas;
END$$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `leerPrestamo`(
in idParametro int
)
BEGIN
    Select * from Prestamos
    inner join Usuarios on Prestamos.idUsuario = Usuarios.id
    inner join Personas on Usuarios.idPersona = Personas.id
    where Prestamos.id = idParametro;
    
END$$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `listarPrestamosActivosDeUser`(
in idParametro int
)
BEGIN
    Select * from Prestamos
    inner join Usuarios on Prestamos.idUsuario = Usuarios.id
    inner join Personas on Usuarios.idPersona = Personas.id
    where Prestamos.aprobado = 1 and Prestamos.rechazado = 0 and idUsuario = idParametro and cantCuotas > cuotasPagas;
END$$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `contarPrestamosPendientes`(
in idParametro int
)
BEGIN
    Select Count(*) from Prestamos
    inner join Usuarios on Prestamos.idUsuario = Usuarios.id
    inner join Personas on Usuarios.idPersona = Personas.id
    where Prestamos.aprobado = 0 and Prestamos.rechazado = 0 and idUsuario = idParametro;
END$$

DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `aprobarPrestamo`(
in idParametro int
)
BEGIN
  
    DECLARE montoPedido float DEFAULT 0;
	DECLARE cbuCuenta varchar(30);
    DECLARE idCuenta int;
  
	Update Prestamos set aprobado = true 
    where Prestamos.id = idParametro;
    
    Select cbu
    into cbuCuenta
    from Prestamos where Prestamos.id = idParametro;
    
    Select importePedido
    into montoPedido
    from Prestamos where Prestamos.id = idParametro;
    
	Select id 
   into idCuenta
   from Cuentas where cbu = cbuCuenta;
    
    
    
    Insert into Movimientos (idDestino, idOrigen, fecha, detalle, importe, idTipo) values (idCuenta, 11, CURRENT_TIMESTAMP, 'Prestamo', montoPedido, 1);
    update Cuentas set saldo = saldo + montoPedido where Cuentas.id = idCuenta;
    
    
END$$

DELIMITER ;




DELIMITER $$
CREATE PROCEDURE `cancelarPrestamo`(
in id int
)
BEGIN
    Update Prestamos set rechazado = true 
    where Prestamos.id = id;
END$$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE  chequeaLoginCliente(
in usuario varchar(50),
in pass varchar(50)
)
BEGIN
	
    Select Count(*) from usuarios 
    where nombreUsuario = usuario and clave = pass and estado = 1;
  
  
END$$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE hacerTransferencia(
in idCuentaOrigen int,
in idCuentaDestino int,
in importeOperacion float,
in concepto varchar(150)
)

BEGIN
	
    Insert into Movimientos (idDestino, idOrigen, fecha, detalle, importe, idTipo) values (idCuentaDestino, idCuentaOrigen, CURRENT_TIMESTAMP, concepto, importeOperacion, 1);
    update Cuentas set saldo = saldo + importeOperacion where id = idCuentaDestino;
    update Cuentas set saldo = saldo - importeOperacion where id = idCuentaOrigen;
    
    
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE listarMovimientos(
in cbuCuenta varchar(30)
)

BEGIN
	
    select  O.cbu as cbuOrigen, D.cbu as cbuDestino, M.importe, M.fecha, M.detalle  from Movimientos as M 
    inner join Cuentas as O on M.idOrigen = O.id
    inner join Cuentas as D on M.idDestino = D.id
	where O.cbu = cbuCuenta or D.cbu = cbuCuenta
    order by fecha desc;
   
    
    
    
END$$
DELIMITER ;
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE listarMovimientosFiltrados(
in cbuCuenta varchar(30),
in importeFiltro float
)

BEGIN
	
    select  O.cbu as cbuOrigen, D.cbu as cbuDestino, M.importe, M.fecha, M.detalle  from Movimientos as M 
    inner join Cuentas as O on M.idOrigen = O.id
    inner join Cuentas as D on M.idDestino = D.id
	where O.cbu = cbuCuenta or D.cbu = cbuCuenta
    and M.importe <= importeFiltro
    order by fecha desc;
   
    
    
    
END$$
DELIMITER ;



DELIMITER $$
CREATE PROCEDURE traerCuentasUsuario(
in idUsuarioCliente int
)

BEGIN
	
    Select * From Cuentas c
    Inner Join tiposdecuenta tc
    on c.tipoCta = tc.id
    WHERE idUsuario = idUsuarioCliente
    AND eliminada = false;
    
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE chequearCbu(
in cbuParametro varchar(30)
)

BEGIN
	
   Select Count(*) from Cuentas where cbu = cbuParametro and eliminada = 0;
    
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE getIdCuenta(
in cbuParametro varchar(30)
)

BEGIN
	
   Select id from Cuentas where cbu = cbuParametro;
    
END$$
DELIMITER ;

DELIMITER $$

CREATE PROCEDURE solicitarPrestamo(
in cbu varchar(30),
in idUsuarioParametro int,
in importeSolicitado float,
in totalApagar float,
in importeMensual float,
in cantidadCuotas int


)

BEGIN
	
   Insert into Prestamos (idUsuario, fecha, importePedido, importeTotal, montoMensual, cantCuotas, cuotasPagas,plazoPago, aprobado, rechazado, cbu) values (idUsuarioParametro, CURRENT_DATE, importeSolicitado, totalApagar, importeMensual, cantidadCuotas, 0, cantidadCuotas, false, false, cbu);
    
	  
END$$
DELIMITER ;

DELIMITER $$

CREATE PROCEDURE PagarCuota(
in idCuentaPaga int,
in idPrestamo int



)

BEGIN
	
   DECLARE montoDeCuota INT DEFAULT 0;
   
   
   Update Prestamos set cuotasPagas = cuotasPagas + 1
   where id = idPrestamo;
   
   Select montoMensual 
   into montodeCuota
   from prestamos where id = idPrestamo;
   
   Insert into Movimientos (idDestino, idOrigen, fecha, detalle, importe, idTipo) values (11, idCuentaPaga, CURRENT_TIMESTAMP, 'Cuota', montodeCuota, 1);
    update Cuentas set saldo = saldo - montodeCuota where id = idCuentaPaga;
   
  
   
   -- HACER TRANSFERENCIA DE PAGO
  
	  
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE contarCuentas(
in idParametro int

)
BEGIN
    Select Count(*) from cuentas where idUsuario = idParametro and eliminada = false;
END$$

DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `informePrestamos`()
BEGIN
SELECT
COUNT(*) AS cantidadPrestamos,
SUM(cuotasPagas) AS cuotasPagas,
(SUM(cantCuotas)/COUNT(*)) AS promedioCuotas,
(SUM(importePedido)/COUNT(*)) AS promedioSaldoPedido,
SUM(montoMensual) AS saldoMensual
FROM prestamos where aprobado = 1;
END$$

DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `informeInpagos`()
BEGIN
SELECT
COUNT(*) AS cantidadPrestamos,
SUM(cuotasPagas) AS cuotasPagas,
(SUM(cantCuotas)/COUNT(*)) AS promedioCuotas,
(SUM(importePedido)/COUNT(*)) AS promedioSaldoPedido,
SUM(montoMensual) AS saldoMensual
FROM prestamos where (to_days(now()) - to_days(fecha)) > 60;
END$$

DELIMITER ;


call cargaUsuario('calle',234,'b','san fernando','buenos aires','123456789','5486113','tomas','dp','M','tom@','542', '1998-01-30','tomUsuario','tomContraseña');
call cargaUsuario('calle',234,'b','san fernando','buenos aires','1','54789223','Oscar','Rodriguez','M','eloski@oski.com','542', '1998-01-30','oscar','tomContraseña');
call cargaUsuario('hola',234,'b','Zona Sur','santa fe','2','54789116','Kiko','Vamoniubal','M','kiko@niubal.com','542', '1998-01-30','vamoniubal','tomContraseña');
call cargaUsuario('caseros',234,'b','san fernando','buenos aires','3','54789443','allbo','gonzales','M','tom@','542', '1998-01-30','allboys','tomContraseña');
call cargaUsuario('hudson',234,'b','san fernando','buenos aires','4','54789555','capo','gonzales','M','tom@','542', '1998-01-30','capo','tomContraseña');
call cargaUsuario('pappo',234,'b','san fernando','buenos aires','5','54789573','teo','gonzales','M','tom@','542', '1998-01-30','teo','tomContraseña');
call cargaUsuario('rock',234,'b','san fernando','buenos aires','6','54789513','asdasd','gonzales','M','tom@','542', '1998-01-30','aaaassUsuariaa','tomContraseña');
call cargaUsuario('callejeros',234,'b','san fernando','buenos aires','7','54789523','jorge','gonzales','M','tom@','542', '1998-01-30','datatable','tomContraseña');
call cargaUsuario('abc',234,'b','san fernando','buenos aires','8','54789550','especial','gonzales','M','tom@','542', '1998-01-30','aguante','tomContraseña');
call cargaUsuario('daoachuras',234,'b','san fernando','buenos aires','9','54789551','mortal','gonzales','M','tom@','542', '1998-01-30','java','tomContraseña');
call cargaUsuario('blabla',234,'b','san fernando','buenos aires','10','54789554','kombat','gonzales','M','tom@','542', '1998-01-30','blabla','tomContraseña');
call cargaUsuario('blabla',234,'b','san fernando','buenos aires','11','54789552','juan','gonzales','M','tom@','542', '1998-01-30','useraa','tomContraseña');
call modificarUsuario(1,1,1,'dbdbdbdbdbdbd',23454,'e','san isidro','catamarca','99554','5478945','pedro','rodrigues','F','tom@sdd','542', '1998-01-30','nueva contraseña');
call asignarCuenta(1,1,'000332312312',10000);
call asignarCuenta(2,1,'000332312313',10000);
call asignarCuenta(3,1,'000332312314',10000);
call asignarCuenta(4,1,'000332312315',10000);
call asignarCuenta(5,1,'000332312316',10000);
call asignarCuenta(6,1,'000332312317',10000);
call asignarCuenta(7,1,'000332312318',10000);
call asignarCuenta(8,1,'000332312319',10000);
call asignarCuenta(2,1,'000332312320',10000);


-- SI ASIGNAN MAS USUARIOS O CUENTAS, HAGANLO DESPUES DE ESTE BLOQUE PORQUE ACA ASIGNO AL USUARIO Y CUENTA DEL BANCO, Y SI LE METEN ANTES SE CORREN LAS ID
insert into Usuarios (estado, nombreUsuario, clave) values (0,'BANCO','BANCO');
insert into Cuentas (idUsuario, cbu, saldo, eliminada ) values (13,'BANCO', 99999999999999, 1);


-- FIN
call leerUsuario(1);
call contarMails('tom@');
call contarDni('99');
call contarUsuario('tomUsuario');
call listarUsuarios("");
call cargaCuenta(1,1);
call chequeaLoginCliente('teo','tomContraseña');
call chequeaLoginCliente('dad','tomdsasdw');
call hacerTransferencia(1,2,1000,'Transferencia');
call hacerTransferencia(4,2,5487,'Transferencia');
call hacerTransferencia(1,2,999,'Transferencia');
call hacerTransferencia(2,3,457,'Transferencia');
call hacerTransferencia(9,4,9000,'Transferencia');
call listarMovimientos('000332312313');
call listarMovimientos('000332312320');
call chequearCbu('000332312320');
call getIdCuenta('000332312314');
call solicitarPrestamo('000332312313',2,70.40,12.41,2500,6);
 call listarPrestamos();
call listarPrestamosActivosDeUser(2);
call contarPrestamosPendientes (2);
call leerPrestamo(1);
call aprobarPrestamo(1);
select * from Prestamos;







