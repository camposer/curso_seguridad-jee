package seguridadjee.blog.servlet.usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seguridadjee.blog.model.Usuario.Rol;

@WebServlet("/usuario/")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> roles = new ArrayList<String>();
		for (Rol v : Rol.values()) {
			roles.add(v.name());
		}
		
		request.setAttribute("roles", roles);
		
		getServletContext().getRequestDispatcher("/usuario.jsp")
			.forward(request, response);
	}

}
