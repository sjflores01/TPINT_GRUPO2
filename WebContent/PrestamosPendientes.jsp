<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
      pageEncoding="ISO-8859-1"%>
<%@page import="dominio.Direccion"%>
<%@page import="dominio.Persona"%>
<%@page import="dominio.Usuario"%>
<%@page import="dominio.Prestamo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prestamos pendientes</title>
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
<script type="text/javascript">
	$(document).ready(function() {
		$('#tablaPrestamos').DataTable();
	});
</script>
</head>
<body>
      <%
      	ArrayList<Prestamo> lista;
      if (request.getAttribute("lista") == null) {

      	lista = new ArrayList<Prestamo>();
      } else {
      	lista = (ArrayList<Prestamo>) request.getAttribute("lista");
      }
      %>
      <nav class="navbar navbar-expand-large navbar-light"
            style="background-color: #e3f2fd;"> <a
            class="navbar-brand" href="#">BANCO JAVA ADMIN</a>
      <button class="navbar-toggler" type="button"
            data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                  <div class="row">
                        <div class="col-md-2">
                              <li class="nav-item dropdown"><a
                                    class="nav-link dropdown-toggle"
                                    href="#" id="navbarDropdownMenuLink"
                                    role="button" data-toggle="dropdown"
                                    aria-haspopup="true"
                                    aria-expanded="false"> Clientes
                              </a>
                                    <div class="dropdown-menu"
                                          aria-labelledby="navbarDropdownMenuLink">
                                          <a class="dropdown-item"
                                                href="#">Nuevo
                                                cliente</a> <a
                                                class="dropdown-item"
                                                href="#">Modificar
                                                cliente</a>
                                          <div class="dropdown-divider"></div>
                                          <a class="dropdown-item"
                                                href="#">Eliminar
                                                cliente</a>
                                    </div></li>
                        </div>
                        <div class="col-md-2">
                              <li class="nav-item dropdown"><a
                                    class="nav-link dropdown-toggle"
                                    href="#" id="navbarDropdownMenuLink"
                                    role="button" data-toggle="dropdown"
                                    aria-haspopup="true"
                                    aria-expanded="false"> Cuentas </a>
                                    <div class="dropdown-menu"
                                          aria-labelledby="navbarDropdownMenuLink">
                                          <a class="dropdown-item"
                                                href="UsuarioDatosPersonales.jsp">Nuevo
                                                cliente</a>
                                          class="dropdown-item"
                                          href="#">Modificar cuenta</a>
                                          <div class="dropdown-divider"></div>
                                          <a class="dropdown-item"
                                                href="ServletUsuario?ListaClientes=1&pagina=1">Listar
                                                clientes</a>
                                    </div></li>
                        </div>
                        <div class="col-md-3">
                              <li class="nav-item"><a
                                    class="nav-link"
                                    href="ServletPrestamo?ListaPrestamos=1">Solicitudes
                                          de prestamos</a></li>
                        </div>
                        <div class="col-md-2">
                              <li class="nav-item"><a
                                    class="nav-link"
                                    href="SeleccionarInforme.jsp">Informes</a>
                              </li>
                        </div>
                        <div class="col-md-2">
                              <li class="nav-item active"><a
                                    class="nav-link"
                                    href="ServletUsuario?Logout=1">Salir
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
                        <h3 class="display-4 text-info">Solicitudes
                              de prestamos</h3>
                        <div style="height: 50px"></div>
                  </div>
            </div>
            <div class="row mt-2 d-flex justify-content-center">
                  <h2>Solicutudes pendientes</h2>
            </div>
            <div class="row mt-2 d-flex justify-content-center">
                  <div class="col-md-11">
                        <div class="card overflow-auto">
                              <div class="card-body"
                                    style="height: 450px;">

                                    <table class="table"
                                          id="tablaPrestamos">
                                          <thead class="table-info">
                                                <tr>
                                                      <th scope="col">Nombre:</th>
                                                      <th scope="col">DNI:</th>
                                                      <th scope="col">Monto
                                                            solicitado:</th>
                                                      <th scope="col">Cuotas:</th>
                                                      <th></th>
                                                      <th></th>
                                                </tr>
                                          </thead>
                                          <tbody>

                                                <%
                                                	for (Prestamo p : lista) {
                                                %>

                                                <tr>



                                                      <td><a
                                                            href="ServletUsuario?cargaInfo=<%=p.getUsuario().getId()%>">
                                                                  <%=p.getUsuario().getPersona().getNombre()%></a>
                                                      </td>
                                                      <td><%=p.getUsuario().getPersona().getDni()%></td>
                                                      <td><%=p.getImportePedido()%></td>
                                                      <td><%=p.getCantCuotas()%></td>

                                                      <td><a
                                                            class="btn btn-info"
                                                            href="ServletPrestamo?cargaCancelar=<%=p.getId()%>">Cancelar</a></td>
                                                      <td><a
                                                            class="btn btn-warning"
                                                            href="ServletPrestamo?cargaAprobar=<%=p.getId()%>">Aprobar</a></td>

                                                </tr>

                                                <%
                                                	}
                                                %>

                                          </tbody>
                                    </table>

                              </div>

                        </div>

                  </div>
            </div>
      </div>


</body>
</html>