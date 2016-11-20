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
import grupouno.dto.Paciente;
import grupouno.interfaces.IObligatorios;

public class DAOPaciente implements IObligatorios<Paciente>{
    private static boolean retorno = false;
    private static final Conectar CONNECTION = Conectar.estado();
    private PreparedStatement ps;
    private Paciente paciente = null;
    private ResultSet rs;            
    private ArrayList<Paciente> l;
	
    private java.sql.Date aSQL(java.util.Date f1){
    	java.sql.Date f2 = new java.sql.Date(f1.getTime());
    	return f2;
    }
    
    private java.util.Date aUtil(java.sql.Date f1){
    	java.util.Date f2 = new java.util.Date(f1.getTime());
    	return f2;
    }
    
	@Override
	public boolean alta(Paciente c) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.altaPaciente());
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getCedula());
            ps.setDate(4, aSQL(c.getFechNac()));
            ps.setInt(5, c.getMutualista().getIdMutualista());
           
            if (ps.executeUpdate() > 0){
            	rs = ps.executeQuery(Consultas.getID());
            	if (rs.next()){
            		c.setpacienteID(rs.getInt("id"));
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
            ps = CONNECTION.getConnection().prepareStatement(Consultas.bajaPaciente());
            ps.setInt(1, (Integer.parseInt(key.toString())));
            if (ps.executeUpdate()>0){
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPaciente.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public boolean modificar(Paciente c) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.modificarPaciente());
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getCedula());
            ps.setDate(4, aSQL(c.getFechNac()));
            ps.setInt(5, c.getMutualista().getIdMutualista());
            ps.setDate(6, aSQL(c.getFecha_de_ingreso()));
            ps.setInt(7, c.getpacienteID());
            if (ps.executeUpdate()>0){
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPaciente.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public Paciente obtener(Object key) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.obtenerPaciente());
            ps.setInt(1, (int)key);
            rs = ps.executeQuery();
            while(rs.next()){
            	DAOMutualista mutualista = new DAOMutualista();
                 paciente = new Paciente(
                		 rs.getString("nombre"),
                		 rs.getString("apellido"),
                		 rs.getString("documento"),
                		 aUtil(rs.getDate("fecha_de_nacimiento")),
                		 mutualista.obtener(rs.getInt("mutualistaID"))
                		 );
                 paciente.setpacienteID((int)key);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPaciente.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return paciente;
	}

	@Override
	public ArrayList<Paciente> listar() {
        l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.listarPacientes("nombre"));
            rs = ps.executeQuery();
            while(rs.next()){
            	DAOMutualista mutualista = new DAOMutualista();
                paciente = new Paciente(
               		 rs.getString("nombre"),
               		 rs.getString("apellido"),
               		 rs.getString("documento"),
               		 aUtil(rs.getDate("fecha_de_nacimiento")),
               		 mutualista.obtener(rs.getInt("mutualistaID"))
               		 );
                paciente.setpacienteID(rs.getInt("pacienteID"));
                l.add(paciente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPaciente.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

	@Override
	public ArrayList<Paciente> filtro(String campo, String filter) {
        l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.buscarPaciente(campo, "nombre"));
            ps.setString(1, "%"+filter+"%");
            rs = ps.executeQuery();
            while(rs.next()){
            	DAOMutualista mutualista = new DAOMutualista();
                paciente = new Paciente(
                  		 rs.getString("nombre"),
                  		 rs.getString("apellido"),
                  		 rs.getString("documento"),
                  		 aUtil(rs.getDate("fecha_de_nacimiento")),
                  		 mutualista.obtener(rs.getInt("mutualistaID"))
                  		 );
                   paciente.setpacienteID(rs.getInt("pacienteID"));
                   l.add(paciente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPaciente.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

	@Override
	public ArrayList<Paciente> entreFechas(String columna_entre, Date desde, Date hasta) {
        return l;
	}

	@Override
	public ArrayList<Paciente> entreFechasYFiltro(String columna_entre, Date desde, Date hasta, String columna_filtro,
			String opcion_columna) {
	        return l;
	}

}
