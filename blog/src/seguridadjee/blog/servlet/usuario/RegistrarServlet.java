package seguridadjee.blog.servlet.usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seguridadjee.blog.model.Usuario;
import seguridadjee.blog.model.Usuario.Rol;
import seguridadjee.blog.service.UsuarioService;
import seguridadjee.blog.service.UsuarioServiceFactory;

@WebServlet("/usuario/registrar")
public class RegistrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errores = new ArrayList<String>();
		UsuarioService usuarioService = UsuarioServiceFactory.createUsuarioService();
		
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");
		String rol = request.getParameter("rol");
		
		if (nombre == null || nombre.trim().equals(""))
			errores.add("Nombre inválido");
		if (clave == null || clave.trim().equals(""))
			errores.add("Clave inválida");
		if (rol == null || rol.trim().equals(""))
			errores.add("Rol inválido");
		
		if (errores.size() == 0) { // Agregando usuario
			try {
				usuarioService.agregarUsuario(new Usuario(nombre, clave, Rol.valueOf(rol)));
			} catch (Exception e) {
				e.printStackTrace();
				errores.add("Error al agregar usuario en BD");
			}
		}
		
		if (errores.size() > 0) {
			request.setAttribute("errores", errores);
			getServletContext().getRequestDispatcher("/usuario.jsp")
				.forward(request, response);
		} else {
			response.sendRedirect("../index.jsp");
		}
	}

}
