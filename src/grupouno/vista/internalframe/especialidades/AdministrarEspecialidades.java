package grupouno.vista.internalframe.especialidades;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import grupouno.controladores.CEspecialidades;
import grupouno.dto.Especialidad;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class AdministrarEspecialidades extends JInternalFrame {
	private JTable tabla;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtFiltro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrarEspecialidades frame = new AdministrarEspecialidades();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void cargarDatos(){
		System.out.println("asfd"+txtFiltro.getText());
		ArrayList<Especialidad> lista = CEspecialidades.filtro("nombre", txtFiltro.getText());
		DefaultTableModel tbm = new DefaultTableModel(new String[] {"Id", "Nombre"}, lista.size());
		tabla.setModel(tbm);
		int row = 0;
		for (Especialidad e : lista){
			tabla.setValueAt(e.getEspecialidadID(), row, 0);
			tabla.setValueAt(e.getNombre(), row, 1);
		}
	}	

	/**
	 * Create the frame.
	 */
	public AdministrarEspecialidades() {
		setBounds(100, 100, 767, 529);
		getContentPane().setLayout(null);
		
		tabla = new JTable();
		tabla.setBounds(35, 145, 682, 327);
		getContentPane().add(tabla);
		
		txtId = new JTextField();
		txtId.setBounds(107, 27, 146, 26);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(107, 69, 146, 26);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtFiltro = new JTextField();
		txtFiltro.setBounds(107, 111, 146, 26);
		getContentPane().add(txtFiltro);
		txtFiltro.setColumns(10);
		
		JLabel lblId = new JLabel("id:");
		lblId.setBounds(23, 30, 69, 20);
		getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(23, 72, 69, 20);
		getContentPane().add(lblNombre);
		
		JLabel lblFiltro = new JLabel("Filtro");
		lblFiltro.setBounds(23, 109, 69, 20);
		getContentPane().add(lblFiltro);

		cargarDatos();
	}
}
