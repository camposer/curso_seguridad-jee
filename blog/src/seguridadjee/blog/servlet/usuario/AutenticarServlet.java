package seguridadjee.blog.servlet.usuario;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seguridadjee.blog.model.Usuario;
import seguridadjee.blog.service.UsuarioService;
import seguridadjee.blog.service.UsuarioServiceFactory;

@WebServlet("/usuario/autenticar")
public class AutenticarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioService usuarioService = UsuarioServiceFactory.createUsuarioService();
		List<String> errores = new ArrayList<String>();
		
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");
		
		// TODO Validar la robustez de la contraseña!!!
		if (nombre == null || nombre.trim().equals(""))
			errores.add("Nombre inválido");
		if (clave == null || clave.trim().equals(""))
			errores.add("Nombre inválido");
		
		if (errores.size() == 0) {
			try {
				Usuario u = usuarioService.autenticar(nombre, clave);
				
				if (u == null) 
					errores.add("Usuario o contraseña incorrecta");
				else { // Usuario autenticado correctamente!!!
					request.getSession().setAttribute("usuario", u);
					
					request.authenticate(response);
					// TODO: Add role
				}
			} catch (Exception e) {
				e.printStackTrace();
				errores.add("Error de BD al autenticar");
			}
		}
		
		if (errores.size() > 0) {
			request.setAttribute("errores", errores);
			getServletContext().getRequestDispatcher("/WEB-INF/index.jsp")
				.forward(request, response);
		} else {
			response.sendRedirect(getServletContext().getContextPath() + "/articulo/");
		}
	}

}
