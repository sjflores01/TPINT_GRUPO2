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

import daoImpl.UsuarioDaoImpl;

// import com.mysql.cj.Session;

import dominio.Cuenta;
import dominio.Movimiento;
import dominio.Prestamo;
import dominio.Usuario;
import negocio.CuentaNeg;
import negocio.MovimientoNeg;
import negocio.UsuarioNeg;
import negocioImpl.CuentaNegImpl;
import negocioImpl.FechaNegImpl;
import negocioImpl.MovimientoNegImpl;
import negocioImpl.PrestamoNegImpl;
import negocioImpl.UsuarioNegImpl;
import sun.management.counter.StringCounter;

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
			
			
			ArrayList<Cuenta> listaCuentasUsuario = new ArrayList<Cuenta>();
	
			
			listaCuentasUsuario = negCuenta.listarCuentasXUsuario(usuario.getId());
			
			
			
			
			
			request.setAttribute("listaCuentasUsuario", listaCuentasUsuario);							
			redireccion = "PedirPrestamo.jsp";
			
			
			
			
			
		}else if(request.getParameter("BtnPedirPrestamo") != null)
		{
			String cbu;
			String stringMonto;
			String stringcuotas;
			
			Float monto;
			int cuotas;
			float montoDevolver;
			float cuotaMensual;
			
			cbu = request.getParameter("TXTcbu");
			stringMonto = request.getParameter("TXTmonto");
			stringcuotas = request.getParameter("TXTcuotas");
			
			monto = Float.parseFloat(stringMonto);
			cuotas = Integer.parseInt(stringcuotas);
			
			montoDevolver = monto * 1.25f;
			cuotaMensual = montoDevolver / cuotas;
			
			request.setAttribute("cbu", cbu);
			request.setAttribute("monto", monto);
			request.setAttribute("cuotas", cuotas);
			request.setAttribute("montoDevolver", montoDevolver);
			request.setAttribute("cuotaMensual", cuotaMensual);
			
			redireccion = "DetallePedirPrestamo.jsp";
			
		}else if(request.getAttribute("BtnPedirPrestamo2") != null)
		{
			String cbu;
			String stringMonto;
			String stringcuotas;
			String stringMontoDevolver;
			String stringCuotaMensual;
			
			Float monto;
			int cuotas;
			float montoDevolver;
			float cuotaMensual;
			
			cbu = request.getParameter("TXTcbu");
			stringMonto = request.getParameter("TXTmonto");
			stringcuotas = request.getParameter("TXTcuotas");
			stringMontoDevolver = request.getParameter("TXTmontoDevolver");
			stringCuotaMensual = request.getParameter("TXTmontoMensual");
			
			monto = Float.parseFloat(stringMonto);
			cuotas = Integer.parseInt(stringcuotas);
			montoDevolver = Float.parseFloat(stringMontoDevolver);
			cuotaMensual = Float.parseFloat(stringCuotaMensual);
			
			
			Prestamo pres = new Prestamo(0, usuario, null, monto, montoDevolver, cuotaMensual, cuotas, cuotas, 0, cbu);
			
			PrestamoNegImpl presNeg = new PrestamoNegImpl();
			presNeg.solicitarPrestamo(pres);
			
			
			
			
			
			
			
		}		
		else if(request.getParameter("cargarMiInfo") != null) {
			
			// boton para ir a donde el usuario ve su info
			
			
				
				String parametro = request.getParameter("cargarMiInfo");
				String sexo;
				String fecha;
				Integer id = Integer.parseInt(parametro);
				
				UsuarioDaoImpl dao = new UsuarioDaoImpl();
				Usuario Cliente;
				
				Cliente = dao.leerUsuario(id);
				
				if(Cliente.getPersona().getSexo() == 'M')
				{
					sexo = "Masculino";
				} else {						
					sexo = "Femenino"; 
				}
				

				FechaNegImpl fechaNegImpl = new FechaNegImpl();
				fecha = fechaNegImpl.getString(usuario.getPersona().getFnac());
				
				
				request.setAttribute("usuarioCliente", usuario);
				request.setAttribute("sexo", sexo);
				request.setAttribute("fecha", fecha);
				redireccion = "Cliente_Mi_Info.jsp";				
			
			
		}
		
		else if (request.getParameter("Logout") != null) {

			request.getSession().removeAttribute("ClienteLogin");
			redireccion = "Login.jsp";

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
