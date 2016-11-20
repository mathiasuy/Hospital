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
import grupouno.dto.Mutualista;
import grupouno.interfaces.IObligatorios;

public class DAOMutualista implements IObligatorios<Mutualista>{
    private static boolean retorno = false;
    private static final Conectar CONNECTION = Conectar.estado();
    private PreparedStatement ps;
    private Mutualista mutualista = null;
    private ResultSet rs;            
    private ArrayList<Mutualista> l;
	
    private java.sql.Date aSQL(java.util.Date f1){
    	java.sql.Date f2 = new java.sql.Date(f1.getTime());
    	return f2;
    }
    
    private java.util.Date aUtil(java.sql.Date f1){
    	java.util.Date f2 = new java.util.Date(f1.getTime());
    	return f2;
    }
    
	@Override
	public boolean alta(Mutualista c) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.altaMutualista());
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDireccion());
            if (ps.executeUpdate() > 0){
            	rs = ps.executeQuery(Consultas.getID());
            	if (rs.next()){
            		c.setIdMutualista(rs.getInt("id"));
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
            ps = CONNECTION.getConnection().prepareStatement(Consultas.bajaMutualista());
            ps.setInt(1, (Integer.parseInt(key.toString())));
            if (ps.executeUpdate()>0){
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMutualista.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public boolean modificar(Mutualista c) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.modificarMutualista());
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDireccion());
            ps.setDate(3, aSQL(c.getFecha_de_ingreso()));
            ps.setInt(4, c.getIdMutualista());
            if (ps.executeUpdate()>0){
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMutualista.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return retorno;
	}

	@Override
	public Mutualista obtener(Object key) {
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.obtenerMutualista());
            ps.setInt(1, (int)key);
            rs = ps.executeQuery();
            while(rs.next()){
                 mutualista = new Mutualista(
                		 rs.getString("nombre"),
                		 rs.getString("direccion")
                		 );
                 mutualista.setIdMutualista((int)key);
                 mutualista.setFecha_de_ingreso(aUtil(rs.getDate("fecha_de_ingreso")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMutualista.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return mutualista;
	}

	@Override
	public ArrayList<Mutualista> listar() {
        l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.listarMutualistas("nombre"));
            rs = ps.executeQuery();
            while(rs.next()){
                mutualista = new Mutualista(
               		 rs.getString("nombre"),
               		 rs.getString("direccion")
               	);
                mutualista.setIdMutualista(rs.getInt("mutualistaID"));
                mutualista.setFecha_de_ingreso(aUtil(rs.getDate("fecha_de_ingreso")));
                l.add(mutualista);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMutualista.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

	@Override
	public ArrayList<Mutualista> filtro(String campo, String filter) {
        l = new ArrayList<>();
        try {
            ps = CONNECTION.getConnection().prepareStatement(Consultas.buscarMutualista(campo, "nombre"));
            ps.setString(1, "%"+filter+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                mutualista = new Mutualista(
                  		 rs.getString("nombre"),
                  		 rs.getString("direccion")
                  	);
                   mutualista.setIdMutualista(rs.getInt("mutualistaID"));
                mutualista.setFecha_de_ingreso(aUtil(rs.getDate("fecha_de_ingreso")));
                   l.add(mutualista);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMutualista.class.getName()).log(Level.SEVERE, null, ex);
            throw new Error("ERROR " + ex.getMessage() + " en " + this.getClass().getName());
        }finally{
            CONNECTION.cerrarConexion();
        }
        return l;
	}

	@Override
	public ArrayList<Mutualista> entreFechas(String columna_entre, Date desde, Date hasta) {
        return l;
	}

	@Override
	public ArrayList<Mutualista> entreFechasYFiltro(String columna_entre, Date desde, Date hasta, String columna_filtro,
			String opcion_columna) {
	        return l;
	}

}
