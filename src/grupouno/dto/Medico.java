package grupouno.dto;

public class Medico {
	String documento;
	String nombre;
	String apellido;
	String telefono;
	Especialidad especialidad;
	
    java.util.Date fecha_de_ingreso;
    public java.util.Date getFecha_de_ingreso() {
		return fecha_de_ingreso;
	}
	public void setFecha_de_ingreso(java.util.Date fecha_de_ingreso) {
		this.fecha_de_ingreso = fecha_de_ingreso;
	}	
	
	public Medico(String documento, String nombre, String apellido, String telefono, Especialidad especialidad) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.especialidad = especialidad;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	@Override
	public String toString() {
		return "Medico [documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono="
				+ telefono + ", especialidad=" + especialidad + "]";
	}

}
