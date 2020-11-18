<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="dominio.Direccion"%>
<%@page import="dominio.Persona"%>
<%@page import="dominio.Usuario"%>
<%@page import="java.sql.Date"%>
<%@page import="dominio.Cuenta"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Info cliente</title>
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
		String mailorg = "ph";
		String dniorg = "ph";
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
		
		
		<%Usuario usuarioAdmin = new Usuario();
		
		
		
		usuarioAdmin =(Usuario)session.getAttribute("UsuarioAdminLogin"); %>
		
		
		href="#">BANCO JAVA ADMINISTRADOR: <%= usuarioAdmin.getNombre()%></a> 		
		
		
		
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
							<a class="dropdown-item" href="UsuarioDatosPersonales.jsp">Nuevo cliente</a>
							 <a	class="dropdown-item" href="ServletUsuario?ListaClientes=1&pagina=1">Listar clientes</a>
							
						</div></li>
				</div>
			<div class="col-md-2">
					
							<a class="dropdown-item" href="ServletCuenta?ListaCuentas=1&pagina=1">Cuentas</a>
						
				</div>
				<div class="col-md-3">
					<li class="nav-item"><a class="nav-link" href="PedirPrestamo.jsp">Solicitudes
							de prestamos</a></li>
				</div>
				<div class="col-md-2">
					<li class="nav-item"><a class="nav-link" href="#">Informes</a>
					</li>
				</div>
				<div class="col-md-2">
						<li class="nav-item active"><a class="nav-link" href="ServletUsuario?Logout=1">Salir
								<span class="sr-only">(current)</span>
						</a></li>
					</div>
			</div>
		</ul>
	</div>
	</nav>
	<div class="container">
	
	<% 
			
			if(usuarioAdmin!=null)
			{%>
	
	
	
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
				<form>
					<div class="form-row">

						<div class="col">
						 <label for="Nombre">Nombre:</label>
							<input type="text" class="form-control" name="TXTnombrePersona"
								id="nombre" aria-describedby="emailHelp" placeholder="Nombres" value=<%=usuario.getPersona().getNombre() %> disabled>
						</div>
						<div class="col">
						 <label for="Apellido">Apellido:</label>
							<input type="text" class="form-control" name="TXTapellido"
								id="apellido" aria-describedby="emailHelp"
								placeholder="Apellidos" value=<%=usuario.getPersona().getApellido() %> disabled>
						</div>

					</div>
					<div style="height:30px"></div>	
					<div class="form-row">
						<div class="col">
						 <label for="Dni">Dni:</label>
							<input type="text" class="form-control" name="TXTdni" id="dni"
								aria-describedby="emailHelp" placeholder="DNI" value=<%=usuario.getPersona().getDni() %> disabled>
						</div>
						<div class="col">
						 <label for="cuil">Cuil:</label>
							<input type="text" class="form-control" name="TXTcuil"
								id="cuil" aria-describedby="emailHelp" placeholder="Cuil" value=<%=usuario.getPersona().getCuil() %> disabled>
						</div>
						
						<div class="col">
						 <label for="contraseña">Contraseña:</label>
							<input type="password" class="form-control" name="TXTpass"
								id="password" aria-describedby="emailHelp" placeholder="contraseña" value=<%=usuario.getClave() %> disabled>
						</div>
					</div>
					<div style="height:30px"></div>	
					<div class="form-row">
						<div class="col">
							<input type="date" class="form-control" name="TXTfecha" id="nacimiento"
								aria-describedby="emailHelp" placeholder="DD" value="<%= request.getAttribute("fecha") %>" disabled>
						</div>
					
						<div class="col">
							<input type="text" class="form-control" name="TXTsexo" id="nacimiento"
								aria-describedby="emailHelp" placeholder="DD" value="<%= request.getAttribute("sexo") %>" disabled>
						</div>
						
					</div>
					<div class="form-row">

						<div class="col">
							<input type="text" style="position:relative; top:30px" class="form-control" name="TXTlprovincia"
								id="localidad" aria-describedby="emailHelp"
								placeholder="localidad" value=<%=usuario.getPersona().getDireccion().getProvincia() %> disabled>
						</div>
						<div class="col">
							<input type="text" style="position:relative; top:30px" class="form-control" name="TXTlocalidad"
								id="localidad" aria-describedby="emailHelp"
								placeholder="localidad" value=<%=usuario.getPersona().getDireccion().getLocalidad() %> disabled>
						</div>

					</div>
					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
							<input type="text" class="form-control" name="TXTdomicilio" id="domicilio"
								aria-describedby="emailHelp" placeholder="Domicilio" value=<%=usuario.getPersona().getDireccion().getCalle() %> disabled>
						</div>
						
					</div>
					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
							<input type="text" class="form-control" name="TXTnumero" id="numero"
								aria-describedby="emailHelp" placeholder="Numero" value=<%=usuario.getPersona().getDireccion().getNumero() %> disabled>
						</div>
						
						<div class="col">
							<input type="text" class="form-control" name="TXTdepto" id="depto"
								aria-describedby="emailHelp" placeholder="Depto" value =<%=usuario.getPersona().getDireccion().getDepto() %> disabled>
						</div>
						
					</div>
					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
							 <input	type="text" class="form-control" name="TXTtelefono"
								id="telefono" aria-describedby="emailHelp"
								placeholder="telefono" value=<%=usuario.getPersona().getTelefono() %> disabled>
						</div>
					
					</div>
					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
							 <input	type="text" class="form-control" name="TXTcorreo"
								id="mail" aria-describedby="emailHelp"
								placeholder="Correo electronico" value=<%=usuario.getPersona().getEmail() %> disabled>
						</div>
					
					</div>
					
					
									
					
					
					
				
				<%}%>
			<%
		          
			
			session.setAttribute("UsuarioAdminLogin",usuarioAdmin);	
			
		
			
			%>		
					

				</form>
			</div>

		</div>
	</div>






</body>
</html>