package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Persona;
import Logico.Viviendas;
import Logico.Cita;
import Logico.Clinica;
import Logico.HistorialClinico;
import Logico.Paciente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RegCita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtFecha;
	private JTextField nombre2;
	private JTextField telefono2;
	private JTextField direccion2;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnNuevaDireccion;
	private JRadioButton rdbtnDireccionExistente;
	private JComboBox<Viviendas> direcciones;
	private JButton btnBuscar;
	private Persona auxPaciente;
	private JButton cancelButton;
	private JButton okButton;
	private Viviendas viviendaSeleccionada;

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
		direcciones.updateUI(); // Actualiza la interfaz del JComboBox
	}

	public RegCita() {
		setTitle("Registrar Cita");
		setBounds(100, 100, 640, 524);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Doctor");
		lblNewLabel.setBounds(12, 208, 56, 16);
		contentPanel.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(12, 237, 236, 171);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		JList list = new JList();
		scrollPane.setViewportView(list);

		JLabel lblNewLabel_1 = new JLabel("Seleccionado");
		lblNewLabel_1.setBounds(374, 208, 89, 16);
		contentPanel.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton(">>");
		btnNewButton_1.setBounds(277, 281, 70, 23);
		contentPanel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("<<");
		btnNewButton_2.setBounds(277, 317, 70, 23);
		contentPanel.add(btnNewButton_2);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 600, 184);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);

		txtCedula = new JTextField();
		txtCedula.setBounds(88, 11, 187, 20);
		panel_2.add(txtCedula);
		txtCedula.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("C\u00E9dula:");
		lblNewLabel_2.setBounds(10, 11, 56, 20);
		panel_2.add(lblNewLabel_2);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCedula.getText().equalsIgnoreCase("___-_______-_")) {
					JOptionPane.showMessageDialog(null, "Por favor, tiene que completar su cédula", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				} else {
					auxPaciente = Clinica.getInstance().buscarPacienteByCedula(txtCedula.getText());
					if (auxPaciente != null) {
						loadDatospaciente(auxPaciente);
					} else {
						JOptionPane.showMessageDialog(null, "¡Bienvenido! Tienes que completar tus datos",
								"Informacion", JOptionPane.INFORMATION_MESSAGE);
						nombre2.setEnabled(true);
						direccion2.setEnabled(true);
						telefono2.setEnabled(true);
						rdbtnDireccionExistente.setEnabled(true);
						rdbtnNuevaDireccion.setEnabled(true);
						rdbtnMujer.setEnabled(true);
						rdbtnHombre.setEnabled(true);
						rdbtnNuevaDireccion.setSelected(true);
						btnBuscar.setVisible(false);
						txtFecha.setEnabled(true);
						txtCedula.setEnabled(false);

						actualizarDirecciones();
					}
				}
			}
		});
		btnBuscar.setBounds(287, 11, 89, 23);
		panel_2.add(btnBuscar);

		JLabel lblNewLabel_3 = new JLabel("Fecha:");
		lblNewLabel_3.setBounds(388, 15, 46, 14);
		panel_2.add(lblNewLabel_3);

		txtFecha = new JTextField();
		txtFecha.setEnabled(false);
		txtFecha.setBounds(446, 12, 86, 20);
		panel_2.add(txtFecha);
		txtFecha.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Nombre:");
		lblNewLabel_4.setBounds(10, 59, 56, 14);
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Sexo:");
		lblNewLabel_5.setBounds(10, 140, 33, 14);
		panel_2.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Telefono:");
		lblNewLabel_6.setBounds(10, 98, 66, 14);
		panel_2.add(lblNewLabel_6);

		nombre2 = new JTextField();
		nombre2.setEnabled(false);
		nombre2.setBounds(88, 56, 418, 20);
		panel_2.add(nombre2);
		nombre2.setColumns(10);

		telefono2 = new JTextField();
		telefono2.setEnabled(false);
		telefono2.setBounds(88, 95, 164, 20);
		panel_2.add(telefono2);
		telefono2.setColumns(10);

		direccion2 = new JTextField();
		direccion2.setEnabled(false);
		direccion2.setBounds(264, 130, 242, 40);
		panel_2.add(direccion2);
		direccion2.setColumns(10);

		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMujer.isSelected()) {
					rdbtnHombre.setSelected(false);
				}
			}
		});
		rdbtnMujer.setEnabled(false);
		rdbtnMujer.setBounds(45, 136, 66, 23);
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
		rdbtnHombre.setBounds(115, 136, 109, 23);
		panel_2.add(rdbtnHombre);

		rdbtnNuevaDireccion = new JRadioButton("Nueva direcci\u00F3n");
		rdbtnNuevaDireccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNuevaDireccion.isSelected()) {
					rdbtnDireccionExistente.setSelected(false);
					direccion2.setVisible(true);
					direccion2.setEnabled(true);
					direcciones.setEnabled(false);
					direcciones.setVisible(false);
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
					direcciones.setVisible(true);
					direcciones.setEnabled(true);
					direccion2.setEnabled(false);
					direccion2.setVisible(false);
				}
			}
		});
		rdbtnDireccionExistente.setEnabled(false);
		rdbtnDireccionExistente.setBounds(387, 98, 145, 23);
		panel_2.add(rdbtnDireccionExistente);

		direcciones = new JComboBox<Viviendas>();
		direcciones.setBounds(264, 130, 242, 40);
		panel_2.add(direcciones);
		direcciones.setEnabled(false);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(374, 237, 236, 171);
		contentPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);

		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtCedula.getText().equalsIgnoreCase("___-_______-_") || txtFecha.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos necesarios",
									"Advertencia", JOptionPane.WARNING_MESSAGE);
							return;
						}

						if (rdbtnNuevaDireccion.isSelected()) {
							String nuevaDireccion = direccion2.getText();
							viviendaSeleccionada = new Viviendas("V" + Clinica.GeneradorCodeVivienda, nuevaDireccion,
									new ArrayList<>());
							Clinica.getInstance().insertarVivienda(viviendaSeleccionada);
						} else if (rdbtnDireccionExistente.isSelected() && direcciones.getSelectedItem() != null) {
							// Obtener la vivienda seleccionada del JComboBox
							viviendaSeleccionada = (Viviendas) direcciones.getSelectedItem();
						}

						Persona persona = null;
						if (auxPaciente == null) {
							persona = new Paciente("P" + Clinica.GeneradorCodePersona, txtCedula.getText(),
									nombre2.getText(), telefono2.getText(), direccion2.getText(), 'p',
									rdbtnMujer.isSelected() ? 'M' : 'H', null);

							HistorialClinico historial = new HistorialClinico("H" + Clinica.GeneradorCodeHistorial,
									(Paciente) persona, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
									new ArrayList<>());

							((Paciente) persona).setHistorial(historial);
							Clinica.getInstance().insertarHistorial(historial);
							Clinica.getInstance().insertarPersona(persona);
						} else {
							persona = auxPaciente;
						}

						Cita nuevaCita = new Cita("C" + Clinica.GeneradorCodeCita, LocalDate.now(), persona, null, 'P');

						((Paciente) persona).getHistorial().getMisCitas().add(nuevaCita);
						Clinica.getInstance().insertarCita(nuevaCita);
						JOptionPane.showMessageDialog(null, "Cita registrada con éxito", "Información",
								JOptionPane.INFORMATION_MESSAGE);
						if (viviendaSeleccionada != null) {
							viviendaSeleccionada.getPersonaHospedada().add((Paciente) persona);
						}

						Clean();
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
		direcciones.removeAllItems();
		for (Viviendas vivienda : Clinica.getInstance().getMisViviendas()) {
			direcciones.addItem(vivienda);
		}
	}

	public void loadDatospaciente(Persona c1) {
		nombre2.setText(c1.getNombre());
		direccion2.setText(c1.getDireccion());
		telefono2.setText(c1.getTelefono());
		txtCedula.setText(c1.getCedula());
	}

	private void Clean() {
		txtCedula.setEnabled(true);
		nombre2.setText("");
		direccion2.setEnabled(true);
		telefono2.setEnabled(true);
		rdbtnDireccionExistente.setEnabled(true);
		rdbtnNuevaDireccion.setEnabled(true);
		rdbtnMujer.setEnabled(true);
		rdbtnHombre.setEnabled(true);
		rdbtnNuevaDireccion.setSelected(true);
		btnBuscar.setVisible(true);
		txtFecha.setEnabled(true);
		viviendaSeleccionada = null;
	}
}
