package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Control;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream clinica2;
				ObjectOutputStream clinicaWrite;
				try {
					clinica2 = new FileOutputStream("clinica.dat");
					clinicaWrite = new ObjectOutputStream(clinica2);
					clinicaWrite.writeObject(Control.getInstance());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		setTitle("Clinica Cruz Roja");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 525);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cerrar Sesi\u00F3n");
		mnUsuario.add(mntmNewMenuItem_2);

		JMenu mnCitas = new JMenu("Citas");
		mnCitas.setEnabled(false);
		menuBar.add(mnCitas);

		JMenuItem mntmRegistrarCitas = new JMenuItem("Registrar Cita");
		mntmRegistrarCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegCita registroCita = new RegCita();
				registroCita.setModal(true);
				registroCita.setVisible(true);
			}
		});
		mnCitas.add(mntmRegistrarCitas);

		JMenuItem mntmListadoCitas = new JMenuItem("Listado Citas");
		mnCitas.add(mntmListadoCitas);

		JMenu mnPersonal = new JMenu("Pacientes");
		mnPersonal.setEnabled(false);
		menuBar.add(mnPersonal);

		JMenuItem mntmListarPacientes = new JMenuItem("Listado Pacientes");
		mntmListarPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoPaciente ListarPaciente = new ListadoPaciente();
				ListarPaciente.setModal(true);
				ListarPaciente.setVisible(true);
			}
		});
		mnPersonal.add(mntmListarPacientes);

		JMenuItem mntmListarViviendas = new JMenuItem("Listado Viviendas");
		mntmListarViviendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarViviendas ListaViviendas = new ListarViviendas();
				ListaViviendas.setModal(true);
				ListaViviendas.setVisible(true);
			}
		});
		mnPersonal.add(mntmListarViviendas);

		JMenuItem mntmHistoriales = new JMenuItem("Listado Historiales");
		mntmHistoriales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarHistorial ListarHistorial = new ListarHistorial();
				ListarHistorial.setModal(true);
				ListarHistorial.setVisible(true);
			}
		});
		mnPersonal.add(mntmHistoriales);

		JMenu mnConsulta = new JMenu("Consulta");
		mnConsulta.setEnabled(false);
		menuBar.add(mnConsulta);

		JMenuItem mntmRealizarConsulta = new JMenuItem("Realizar Consulta");
		mntmRealizarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegConsulta registroConsulta = new RegConsulta();
				registroConsulta.setModal(true);
				registroConsulta.setVisible(true);
			}
		});
		mnConsulta.add(mntmRealizarConsulta);

		JMenuItem mntmNewMenuItem = new JMenuItem("Listado Consultas");
		mnConsulta.add(mntmNewMenuItem);

		JMenu mnLaboratorio = new JMenu("Laboratorio");
		mnLaboratorio.setEnabled(false);
		menuBar.add(mnLaboratorio);

		JMenuItem mntmEnfermedades = new JMenuItem("Registrar Enfermedad");
		mntmEnfermedades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEnfermedad registroEnfermedad = new RegEnfermedad();
				registroEnfermedad.setModal(true);
				registroEnfermedad.setVisible(true);
			}
		});
		mnLaboratorio.add(mntmEnfermedades);

		JMenuItem mntmVacunas = new JMenuItem("Registrar Vacuna");
		mntmVacunas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegVacuna registroVacuna = new RegVacuna();
				registroVacuna.setModal(true);
				registroVacuna.setVisible(true);
			}
		});
		mnLaboratorio.add(mntmVacunas);

		JMenuItem mntmListEnfermedades = new JMenuItem("Listado Enfermedades");
		mnLaboratorio.add(mntmListEnfermedades);

		JMenuItem mntmListVacunas = new JMenuItem("Listado Vacunas");
		mnLaboratorio.add(mntmListVacunas);

		JMenu mnMedicos = new JMenu("Administraci\u00F3n");
		mnMedicos.setEnabled(false);
		menuBar.add(mnMedicos);

		JMenuItem mntmRegistrarPersonas = new JMenuItem("Registrar Usuario");
		mntmRegistrarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegUsuario registroUsuario = new RegUsuario();
				registroUsuario.setModal(true);
				registroUsuario.setVisible(true);
			}
		});
		mnMedicos.add(mntmRegistrarPersonas);

		JMenuItem mntmListarDoctores = new JMenuItem("Listado Doctores");
		mnMedicos.add(mntmListarDoctores);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listado Secretarias");
		mnMedicos.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(Principal.class.getResource("/Imagess/cruzDominicana.jpg"));
		lblNewLabel.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(725, 425, Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);

		if (Control.getLoginUser().getTipo().equalsIgnoreCase("Administrador")) {
			mnCitas.setEnabled(true);
			mnConsulta.setEnabled(true);
			mnLaboratorio.setEnabled(true);
			mnPersonal.setEnabled(true);
			mnMedicos.setEnabled(true);
		} else if (Control.getLoginUser().getTipo().equalsIgnoreCase("Secretaria")) {
			mnCitas.setEnabled(true);
			mnConsulta.setEnabled(false);
			mnLaboratorio.setEnabled(false);
			mnPersonal.setEnabled(true);
			mnMedicos.setEnabled(false);
		} else if (Control.getLoginUser().getTipo().equalsIgnoreCase("Doctor")) {
			mnCitas.setEnabled(true);
			mnConsulta.setEnabled(true);
			mnLaboratorio.setEnabled(false);
			mnPersonal.setEnabled(true);
			mnMedicos.setEnabled(false);
		}
	}

}
