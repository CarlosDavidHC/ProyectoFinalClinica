package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Cita;
import Logico.Clinica;
import Logico.Consulta;
import Logico.Doctor;
import Logico.Enfermedad;
import Logico.HistorialClinico;
import Logico.Paciente;
import Logico.Persona;
import Logico.Vacuna;
import Logico.Viviendas;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class RegConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPaciente;
	private JTextField txtDoctor;
	private JTextField txtFecha;
	private JComboBox cmbCitas;
	private JComboBox cmbEnfermedad;
	private DefaultListModel<String> listEnfermedadModel;
	private JList listEnfermedad;
	private JComboBox cmbVacuna;
	private DefaultListModel<String> listVacunaModel;
	private JList listVacuna;
	private JRadioButton rdbtnObservacin;
	private JRadioButton rdbtnCurado;
	private JList listHistorial;

	public static void main(String[] args) {
		try {
			RegConsulta dialog = new RegConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void actualizarTodo() {
		loadEnfermedades();
		loadVacuna();
		loadCitas();
		cmbCitas.updateUI();
	}

	public RegConsulta() {
		setTitle("Consulta");
		setBounds(100, 100, 524, 653);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setBounds(12, 74, 64, 14);
		contentPanel.add(lblPaciente);

		JLabel lblDoctor = new JLabel("Doctor:");
		lblDoctor.setBounds(12, 128, 46, 14);
		contentPanel.add(lblDoctor);

		JLabel lblEnfermedad = new JLabel("Enfermedad:");
		lblEnfermedad.setBounds(12, 170, 76, 14);
		contentPanel.add(lblEnfermedad);

		txtPaciente = new JTextField();
		txtPaciente.setEditable(false);
		txtPaciente.setBounds(123, 74, 346, 20);
		contentPanel.add(txtPaciente);
		txtPaciente.setColumns(10);

		txtDoctor = new JTextField();
		txtDoctor.setEditable(false);
		txtDoctor.setBounds(123, 125, 346, 20);
		contentPanel.add(txtDoctor);
		txtDoctor.setColumns(10);

		cmbEnfermedad = new JComboBox();
		cmbEnfermedad.setBounds(123, 170, 110, 20);
		contentPanel.add(cmbEnfermedad);

		JLabel lblVacuna = new JLabel("Vacuna:");
		lblVacuna.setBounds(287, 173, 64, 14);
		contentPanel.add(lblVacuna);

		cmbVacuna = new JComboBox();
		cmbVacuna.setBounds(363, 170, 106, 20);
		contentPanel.add(cmbVacuna);

		JLabel lblNewLabel_5 = new JLabel("Historial cl\u00EDnico:");
		lblNewLabel_5.setBounds(12, 381, 100, 14);
		contentPanel.add(lblNewLabel_5);

		JLabel lblCita = new JLabel("Cita:");
		lblCita.setBounds(12, 27, 46, 14);
		contentPanel.add(lblCita);

		cmbCitas = new JComboBox();
		cmbCitas.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>" }));
		cmbCitas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarCamposCitaSeleccionada(); 
			}
		});
		cmbCitas.setBounds(123, 27, 110, 20);
		contentPanel.add(cmbCitas);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(287, 27, 64, 14);
		contentPanel.add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(363, 24, 106, 20);
		contentPanel.add(txtFecha);

		JLabel lblAtendido = new JLabel("Diagnostico:");
		lblAtendido.setBounds(220, 532, 76, 19);
		contentPanel.add(lblAtendido);

		rdbtnCurado = new JRadioButton("Curado");
		rdbtnCurado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnObservacin.setSelected(false);
			}
		});
		rdbtnCurado.setBounds(305, 530, 76, 23);
		contentPanel.add(rdbtnCurado);

		rdbtnObservacin = new JRadioButton("Observaci\u00F3n");
		rdbtnObservacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCurado.setSelected(false);
			}
		});
		rdbtnObservacin.setBounds(385, 530, 109, 23);
		contentPanel.add(rdbtnObservacin);

		JButton btnEnfermedad = new JButton("Agregar");
		btnEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarEnfermedadALista();
			}
		});
		btnEnfermedad.setBounds(136, 203, 97, 25);
		contentPanel.add(btnEnfermedad);

		JLabel lblLista = new JLabel("Lista:");
		lblLista.setBounds(12, 208, 76, 14);
		contentPanel.add(lblLista);

		JLabel lblLista2 = new JLabel("Lista:");
		lblLista2.setBounds(287, 208, 76, 14);
		contentPanel.add(lblLista2);

		JButton btnVacuna = new JButton("Agregar");
		btnVacuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarVacunaALista();
			}
		});
		btnVacuna.setBounds(373, 203, 97, 25);
		contentPanel.add(btnVacuna);

		actualizarTodo();

		JPanel panel = new JPanel();
		panel.setBounds(12, 241, 221, 117);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		listEnfermedadModel = new DefaultListModel<>();

		listEnfermedad = new JList();
		scrollPane.setViewportView(listEnfermedad);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(287, 241, 207, 117);
		contentPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);

		listVacunaModel = new DefaultListModel<>();

		listVacuna = new JList();
		scrollPane_1.setViewportView(listVacuna);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(123, 381, 279, 140);
		contentPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2, BorderLayout.CENTER);

		listHistorial = new JList();
		scrollPane_2.setViewportView(listHistorial);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						registrarConsulta();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clean();
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void loadCitas() {
		cmbCitas.removeAllItems();
		cmbCitas.addItem("<Seleccione>");

		for (Cita cita : Clinica.getInstance().getMisCitas()) {
			if (cita.estaPendiente()) {
				String codigo = cita.getCodigoCita();
				cmbCitas.addItem(codigo);
			}
		}
	}

	private void loadEnfermedades() {
		cmbEnfermedad.removeAllItems();
		cmbEnfermedad.addItem("<Seleccione>");

		for (Enfermedad enfermedad : Clinica.getInstance().getMisEnfermedades()) {
			cmbEnfermedad.addItem(enfermedad.getNombre());
		}
	}

	private void actualizarCamposCitaSeleccionada() {
		String selectedCodigo = (String) cmbCitas.getSelectedItem();

		if ("<Seleccione>".equals(selectedCodigo)) {
			txtFecha.setText("");
			txtPaciente.setText("");
			txtDoctor.setText("");
		} else {
			Cita selectedCita = null;
			for (Cita cita : Clinica.getInstance().getMisCitas()) {
				if (cita.getCodigoCita().equals(selectedCodigo)) {
					selectedCita = cita;
					break;
				}
			}

			if (selectedCita != null) {
				String fechaCitaStr = selectedCita.getFechaCita().toString();

				txtFecha.setText(fechaCitaStr);
				txtPaciente.setText(selectedCita.getPersona().getNombre());
				txtDoctor.setText(selectedCita.getDoctor().getNombre());
			}
		}
	}

	private void agregarEnfermedadALista() {
		String selectedEnfermedad = (String) cmbEnfermedad.getSelectedItem();

		if (!"<Seleccione>".equals(selectedEnfermedad)) {
			if (!listEnfermedadModel.contains(selectedEnfermedad)) {
				listEnfermedadModel.addElement(selectedEnfermedad);
				listEnfermedad.setModel(listEnfermedadModel);
			} else {
				JOptionPane.showMessageDialog(null, "La enfermedad ya ha sido añadida", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void loadVacuna() {
		cmbVacuna.removeAllItems();
		cmbVacuna.addItem("<Seleccione>");

		for (Vacuna vacuna : Clinica.getInstance().getMisVacunas()) {
			cmbVacuna.addItem(vacuna.getNombre());
		}
	}

	private void agregarVacunaALista() {
		String selectedVacuna = (String) cmbVacuna.getSelectedItem();

		if (!"<Seleccione>".equals(selectedVacuna)) {
			if (!listVacunaModel.contains(selectedVacuna)) {
				listVacunaModel.addElement(selectedVacuna);
				listVacuna.setModel(listVacunaModel);
			} else {
				JOptionPane.showMessageDialog(null, "La vacuna ya ha sido añadida", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void registrarConsulta() {
		String selectedCodigo = (String) cmbCitas.getSelectedItem();

		if ("<Seleccione>".equals(selectedCodigo)) {
			JOptionPane.showMessageDialog(null, "Seleccione una cita", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (!rdbtnObservacin.isSelected() && !rdbtnCurado.isSelected()) {
			JOptionPane.showMessageDialog(null, "Seleccione un diagnóstico (Observación o Curado)", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		Cita selectedCita = null;
		for (Cita cita : Clinica.getInstance().getMisCitas()) {
			if (cita.getCodigoCita().equals(selectedCodigo)) {
				selectedCita = cita;
				break;
			}
		}

		if (selectedCita != null) {
			Paciente paciente = (Paciente) selectedCita.getPersona();
			Doctor doctor = selectedCita.getDoctor();
			char atendido = rdbtnCurado.isSelected() ? 'c' : 'o'; // 'c' si está curado, 'o' si es observación
			ArrayList<Enfermedad> enfermedades = obtenerEnfermedadesDeLista();
			ArrayList<Vacuna> vacunas = obtenerVacunasDeLista();
			HistorialClinico historialClinico = paciente.getHistorial();
			Date fecha = new Date();
			selectedCita.setEstado('a');
			Clinica.getInstance().actualizarEstadoCita(selectedCita.getCodigoCita(), 'a');

			Consulta nuevaConsulta = new Consulta(paciente, "C-" + Clinica.GeneradorCodeConsulta, doctor, atendido,
					enfermedades, vacunas, historialClinico, fecha);

			historialClinico.insertarConsulta(nuevaConsulta);
			Clinica.getInstance().insertarConsulta(nuevaConsulta);

			historialClinico.getMisEnfermedades().addAll(enfermedades);
			historialClinico.getMisVacunas().addAll(vacunas);

			actualizarHistorial(paciente);

			clean();
			actualizarTodo();
			cmbCitas.setSelectedIndex(0);

			JOptionPane.showMessageDialog(null, "Consulta registrada correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private ArrayList<Enfermedad> obtenerEnfermedadesDeLista() {
		ArrayList<Enfermedad> enfermedades = new ArrayList<>();
		for (int i = 0; i < listEnfermedadModel.getSize(); i++) {
			String enfermedadNombre = listEnfermedadModel.getElementAt(i);
			Enfermedad enfermedad = buscarEnfermedadPorNombre(enfermedadNombre);
			if (enfermedad != null) {
				enfermedades.add(enfermedad);
			}
		}
		return enfermedades;
	}

	private ArrayList<Vacuna> obtenerVacunasDeLista() {
		ArrayList<Vacuna> vacunas = new ArrayList<>();
		for (int i = 0; i < listVacunaModel.getSize(); i++) {
			String vacunaNombre = listVacunaModel.getElementAt(i);
			Vacuna vacuna = buscarVacunaPorNombre(vacunaNombre);
			if (vacuna != null) {
				vacunas.add(vacuna);
			}
		}
		return vacunas;
	}

	private Enfermedad buscarEnfermedadPorNombre(String nombre) {
		for (Enfermedad enfermedad : Clinica.getInstance().getMisEnfermedades()) {
			if (enfermedad.getNombre().equals(nombre)) {
				return enfermedad;
			}
		}
		return null;
	}

	private Vacuna buscarVacunaPorNombre(String nombre) {
		for (Vacuna vacuna : Clinica.getInstance().getMisVacunas()) {
			if (vacuna.getNombre().equals(nombre)) {
				return vacuna;
			}
		}
		return null;
	}

	private void actualizarHistorial(Paciente paciente) {
		DefaultListModel<String> historialModel = new DefaultListModel<>();

		for (Enfermedad enfermedad : paciente.getHistorial().getMisEnfermedades()) {
			historialModel.addElement("Enfermedad: " + enfermedad.getNombre());
		}

		for (Vacuna vacuna : paciente.getHistorial().getMisVacunas()) {
			historialModel.addElement("Vacuna: " + vacuna.getNombre());
		}

		listHistorial.setModel(historialModel);
	}

	private void clean() {
		txtPaciente.setText("");
		txtDoctor.setText("");
		txtFecha.setText("");

		listEnfermedadModel.clear();
		listEnfermedad.setModel(listEnfermedadModel);

		listVacunaModel.clear();
		listVacuna.setModel(listVacunaModel);

		DefaultListModel<String> historialModel = new DefaultListModel<>();
		listHistorial.setModel(historialModel);

		rdbtnObservacin.setSelected(false);
		rdbtnCurado.setSelected(false);

		cmbCitas.setSelectedIndex(0);
		cmbEnfermedad.setSelectedIndex(0);
		cmbVacuna.setSelectedIndex(0);
	}

}
