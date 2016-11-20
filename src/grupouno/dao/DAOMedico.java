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
import grupouno.dto.Medico;
import grupouno.interfaces.IObligatorios;

public class DAOMedico implements IObligatorios<Medico>{
    private static boolean retorno = false;
    private static final Conectar CONNECTION = Conectar.estado();
    private PreparedStatement ps;
    private Medico medico = null;
    private ResultSet rs;            
    private ArrayList<Medico> l;
	
    private java.sql.Date aSQL(java.util.Date f1){
    	java.sql.Date f2 = new java.sql.Date(f1.getTime());
    	return f2;
    }
    
    private java.util.Date aUtil(java.sql.Date f1){
    	java.util.Date f2 = new java.util.Date(f1.getTime());
    	return f2;
    }
    
	@Override
	public boolean alta(Medico c) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.altaMedico());
            ps.setString(1, c.getDocumento());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellido());
            ps.setString(4, c.getTelefono());
            ps.setInt(5, c.getEspecialidad().getEspecialidadID());
            if (ps.executeUpdate() > 0){
           		retorno = true;
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
            ps = CONNECTION.getConnection().prepareStatement(Consultas.bajaMedico());
            ps.setInt(1, (Integer.parseInt(key.toString())));
            if (ps.executeUpdate()>0){
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMedico.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public boolean modificar(Medico c) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.modificarMedico());
            ps.setString(1, c.getDocumento());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellido());
            ps.setString(4, c.getTelefono());
            ps.setInt(5, c.getEspecialidad().getEspecialidadID());
            ps.setDate(6, aSQL(c.getFecha_de_ingreso()));
            ps.setString(7, c.getDocumento());
            if (ps.executeUpdate()>0){
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMedico.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public Medico obtener(Object key) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.obtenerMedico());
            ps.setInt(1, (int)key);
            rs = ps.executeQuery();
            while(rs.next()){
                DAOEspecialidad especialdiad = new DAOEspecialidad();
                 medico = new Medico(
                		 rs.getString("documento"),
                		 rs.getString("nombre"),
                		 rs.getString("apellido"),
                		 rs.getString("Telefono"),
                		 especialdiad.obtener(rs.getInt("especialidad"))
                		 );
                 medico.setFecha_de_ingreso(aUtil(rs.getDate("fecha_de_ingreso")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMedico.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return medico;
	}

	@Override
	public ArrayList<Medico> listar() {
        l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.listarMedicos("nombre"));
            rs = ps.executeQuery();
            while(rs.next()){
                DAOEspecialidad especialdiad = new DAOEspecialidad();
                medico = new Medico(
               		 rs.getString("documento"),
               		 rs.getString("nombre"),
               		 rs.getString("apellido"),
               		 rs.getString("Telefono"),
               		 especialdiad.obtener(rs.getInt("especialidad"))
               	);
                medico.setFecha_de_ingreso(aUtil(rs.getDate("fecha_de_ingreso")));
                l.add(medico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMedico.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

	@Override
	public ArrayList<Medico> filtro(String campo, String filter) {
        l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.buscarMedico(campo, "nombre"));
            ps.setString(1, "%"+filter+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                DAOEspecialidad especialdiad = new DAOEspecialidad();
                medico = new Medico(
               		 rs.getString("documento"),
               		 rs.getString("nombre"),
               		 rs.getString("apellido"),
               		 rs.getString("Telefono"),
               		 especialdiad.obtener(rs.getInt("especialidad"))
               	);
                medico.setFecha_de_ingreso(aUtil(rs.getDate("fecha_de_ingreso")));
                l.add(medico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMedico.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

	@Override
	public ArrayList<Medico> entreFechas(String columna_entre, Date desde, Date hasta) {
        return l;
	}

	@Override
	public ArrayList<Medico> entreFechasYFiltro(String columna_entre, Date desde, Date hasta, String columna_filtro,
			String opcion_columna) {
	        return l;
	}

}
