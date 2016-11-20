package grupouno.controladores;

import java.sql.Date;
import java.util.ArrayList;

import grupouno.dao.DAOPaciente;
import grupouno.dto.Paciente;
import grupouno.interfaces.IObligatorios;

public class CPacientes //implements IObligatorios<Paciente>
{
	DAOPaciente paciente = new DAOPaciente();
	
//	@Override
	public boolean alta(Paciente c) {
		// TODO Auto-generated method stub
		return paciente.alta(c);
	}

//	@Override
	public boolean baja(Object key) {
		// TODO Auto-generated method stub
		return paciente.baja(key);
	}

//	@Override
	public boolean modificar(Paciente c) {
		// TODO Auto-generated method stub
		return paciente.modificar(c);
	}

//	@Override
	public Paciente obtener(Object key) {
		// TODO Auto-generated method stub
		return paciente.obtener(key);
	}

//	@Override
	public ArrayList<Paciente> listar() {
		// TODO Auto-generated method stub
		return paciente.listar();
	}

//	@Override
	public ArrayList<Paciente> filtro(String campo, String filter) {
		// TODO Auto-generated method stub
		return paciente.filtro(campo, filter);
	}

//	@Override
	public ArrayList<Paciente> entreFechas(String columna_entre, Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return paciente.entreFechas(columna_entre, desde, hasta);
	}

//	@Override
	public ArrayList<Paciente> entreFechasYFiltro(String columna_entre, Date desde, Date hasta, String columna_filtro,
			String opcion_columna) {
		// TODO Auto-generated method stub
		return paciente.entreFechasYFiltro(columna_entre, desde, hasta, columna_filtro, opcion_columna);
	}

}
