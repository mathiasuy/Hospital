package grupouno.vista.ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import grupouno.vista.internalframe.consultas.AdministrarConsultas;
import grupouno.vista.internalframe.especialidades.AdministrarEspecialidades;
import grupouno.vista.internalframe.medicos.AdministrarMedicos;
import grupouno.vista.internalframe.mutualistas.AdministrarMutualistas;
import grupouno.vista.internalframe.pacientes.AdministrarPacientes;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {
	JDesktopPane fondo = new JDesktopPane();
	private AdministrarConsultas consultas;
	private AdministrarEspecialidades especialidades;
	private AdministrarMedicos medicos;
	private AdministrarMutualistas mutualistas;
	private AdministrarPacientes pacientes;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 533);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMutualistas = new JMenu("Mutualistas");
		menuBar.add(mnMutualistas);
		
		JMenuItem mntmAdministrar = new JMenuItem("Administrar");
		mntmAdministrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        try {
		            mutualistas = new AdministrarMutualistas();
		            mutualistas.setTitle("Administrar Mutualistas");
		            fondo.add(mutualistas);
		            Dimension desktopSize = fondo.getSize();
		            Dimension FrameSize = mutualistas.getSize();
		            mutualistas.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);      
		            mutualistas.setVisible(true);
		            mutualistas.setClosable(true);
		            mutualistas.setIconifiable(true);
		        } catch (Exception emu) {
		            JOptionPane.showMessageDialog(fondo, "No se pudo abrir la ventana " + mutualistas.getTitle(),"Problema",JOptionPane.ERROR_MESSAGE);
		        }   					
			}
		});
		mnMutualistas.add(mntmAdministrar);
		
		JMenu mnPacientes = new JMenu("Pacientes");
		menuBar.add(mnPacientes);
		
		JMenuItem mntmAdministrar_1 = new JMenuItem("Administrar");
		mntmAdministrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        try {
		            pacientes = new AdministrarPacientes();
		            pacientes.setTitle("Administrar pacientes");
		            fondo.add(pacientes);
		            Dimension desktopSize = fondo.getSize();
		            Dimension FrameSize = pacientes.getSize();
		            pacientes.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);      
		            pacientes.setVisible(true);
		            pacientes.setClosable(true);
		            pacientes.setIconifiable(true);
		        } catch (Exception ep) {
		            JOptionPane.showMessageDialog(fondo, "No se pudo abrir la ventana " + pacientes.getTitle(),"Problema",JOptionPane.ERROR_MESSAGE);
		        }   					
			}
		});
		mnPacientes.add(mntmAdministrar_1);
		
		JMenu mnEspecialidades = new JMenu("Especialidades");
		menuBar.add(mnEspecialidades);
		
		JMenuItem mntmAdministrar_2 = new JMenuItem("Administrar");
		mntmAdministrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        try {
		            especialidades = new AdministrarEspecialidades();
		            especialidades.setTitle("Administrar especialidades");
		            fondo.add(especialidades);
		            Dimension desktopSize = fondo.getSize();
		            Dimension FrameSize = especialidades.getSize();
		            especialidades.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);      
		            especialidades.setVisible(true);
		            especialidades.setClosable(true);
		            especialidades.setIconifiable(true);
		        } catch (Exception ee) {
		            JOptionPane.showMessageDialog(fondo, "No se pudo abrir la ventana " + especialidades.getTitle(),"Problema",JOptionPane.ERROR_MESSAGE);
		        }  				
			}
		});
		mnEspecialidades.add(mntmAdministrar_2);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmAdministrar_3 = new JMenuItem("Administrar");
		mntmAdministrar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        try {
		            consultas = new AdministrarConsultas();
		            consultas.setTitle("Administrar consultas");
		            fondo.add(consultas);
		            Dimension desktopSize = fondo.getSize();
		            Dimension FrameSize = consultas.getSize();
		            consultas.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);      
		            consultas.setVisible(true);
		            consultas.setClosable(true);
		            consultas.setIconifiable(true);
		        } catch (Exception ec) {
		            JOptionPane.showMessageDialog(fondo, "No se pudo abrir la ventana " + consultas.getTitle(),"Problema",JOptionPane.ERROR_MESSAGE);
		        }   				
			}
		});
		mnConsultas.add(mntmAdministrar_3);
		
		JMenu mnMedicos = new JMenu("Medicos");
		menuBar.add(mnMedicos);
		
		JMenuItem mntmAdministrar_4 = new JMenuItem("Administrar");
		mntmAdministrar_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        try {
		            medicos = new AdministrarMedicos();
		            medicos.setTitle("Administrar medicos");
		            fondo.add(medicos);
		            Dimension desktopSize = fondo.getSize();
		            Dimension FrameSize = medicos.getSize();
		            medicos.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);      
		            medicos.setVisible(true);
		            medicos.setClosable(true);
		            medicos.setIconifiable(true);
		        } catch (Exception em) {
		            JOptionPane.showMessageDialog(fondo, "No se pudo abrir la ventana " + medicos.getTitle(),"Problema",JOptionPane.ERROR_MESSAGE);
		        }				
			}
		});
		mnMedicos.add(mntmAdministrar_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		contentPane.add(fondo, BorderLayout.CENTER);
	}
}
