package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

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
		setTitle("Clinica Cruz Roja");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 525);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPersonas = new JMenu("Personas");
		menuBar.add(mnPersonas);
		
		JMenuItem mntmRegistrarPersonas = new JMenuItem("Registrar");
		mnPersonas.add(mntmRegistrarPersonas);
		
		JMenuItem mntmListarPacientes = new JMenuItem("Listado Pacientes");
		mnPersonas.add(mntmListarPacientes);
		
		JMenuItem mntmListarDoctores = new JMenuItem("Listado Doctores");
		mnPersonas.add(mntmListarDoctores);
		
		JMenu mnVivienda = new JMenu("Vivienda");
		menuBar.add(mnVivienda);
		
		JMenuItem mntmRegistrarVivienda = new JMenuItem("Registrar");
		mnVivienda.add(mntmRegistrarVivienda);
		
		JMenuItem mntmListadoViviendas = new JMenuItem("Listado Viviendas");
		mnVivienda.add(mntmListadoViviendas);
		
		JMenu mnCitas = new JMenu("Citas");
		menuBar.add(mnCitas);
		
		JMenuItem mntmRegistrarCitas = new JMenuItem("Registrar Cita");
		mnCitas.add(mntmRegistrarCitas);
		
		JMenuItem mntmListadoCitas = new JMenuItem("Listado Citas");
		mnCitas.add(mntmListadoCitas);
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		JMenuItem mntmRealizarConsulta = new JMenuItem("Realizar Consulta");
		mnConsulta.add(mntmRealizarConsulta);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Listado Consultas");
		mnConsulta.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
