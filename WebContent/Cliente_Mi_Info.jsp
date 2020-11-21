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
<title>Mi Informacion</title>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
	integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.22/sc-2.0.3/sp-1.2.1/datatables.min.css" />

<script type="text/javascript"
	src="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.22/sc-2.0.3/sp-1.2.1/datatables.min.js"></script>
</head>
<body>
	<% Usuario usuario;
		String mailorg = "ph";
		String dniorg = "ph";
	if(request.getAttribute("usuarioCliente") == null)
	{
		
	    Date fecha = new Date(2000, 5, 5);
		Direccion direccion = new Direccion("ph", 0, "ph", "ph", "ph");
		Persona persona = new Persona(0, "ph","ph" , "ph", "ph", "ph", "ph", 'p',fecha , direccion);
	    usuario = new Usuario(0, "ph", "ph", persona);
	    
	} else{		
		
		usuario = (Usuario) request.getAttribute("usuarioCliente");
		mailorg = (String) request.getAttribute("mailOriginal");
		dniorg = (String) request.getAttribute("dniOriginal");
	}
	
	
	%>
	
	<nav class="navbar navbar-expand-large navbar-light"
		style="background-color: #e3f2fd;">
		
<a class="navbar-brand"
		
		
	<%Usuario usuarioCliente = new Usuario();
		
		
		
		usuarioCliente =(Usuario)session.getAttribute("clienteLogin");%>
		
		
		href="#">BANCO JAVA USUARIO: <%= usuarioCliente.getPersona().getNombre()%></a> 		
		


		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<div class="row">
					<div class="col-md-2">
						<li class="nav-item active"><a class="nav-link" href="IndexUsuario.jsp">Home
								<span class="sr-only">(current)</span>
						</a></li>
					</div>
					<div class="col-md-2">
						<li class="nav-item"><a class="nav-link" href="ServletCliente?cargarCuentas=<%=usuario.getId()%>">Cuentas</a>
						</li>
					</div>
					<div class="col-md-2">
						<li class="nav-item"><a class="nav-link" href="ServletCliente?cargarPrestamos=<%=usuario.getId()%>">Ver Prestamos</a>
						</li>
					</div>
					<div class="col-md-2">
						<li class="nav-item"><a class="nav-link" href="ServletCliente?cargarPedirPrestamos=<%=usuario.getId()%>">Pedí tu Prestamo</a>
						</li>
					</div>
					<div class="col-md-2">
						<li class="nav-item"><a class="nav-link" href="ServletCliente?cargarMiInfo=<%=usuario.getId()%>">Mi info</a>
						</li>
					</div>
					
					<div class="col-md-2">
						<li class="nav-item active"><a class="nav-link" href="ServletCliente?Logout=1">Salir
								<span class="sr-only">(current)</span>
						</a></li>
					</div>
					
					
				</div>
			</ul>
		</div>
	</nav>
	
	
	<div class="container">
	
	<% 
			
			if(usuarioCliente.getId()!=null)
			{%>
	
	
	
		<div class="row mt-2">
			<div class="col-md-12">
				<h3 class="display-4 text-info">Mis Datos</h3>
				<div style="height:50px"></div>	
			</div>
		</div>
		<div class="row mt-2 d-flex justify-content-center">
		<h2>Informacion Personal</h2>
		</div>
		<div class="row mt-2 d-flex justify-content-center"
			style="position: relative; top: 50px">
			<div class="col-md-6" style="">
				<form action="ServletCliente" method="get">
					<div class="form-row">

						<div class="col">
						 <label for="Nombre">Nombre:</label>
							<input type="text" class="form-control" name="TXTnombrePersona"
								id="nombre" aria-describedby="emailHelp" placeholder="Nombres" value=<%=usuarioCliente.getPersona().getNombre() %> readonyly>
						</div>
						<div class="col">
						 <label for="Apellido">Apellido:</label>
							<input type="text" class="form-control" name="TXTapellido"
								id="apellido" aria-describedby="emailHelp"
								placeholder="Apellidos" value=<%=usuarioCliente.getPersona().getApellido() %> readonyly>
						</div>

					</div>
					<div style="height:30px"></div>	
					<div class="form-row">
						<div class="col">
						 <label for="Dni">Dni:</label>
							<input type="text" class="form-control" name="TXTdni" id="dni"
								aria-describedby="emailHelp" placeholder="DNI" value=<%=usuarioCliente.getPersona().getDni() %> readonyly>
						</div>
						<div class="col">
						 <label for="cuil">Cuil:</label>
							<input type="text" class="form-control" name="TXTcuil"
								id="cuil" aria-describedby="emailHelp" placeholder="Cuil" value=<%=usuarioCliente.getPersona().getCuil() %> readonyly>
						</div>
						
						<div class="col">
						
						</div>
					</div>
					<div style="height:30px"></div>	
					<div class="form-row">
						<div class="col">
							<input type="date" class="form-control" name="TXTfecha" id="nacimiento"
								aria-describedby="emailHelp" placeholder="DD" value="<%= request.getAttribute("fecha") %>" readonyly>
						</div>
					
						<div class="col" style="position:relative; bottom:30px">
							<label for="sexo">Sexo:</label>
							<input type="text" class="form-control" name="TXTsexo"
								id="sexo" aria-describedby="emailHelp"
								placeholder="Sexo" value=<%=usuarioCliente.getPersona().getSexo() %> readonyly>
						</div>
					</div>
					<div class="form-row">

						<div class="col">
							<label for="provincia">Provincia:</label>
							
							
							<input type="text" class="form-control" name="TXTapellido"
								id="apellido" aria-describedby="emailHelp"
								placeholder="Apellidos" value=<%=usuarioCliente.getPersona().getDireccion().getProvincia() %> readonyly>
						</div>
						<div class="col">
							<input type="text" style="position:relative; top:30px" class="form-control" name="TXTlocalidad"
								id="localidad" aria-describedby="emailHelp"
								placeholder="localidad" value=<%=usuarioCliente.getPersona().getDireccion().getLocalidad() %> readonyly>
						</div>

					</div>
					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
							<input type="text" class="form-control" name="TXTdomicilio" id="domicilio"
								aria-describedby="emailHelp" placeholder="Domicilio" value=<%=usuarioCliente.getPersona().getDireccion().getCalle() %> readonyly>
						</div>
						
					</div>
					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
							<input type="text" class="form-control" name="TXTnumero" id="numero"
								aria-describedby="emailHelp" placeholder="Numero" value=<%=usuarioCliente.getPersona().getDireccion().getNumero() %> readonyly>
						</div>
						
						<div class="col">
							<input type="text" class="form-control" name="TXTdepto" id="depto"
								aria-describedby="emailHelp" placeholder="Depto" value =<%=usuarioCliente.getPersona().getDireccion().getDepto() %> readonyly>
						</div>
						
					</div>
					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
							 <input	type="text" class="form-control" name="TXTtelefono"
								id="telefono" aria-describedby="emailHelp"
								placeholder="telefono" value=<%=usuarioCliente.getPersona().getTelefono() %> readonyly>
						</div>
					
					</div>
					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
							 <input	type="text" class="form-control" name="TXTcorreo"
								id="mail" aria-describedby="emailHelp"
								placeholder="Correo electronico" value=<%=usuarioCliente.getPersona().getEmail() %> readonyly>
						</div>
					
					</div>
					<input type="hidden" name="TXTidUsuario" value="<%=usuarioCliente.getId() %>" />
					<input type="hidden" name="TXTidPersona" value="<%=usuarioCliente.getPersona().getId()%>" />
					<input type="hidden" name="TXTidDireccion" value="<%=usuarioCliente.getPersona().getDireccion().getId()%>" />
					<input type="hidden" name="TXTmailOriginal" value="<%=mailorg%>" />
					<input type="hidden" name="TXTdniOriginal" value="<%=dniorg%>" />
					
					
					</div>
				
				<%} %>
			<%
		          
			
			session.setAttribute("UsuarioAdminLogin",usuarioCliente);	
			
		
			
			%>		
					

				</form>
			</div>

		</div>
	</div>
	
	
	
	
	</body>
</html>