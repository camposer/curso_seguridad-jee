package seguridadjee.blog.service;

public abstract class UsuarioServiceFactory {
	public static UsuarioService createUsuarioService() {
		return new UsuarioServiceImpl();
	}
}
