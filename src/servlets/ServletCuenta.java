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
import negocio.CuentaNeg;
import negocio.UsuarioNeg;
import negocioImpl.CuentaNegImpl;
import negocioImpl.UsuarioNegImpl;

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
			
			
			UsuarioNeg neguUsuario = new UsuarioNegImpl();
			Usuario usuario = null;

			
			usuario = neguUsuario.leerUsuario(id);
			
			request.setAttribute("usuario", usuario);
			redireccion = "NuevaCuenta.jsp";
			
			
		} else if(request.getParameter("BtnNuevaCuenta") != null) {
			
			// boton alta cuenta
			int idUsuario;
			int tipoCta;
			
			tipoCta = Integer.parseInt(request.getParameter("Cuentas"));
			idUsuario = Integer.parseInt(request.getParameter("TXTidUsuario"));
			
			
			CuentaNeg negCuenta = new CuentaNegImpl();
			negCuenta.cargarCuenta(idUsuario, tipoCta);
			
String mensaje = "Cuenta Creada con exito";
			
			request.setAttribute("mensaje",mensaje);
			
			redireccion ="IndexAdmin.jsp";
			
			
		} else if(request.getParameter("ListaCuentas") != null || request.getParameter("TXTbuscador") != null) {
		
			PrintWriter out = response.getWriter();
			
			String spageid = request.getParameter("pagina");
			int pageId = Integer.parseInt(spageid);
			int total = 5;
			
			if(pageId ==1) {}
			else {
				pageId = pageId-1;
				pageId = pageId*total+1;
			}
			
			ArrayList<Cuenta> lista = new ArrayList<Cuenta>();
			CuentaNeg negCuenta = new CuentaNegImpl();
			
			String search = "";
			if(request.getParameter("TXTbuscador") != null)
			{
				search = request.getParameter("TXTbuscador");
			}
			
			lista = negCuenta.listarCuentas(search,1,10);
											
			request.setAttribute("lista", lista);
			redireccion = "ListadoCuentas.jsp";
			
			
		} else if(request.getParameter("cargaEliminar") != null) {
			
			String parametro = request.getParameter("cargaEliminar");
			Integer id = Integer.parseInt(parametro);
			
			CuentaNeg negCuenta = new CuentaNegImpl();
			Cuenta cuenta = null;

			cuenta = negCuenta.getCuenta(id);
			
			request.setAttribute("cuenta", cuenta);
			redireccion = "EliminarCuenta.jsp";
	
			
		} else if(request.getParameter("BtnEliminar") != null) {
		
			String id = request.getParameter("TXTid");
			int idnum = Integer.parseInt(id);
			
			CuentaNeg negCuenta = new CuentaNegImpl();
			negCuenta.eliminarCuenta(idnum);
			String mensaje = "Cuenta Eliminada con exito";
			
			request.setAttribute("mensaje",mensaje);
			redireccion = "IndexAdmin.jsp";
			
		} else if(request.getParameter("cargaModificar") != null) {
		
			String parametro = request.getParameter("cargaModificar");
			Integer id = Integer.parseInt(parametro);
			
			CuentaNeg negCuenta = new CuentaNegImpl();
			Cuenta cuenta = null;

			cuenta = negCuenta.getCuenta(id);
			
			request.setAttribute("cuenta", cuenta);
			redireccion = "ModificarCuenta.jsp";
			
		}else if(request.getParameter("BtnModificar") != null) {
			
			String ID;
			String CTA;
			String SALDO;
			
			int id;
			int tipoCta;
			double saldo;
			
			ID = request.getParameter("TXTid");
			CTA = request.getParameter("Cuentas");
			SALDO =  request.getParameter("TXTsaldo");
			
			id = Integer.parseInt(ID);
			tipoCta  = Integer.parseInt(CTA);
			saldo  = Double.parseDouble(SALDO);
			
			CuentaNeg negCuenta = new CuentaNegImpl();
			negCuenta.modificarCuenta(tipoCta, saldo, id);
			
			String mensaje = "Modificacion de cuenta exitosa";
			request.setAttribute("mensaje", mensaje);
			redireccion ="IndexAdmin.jsp";
			
			
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
