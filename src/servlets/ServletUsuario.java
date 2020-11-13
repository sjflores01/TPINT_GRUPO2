package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import dominio.Direccion;
import dominio.Persona;
import dominio.Usuario;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String redireccion = "Indddsadsex.jsp";
		
		
		if(request.getParameter("BtnSiguiente1") != null)
		{
			//Boton alta usuario 1
			
			
			String nombre;
			String apellido;
			String dni;
			String cuil;
			String fnac;
			String sexo;
			String day;
			String month;
			String year;
			
			
			nombre = request.getParameter("TXTnombre");
			apellido = request.getParameter("TXTapellido");
			dni = request.getParameter("TXTdni");
			cuil = request.getParameter("TXTcuil");
			fnac = request.getParameter("TXTnacimiento");
			sexo = request.getParameter("sexo");
			nombre = request.getParameter("TXTnombre");
			cuil = request.getParameter("TXTcuil");
			day = request.getParameter("TXTdia");
			month = request.getParameter("TXTmes");
			year = request.getParameter("TXTanio");
			
			
			Direccion direccion = new Direccion("ph", 0, "ph", "ph", "ph");
			Persona persona = new Persona(0, dni,cuil , nombre, apellido, "ph", "ph", sexo.charAt(0),null , direccion);
			Usuario usuario = new Usuario(0, "ph", "ph", persona);
			
			
			request.setAttribute("dia", day);
			request.setAttribute("mes", month);
			request.setAttribute("anio", year);
			request.setAttribute("Usuario", usuario);
			
			UsuarioDao dao = new UsuarioDao();
			if(dao.chequearDni(dni)) {
				redireccion = "UsuarioDireccion.jsp";
				
			} else {
			
				String error = "Dni ya registrado";
				request.setAttribute("errorDni", error);
				redireccion = "UsuarioDatosPersonales.jsp";
			}
			
		
		}else if(request.getParameter("BtnSiguiente2") != null) {
		
			//Boton alta usuario 2
		
			
			
			
			String provincia;
			String localidad;
			String domicilio;
			String telefono;
			String correo;
			String depto;
			String nombreUsuario;
			String clave;
			String dni;
			String nombrePersona;
			String apellido;
			String sexo;
			String numero;
			String cuil;
			String day;
			String month;
			String year;
			
			
			provincia = request.getParameter("provincia");
			localidad =  request.getParameter("TXTlocalidad");
			domicilio =  request.getParameter("TXTdomicilio");
			numero = request.getParameter("TXTnumero");
			telefono = request.getParameter("TXTtelefono");
			correo = request.getParameter("TXTcorreo");
			depto = request.getParameter("TXTdepto");
			nombreUsuario = request.getParameter("TXTnombreUsuario");
			clave = request.getParameter("TXTclave");
			dni = request.getParameter("TXTdni");
			nombrePersona = request.getParameter("TXTnombrePersona");
			apellido = request.getParameter("TXTapellido");
			sexo = request.getParameter("TXTsexo");
			cuil = request.getParameter("TXTcuil");
			day = request.getParameter("TXTdia");
			month = request.getParameter("TXTmes");
			year = request.getParameter("TXTanio");
			
			Direccion direccion = new Direccion(domicilio, Integer.parseInt(numero), depto, localidad, provincia);		
			Persona persona = new Persona(0, dni,cuil, nombrePersona, apellido, telefono, correo, sexo.charAt(0),null ,direccion);
			Usuario usuario = new Usuario(0, nombreUsuario, clave, persona);
															
				
			
			request.setAttribute("dia", day);
			request.setAttribute("mes", month);
			request.setAttribute("anio", year);
			request.setAttribute("Usuario", usuario);
			
			UsuarioDao dao = new UsuarioDao();
			if(dao.chequearEmail(correo)) {
				redireccion = "UsuarioCuenta.jsp";
				
			} else{
				
				String error = "mail en uso";
				request.setAttribute("errorMail", error);
				redireccion = "UsuarioDireccion.jsp";
			}
			
			
			
			
			
		}else if(request.getParameter("BtnSiguiente3") != null) {
			
			// boton alta usuario 3
			
			String provincia;
			String localidad;
			String domicilio;
			String telefono;
			String correo;
			String depto;
			String nombreUsuario;
			String clave;
			String repetirClave;
			String dni;
			String nombrePersona;
			String apellido;
			String sexo;
			String numero;
			String cuil;
			String day;
			String month;
			String year;
			
			
			numero = request.getParameter("TXTnumero");
			provincia = request.getParameter("TXTprovincia");
			localidad =  request.getParameter("TXTlocalidad");
			domicilio =  request.getParameter("TXTdomicilio");
			telefono = request.getParameter("TXTtelefono");
			correo = request.getParameter("TXTcorreo");
			depto = request.getParameter("TXTdepto");
			nombreUsuario = request.getParameter("TXTusuario");
			clave = request.getParameter("TXTpass");
			repetirClave = request.getParameter("TXTrepetirpass");
			dni = request.getParameter("TXTdni");
			nombrePersona = request.getParameter("TXTnombrePersona");
			apellido = request.getParameter("TXTapellido");
			sexo = request.getParameter("TXTsexo");
			cuil = request.getParameter("TXTcuil");
			day = request.getParameter("TXTdia");
			month = request.getParameter("TXTmes");
			year = request.getParameter("TXTanio");
			
			
			Date fecha = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		
			
			Direccion direccion = new Direccion(domicilio, Integer.parseInt(numero), depto, localidad, provincia);		
			Persona persona = new Persona(0, dni,cuil, nombrePersona, apellido, telefono, correo, sexo.charAt(0),fecha, direccion);
			Usuario usuario = new Usuario(0, nombreUsuario, clave, persona);
			
			UsuarioDao usuarioDao = new UsuarioDao();
			
			if(clave.equals(repetirClave) == false) {
			
				String error = "Las contraseñas no coinciden";
				request.setAttribute("errorNombre", error);
				request.setAttribute("dia", day);
				request.setAttribute("mes", month);
				request.setAttribute("anio", year);
				request.setAttribute("Usuario", usuario);
				redireccion = "UsuarioCuenta.jsp";
				
			}else if(usuarioDao.chequearNombreUsuario(nombreUsuario)){
			
				usuarioDao.cargarUsuario(usuario);
				String mensaje = "Alta usuario exitosa";
				request.setAttribute("mensaje", mensaje);
				redireccion ="IndexAdmin.jsp";
				
			} else {
			
				String error = "Nombre de usuario en uso";
				request.setAttribute("errorNombre", error);
				request.setAttribute("dia", day);
				request.setAttribute("mes", month);
				request.setAttribute("anio", year);
				request.setAttribute("Usuario", usuario);
				redireccion = "UsuarioCuenta.jsp";

			}
			
			
			
			
			
			
			
			
			
			
			
		}else if(request.getParameter("ListaClientes") != null || request.getParameter("TXTbuscador") != null) {
		
			PrintWriter out = response.getWriter();
			int pageId;
			
			if(request.getParameter("pagina") != null) {
				String spageid = request.getParameter("pagina");				
				pageId = Integer.parseInt(spageid);
			}else {
				pageId = 1;
			}
			int total = 5;
			
			if(pageId ==1) {}
			else {
				pageId = pageId-1;
				pageId = pageId*total+1;
			}
			
			ArrayList<Usuario> lista = new ArrayList<Usuario>();
			UsuarioDao dao = new UsuarioDao();
			
			String search = "";
			if(request.getParameter("TXTbuscador") != null)
			{
				search = request.getParameter("TXTbuscador");
			}
			
			lista = dao.listarUsuarios(search,1,10);
											
			request.setAttribute("lista", lista);
			redireccion = "ListadoClientes.jsp";
			
			
			
			
		}else if(request.getParameter("cargaModificar") != null) {
		
			String parametro = request.getParameter("cargaModificar");
			Integer id = Integer.parseInt(parametro);
			
			
			UsuarioDao dao = new UsuarioDao();
			Usuario usuario = null;

			
			usuario = dao.leerUsuario(id);
			
			request.setAttribute("usuario", usuario);
			redireccion = "ModificarUsuario.jsp";
			
		}else if(request.getParameter("BtnModificar") != null) {
			
			String provincia;
			String localidad;
			String domicilio;
			String telefono;
			String correo;
			String depto;
			String clave;
			String dni;
			String nombrePersona;
			String apellido;
			String sexo;
			String numero;
			String cuil;
			String day;
			String month;
			String year;
			String idUsuario;
			String idPersona;
			String idDireccion;
			
			
			numero = request.getParameter("TXTnumero");
			provincia = request.getParameter("TXTprovincia");
			localidad =  request.getParameter("TXTlocalidad");
			domicilio =  request.getParameter("TXTdomicilio");
			telefono = request.getParameter("TXTtelefono");
			correo = request.getParameter("TXTcorreo");
			depto = request.getParameter("TXTdepto");
			clave = request.getParameter("TXTpass");
			dni = request.getParameter("TXTdni");
			nombrePersona = request.getParameter("TXTnombrePersona");
			apellido = request.getParameter("TXTapellido");
			sexo = request.getParameter("TXTsexo");
			cuil = request.getParameter("TXTcuil");
			day = request.getParameter("TXTdia");
			month = request.getParameter("TXTmes");
			year = request.getParameter("TXTanio");
			idUsuario = request.getParameter("TXTidUsuario");
			idPersona = request.getParameter("TXTidPersona");
			idDireccion = request.getParameter("TXTidDireccion");
			
			Date fecha = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			
			
			Direccion direccion = new Direccion(domicilio, Integer.parseInt(numero), depto, localidad, provincia);
			direccion.setId(Integer.parseInt(idDireccion));
			Persona persona = new Persona(Integer.parseInt(idPersona), dni,cuil, nombrePersona, apellido, telefono, correo, sexo.charAt(0),fecha, direccion);
			Usuario usuario = new Usuario(Integer.parseInt(idDireccion), "ph", clave, persona);
			
			UsuarioDao dao = new UsuarioDao();
			dao.modificarUsuario(usuario);
			
			String mensaje = "Modificacion de usuario exitosa";
			request.setAttribute("mensaje", mensaje);
			redireccion ="IndexAdmin.jsp";
			
			
		}else if(request.getParameter("cargaEliminar") != null) {
			
			String parametro = request.getParameter("cargaEliminar");
			Integer id = Integer.parseInt(parametro);
			
			
			UsuarioDao dao = new UsuarioDao();
			Usuario usuario = null;

			
			usuario = dao.leerUsuario(id);
			
			request.setAttribute("usuario", usuario);
			redireccion = "EliminarCliente.jsp";
	
			
			
		}else if(request.getParameter("BtnEliminar") != null) {
		
			String id = request.getParameter("TXTidUsuario");
			Integer idnum = Integer.parseInt(id);
			
			UsuarioDao dao = new UsuarioDao();
			dao.eliminarUsuario(idnum);
			
			String mensaje = "Baja de usuario exitosa";
			request.setAttribute("mensaje", mensaje);
			redireccion = "IndexAdmin.jsp";
			
		}else
		{
			response.getWriter().append("Sedsdssddssrved at: ").append(request.getContextPath());
		}
		
		RequestDispatcher dis=request.getRequestDispatcher(redireccion);          
        dis.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
