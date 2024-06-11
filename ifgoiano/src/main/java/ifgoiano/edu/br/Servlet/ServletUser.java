package ifgoiano.edu.br.Servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ifgoiano.edu.br.entidade.Usuario;
import ifgoiano.edu.br.entidade.usuario.UsuarioRepositorio;

/**
 * Servlet implementation class ServletUser
 */
@WebServlet("/CadastroServlet")
public class ServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Email = request.getParameter("Email");
		String Senha = request.getParameter("Senha");

		if (Email.contains("") && Senha.equals("123456")) {
			try {
				UsuarioRepositorio repositorio = new UsuarioRepositorio();
				List<Usuario> lstUsuario = repositorio.listarUsuarios();
				
					request.setAttribute("lstUsuario", lstUsuario);
					request.getRequestDispatcher("listaUsuario.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException("Erro na listagem de Usu�rios");
			}
		} else {
			request.setAttribute("mostrarFalha", true);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
