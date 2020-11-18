package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String redireccion = "IndexUsuario.jsp";
		
		if(request.getSession().getAttribute("cliente") == null)
		{
			// Si no esta logueado, al login
			
			redireccion = "Login.jsp";
			
		}
		else if(request.getParameter("cargarCuentas") != null)
		{
			// falta hacer 
			redireccion = "CuentaMovimientos.jsp";
		}
		else if(request.getParameter("cargarPrestamos") != null)
		{
			// boton para ir a prestamos
		}
		else if(request.getParameter("cargarPedirPrestamos") != null)
		{
			// boton para ir a pedir prestamos
		}
		else if(request.getParameter("cargarMiInfo") != null) {
			
			// boton para ir a donde el usuario ve su info
		}
										
		RequestDispatcher dis = request.getRequestDispatcher(redireccion);
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
