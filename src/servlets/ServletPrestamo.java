package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Prestamo;
import negocio.PrestamoNeg;
import negocioImpl.PrestamoNegImpl;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletPrestamo")
public class ServletPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrestamo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String redireccion = "Indddsadsex.jsp";
		
		
		 if(request.getParameter("ListaPrestamos") != null) {
		
			
			ArrayList<Prestamo> lista = new ArrayList<Prestamo>();
			PrestamoNeg negPrestamo = new PrestamoNegImpl();
			
			
			lista = negPrestamo.listarPrestamos();
											
			request.setAttribute("lista", lista);
			redireccion = "PrestamosPendientes.jsp";
			
			
		} else if(request.getParameter("cargaAprobar") != null) {
			
			String parametro = request.getParameter("cargaAprobar");
			Integer id = Integer.parseInt(parametro);
		
			
			ArrayList<Prestamo> lista = new ArrayList<Prestamo>();
			PrestamoNeg negPrestamo = new PrestamoNegImpl();
			
			
			negPrestamo.aprobarPrestamo(id);
			lista = negPrestamo.listarPrestamos();
											
			request.setAttribute("lista", lista);
			redireccion = "PrestamosPendientes.jsp";
			
			
		} else if(request.getParameter("cargaCancelar") != null) {
		
			String parametro = request.getParameter("cargaCancelar");
			Integer id = Integer.parseInt(parametro);
			
			
			ArrayList<Prestamo> lista = new ArrayList<Prestamo>();
			PrestamoNeg negPrestamo = new PrestamoNegImpl();
			
			negPrestamo.cancelarPrestamo(id);
			lista = negPrestamo.listarPrestamos();
											
			request.setAttribute("lista", lista);
			redireccion = "PrestamosPendientes.jsp";
			
			
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
