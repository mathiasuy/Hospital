package grupouno.dto;

public class Consulta {
	int consultaID;
	Paciente paciente;
    Medico medico;
    String diagnostico;
    
    java.util.Date fecha_de_ingreso;
    public java.util.Date getFecha_de_ingreso() {
		return fecha_de_ingreso;
	}
	public void setFecha_de_ingreso(java.util.Date fecha_de_ingreso) {
		this.fecha_de_ingreso = fecha_de_ingreso;
	}
	
	public Consulta(Paciente paciente, Medico medico, String diagnostico) {
		super();
		this.paciente = paciente;
		this.medico = medico;
		this.diagnostico = diagnostico;
	}
	public int getConsultaID() {
		return consultaID;
	}
	public void setConsultaID(int consultaID) {
		this.consultaID = consultaID;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	@Override
	public String toString() {
		return "Consulta [consultaID=" + consultaID + ", paciente=" + paciente + ", medico=" + medico
				+ ", diagnostico=" + diagnostico + "]";
	}

}
