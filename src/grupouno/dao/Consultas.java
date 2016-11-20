package grupouno.dao;

public class Consultas {
	
	/***   ESPECIALIAD  *****/
	
	/**
	 * nombre
	 * @return
	 */
	public static String altaEspecialidad(){
		return "INSERT INTO Especialidades (nombre) VALUES (?);";
	}

	/**
	 * especialidadID
	 * @return
	 */
	public static String bajaEspecialidad(){
		return "DELETE FROM Especialidades WHERE especialidadID=?";
	}
	
	/**
	 * nombre, especialidadesID
	 * @return
	 */
	public static String modificarEspecialidad(){
		return "UPDATE Especialidades SET nombre=? WHERE especialidadesID=?";
	}
    	
	/**
	 * especialidadesID
	 * @return
	 */
	public static String obtenerEspecialidad(){
		return "SELECT * FROM Especialidades WHERE especialidadesID=?";
	}
	
	/**
	 * filtro, 
	 * @param filtro
	 * @return
	 */
	public static String buscarEspecialidades(String columna, String orden){
		return "SELECT * FROM Especialidades WHERE columna LIKE ? ORDER BY orden"
				.replaceAll("columna", columna).replaceAll("orden", orden);
	}	
	
	/**
	 *  
	 * @param orden
	 * @return
	 */
	public static String listarEspecialidades(String orden){
		return "SELECT * FROM Especialidades ORDER BY orden"
				.replaceAll("orden", orden);
	}	
		
	/***   CONSULTA  *****/

	/**
	 * pacienteID, MedicoID, Diagnostico
	 * @return
	 */
	public static String altaConsulta(){
		return "INSERT INTO Consultas (pacienteID, MedicoID, Diagnostico) VALUES (?,?,?);";
	}

	/**
	 * ConsultaID
	 * @return
	 */
	public static String bajaConsulta(){
		return "DELETE FROM Consultas WHERE ConsultaID=?";
	}
	
	/**
	 * pacienteID,MedicoID,diagnostico,fecha_de_ingreso,ConsultaID";
	 * @return
	 */
	public static String modificarConsulta(){
		return "UPDATE Consultas SET pacienteID=?,MedicoID=?,diagnostico=?,fecha_de_ingreso=? "
				+ "WHERE ConsultaID=?";
	}
    	
	/**
	 * ConsultaID
	 * @return
	 */
	public static String obtenerConsulta(){
		return "SELECT * FROM Consultas WHERE ConsultaID=?";
	}
	
	/**
	 * filtro, 
	 * @param columna,orden
	 * @return
	 */
	public static String buscarConsulta(String columna, String orden){
		return "SELECT * FROM Consultas WHERE columna LIKE ? ORDER BY orden"
				.replaceAll("columna", columna).replaceAll("orden", orden);
	}	

	/**
	 * filtro, fecha_de_ingreso,fecha_de_ingreso
	 * @param columna,orden
	 * @return
	 */
	public static String buscarConsultaPorFecha(String columna, String orden){
		return "SELECT * FROM Consultas WHERE columna LIKE ? AND fecha_de_ingreso BETWEEN ? AND ? ORDER BY orden"
				.replaceAll("columna", columna).replaceAll("orden", orden);
	}		
	
	/**
	 *  
	 * @param orden
	 * @return
	 */
	public static String listarConsultas(String orden){
		return "SELECT * FROM Consultas ORDER BY orden"
				.replaceAll("orden", orden);
	}	
	
	
	/***   MEDICO  *****/
	
	/**
	 * documento,nombre,apellido,telefono,especialidadID
	 * @return
	 */
	public static String altaMedico(){
		return "INSERT INTO Medicos (documento,nombre,apellido,telefono,especialidadID) "
				+ "VALUES (?,?,?,?,?);";
	}

	/**
	 * documento
	 * @return
	 */
	public static String bajaMedico(){
		return "DELETE FROM Medicos WHERE documento=?";
	}
	
	/**
	 * documento,nombre,apellido,Telefono,especialidadID,fecha_de_ingreso,documento
	 * @return
	 */
	public static String modificarMedico(){
		return "UPDATE Medicos SET documento=?,nombre=?,apellido=?,Telefono=?,especialidadID=?,fecha_de_ingreso=? "
				+ "WHERE documento=?";
	}
    	
	/**
	 * documento
	 * @return
	 */
	public static String obtenerMedico(){
		return "SELECT * FROM Medicos WHERE documento=?";
	}
	
	/**
	 * filtro, 
	 * @param columna
	 * @return
	 */
	public static String buscarMedico(String columna, String orden){
		return "SELECT * FROM Medicos WHERE columna LIKE ? ORDER BY orden"
				.replaceAll("columna", columna).replaceAll("orden", orden);
	}		
	
	/**
	 *  
	 * @param orden
	 * @return
	 */
	public static String listarMedicos(String orden){
		return "SELECT * FROM Medicos ORDER BY orden"
				.replaceAll("orden", orden);
	}		
	
	/***   MUTUALISTA  *****/
	
	/**
	 * nombre,direccion
	 * @return
	 */
	public static String altaMutualista(){
		return "INSERT INTO Mutualistas (nombre,direccion) VALUES (?,?);";
	}

	/**
	 * mutualistaID
	 * @return
	 */
	public static String bajaMutualista(){
		return "DELETE FROM Mutualistas WHERE mutualistaID=?";
	}
	
	/**
	 * nombre,direccion,fecha_de_ingreso, mutualistaID,
	 * @return
	 */
	public static String modificarMutualista(){
		return "UPDATE Mutualistas SET nombre=?,direccion=?,fecha_de_ingreso=? WHERE mutualistaID=?";
	}
    	
	/**
	 * mutualistaID
	 * @return
	 */
	public static String obtenerMutualista(){
		return "SELECT * FROM Mutualistas WHERE mutualistaID=?";
	}
	
	/**
	 * filtro, 
	 * @param columna
	 * @return
	 */
	public static String buscarMutualista(String columna, String orden){
		return "SELECT * FROM Mutualistas WHERE columna LIKE ? ORDER BY orden"
				.replaceAll("columna", columna).replaceAll("orden", orden);
	}		
	
	/**
	 *  
	 * @param orden
	 * @return
	 */
	public static String listarMutualistas(String orden){
		return "SELECT * FROM Mutualistas ORDER BY orden"
				.replaceAll("orden", orden);
	}		
	
	
	/***   PACIENTE  *****/
	
	/**
	 * nombre,apellido,documento,fecha_de_nacimiento,mutualistaID
	 * @return
	 */
	public static String altaPaciente(){
		return "INSERT INTO Pacientes (nombre,apellido,documento,fecha_de_nacimiento,mutualistaID)"
				+ " VALUES (?,?,?,?,?);";
	}

	/**
	 * pacienteID
	 * @return
	 */
	public static String bajaPaciente(){
		return "DELETE FROM Pacientes WHERE pacienteID=?";
	}
	
	/**
	 * nombre,apellido,documento,fecha_de_nacimiento,mutualistaID,fecha_de_ingreso, pacienteID";
	 * @return
	 */
	public static String modificarPaciente(){
		return "UPDATE Pacientes SET nombre=?,apellido=?,documento=?,fecha_de_nacimiento=?,mutualistaID=?,fecha_de_ingreso=? WHERE pacienteID=?";
	}
    	
	/**
	 * pacienteID
	 * @return
	 */
	public static String obtenerPaciente(){
		return "SELECT * FROM Pacientes WHERE pacienteID=?";
	}
	
	/**
	 * filtro, 
	 * @param columna
	 * @return
	 */
	public static String buscarPaciente(String columna, String orden){
		return "SELECT * FROM Pacientes WHERE columna LIKE ? ORDER BY orden"
				.replaceAll("columna", columna).replaceAll("orden", orden);
	}		
	
	public static String getID(){
		return "select @@identity as id";
	}
	
	/**
	 *  
	 * @param orden
	 * @return
	 */
	public static String listarPacientes(String orden){
		return "SELECT * FROM Pacientes ORDER BY orden"
				.replaceAll("orden", orden);
	}		

}
