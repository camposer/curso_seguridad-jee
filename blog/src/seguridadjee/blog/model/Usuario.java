package seguridadjee.blog.model;

import java.io.Serializable;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 3054990593413228582L;
	
	private Integer id;
	private String nombre;
	private String clave;
	private Rol rol;
	
	public static enum Rol {
		ADMIN, ORD;
	}
	
	public Usuario(String nombre, String clave, Rol rol) {
		this.nombre = nombre;
		this.clave = clave;
		this.rol = rol;
	}
	
	public Usuario() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
}
