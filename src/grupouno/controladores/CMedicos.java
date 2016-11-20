package grupouno.controladores;

import java.sql.Date;
import java.util.ArrayList;

import grupouno.dao.DAOMedico;
import grupouno.dto.Medico;
import grupouno.interfaces.IObligatorios;

public class CMedicos // implements IObligatorios<Medico> 
{
	DAOMedico medico = new DAOMedico();
	
//	@Override
	public boolean alta(Medico c) {
		return medico.alta(c);
	}

//	@Override
	public boolean baja(Object key) {
		return medico.baja(key);
	}

//	@Override
	public boolean modificar(Medico c) {
		return medico.modificar(c);
	}

//	@Override
	public Medico obtener(Object key) {
		return medico.obtener(key);
	}

//	@Override
	public ArrayList<Medico> listar() {
		return medico.listar();
	}

//	@Override
	public ArrayList<Medico> filtro(String campo, String filter) {
		return medico.filtro(campo, filter);
	}

//	@Override
	public ArrayList<Medico> entreFechas(String columna_entre, Date desde, Date hasta) {
		return medico.entreFechas(columna_entre, desde, hasta);

	}

//	@Override
	public ArrayList<Medico> entreFechasYFiltro(String columna_entre, Date desde, Date hasta, String columna_filtro,
			String opcion_columna) {
		return medico.entreFechasYFiltro(columna_entre, desde, hasta, columna_filtro, opcion_columna);
	}
}
