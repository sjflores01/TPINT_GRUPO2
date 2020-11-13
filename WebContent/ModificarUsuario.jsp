<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@page import="dominio.Direccion"%>
<%@page import="dominio.Persona"%>
<%@page import="dominio.Usuario"%>
<%@page import="java.sql.Date"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Cliente</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
	integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
	crossorigin="anonymous"></script>
</head>
<body>
	<% Usuario usuario; 
	if(request.getAttribute("usuario") == null)
	{
		
	    Date fecha = new Date(2000, 5, 5);
		Direccion direccion = new Direccion("ph", 0, "ph", "ph", "ph");
		Persona persona = new Persona(0, "ph","ph" , "ph", "ph", "ph", "ph", 'p',fecha , direccion);
	    usuario = new Usuario(0, "ph", "ph", persona);
	    
	} else{		
		
		usuario = (Usuario) request.getAttribute("usuario");
	}
	
	
	%>
	<nav class="navbar navbar-expand-large navbar-light"
		style="background-color: #e3f2fd;"> <a class="navbar-brand"
		href="#">BANCO JAVA ADMIN</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<div class="row">
				<div class="col-md-2">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Clientes </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#">Nuevo cliente</a> <a
								class="dropdown-item" href="#">Modificar cliente</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Eliminar cliente</a>
						</div></li>
				</div>
				<div class="col-md-2">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Cuentas </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#">Nueva cuenta</a> <a
								class="dropdown-item" href="#">Modificar cuenta</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Eliminar cuenta</a>
						</div></li>
				</div>
				<div class="col-md-3">
					<li class="nav-item"><a class="nav-link" href="#">Solicitudes
							de prestamos</a></li>
				</div>
				<div class="col-md-2">
					<li class="nav-item"><a class="nav-link" href="#">Informes</a>
					</li>
				</div>
			</div>
		</ul>
	</div>
	</nav>
	<div class="container">
		<div class="row mt-2">
			<div class="col-md-12">
				<h3 class="display-4 text-info">Modificar cliente</h3>
				<div style="height:50px"></div>	
			</div>
		</div>
		<div class="row mt-2 d-flex justify-content-center">
		<h2>Modificar Datos Personales</h2>
		</div>
		<div class="row mt-2 d-flex justify-content-center"
			style="position: relative; top: 50px">
			<div class="col-md-6" style="">
				<form action="ServletUsuario" method="get">
					<div class="form-row">

						<div class="col">
						 <label for="Nombre">Nombre:</label>
							<input type="text" class="form-control" name="TXTnombrePersona"
								id="nombre" aria-describedby="emailHelp" placeholder="Nombres" value=<%=usuario.getPersona().getNombre() %>>
						</div>
						<div class="col">
						 <label for="Apellido">Apellido:</label>
							<input type="text" class="form-control" name="TXTapellido"
								id="apellido" aria-describedby="emailHelp"
								placeholder="Apellidos" value=<%=usuario.getPersona().getApellido() %>>
						</div>

					</div>
					<div style="height:30px"></div>	
					<div class="form-row">
						<div class="col">
						 <label for="Dni">Dni:</label>
							<input type="text" class="form-control" name="TXTdni" id="dni"
								aria-describedby="emailHelp" placeholder="DNI" value=<%=usuario.getPersona().getDni() %>>
						</div>
						<div class="col">
						 <label for="cuil">Cuil:</label>
							<input type="text" class="form-control" name="TXTcuil"
								id="cuil" aria-describedby="emailHelp" placeholder="Cuil" value=<%=usuario.getPersona().getCuil() %>>
						</div>
						
						<div class="col">
						 <label for="contraseña">Contraseña:</label>
							<input type="password" class="form-control" name="TXTpass"
								id="password" aria-describedby="emailHelp" placeholder="contraseña" value=<%=usuario.getClave() %>>
						</div>
					</div>
					<div style="height:30px"></div>	
					<div class="form-row">
						<div class="col">
							<input type="number" class="form-control" name="TXTdia" id="nacimiento"
								aria-describedby="emailHelp" placeholder="DD" value=<%=usuario.getPersona().getFnac().getDate() %>>
						</div>
						<div class="col">
							 
							<input type="number" class="form-control" name="TXTmes" id="nacimiento"
								aria-describedby="emailHelp" placeholder="MM" value=<%=usuario.getPersona().getFnac().getMonth() %>>
						</div>
						<div class="col">
							
							<input type="number" class="form-control" name="TXTanio" id="nacimiento"
								aria-describedby="emailHelp" placeholder="YYYY" value=<%=usuario.getPersona().getFnac().getYear() %>>
						</div>
						<div class="col" style="position:relative; bottom:30px">
							<label for="sexo">Sexo:</label>
							<select class="form-control"  id="sexo" name=TXTsexo>
							<option value="M">Masculino</option>
							<option value="F">Femenino</option>
							</select>
						</div>
					</div>
					<div class="form-row">

						<div class="col">
							<label for="provincia">Provincia:
							</label> <select class="form-control"
								id="provincia" name=TXTprovincia>
								<option value="CABA">CABA</option>
								<option value="Buenos Aires">Buenos Aires</option>
								<option value="Catamarca">Catamarca</option>
								<option value="Chaco">Chaco</option>
								<option value="Chubut">Chubut</option>
								<option value="Cordoba">Cordoba</option>
								<option value="Corrientes">Corrientes</option>
								<option value="Entre rios">Entre rios</option>
								<option value="Formosa">Formosa</option>
								<option value="Jujuy">Jujuy</option>
								<option value="La Pampa">La Pampa</option>
								<option value="La rioja">La rioja</option>
								<option value="Mendoza">Mendoza</option>
								<option value="Misiones">Misiones</option>
								<option value="Neuquen">Neuquen</option>
								<option value="Rio Negro">Rio Negro</option>
								<option value="Salta">Salta</option>
								<option value="San Juan">San Juan</option>
								<option value="San Luis">San Luis</option>
								<option value="Santa fe">Santa fe</option>
								<option value="Santiago del estero">Santiago del estero</option>
								<option value="Tierra del fuego">Tierra del fuego</option>
								<option value="Tucuman">Tucuman</option>
							
								
								
							</select>
						</div>
						<div class="col">
							<input type="text" style="position:relative; top:30px" class="form-control" name="TXTlocalidad"
								id="localidad" aria-describedby="emailHelp"
								placeholder="localidad" value=<%=usuario.getPersona().getDireccion().getLocalidad() %>>
						</div>

					</div>
					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
							<input type="text" class="form-control" name="TXTdomicilio" id="domicilio"
								aria-describedby="emailHelp" placeholder="Domicilio" value=<%=usuario.getPersona().getDireccion().getCalle() %>>
						</div>
						
					</div>
					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
							<input type="text" class="form-control" name="TXTnumero" id="numero"
								aria-describedby="emailHelp" placeholder="Numero" value=<%=usuario.getPersona().getDireccion().getNumero() %>>
						</div>
						
						<div class="col">
							<input type="text" class="form-control" name="TXTdepto" id="depto"
								aria-describedby="emailHelp" placeholder="Depto" value =<%=usuario.getPersona().getDireccion().getDepto() %>>
						</div>
						
					</div>
					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
							 <input	type="text" class="form-control" name="TXTtelefono"
								id="telefono" aria-describedby="emailHelp"
								placeholder="telefono" value=<%=usuario.getPersona().getTelefono() %>>
						</div>
					
					</div>
					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
							 <input	type="text" class="form-control" name="TXTcorreo"
								id="mail" aria-describedby="emailHelp"
								placeholder="Correo electronico" value=<%=usuario.getPersona().getEmail() %>>
						</div>
					
					</div>
					<input type="hidden" name="TXTidUsuario" value="<%=usuario.getId() %>" />
					<input type="hidden" name="TXTidPersona" value="<%=usuario.getPersona().getId()%>" />
					<input type="hidden" name="TXTidDireccion" value="<%=usuario.getPersona().getDireccion().getId()%>" />
					
					<div  class="row d-flex justify-content-center"style="position:relative; top:30px">
					<input type="submit" name="BtnModificar" value= "Modificar">
					</div>
						
					

				</form>
			</div>

		</div>
	</div>
</body>
</html>