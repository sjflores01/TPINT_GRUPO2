package servlets;

import java.io.IOException;

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
			
			
			nombre = request.getParameter("TXTnombre");
			apellido = request.getParameter("TXTapellido");
			dni = request.getParameter("TXTdni");
			cuil = request.getParameter("TXTcuil");
			fnac = request.getParameter("TXTnacimiento");
			sexo = request.getParameter("sexo");
			nombre = request.getParameter("TXTnombre");
			
			
			Direccion direccion = new Direccion("ph", 0, "ph", "ph", "ph");
			Persona persona = new Persona(0, dni , nombre, apellido, "ph", "ph", sexo.charAt(0), direccion);
			Usuario usuario = new Usuario(0, "ph", "ph", persona);
			
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.cargarUsuario(usuario);
						
			request.setAttribute("persona", persona);
			redireccion = "Index.jsp";
			
		}else if(request.getParameter("BtnSiguiente") != "Siguiente2") {
		
			//Boton alta usuario 2
			
			
			
			
			
			
			
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
