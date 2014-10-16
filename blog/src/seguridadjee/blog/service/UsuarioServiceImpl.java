package seguridadjee.blog.service;

import java.sql.SQLException;

import seguridadjee.blog.dao.UsuarioDao;
import seguridadjee.blog.dao.UsuarioDaoFactory;
import seguridadjee.blog.exception.AppException;
import seguridadjee.blog.model.Usuario;

class UsuarioServiceImpl implements UsuarioService {
	private UsuarioDao usuarioDao;
	
	public UsuarioServiceImpl() {
		try {
			this.usuarioDao = UsuarioDaoFactory.createUsuarioDao();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e);
		}
	}
	
	public Usuario agregarUsuario(Usuario u) {
		try {
			u = usuarioDao.agregar(u);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e);
		}
		
		return u;
	}
}
