package grupouno.conexion;

import java.sql.Connection;

import javax.swing.JOptionPane;

public class Conectar {
    private Conexion cdb;
    private static Conectar instancia;
    
    public Conectar()   
    {
        try {
           if (cdb==null){
               //va a busacr a el archivo txt de configuracion de bd el nombre de la clase que tiene info sobre 
               //el tipo de bd a usar
                String nombreClase = System.getProperty("databaseclass");
                //Crea la conexión usando la clase Conexion que contiene la informacion 
                //adecuada extraida de el archivo de configuracin
                cdb= (Conexion)Class.forName(nombreClase).newInstance();
           }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al conectar a la bd");
        }
    }
    
    public synchronized static Conectar estado()
    {
            if (instancia==null){
            instancia = new Conectar();
        }
        return instancia;
    }
    
    public Connection getConnection() {
        return cdb.conn;
    }
    
    public void cerrarConexion(){
        instancia = null;
    }
}
