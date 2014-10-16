package seguridadjee.blog.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import seguridadjee.blog.model.Usuario;
import seguridadjee.blog.model.Usuario.Rol;

class UsuarioDaoImpl extends BaseDao implements UsuarioDao {
	
	public UsuarioDaoImpl() throws SQLException {
		super();
	}

	/**
	 * Asume que las claves viajan ya cifradas (resumen sha-1)
	 * @param u
	 * @return
	 * @throws SQLException
	 */
	@Override
	public Usuario agregar(Usuario u) throws SQLException {
		// PreparedStatment no Statement
		String sql = "INSERT INTO usuario(nombre, clave, rol) "
				+ "VALUES(?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql, 
				PreparedStatement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, u.getNombre());
		pstmt.setString(2, u.getClave()); // Contraseña cifrada no en plano
		pstmt.setString(3, u.getRol().name());
		
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next())
			u.setId(rs.getInt(1));
		
		return u;
	}

	@Override
	public Usuario autenticar(String nombre, String clave) throws SQLException {
		Usuario u = null;
		
		// PreparedStatment no Statement
		String sql = "SELECT * FROM usuario WHERE nombre = ? AND clave = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, nombre);
		pstmt.setString(2, clave); 
		
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			u = new Usuario(rs.getString("nombre"), 
					rs.getString("clave"), 
					Rol.valueOf(rs.getString("rol")));
			u.setId(rs.getInt("id"));
		}
		
		return u;
	}
}
