package grupouno.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import grupouno.conexion.Conectar;
import grupouno.dto.Especialidad;
import grupouno.interfaces.IObligatorios;

public class DAOEspecialidad implements IObligatorios<Especialidad> {
    private static boolean retorno = false;
    private static final Conectar CONNECTION = Conectar.estado();
    private PreparedStatement ps;
    private Especialidad especialidad = null;
    private ResultSet rs;            
    private ArrayList<Especialidad> l;

	@Override
	public boolean alta(Especialidad c) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.altaEspecialidad());
            ps.setString(1, c.getNombre());
            if (ps.executeUpdate() > 0){
            	rs = ps.executeQuery(Consultas.getID());
            	if (rs.next()){
            		c.setEspecialidadID(rs.getInt("id"));
            		retorno = true;
            	}
            }
        } catch (Exception e) {
            throw new Error("ERROR " + e.getMessage() + " en " + this.getClass().getName());
        }finally{
           CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public boolean baja(Object key) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.bajaEspecialidad());
            ps.setInt(1, (Integer.parseInt(key.toString())));
            if (ps.executeUpdate()>0){
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public boolean modificar(Especialidad c) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.modificarEspecialidad());
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getEspecialidadID());
            if (ps.executeUpdate()>0){
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public Especialidad obtener(Object key) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.obtenerEspecialidad());
            ps.setInt(1, (int)key);
            rs = ps.executeQuery();
            while(rs.next()){
                 especialidad = new Especialidad(
                        rs.getString("nombre")
                 );
                 especialidad.setEspecialidadID((int)key);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return especialidad;
	}

	@Override
	public ArrayList<Especialidad> listar() {
        l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.listarEspecialidades("nombre"));
            rs = ps.executeQuery();
            while(rs.next()){
            	especialidad = new Especialidad(
            			rs.getString("nombre")
            			);
            	especialidad.setEspecialidadID(rs.getInt("especialidadID"));
                 l.add(especialidad);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

	@Override
	public ArrayList<Especialidad> filtro(String campo, String filter) {
		
        l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.buscarEspecialidades("nombre", "nombre"));
            ps.setString(1, "%"+filter+"%");
            
            rs = ps.executeQuery();
            while(rs.next()){
            	especialidad = new Especialidad(
            			rs.getString("nombre")
            			);
            	especialidad.setEspecialidadID(rs.getInt("especialidadID"));
                 l.add(especialidad);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

	@Override
	public ArrayList<Especialidad> entreFechas(String columna_entre, Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Especialidad> entreFechasYFiltro(String columna_entre, Date desde, Date hasta,
			String columna_filtro, String opcion_columna) {
		// TODO Auto-generated method stub
		return null;
	}

}
