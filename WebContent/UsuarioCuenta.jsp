<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="dominio.Direccion" %>
<%@page import="dominio.Persona" %>
<%@page import="dominio.Usuario" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo usuario</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	
	
				<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	
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
						<li class="nav-item active"><a class="nav-link" href="IndexAdmin.jsp">Home
								<span class="sr-only">(current)</span>
						</a></li>
					</div>
			
			
				<div class="col-md-2">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Clientes </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="UsuarioDatosPersonales.jsp">Nuevo cliente</a>
							<a class="dropdown-item" href="UsuarioDatosPersonales.jsp">Nuevo cliente</a>
							
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
						<li class="nav-item active"><a class="nav-link" href="IndexAdmin.jsp">Salir
								<span class="sr-only">(current)</span>
						</a></li>
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
	<% Usuario usuario = (Usuario) request.getAttribute("Usuario"); %>
	<div class="container">
	
	<% 
			
			if(usuarioAdmin!=null)
			{%>
	
	
		<div class="row mt-2">
			<div class="col-md-12">
				<h3 class="display-4 text-info">Alta cliente</h3>
				<div style="height: 50px"></div>
			</div>
		</div>
		<div class="row mt-2 d-flex justify-content-center">
			<h2>Datos de sesion</h2>
		</div>
		<div class="row mt-2 d-flex justify-content-center"
			style="position: relative; top: 50px">
			<div class="col-md-6" style="">
				<form action="ServletUsuario" method="get">
					<div class="form-row">
						<div class="col">
							<input type="text" class="form-control" name="TXTusuario" id="usuario"
								aria-describedby="emailHelp" placeholder="Nombre de usuario" required>
						</div>
						
					</div>
					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
							 <input	type="password" class="form-control" name="TXTpass"
								id="pass" aria-describedby="emailHelp"placeholder="Contrase�a" required>
								<small id="passHelp" class="form-text text-muted">El usuario deber� cambiarla en su primir inicio de sesion.</small>
						</div>
					
					</div>
					<div style="height: 30px"></div>
					<div class="form-row">
						<div class="col">
							 <input	type="password" class="form-control" name="TXTrepetirpass"
								id="repetirpass" aria-describedby="emailHelp"	placeholder="Repetir contrase�a" required>
						</div>
					
					</div>
					
					<%
							if (request.getAttribute("errorNombre") != null) {
						%>
						<div class="row d-flex justify-content-center"
						style="position: relative; top: 30px" >
						<label for="inputEmail4" style="color: red"><%=request.getAttribute("errorNombre") %></label>
						</div>
						
						
						
						<%
							}
						%>
					
					<div class="row d-flex justify-content-center"
						style="position: relative; top: 30px">
						
					<input type="hidden" name="TXTnombreUsuario" value="<%=usuario.getNombre() %>" />
					<input type="hidden" name="TXTclave" value="<%=usuario.getClave() %>" />
					<input type="hidden" name="TXTdni" value="<%=usuario.getPersona().getDni() %>" />
					<input type="hidden" name="TXTnombrePersona" value="<%=usuario.getPersona().getNombre() %>" />
					<input type="hidden" name="TXTapellido" value="<%=usuario.getPersona().getApellido() %>" />					
					<input type="hidden" name="TXTsexo" value="<%=usuario.getPersona().getSexo() %>" />
					<input type="hidden" name="TXTprovincia" value="<%=usuario.getPersona().getDireccion().getProvincia() %>" />
					<input type="hidden" name="TXTlocalidad" value="<%=usuario.getPersona().getDireccion().getLocalidad() %>" />
					<input type="hidden" name="TXTdomicilio" value="<%=usuario.getPersona().getDireccion().getCalle() %>" />
					<input type="hidden" name="TXTdepto" value="<%=usuario.getPersona().getDireccion().getDepto() %>" />
					<input type="hidden" name="TXTtelefono" value="<%=usuario.getPersona().getTelefono() %>" />	
					<input type="hidden" name="TXTnumero" value="<%=usuario.getPersona().getDireccion().getNumero() %>" />					
					<input type="hidden" name="TXTcuil" value="<%=usuario.getPersona().getCuil() %>" />
					<input type="hidden" name="TXTcorreo" value="<%=usuario.getPersona().getEmail() %>" />
					<input type="hidden" name="TXTdia" value="<%=request.getAttribute("dia") %>" />
					<input type="hidden" name="TXTmes" value="<%=request.getAttribute("mes")%>" />
					<input type="hidden" name="TXTanio" value="<%=request.getAttribute("anio") %>" />
						
						
						
						
						<input type="submit" name="BtnSiguiente3" value="Siguiente">
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