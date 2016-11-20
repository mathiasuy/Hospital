package grupouno.dto;

public class Mutualista {
	private String nombre;
	private String direccion;
	private int idMutualista;
	
    java.util.Date fecha_de_ingreso;
    public java.util.Date getFecha_de_ingreso() {
		return fecha_de_ingreso;
	}
	public void setFecha_de_ingreso(java.util.Date fecha_de_ingreso) {
		this.fecha_de_ingreso = fecha_de_ingreso;
	}	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getIdMutualista() {
		return idMutualista;
	}
	public void setIdMutualista(int idMutualista) {
		this.idMutualista = idMutualista;
	}
	public Mutualista(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
	}

}
