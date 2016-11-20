package grupouno.vista.internalframe.pacientes;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class AdministrarPacientes extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrarPacientes frame = new AdministrarPacientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdministrarPacientes() {
		setBounds(100, 100, 450, 300);

	}

}
