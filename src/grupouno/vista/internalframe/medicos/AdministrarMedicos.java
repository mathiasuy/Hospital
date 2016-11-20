package grupouno.vista.internalframe.medicos;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class AdministrarMedicos extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrarMedicos frame = new AdministrarMedicos();
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
	public AdministrarMedicos() {
		setBounds(100, 100, 450, 300);

	}

}
