package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Cita;
import Logico.Clinica;
import Logico.Enfermedad;
import Logico.Vacuna;
import Logico.Viviendas;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

	/**
	 * Launch the application.
	 */
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
				// Call a method to update the fields based on the selected Cita
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

		JRadioButton rdbtnCurado = new JRadioButton("Curado");
		rdbtnCurado.setBounds(305, 530, 76, 23);
		contentPanel.add(rdbtnCurado);

		JRadioButton rdbtnObservacin = new JRadioButton("Observaci\u00F3n");
		rdbtnObservacin.setBounds(385, 530, 109, 23);
		contentPanel.add(rdbtnObservacin);

		JButton btnEnfermedad = new JButton("Agregar");
		btnEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Call a method to handle the addition of diseases to the list
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

		JList listHistorial = new JList();
		scrollPane_2.setViewportView(listHistorial);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
			String codigo = cita.getCodigoCita();
			cmbCitas.addItem(codigo);
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

		// Verificar si la opción seleccionada es "<Seleccione>"
		if ("<Seleccione>".equals(selectedCodigo)) {
			// Restablecer los campos a valores predeterminados o realizar cualquier acción
			// necesaria
			txtFecha.setText("");
			txtPaciente.setText("");
			txtDoctor.setText("");
		} else {
			// Buscar la cita correspondiente al código en la lista de citas
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
			// Add the selected disease to the DefaultListModel
			listEnfermedadModel.addElement(selectedEnfermedad);

			// Set the DefaultListModel to the JList
			listEnfermedad.setModel(listEnfermedadModel);
		}
	}
	
	private void loadVacuna() {
		cmbVacuna.removeAllItems();
		cmbVacuna.addItem("<Seleccione>");

		for (Vacuna vacuna: Clinica.getInstance().getMisVacunas()) {
			cmbVacuna.addItem(vacuna.getNombre());
		}
	}
	
    private void agregarVacunaALista() {
        String selectedVacuna = (String) cmbVacuna.getSelectedItem();

        if (!"<Seleccione>".equals(selectedVacuna)) {
            // Add the selected vaccine to the DefaultListModel
            listVacunaModel.addElement(selectedVacuna);

            // Set the DefaultListModel to the JList
            listVacuna.setModel(listVacunaModel);
        }
    }

}
