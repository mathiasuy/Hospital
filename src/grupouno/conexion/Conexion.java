package grupouno.conexion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexion {
    public Connection conn=null;
    public DatabaseMetaData dbmt;
    public String datosConexion;
    
    protected String jdbc;
    protected String driver;
    protected String host;
    protected String database;
    protected String username;
    protected String password;
    
    
    public Conexion() throws Error{
    	
    	
    	System.out.println("asdasdfasdf");
    	Properties p = new Properties();
    	try {
			p.load(new FileInputStream("/ProyectoUno/config/parametros.txt"));
			if (p.getProperty("mostrarproperties")=="si"){
				p.list(System.out);
			}
		} catch (FileNotFoundException e) {			
			e.printStackTrace();			
		} catch (IOException e) {
			e.printStackTrace();			
		}
    	
        //obtenemos los parametros de el archivo de configuracion señalado en Inicio.java
        this.jdbc = System.getProperty("jdbc");
        this.driver = System.getProperty("driver");
        this.host = System.getProperty("host");
        this.database = System.getProperty("database");
        this.username = System.getProperty("username");
        this.password = System.getProperty("password");
        
        try {
            iniciardb();
        } catch (Exception e) {
            throw new Error("Ha ocurrido un error al conectar a la base de datos");
        }
    }

    public void iniciardb() throws Error {
        try{
            this.datosConexion = jdbc + host + "/" + database;
            Class.forName(driver).newInstance();
            conn= DriverManager.getConnection(datosConexion, username, password);
        }
        catch(Exception e){
           throw new Error("Ha ocurrido un error al conectar a la base de datos");
        }
    }

}
