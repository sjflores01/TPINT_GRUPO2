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

import dao.CuentaDao;
import dao.UsuarioDao;
import dominio.Cuenta;
import dominio.Direccion;
import dominio.Persona;
import dominio.Usuario;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletCuenta")
public class ServletCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String redireccion = "Indddsadsex.jsp";
		
		
		 if(request.getParameter("nuevaCuenta") != null) {
		
			String parametro = request.getParameter("nuevaCuenta");
			Integer id = Integer.parseInt(parametro);
			
			
			UsuarioDao dao = new UsuarioDao();
			Usuario usuario = null;

			
			usuario = dao.leerUsuario(id);
			
			request.setAttribute("usuario", usuario);
			redireccion = "NuevaCuenta.jsp";
			
		} else if(request.getParameter("BtnNuevaCuenta") != null) {
			
			// boton alta cuenta
			int idUsuario;
			int tipoCta;
			
			tipoCta = Integer.parseInt(request.getParameter("Cuentas"));
			idUsuario = Integer.parseInt(request.getParameter("TXTidUsuario"));
			
			
			CuentaDao cuentaDao = new CuentaDao();
			cuentaDao.cargarCuenta(idUsuario, tipoCta);
			
			redireccion ="Index.jsp";
		}
		 else
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
