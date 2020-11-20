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

// import com.mysql.cj.Session;

import dominio.Cuenta;
import dominio.Movimiento;
import dominio.Usuario;
import negocio.CuentaNeg;
import negocio.MovimientoNeg;
import negocio.UsuarioNeg;
import negocioImpl.CuentaNegImpl;
import negocioImpl.MovimientoNegImpl;
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
		MovimientoNeg negMov = new MovimientoNegImpl();
			
			
		
		Usuario usuario = (Usuario)request.getSession().getAttribute("cliente");
		
		if(usuario == null)
		{
			// Si no esta logueado, al login
			
			redireccion = "Login.jsp";
			
		}
		else if(request.getParameter("cargarCuentas") != null)
		{
			ArrayList<Cuenta> listaCuentasUsuario = new ArrayList<Cuenta>();
			ArrayList<Movimiento> listaMovimientos = new ArrayList<Movimiento>();
			int idSeleccionada;
			
			listaCuentasUsuario = negCuenta.listarCuentasXUsuario(usuario.getId());
			listaMovimientos = negMov.listarMovimientos(listaCuentasUsuario.get(0).getCbu());
			idSeleccionada = listaCuentasUsuario.get(0).getId();
			
			
			
			request.setAttribute("listaCuentasUsuario", listaCuentasUsuario);
			request.setAttribute("movimientos", listaMovimientos);
			request.setAttribute("selected", listaCuentasUsuario.get(0).getCbu());
			request.setAttribute("idSeleccionada", idSeleccionada);
			request.setAttribute("saldo", listaCuentasUsuario.get(0).getSaldo());
			
			redireccion = "CuentaMovimientos.jsp";
			
			
			
			
			
			
		} else if(request.getParameter("BtnVerMovimientos") != null)
		{
			ArrayList<Cuenta> listaCuentasUsuario = new ArrayList<Cuenta>();
			ArrayList<Movimiento> listaMovimientos = new ArrayList<Movimiento>();
			String cbu = request.getParameter("TXTcbu");
			int idSeleccionada = 0;
			float saldo = 0f;
			
			listaCuentasUsuario = negCuenta.listarCuentasXUsuario(usuario.getId());
			listaMovimientos = negMov.listarMovimientos(cbu);
			
			
			for(Cuenta cuenta : listaCuentasUsuario)
			{
				if(cuenta.getCbu().equals(cbu))
				{
					idSeleccionada = cuenta.getId();
					saldo = cuenta.getSaldo();
				}
			}
			
			
			
			request.setAttribute("listaCuentasUsuario", listaCuentasUsuario);
			request.setAttribute("movimientos", listaMovimientos);
			request.setAttribute("selected", cbu);
			request.setAttribute("idSeleccionada", idSeleccionada);
			request.setAttribute("saldo", saldo );
			
			redireccion = "CuentaMovimientos.jsp";
					
			
		}else if(request.getParameter("BtnCargaTransferencia") != null) 
		{
		
			String stringId = request.getParameter("TXTidCuenta");
			int id = Integer.parseInt(stringId);
			
			
			Cuenta cuenta = negCuenta.getCuenta(id);
			
			
			request.setAttribute("cuenta", cuenta);
			request.setAttribute("idSeleccionada", id);
			redireccion = "HacerTransferencia.jsp";
			
		}else if(request.getParameter("BtnTransferir") != null)
		{
			
			String destino = request.getParameter("TXTcbu");
			String stringMonto = request.getParameter("TXTmonto");
			String stringId = request.getParameter("TXTidCuenta");
			String mensaje;
			
			int id = Integer.parseInt(stringId);
			float monto = Float.parseFloat(stringMonto);
			
			Cuenta cuenta = negCuenta.getCuenta(id);
			
			
			if(!negCuenta.chequearCbu(destino))
			{
				mensaje = "CBU invalido.";
				
				redireccion = "HacerTransferencia.jsp";
				
				request.setAttribute("cuenta", cuenta);
				request.setAttribute("idSeleccionada", id);
				request.setAttribute("mensaje", mensaje);
			} else if (cuenta.getSaldo() < monto)
			{
				mensaje = "Saldo insuficiente";
				
				redireccion = "HacerTransferencia.jsp";
				
				redireccion = "HacerTransferencia.jsp";
				request.setAttribute("cuenta", cuenta);
				request.setAttribute("idSeleccionada", id);
				request.setAttribute("mensaje", mensaje);
			}  else {
				
				Movimiento movimiento = new Movimiento(cuenta.getCbu(), destino, monto, null, "Transferencia");
				negMov.hacerTransferencia(movimiento);
				
				
				
				
				
			}
			
			
			
			
			
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
