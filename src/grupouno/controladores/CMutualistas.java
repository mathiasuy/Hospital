package grupouno.controladores;

import java.sql.Date;
import java.util.ArrayList;

import grupouno.dao.DAOMutualista;
import grupouno.dto.Mutualista;
import grupouno.interfaces.IObligatorios;

public class CMutualistas// implements IObligatorios<Mutualista> 
{
	DAOMutualista mutualista = new DAOMutualista();
	
//	@Override
	public boolean alta(Mutualista c) {
		// TODO Auto-generated method stub
		return mutualista.alta(c);
	}

//	@Override
	public boolean baja(Object key) {
		// TODO Auto-generated method stub
		return mutualista.baja(key);
	}

//	@Override
	public boolean modificar(Mutualista c) {
		// TODO Auto-generated method stub
		return mutualista.modificar(c);
	}

//	@Override
	public Mutualista obtener(Object key) {
		// TODO Auto-generated method stub
		return mutualista.obtener(key);
	}

//	@Override
	public ArrayList<Mutualista> listar() {
		// TODO Auto-generated method stub
		return mutualista.listar();
	}

//	@Override
	public ArrayList<Mutualista> filtro(String campo, String filter) {
		// TODO Auto-generated method stub
		return mutualista.filtro(campo, filter);
	}

//	@Override
	public ArrayList<Mutualista> entreFechas(String columna_entre, Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return mutualista.entreFechas(columna_entre, desde, hasta);
	}

//	@Override
	public ArrayList<Mutualista> entreFechasYFiltro(String columna_entre, Date desde, Date hasta, String columna_filtro,
			String opcion_columna) {
		// TODO Auto-generated method stub
		return mutualista.entreFechasYFiltro(columna_entre, desde, hasta, columna_filtro, opcion_columna);
	}

}
