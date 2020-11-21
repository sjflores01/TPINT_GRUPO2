<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informes</title>
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
				<h3 class="display-4 text-info">Informes</h3>
			</div>

		</div>
		<div style="height: 100px"></div>
		<div class="row mt-2 d-flex justify-content-center">
			<div class="col-md-4">


							
					<div class="card" style="width:300px">
						<img style="height: 200px;" class="card-img-top"
							src="https://www.bapesa.com/wp-content/uploads/2018/12/prueba1_5e0a2c41.jpg"
							alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title">Prestamos activos</h5>
							<div style="height:20px"></div>	
						<a  style="position:relative; left:75px" class="btn btn-primary" 
						href="ServletInforme?activos=1">continuar</a>

						</div>
					</div>
			</div>
				<div class="col-md-4">
					<div class="card" style="width:300px">
						<img style="height: 200px;" class="card-img-top"
							src="https://image.freepik.com/vector-gratis/mensaje-alerta-notificacion-movil-alertas-error-peligro-problema-virus-telefono-inteligente-o-notificaciones-problemas-mensajes-correo-no-deseado-inseguros_100456-460.jpg"
							alt="Card image cap">
						<div class="card-body">
						
							<h5 class="card-title">Prestamos inpagos</h5>
							<div style="height:20px"></div>	
							<a style="position:relative; left:75px" class="btn btn-primary" 
							href="ServletInforme?inpagos=1">continuar</a>

						</div>
					</div>
			</div>		










		</div>
	</div>




</body>
</html>