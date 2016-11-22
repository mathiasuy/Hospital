package grupouno.controladores;

import java.sql.Date;
import java.util.ArrayList;

import grupouno.dao.DAOConsulta;
import grupouno.dto.Consulta;

public class CConsultas {

	//@Override
	public static boolean alta(Consulta c) {
		DAOConsulta consulta = new DAOConsulta();
		return consulta.alta(c);
	}

//	@Override
	public static boolean baja(Object key) {
		DAOConsulta consulta = new DAOConsulta();
		return consulta.baja(key);
	}

//	@Override
	public static boolean modificar(Consulta c) {
		DAOConsulta consulta = new DAOConsulta();
		return consulta.modificar(c);
	}

//	@Override
	public static Consulta obtener(Object key) {
		// TODO Auto-generated method stub
		DAOConsulta consulta = new DAOConsulta();
		return consulta.obtener(key);
	}

//	@Override
	public static ArrayList<Consulta> listar() {
		// TODO Auto-generated method stub
		DAOConsulta consulta = new DAOConsulta();
		return consulta.listar();
	}

//	@Override
	public static ArrayList<Consulta> filtro(String campo, String filter) {
		// TODO Auto-generated method stub
		DAOConsulta consulta = new DAOConsulta();
		return consulta.filtro(campo, filter);
	}

//	@Override
	public static ArrayList<Consulta> entreFechas(String filtro, Date desde, Date hasta) {
		// TODO Auto-generated method stub
		DAOConsulta consulta = new DAOConsulta();
		return consulta.entreFechas(filtro, desde, hasta);
	}

//	@Override
	public static ArrayList<Consulta> entreFechasYFiltro(String columna_entre, Date desde, Date hasta, String columna_filtro,
			String opcion_columna) {
		// TODO Auto-generated method stub
		DAOConsulta consulta = new DAOConsulta();
		return consulta.entreFechasYFiltro(columna_entre, desde, hasta, columna_filtro, opcion_columna);
	}


}
