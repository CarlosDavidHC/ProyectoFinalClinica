package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Logico.Persona;
import Logico.Viviendas;
import Logico.Cita;
import Logico.Clinica;
import Logico.Doctor;
import Logico.HistorialClinico;
import Logico.Paciente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class RegCita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JFormattedTextField txtFecha;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnNuevaDireccion;
	private JRadioButton rdbtnDireccionExistente;
	private JComboBox<Viviendas> cmbDirecciones;
	private JButton btnBuscar;
	private Persona auxPaciente;
	private JButton cancelButton;
	private JButton okButton;
	private Viviendas viviendaSeleccionada;
	private JComboBox cobxEspecialidad;
	private JComboBox cobxDoctorEspecialidad;

	public static void main(String[] args) {
		try {
			RegCita dialog = new RegCita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void actualizarDirecciones() {
		loadDirecciones();
		cmbDirecciones.updateUI();
	}

	public RegCita() {
		setTitle("Registrar Cita");
		setBounds(100, 100, 587, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblEspecialidades = new JLabel("Especialidades:");
		lblEspecialidades.setBounds(23, 230, 98, 16);
		contentPanel.add(lblEspecialidades);

		JLabel lblDoctor = new JLabel("Doctor:");
		lblDoctor.setBounds(343, 230, 78, 16);
		contentPanel.add(lblDoctor);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 544, 184);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);

		txtCedula = new JFormattedTextField(createCedulaFormatter());
		txtCedula.setBounds(88, 11, 187, 20);
		panel_2.add(txtCedula);
		txtCedula.setColumns(10);

		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setBounds(10, 11, 56, 20);
		panel_2.add(lblCedula);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedulaInput = txtCedula.getText().replaceAll("_", "");

				if (cedulaInput.length() != 13) {
					JOptionPane.showMessageDialog(null, "Por favor, complete la cédula antes de buscar", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				auxPaciente = Clinica.getInstance().buscarPacienteByCedula(cedulaInput);
				if (auxPaciente != null) {
					loadDatospaciente(auxPaciente);
					txtFecha.setEnabled(true);
					String especialidad = (String) cobxEspecialidad.getSelectedItem();
					loadDoctoresPorEspecialidad(especialidad);
					if (auxPaciente.getSexo() == 'M') {
						rdbtnMujer.setSelected(true);
					} else {
						rdbtnHombre.setSelected(true);
					}
					cobxEspecialidad.setEnabled(true);
					cobxDoctorEspecialidad.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "¡Bienvenido! Tienes que completar tus datos", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
					txtNombre.setEnabled(true);
					txtDireccion.setEnabled(true);
					txtTelefono.setEnabled(true);
					rdbtnDireccionExistente.setEnabled(true);
					rdbtnNuevaDireccion.setEnabled(true);
					rdbtnMujer.setEnabled(true);
					rdbtnHombre.setEnabled(true);
					rdbtnNuevaDireccion.setSelected(true);
					btnBuscar.setVisible(false);
					txtFecha.setEnabled(true);
					txtCedula.setEnabled(false);
					cobxEspecialidad.setEnabled(true);
					cobxDoctorEspecialidad.setEnabled(true);

					actualizarDirecciones();
				}
			}
		});
		btnBuscar.setBounds(287, 11, 89, 23);
		panel_2.add(btnBuscar);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(388, 15, 46, 14);
		panel_2.add(lblFecha);

		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			mask.setPlaceholderCharacter('_');
			txtFecha = new JFormattedTextField(mask);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
			txtFecha = new JFormattedTextField();
		}
		txtFecha.setEnabled(false);
		txtFecha.setBounds(446, 12, 86, 20);
		panel_2.add(txtFecha);

		txtFecha.setEnabled(false);
		txtFecha.setBounds(446, 12, 86, 20);
		panel_2.add(txtFecha);
		txtFecha.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 59, 56, 14);
		panel_2.add(lblNombre);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(10, 143, 33, 14);
		panel_2.add(lblSexo);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(10, 98, 66, 14);
		panel_2.add(lblTelefono);

		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setBounds(88, 56, 418, 20);
		panel_2.add(txtNombre);
		txtNombre.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setBounds(88, 95, 164, 20);
		panel_2.add(txtTelefono);
		txtTelefono.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setBounds(264, 130, 242, 40);
		panel_2.add(txtDireccion);
		txtDireccion.setColumns(10);

		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMujer.isSelected()) {
					rdbtnHombre.setSelected(false);
				}
			}
		});
		rdbtnMujer.setEnabled(false);
		rdbtnMujer.setBounds(47, 139, 66, 23);
		panel_2.add(rdbtnMujer);

		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnHombre.isSelected()) {
					rdbtnMujer.setSelected(false);
				}
			}
		});
		rdbtnHombre.setEnabled(false);
		rdbtnHombre.setBounds(117, 139, 109, 23);
		panel_2.add(rdbtnHombre);

		rdbtnNuevaDireccion = new JRadioButton("Nueva direcci\u00F3n");
		rdbtnNuevaDireccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNuevaDireccion.isSelected()) {
					rdbtnDireccionExistente.setSelected(false);
					txtDireccion.setVisible(true);
					txtDireccion.setEnabled(true);
					cmbDirecciones.setEnabled(false);
					cmbDirecciones.setVisible(false);
				}
			}
		});
		rdbtnNuevaDireccion.setEnabled(false);
		rdbtnNuevaDireccion.setBounds(264, 98, 119, 23);
		panel_2.add(rdbtnNuevaDireccion);

		rdbtnDireccionExistente = new JRadioButton("Direcci\u00F3n existente");
		rdbtnDireccionExistente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnDireccionExistente.isSelected()) {
					rdbtnNuevaDireccion.setSelected(false);
					cmbDirecciones.setVisible(true);
					cmbDirecciones.setEnabled(true);
					txtDireccion.setEnabled(false);
					txtDireccion.setVisible(false);
				}
			}
		});
		rdbtnDireccionExistente.setEnabled(false);
		rdbtnDireccionExistente.setBounds(387, 98, 145, 23);
		panel_2.add(rdbtnDireccionExistente);

		cmbDirecciones = new JComboBox<Viviendas>();
		cmbDirecciones.setBounds(264, 130, 242, 40);
		panel_2.add(cmbDirecciones);
		cmbDirecciones.setEnabled(false);

		cobxEspecialidad = new JComboBox();
		cobxEspecialidad.setEnabled(false);
		cobxEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String especialidadSeleccionada = cobxEspecialidad.getSelectedItem().toString();
				if (!especialidadSeleccionada.equals("<Seleccione>")) {
					cobxDoctorEspecialidad.setEnabled(true);
					loadDoctoresPorEspecialidad(especialidadSeleccionada);
				} else {
					cobxDoctorEspecialidad.setEnabled(false);
				}
			}
		});
		cobxEspecialidad.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>", "Cardiolog\u00EDa",
				"Dermatolog\u00EDa", "Endoscopia ", "Gastroenterolog\u00EDa", "Ginegolog\u00EDa", "Hematolog\u00EDa",
				"Neumolog\u00EDa", "Ortopedia", "Oftalmolog\u00EDa", "Pediatr\u00EDa", "Psiquiatr\u00EDa General",
				"Radiolog\u00EDa", "Cardiolog\u00EDa", "Hematolog\u00EDa" }));
		cobxEspecialidad.setBounds(117, 228, 153, 20);
		contentPanel.add(cobxEspecialidad);

		cobxDoctorEspecialidad = new JComboBox<Persona>();
		cobxDoctorEspecialidad.setEnabled(false);
		cobxDoctorEspecialidad.setBounds(401, 228, 153, 20);

		contentPanel.add(cobxDoctorEspecialidad);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtCedula.getText().equalsIgnoreCase("_-__-") || txtFecha.getText().isEmpty()
								|| txtNombre.getText().isEmpty() || txtTelefono.getText().isEmpty()
								|| cobxEspecialidad.getSelectedItem().toString().equals("<Seleccione>")
								|| cobxDoctorEspecialidad.getSelectedItem() == null
								|| (!rdbtnNuevaDireccion.isSelected() && !rdbtnDireccionExistente.isSelected())) {
							JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos necesarios",
									"Advertencia", JOptionPane.WARNING_MESSAGE);
							return;
						}

						if (rdbtnNuevaDireccion.isSelected() && txtDireccion.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Por favor, ingrese la nueva dirección", "Advertencia",
									JOptionPane.WARNING_MESSAGE);
							return;
						}

						if (rdbtnNuevaDireccion.isSelected()) {
							String nuevaDireccion = txtDireccion.getText();
							viviendaSeleccionada = new Viviendas("V-" + Clinica.GeneradorCodeVivienda, nuevaDireccion,
									new ArrayList<>());
							Clinica.getInstance().insertarVivienda(viviendaSeleccionada);
						} else if (rdbtnDireccionExistente.isSelected() && cmbDirecciones.getSelectedItem() != null) {
							viviendaSeleccionada = (Viviendas) cmbDirecciones.getSelectedItem();
						}

						if (viviendaSeleccionada != null) {
							Paciente pacienteExistente = null;
							for (Persona persona : viviendaSeleccionada.getPersonaHospedada()) {
								if (persona instanceof Paciente) {
									Paciente paciente = (Paciente) persona;
									if (paciente.getDireccion().equalsIgnoreCase(txtDireccion.getText())) {
										pacienteExistente = paciente;
										break;
									}
								}
							}

							if (pacienteExistente != null) {
								viviendaSeleccionada.getPersonaHospedada().add(pacienteExistente);
							} else {
								// Si no existe, crea un nuevo paciente y agrégalo a la vivienda
								Paciente nuevoPaciente = new Paciente("P-" + Clinica.GeneradorCodePaciente,
										txtCedula.getText(), txtNombre.getText(), txtTelefono.getText(),
										txtDireccion.getText(), 'p', rdbtnMujer.isSelected() ? 'M' : 'H', null);

								HistorialClinico historial = new HistorialClinico("H-" + Clinica.GeneradorCodeHistorial,
										nuevoPaciente, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
										new ArrayList<>());

								auxPaciente = nuevoPaciente;

								nuevoPaciente.setHistorial(historial);
								Clinica.getInstance().insertarHistorial(historial);
								Clinica.getInstance().insertarPersona(nuevoPaciente);

								// Agregar el nuevo paciente a la vivienda
								viviendaSeleccionada.getPersonaHospedada().add(nuevoPaciente);
							}
						}

						String especialidadSeleccionada = cobxEspecialidad.getSelectedItem().toString();
						Doctor doctorSeleccionado = (Doctor) cobxDoctorEspecialidad.getSelectedItem();

						Cita nuevaCita = new Cita("C-" + Clinica.GeneradorCodeCita, LocalDate.now(), auxPaciente, doctorSeleccionado, 'P');
						nuevaCita.setNombreDoctor(doctorSeleccionado.getNombre());

						if (auxPaciente != null) {
						    // Obtener o crear el HistorialClinico del paciente
						    HistorialClinico historial = ((Paciente) auxPaciente).getHistorial();
						    if (historial == null) {
						        historial = new HistorialClinico("H-" + Clinica.GeneradorCodeHistorial, (Paciente) auxPaciente,
						                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
						        ((Paciente) auxPaciente).setHistorial(historial);
						        Clinica.getInstance().insertarHistorial(historial);
						    }
							// Obtener la vivienda seleccionada
							Viviendas viviendaSeleccionada = obtenerViviendaSeleccionada();

							// Verificar si el paciente ya está hospedado en la vivienda
							boolean pacienteYaHospedado = false;
							for (Persona persona : viviendaSeleccionada.getPersonaHospedada()) {
								if (persona instanceof Paciente
										&& ((Paciente) persona).getCedula().equals(auxPaciente.getCedula())) {
									pacienteYaHospedado = true;
									break;
								}
							}

							// Si el paciente no está hospedado, agregarlo a la vivienda
							if (!pacienteYaHospedado) {
								viviendaSeleccionada.getPersonaHospedada().add(auxPaciente);
							}

							// Resto de tu lógica para registrar la cita
							((Paciente) auxPaciente).getHistorial().getMisCitas().add(nuevaCita);
							Clinica.getInstance().insertarCita(nuevaCita);

							// Otros pasos necesarios

							JOptionPane.showMessageDialog(null, "Cita registrada con éxito", "Información",
									JOptionPane.INFORMATION_MESSAGE);
							Clinica.getInstance().guardarViviendas();
							Clinica.getInstance().guardarHistoriales();
							Clean();
						} else {
							JOptionPane.showMessageDialog(null, "No se encontró al paciente", "Advertencia",
									JOptionPane.WARNING_MESSAGE);
						}

					}
				});

				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
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

	private void loadDirecciones() {
		cmbDirecciones.removeAllItems();
		for (Viviendas vivienda : Clinica.getInstance().getMisViviendas()) {
			cmbDirecciones.addItem(vivienda);
		}
	}

	public void loadDatospaciente(Persona c1) {
		txtNombre.setText(c1.getNombre());
		txtDireccion.setText(c1.getDireccion());
		txtTelefono.setText(c1.getTelefono());
		txtCedula.setText(c1.getCedula());
	}

	private void Clean() {
		txtCedula.setEnabled(true);
		txtCedula.setText("");
		txtNombre.setEnabled(false);
		txtNombre.setText("");
		txtDireccion.setEnabled(false);
		txtDireccion.setText("");
		txtTelefono.setEnabled(false);
		txtTelefono.setText("");
		rdbtnDireccionExistente.setEnabled(false);
		rdbtnDireccionExistente.setSelected(false);
		rdbtnNuevaDireccion.setEnabled(false);
		rdbtnNuevaDireccion.setSelected(true);
		rdbtnMujer.setEnabled(false);
		rdbtnMujer.setSelected(false);
		rdbtnHombre.setEnabled(false);
		rdbtnHombre.setSelected(false);
		btnBuscar.setVisible(true);
		txtFecha.setEnabled(false);
		txtFecha.setText("");
		viviendaSeleccionada = null;
		cobxEspecialidad.setEnabled(false);
		cobxEspecialidad.setSelectedItem("<Seleccione>");
		cobxDoctorEspecialidad.setEnabled(false);
		cmbDirecciones.setEnabled(false);
		
	}

	private void loadDoctoresPorEspecialidad(String especialidad) {
		cobxDoctorEspecialidad.removeAllItems();

		for (Persona persona : Clinica.getInstance().getmisPersonas()) {
			if (persona instanceof Doctor) {
				Doctor doctor = (Doctor) persona;
				if (doctor.getEspecialidad().equalsIgnoreCase(especialidad)) {
					cobxDoctorEspecialidad.addItem(doctor);
				}
			}
		}
	}

	private MaskFormatter createCedulaFormatter() {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("###-#######-#");
			formatter.setPlaceholderCharacter('_');
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return formatter;
	}

	private Viviendas obtenerViviendaSeleccionada() {
		if (rdbtnNuevaDireccion.isSelected()) {
			// Si se selecciona nueva dirección, devuelve la vivienda creada
			return viviendaSeleccionada;
		} else if (rdbtnDireccionExistente.isSelected() && cmbDirecciones.getSelectedItem() != null) {
			// Si se selecciona dirección existente, devuelve la vivienda seleccionada en el
			// combo
			return (Viviendas) cmbDirecciones.getSelectedItem();
		} else {
			// En caso contrario, devuelve null
			return null;
		}
	}
}