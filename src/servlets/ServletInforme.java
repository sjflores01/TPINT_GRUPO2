package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Informe;
import dominio.Prestamo;
import negocio.InformeNeg;
import negocio.PrestamoNeg;
import negocioImpl.InformeNegImpl;
import negocioImpl.PrestamoNegImpl;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletInforme")
public class ServletInforme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInforme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String redireccion = "Indddsadsex.jsp";
		
		
		 if(request.getParameter("activos") != null) {
		
			
			ArrayList<Informe> lista = new ArrayList<Informe>();
			InformeNeg negInforme = new InformeNegImpl();
			
			
			lista = negInforme.informePrestamos();
											
			request.setAttribute("lista", lista);
			redireccion = "PrestamosActivos.jsp";
			
			
		} else if(request.getParameter("inpagos") != null) {
			
			String parametro = request.getParameter("cargaAprobar");
			Integer id = Integer.parseInt(parametro);
		
			
			ArrayList<Prestamo> lista = new ArrayList<Prestamo>();
			PrestamoNeg negPrestamo = new PrestamoNegImpl();
			
			
			negPrestamo.aprobarPrestamo(id);
			lista = negPrestamo.listarPrestamos();
											
			request.setAttribute("lista", lista);
			redireccion = "PrestamosInpagos.jsp";
			
			
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
