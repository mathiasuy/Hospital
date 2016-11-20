package grupouno.controladores;

import java.sql.Date;
import java.util.ArrayList;

import grupouno.dao.DAOEspecialidad;
import grupouno.dto.Especialidad;

public class CEspecialidades {

	private static DAOEspecialidad especialidad = new DAOEspecialidad();
	
//	@Override
	public static boolean alta(Especialidad c) {
		// TODO Auto-generated method stub
		return especialidad.alta(c);
	}

//	@Override
	public static boolean baja(Object key) {
		// TODO Auto-generated method stub
		return especialidad.baja(key);
	}

//	@Override
	public static boolean modificar(Especialidad c) {
		// TODO Auto-generated method stub
		return especialidad.modificar(c);
	}

//	@Override
	public static Especialidad obtener(Object key) {
		// TODO Auto-generated method stub
		return especialidad.obtener(key);
	}

//	@Override
	public static ArrayList<Especialidad> listar() {
		// TODO Auto-generated method stub
		return especialidad.listar();
	}

//	@Override
	public static ArrayList<Especialidad> filtro(String campo, String filter) {
		// TODO Auto-generated method stub
		return especialidad.filtro(campo, filter);
	}

//	@Override
	public static ArrayList<Especialidad> entreFechas(String columna_entre, Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return especialidad.entreFechas(columna_entre, desde, hasta);
	}

//	@Override
	public static ArrayList<Especialidad> entreFechasYFiltro(String columna_entre, Date desde, Date hasta,
			String columna_filtro, String opcion_columna) {
		// TODO Auto-generated method stub
		return especialidad.entreFechasYFiltro(columna_entre, desde, hasta, columna_filtro, opcion_columna);
	}


}
