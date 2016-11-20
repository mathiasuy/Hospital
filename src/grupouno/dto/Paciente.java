package grupouno.dto;

import java.util.Date;

public class Paciente {
	private int pacienteID;
	private String nombre;
	private String apellido;
	private String cedula;
	private Date fechNac;
	private Mutualista mutualista;
	
    java.util.Date fecha_de_ingreso;
    public java.util.Date getFecha_de_ingreso() {
		return fecha_de_ingreso;
	}
	public void setFecha_de_ingreso(java.util.Date fecha_de_ingreso) {
		this.fecha_de_ingreso = fecha_de_ingreso;
	}	
	
	public int getpacienteID() {
		return pacienteID;
	}
	public void setpacienteID(int pacienteID) {
		this.pacienteID = pacienteID;
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public Date getFechNac() {
		return fechNac;
	}
	public void setFechNac(Date fechNac) {
		this.fechNac = fechNac;
	}
	public Mutualista getMutualista() {
		return mutualista;
	}
	public void setmutualista(Mutualista mutualista) {
		this.mutualista = mutualista;
	}
	public Paciente(String nombre, String apellido,
			String cedula, Date fechNac, Mutualista mutualista) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.fechNac = fechNac;
		this.mutualista = mutualista;
	}
	@Override
	public String toString() {
		return "Paciente [pacienteID=" + pacienteID + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula="
				+ cedula + ", fechNac=" + fechNac + ", mutualista=" + mutualista + "]";
	}

}
