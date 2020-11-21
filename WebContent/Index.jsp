<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BANCO AGUANTE JAVA!</title>
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
		<a class="navbar-brand" href="#">BANCO JAVA</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<div class="row">
					<div class="col-md-2">
						<li class="nav-item active"><a class="nav-link" href="Index.jsp">Home
								<span class="sr-only">(current)</span>
						</a></li>
					</div>
					<div class="col-md-2">
						<li class="nav-item"><a class="nav-link" href="NuestrosBeneficios.jsp">Beneficios</a>
						</li>
					</div>
					<div class="col-md-2">
						<li class="nav-item"><a class="nav-link" href="#">Conocenos</a>
						</li>
					</div>
					<div class="col-md-2">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"> Sos Cliente? </a>
							<div class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<a class="dropdown-item" href="Login.jsp">Login</a> 
								
								<div class="dropdown-divider"></div>
								
							</div></li>
					</div>
				</div>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row mt-2">
			<div class="col-md-12">
				<h3 class="display-4 text-info">Bienvenid@ al Banco Java!!</h3>
				
				
				
				<%if(request.getAttribute("Error logueo") != null) {
			%>
		
		<div class="row mt-2 d-flex justify-content-center" style="position:relative; top:40px">
			<div class="col-3 card title d-flex justify-content-center">
			
			<h6 style="text-align:center"><%=request.getAttribute("Error logueo") %> </h6>
			</div>
		
		</div>
		<%
		}
		%>
				
				
				
				
			</div>
		</div>
	</div>
</body>
</html>