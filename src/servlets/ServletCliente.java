package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import dominio.Cuenta;
import dominio.Usuario;
import negocio.CuentaNeg;
import negocio.UsuarioNeg;
import negocioImpl.CuentaNegImpl;
import negocioImpl.UsuarioNegImpl;

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
		CuentaNeg negCuenta = new CuentaNegImpl();
		Usuario usuario = (Usuario)request.getSession().getAttribute("cliente");
		
		if(usuario == null)
		{
			// Si no esta logueado, al login
			
			redireccion = "Login.jsp";
			
		}
		else if(request.getParameter("cargarCuentas") != null)
		{
			ArrayList<Cuenta> listaCuentasUsuario = new ArrayList<Cuenta>();
			listaCuentasUsuario = negCuenta.listarCuentasXUsuario(usuario.getId());
			request.setAttribute("listaCuentasUsuario", listaCuentasUsuario);
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
