package grupouno.dto;

public class Especialidad {
	int especialidadID;
	String nombre;
	
	public Especialidad(String nombre) {
		super();
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Especialidad [especialidadID=" + especialidadID + ", nombre=" + nombre + "]";
	}
	public int getEspecialidadID() {
		return especialidadID;
	}
	public void setEspecialidadID(int especialidadID) {
		this.especialidadID = especialidadID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
