package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import Logico.Administrador;
import Logico.Clinica;
import Logico.Doctor;
import Logico.Persona;
import Logico.Secretaria;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class RegUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCedula;
	private JRadioButton rdbMujer;
	private JRadioButton rdbHombre;
	private JRadioButton rdbDoctor;
	private JRadioButton rdbSecretaria;
	private JRadioButton rdbAdministrador;
	private JComboBox cmbEspecialidad;
	private JTextField txtContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegUsuario dialog = new RegUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegUsuario() {
		setTitle("Registrar Usuario");
		setBounds(100, 100, 515, 459);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel pnldoctor = new JPanel();
		pnldoctor.setBounds(10, 307, 475, 55);
		contentPanel.add(pnldoctor);
		pnldoctor.setLayout(null);

		JLabel label = new JLabel("Especialidad:");
		label.setBounds(243, 24, 82, 14);
		pnldoctor.add(label);

		cmbEspecialidad = new JComboBox();
		cmbEspecialidad.setModel(new DefaultComboBoxModel(new String[] { "<Seleccione>", "Cardiolog\u00EDa",
				"Dermatolog\u00EDa", "Endoscopia ", "Gastroenterolog\u00EDa", "Ginegolog\u00EDa", "Hematolog\u00EDa",
				"Neumolog\u00EDa", "Ortopedia", "Oftalmolog\u00EDa", "Pediatr\u00EDa", "Psiquiatr\u00EDa General",
				"Radiolog\u00EDa", "Cardiolog\u00EDa", "Hematolog\u00EDa" }));
		cmbEspecialidad.setEnabled(false);
		cmbEspecialidad.setToolTipText("");
		cmbEspecialidad.setBounds(331, 20, 132, 22);
		pnldoctor.add(cmbEspecialidad);

		JLabel lblContrase = new JLabel("Contrase\u00F1a:");
		lblContrase.setBounds(11, 24, 82, 14);
		pnldoctor.add(lblContrase);

		txtContra = new JTextField();
		txtContra.setEditable(false);
		txtContra.setEnabled(false);
		txtContra.setBounds(99, 20, 132, 22);
		pnldoctor.add(txtContra);
		txtContra.setColumns(10);

		JPanel pnlVacio = new JPanel();
		pnlVacio.setLayout(null);
		pnlVacio.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlVacio.setBounds(10, 307, 475, 57);
		contentPanel.add(pnlVacio);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 475, 202);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(78, 12, 91, 20);
		panel_2.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(10, 13, 56, 18);
		panel_2.add(lblCodigo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 64, 56, 14);
		panel_2.add(lblNombre);

		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(9, 105, 66, 14);
		panel_2.add(lblTelefono);

		txtNombre = new JTextField();
		txtNombre.setBounds(78, 60, 385, 20);
		panel_2.add(txtNombre);
		txtNombre.setColumns(10);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(78, 147, 242, 40);
		panel_2.add(txtDireccion);
		txtDireccion.setColumns(10);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 146, 66, 14);
		panel_2.add(lblDireccin);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(99, 102, 132, 20);
		panel_2.add(txtTelefono);

		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(181, 13, 56, 18);
		panel_2.add(lblCdula);

		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(249, 12, 214, 20);
		panel_2.add(txtCedula);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(249, 103, 33, 14);
		panel_2.add(lblSexo);

		rdbMujer = new JRadioButton("Mujer");
		rdbMujer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbHombre.setSelected(false);
			}
		});
		rdbMujer.setBounds(317, 99, 71, 23);
		panel_2.add(rdbMujer);

		rdbHombre = new JRadioButton("Hombre");
		rdbHombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbMujer.setSelected(false);
			}
		});
		rdbHombre.setBounds(392, 99, 81, 23);
		panel_2.add(rdbHombre);

		JPanel pnlTipo = new JPanel();
		pnlTipo.setLayout(null);
		pnlTipo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Usuario:",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlTipo.setBounds(10, 226, 475, 68);
		contentPanel.add(pnlTipo);

		rdbDoctor = new JRadioButton("Doctor");
		rdbDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbSecretaria.setSelected(false);
				rdbAdministrador.setSelected(false);
				cmbEspecialidad.setEnabled(true);
				txtContra.setEditable(true);
				txtContra.setEnabled(true);
				txtContra.setText("");

			}
		});
		rdbDoctor.setBounds(8, 25, 135, 23);
		pnlTipo.add(rdbDoctor);

		rdbAdministrador = new JRadioButton("Administrador");
		rdbAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbSecretaria.setSelected(false);
				rdbDoctor.setSelected(false);
				cmbEspecialidad.setEnabled(false);
				cmbEspecialidad.setSelectedIndex(0);
				txtContra.setEditable(true);
				txtContra.setEnabled(true);
				txtContra.setText("");
			}
		});
		rdbAdministrador.setBounds(292, 25, 149, 23);
		pnlTipo.add(rdbAdministrador);

		rdbSecretaria = new JRadioButton("Secretaria");
		rdbSecretaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbDoctor.setSelected(false);
				rdbAdministrador.setSelected(false);
				cmbEspecialidad.setEnabled(false);
				cmbEspecialidad.setSelectedIndex(0);
				txtContra.setEditable(true);
				txtContra.setEnabled(true);
				txtContra.setText("");

			}
		});
		rdbSecretaria.setBounds(163, 24, 118, 23);
		pnlTipo.add(rdbSecretaria);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Persona perso = null;
						String codigo = txtCodigo.getText();
						String cedula = txtCedula.getText();
						String nombre = txtNombre.getText();
						String telefono = txtTelefono.getText();
						String direccion = txtDireccion.getText();

						if (rdbDoctor.isSelected()) {
							String especialidad = (String) cmbEspecialidad.getSelectedItem();
							if (rdbMujer.isSelected()) {
								perso = new Doctor(codigo, cedula, nombre, telefono, direccion, 'd', 'm', especialidad);
							}
							if (rdbHombre.isSelected()) {
								perso = new Doctor(codigo, cedula, nombre, telefono, direccion, 'd', 'h', especialidad);
							}
						}
						if (rdbSecretaria.isSelected()) {
							if (rdbMujer.isSelected()) {
								perso = new Secretaria(codigo, cedula, nombre, telefono, direccion, 's', 'm');
							}
							if (rdbHombre.isSelected()) {
								perso = new Secretaria(codigo, cedula, nombre, telefono, direccion, 's', 'h');
							}
						}
						if (rdbAdministrador.isSelected()) {
							if (rdbMujer.isSelected()) {
								perso = new Administrador(codigo, cedula, nombre, telefono, direccion, 'a', 'm');
							}
							if (rdbHombre.isSelected()) {
								perso = new Administrador(codigo, cedula, nombre, telefono, direccion, 'a', 'h');
							}
						}

						if (!rdbDoctor.isSelected() && !rdbSecretaria.isSelected() && !rdbAdministrador.isSelected()) {
							JOptionPane.showMessageDialog(null, "debes seleccionar un tipo", "error",
									JOptionPane.ERROR_MESSAGE);
						}
						Clinica.getInstance().insertarPersona(perso);
						if (rdbDoctor.isSelected() || rdbSecretaria.isSelected() || rdbAdministrador.isSelected()) {
							JOptionPane.showMessageDialog(null, "Usuario registrado con éxito", "Información",
									JOptionPane.INFORMATION_MESSAGE);
							ClearSecion();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void ClearSecion() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtCedula.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtContra.setText("");
		rdbMujer.setSelected(false);
		rdbHombre.setSelected(false);
		cmbEspecialidad.setSelectedIndex(0);
		rdbDoctor.setSelected(false);
		rdbSecretaria.setSelected(false);
		rdbAdministrador.setSelected(false);
		cmbEspecialidad.setEnabled(false);
		txtContra.setEditable(false);
		txtContra.setEnabled(false);

	}
}
