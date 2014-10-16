package seguridadjee.blog.dao;

import java.sql.SQLException;

public abstract class UsuarioDaoFactory {
	public static UsuarioDao createUsuarioDao() throws SQLException {
		return new UsuarioDaoImpl();
	}
}
