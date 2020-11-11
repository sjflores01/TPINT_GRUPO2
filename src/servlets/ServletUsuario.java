package servlets;

import java.io.IOException;
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
			redireccion = "UsuarioDireccion.jsp";
			
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
			redireccion = "UsuarioCuenta.jsp";
			
			
			
			
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
			usuarioDao.cargarUsuario(usuario);
			
			redireccion ="Index.jsp";
			
		}else if(request.getParameter("ListaClientes") != null || request.getParameter("TXTbuscador") != null) {
		
			ArrayList<Usuario> lista = new ArrayList<Usuario>();
			UsuarioDao dao = new UsuarioDao();
			
			String search = "";
			if(request.getParameter("TXTbuscador") != null)
			{
				search = request.getParameter("TXTbuscador");
			}
			
			lista = dao.listarUsuarios(search);
											
			request.setAttribute("lista", lista);
			redireccion = "ListadoClientes.jsp";
			
			
			
			
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
