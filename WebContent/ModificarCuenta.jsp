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
<title>Modificar Cuenta</title>
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
	<%
		Cuenta cuenta;
		if (request.getAttribute("cuenta") == null) {
			cuenta = new Cuenta();

		} else {
			cuenta = (Cuenta) request.getAttribute("cuenta");
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
							 <a	class="dropdown-item" href="ServletUsuario?ListaClientes=1&pagina=1">Listar clientes</a>
							
						</div></li>
				</div>
				<div class="col-md-2">
					
							<a class="dropdown-item" href="ServletCuenta?ListaCuentas=1&pagina=1">Cuentas</a>
						
				</div>
				<div class="col-md-3">
					<li class="nav-item"><a class="nav-link" href="ServletPrestamo?ListaPrestamos=1">Solicitudes
							de prestamos</a></li>
				</div>
				<div class="col-md-2">
					<li class="nav-item"><a class="nav-link" href="SeleccionarInforme.jsp">Informes</a>
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
				<h3 class="display-4 text-info">Modificar Cuenta</h3>
				<div style="height: 50px"></div>
			</div>
		</div>
		<div class="row mt-2 d-flex justify-content-center">
			<h2>Informacion de la cuenta</h2>
		</div>
		<div class="row mt-2 d-flex justify-content-center"
			style="position: relative; top: 50px">
			<div class="col-md-6" style="">
				<form>
					<div class="form-row">

						<div class="row">

							<div class="col">
								<label for="exampleInputEmail1">Cuenta: </label>
							</div>

							<div class="col">
								<input type="text" readonly class="form-control-plaintext"
									name="TXTid" id="nombre" value=<%=cuenta.getId()%>>
							</div>


							<div class="col">
								<label for="exampleInputEmail1">Cliente: </label> <label
									for="exampleInputEmail2"><%=cuenta.getUsuario().getPersona().getNombre()%></label>
								<label for="exampleInputEmail2"><%=cuenta.getUsuario().getPersona().getApellido()%></label>
							</div>
						</div>

						<div class="row">

							<div class="col-12" style="height: 30px">
								<label for="exampleInputEmail1">Tipo Cuenta Actual: </label> <label
									for="exampleInputEmail2"><%=cuenta.getTipoCuenta().getDescripcion()%></label>
							</div>


							<div class="col-12" style="height: 30px">
								<label for="Tipo de cuenta">Nuevo Tipo:</label> <select
									class="form-control" id="cuentas" name=Cuentas>
									<option value="1">Caja de ahorro</option>
									<option value="2">Cuenta Corriente</option>
									<option value="3">Caja de ahorro USD</option>
								</select>
							</div>

						</div>

					</div>

					<div class="row">

						<div class="col-12" style="margin-top: 50px;">
							<label for="Tipo de cuenta">Nuevo Saldo:</label> <input
								type="text" class="form-control" name="TXTsaldo" id="saldo"
								aria-describedby="emailHelp" value=<%=cuenta.getSaldo()%>>

						</div>

					</div>


					<div style="height: 30px"></div>

					<input type="hidden" name="TXTid"
						value="<%=cuenta.getId()%>" />

					<div class="row d-flex justify-content-center"
						style="position: relative; top: 30px">
						<input type="submit" name="BtnModificar" value="Modificar">
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