package seguridadjee.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	public static final String URL = "jdbc:derby://localhost:1527/blogbd";
	public static final String USUARIO = "user";
	public static final String CLAVE = "123";
	
	protected Connection con;
	
	static {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public BaseDao() throws SQLException {
		this.con = DriverManager.getConnection(URL, USUARIO, CLAVE);
	}
	
	public void cerrar() throws SQLException {
		if (con != null && !con.isClosed())
			con.close();
	}
	
	@Override
	protected void finalize() throws Throwable {
		cerrar();
	}
	
}
