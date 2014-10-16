package seguridadjee.blog.servlet.articulo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seguridadjee.blog.model.Usuario;
import seguridadjee.blog.model.Usuario.Rol;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(name = "IndexArticuloServlet", urlPatterns = { "/articulo/" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = (Usuario)request.getSession().getAttribute("usuario");
		
		if (u != null && u.getRol().equals(Rol.ADMIN)) {
			getServletContext().getRequestDispatcher("/WEB-INF/articulo.jsp")
				.forward(request, response);
		} else {
			throw new ServletException("Usuario inválido");
		}
	}

}
