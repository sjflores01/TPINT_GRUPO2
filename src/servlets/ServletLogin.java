package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import dominio.Usuario;
import negocio.UsuarioNeg;
import negocioImpl.UsuarioNegImpl;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getParameter("BtnIngersar")!=null)
		{
			Usuario usuarioAdmin = new Usuario();
			Usuario usuarioUser = new Usuario();
			UsuarioNeg negUsuario = new UsuarioNegImpl();
			
			String username = request.getParameter("txtBoxUsuario");
			String pass = request.getParameter("txtBoxClave");
			
			usuarioAdmin = negUsuario.confirmarAdmin(request.getParameter("txtBoxUsuario"),request.getParameter("txtBoxClave"));	
			
			
			
			
			
			
			
			if(usuarioAdmin.getId()!=null)
					{
								
						request.getSession().setAttribute("UsuarioAdmin", usuarioAdmin);
						
						RequestDispatcher rd = request.getRequestDispatcher("IndexAdmin.jsp");
						
						rd.forward(request, response);
				
				
					}
			else if(negUsuario.chequearSiEsUsuario(username, pass))
			{
				usuarioUser = negUsuario.confirmarUser(request.getParameter("txtBoxUsuario"),request.getParameter("txtBoxClave"));
				
				request.getSession().setAttribute("cliente", usuarioUser);
				
				RequestDispatcher rd = request.getRequestDispatcher("IndexUsuario.jsp");
				
				rd.forward(request,response);
				
			}
			else {
				
				String error = "error de logueo";
				request.setAttribute("Error logueo", error);
				
				RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
				
				rd.forward(request, response);
				
			}	
			
			
			
			
			if(request.getParameter("Logout") != null){
				
				request.getSession().removeAttribute("UsuarioAdmin");
				request.getSession().removeAttribute("cliente");
               RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
				
				rd.forward(request, response);
				
				
			}
						
			
		}	
		else {
			
			System.out.println("Error de logueo");
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		
		rd.forward(request, response);
		
		}
	}

		
}


