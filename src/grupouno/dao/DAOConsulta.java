package grupouno.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import grupouno.conexion.Conectar;
import grupouno.dto.Consulta;
import grupouno.interfaces.IObligatorios;

public class DAOConsulta implements IObligatorios<Consulta>{

    private static boolean retorno = false;
    private static final Conectar CONNECTION = Conectar.estado();
    private PreparedStatement ps;
    private Consulta consulta = null;
    private ResultSet rs;            
    private ArrayList<Consulta> l;
	
    private java.sql.Date aSQL(java.util.Date f1){
    	java.sql.Date f2 = new java.sql.Date(f1.getTime());
    	return f2;
    }
    
    private java.util.Date aUtil(java.sql.Date f1){
    	java.util.Date f2 = new java.util.Date(f1.getTime());
    	return f2;
    }
    
	@Override
	public boolean alta(Consulta c) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.altaConsulta());
            ps.setInt(1, c.getPaciente().getpacienteID());
            ps.setString(2, c.getMedico().getDocumento());
            ps.setString(3, c.getDiagnostico());
            if (ps.executeUpdate() > 0){
            	rs = ps.executeQuery(Consultas.getID());
            	if (rs.next()){
            		c.setConsultaID(rs.getInt("id"));
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
            ps = CONNECTION.getConnection().prepareStatement(Consultas.bajaConsulta());
            ps.setInt(1, (Integer.parseInt(key.toString())));
            if (ps.executeUpdate()>0){
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOConsulta.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public boolean modificar(Consulta c) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.modificarConsulta());
            ps.setInt(1, c.getPaciente().getpacienteID());
            ps.setString(2, c.getMedico().getDocumento());
            ps.setString(3, c.getDiagnostico());
            ps.setDate(4, aSQL(c.getFecha_de_ingreso()));
            ps.setInt(5, c.getConsultaID());
            if (ps.executeUpdate()>0){
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOConsulta.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public Consulta obtener(Object key) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.obtenerConsulta());
            ps.setInt(1, (int)key);
            rs = ps.executeQuery();
            while(rs.next()){
                DAOMedico medico = new DAOMedico();
                DAOPaciente paciente = new DAOPaciente();
                 consulta = new Consulta(
                		 paciente.obtener(rs.getInt("pacienteID")),
                		 medico.obtener(rs.getString("documento")),
                		 rs.getString("diagnostico")
                		 );
                 consulta.setConsultaID((int)key);
                 consulta.setFecha_de_ingreso(aUtil(rs.getDate("fecha_de_ingreso")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOConsulta.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return consulta;
	}

	@Override
	public ArrayList<Consulta> listar() {
        l = new ArrayList<>();
        try {
        	
        	System.out.println("arraylist listar");
            ps = CONNECTION.getConnection().prepareStatement(Consultas.listarConsultas("fecha_de_ingreso"));
            rs = ps.executeQuery();
            while(rs.next()){
            	DAOMedico medico = new DAOMedico();
                DAOPaciente paciente = new DAOPaciente();
                 consulta = new Consulta(
                		 paciente.obtener(rs.getInt("pacienteID")),
                		 medico.obtener(rs.getString("documento")),
                		 rs.getString("diagnostico")
                		 );
                 consulta.setConsultaID(rs.getInt("consultaID"));
                 consulta.setFecha_de_ingreso(aUtil(rs.getDate("fecha_de_ingreso")));
                 l.add(consulta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOConsulta.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

	@Override
	public ArrayList<Consulta> filtro(String campo, String filter) {
        l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.buscarConsulta("ConsultaID", "fecha_de_ingreso"));
            ps.setString(1, "%"+filter+"%");
            rs = ps.executeQuery();
            while(rs.next()){
            	DAOMedico medico = new DAOMedico();
                DAOPaciente paciente = new DAOPaciente();
                consulta = new Consulta(
               		 paciente.obtener(rs.getInt("pacienteID")),
               		 medico.obtener(rs.getString("documento")),
               		 rs.getString("diagnostico")
               		 );
                consulta.setConsultaID(rs.getInt("consultaID"));
                consulta.setFecha_de_ingreso(aUtil(rs.getDate("fecha_de_ingreso")));
                 l.add(consulta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOConsulta.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

	@Override
	public ArrayList<Consulta> entreFechas(String filtro, Date desde, Date hasta) {
        l = new ArrayList<>();
        try {
        		ps = CONNECTION.getConnection().prepareStatement(Consultas.buscarConsultaPorFecha("ConsultaID","orden"));
                            ps.setString(1,  "%"+filtro+"%");
                            ps.setDate(2, desde);
                            ps.setDate(3, hasta);
            rs = ps.executeQuery();
            while(rs.next()){
	            	DAOMedico medico = new DAOMedico();
	                DAOPaciente paciente = new DAOPaciente();
	                consulta = new Consulta(
	                  		 paciente.obtener(rs.getInt("pacienteID")),
	                  		 medico.obtener(rs.getString("documento")),
	                  		 rs.getString("diagnostico")
	                  		 );
	                   consulta.setConsultaID(rs.getInt("consultaID"));
	                 consulta.setFecha_de_ingreso(aUtil(rs.getDate("fecha_de_ingreso")));
	                 l.add(consulta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOConsulta.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}


	@Override
	public ArrayList<Consulta> entreFechasYFiltro(String columna_entre, Date desde, Date hasta, String columna_filtro,
			String opcion_columna) {
		// TODO Auto-generated method stub
		return null;
	}

}
