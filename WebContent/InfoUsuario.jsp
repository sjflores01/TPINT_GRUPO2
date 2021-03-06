<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
      <%@page import="dominio.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mi Info</title>
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
						<li class="nav-item"><a class="nav-link" href="ServletCliente?cargarCuentas=<%=usuarioCliente.getId()%>">Cuentas</a>
						</li>
					</div>
					<div class="col-md-2">
						<li class="nav-item"><a class="nav-link" href="ServletCliente?cargarPrestamos=<%=usuarioCliente.getId()%>">Ver Prestamos</a>
						</li>
					</div>
					<div class="col-md-2">
						<li class="nav-item"><a class="nav-link" href="ServletCliente?cargarPedirPrestamos=<%=usuarioCliente.getId()%>">Ped� tu Prestamo</a>
						</li>
					</div>
					<div class="col-md-2">
						<li class="nav-item"><a class="nav-link" href="ServletCliente?cargarMiInfo=<%=usuarioCliente.getId()%>">Mi info</a>
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
		<div class="row mt-2">
			<div class="col-md-12">
				<h3 class="display-4 text-info">Mis datos</h3>
			</div>
			<div style="height: 130px"></div>
		</div>
		<div class="row-mt-2">
			<div class="col-md-11">
				<div class="card">
					<div class="card-header d-flex justify-content-center">
						<h3>Datos personales</h3>
					</div>
					<div class="card-body">
						<div class="card-text">

							<form>
								<div class="form-row">

									<div class="col">
										<label for="nombre">Nombre completo:</label> <input
											type="text" class="form-control" name="TXTnombre" id="nombre"
											aria-describedby="emailHelp" placeholder="Juan perez"
											readonly = "">
									</div>
									<div class="col">
										<label for="nombre">Fecha de nacimiento:</label> <input
											type="text" class="form-control" name="TXTfnac" id="apellido"
											aria-describedby="emailHelp" placeholder="23/02/1969"
											readonly>
									</div>
								</div>
								<div style="height: 30px"></div>
								<div class="form-row">

									<div class="col">
										<label for="dni">DNI:</label> <input type="text"
											class="form-control" name="TXTdni" id="dni"
											aria-describedby="emailHelp" placeholder="24.847.269"
											readonly>
									</div>
									<div class="col">
										<label for="cuil">Cuil:</label> <input type="text"
											class="form-control" name="TXTcuil" id="cuil"
											aria-describedby="emailHelp" placeholder="20248847269302"
											readonly>
									</div>
								</div>
								<div style="height: 30px"></div>
								<div class="form-row d-flex justify-content-center">

									<div class="col-3">
										<label for="sexo">Sexo:</label> <input type="text"
											class="form-control" name="TXTsexo" id="sexo"
											aria-describedby="emailHelp" placeholder="Masculino" readonly>
									</div>

								</div>



							</form>
						</div>
					</div>
					<div style="height: 45px"></div>
					<div class="card-header d-flex justify-content-center">
						<h3>Datos de contacto</h3>
					</div>
					<div class="card-body">
						<div class="card-text">

							<form>
								<div class="form-row">

									<div class="col">
										<label for="Provincia">Provincia:</label> <input type="text"
											class="form-control" name="TXTprovincia" id="Provincia"
											aria-describedby="emailHelp" placeholder="Catamarca" readonly>
									</div>
									<div class="col">
										<label for="Localidad">Localidad:</label> <input type="text"
											class="form-control" name="TXTlocalidad" id="Localidad"
											aria-describedby="emailHelp" placeholder="Catamarca capital"
											readonly>
									</div>
									<div class="col">
										<label for="Telefono">Telefono:</label> <input type="text"
											class="form-control" name="TXTtel" id="Telefono"
											aria-describedby="emailHelp" placeholder="1122476599"
											readonly>
									</div>
								</div>
								<div style="height: 30px"></div>
								<div class="form-row">

									<div class="col">
										<label for="Domicilio">Domicilio:</label> <input type="text"
											class="form-control" name="TXTdomicilio" id="Domicilio"
											aria-describedby="emailHelp" placeholder="puerto alto 232"
											readonly>
									</div>
									<div class="col">
										<label for="Correo">Correo:</label> <input type="text"
											class="form-control" name="TXTcorreo" id="Correo"
											aria-describedby="emailHelp"
											placeholder="juanperez@gmail.com" readonly>
									</div>

								</div>

							</form>
						</div>
					</div>
				</div>

			</div>


		</div>
	</div>
<div style="height: 150px"></div>



























</body>
</html>