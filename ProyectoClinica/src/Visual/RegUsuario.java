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

public class RegUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField codigo2;
	private JTextField nombre2;
	private JTextField direccion2;
	private JTextField telefono2;
	private JTextField cedula2;
	private JTextField especialidad2;
	private JRadioButton rdMujer;
	private JRadioButton rdHombre;
	private JRadioButton rdbDoctor;
	private JRadioButton rdbSecretaria;
	private JRadioButton rdbAdministrador;

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
		label.setBounds(12, 22, 82, 14);
		pnldoctor.add(label);
		
		especialidad2 = new JTextField();
		especialidad2.setEnabled(false);
		especialidad2.setEditable(false);
		especialidad2.setColumns(10);
		especialidad2.setBounds(100, 19, 132, 20);
		pnldoctor.add(especialidad2);
		
		JPanel pnlVacio = new JPanel();
		pnlVacio.setLayout(null);
		pnlVacio.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlVacio.setBounds(10, 307, 475, 57);
		contentPanel.add(pnlVacio);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 475, 202);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		codigo2 = new JTextField();
		codigo2.setBounds(78, 12, 91, 20);
		panel_2.add(codigo2);
		codigo2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo:");
		lblNewLabel_2.setBounds(10, 13, 56, 18);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre:");
		lblNewLabel_4.setBounds(10, 64, 56, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_6.setBounds(9, 105, 66, 14);
		panel_2.add(lblNewLabel_6);
		
		nombre2 = new JTextField();
		nombre2.setBounds(78, 60, 385, 20);
		panel_2.add(nombre2);
		nombre2.setColumns(10);
		
		direccion2 = new JTextField();
		direccion2.setBounds(78, 147, 242, 40);
		panel_2.add(direccion2);
		direccion2.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 146, 66, 14);
		panel_2.add(lblDireccin);
		
		telefono2 = new JTextField();
		telefono2.setColumns(10);
		telefono2.setBounds(99, 102, 132, 20);
		panel_2.add(telefono2);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(181, 13, 56, 18);
		panel_2.add(lblCdula);
		
		cedula2 = new JTextField();
		cedula2.setColumns(10);
		cedula2.setBounds(249, 12, 214, 20);
		panel_2.add(cedula2);
		
		JLabel label_1 = new JLabel("Sexo:");
		label_1.setBounds(249, 103, 33, 14);
		panel_2.add(label_1);
		
		rdMujer = new JRadioButton("Mujer");
		rdMujer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdHombre.setSelected(false);
			}
		});
		rdMujer.setBounds(317, 99, 71, 23);
		panel_2.add(rdMujer);
		
		rdHombre = new JRadioButton("Hombre");
		rdHombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdMujer.setSelected(false);
			}
		});
		rdHombre.setBounds(392, 99, 81, 23);
		panel_2.add(rdHombre);
		
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
				especialidad2.setEditable(true);
				especialidad2.setEnabled(true);
				
			}
		});
		rdbDoctor.setBounds(8, 25, 135, 23);
		pnlTipo.add(rdbDoctor);
		
		rdbAdministrador = new JRadioButton("Administrador");
		rdbAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbSecretaria.setSelected(false);
				rdbDoctor.setSelected(false);
				especialidad2.setEnabled(false);
				especialidad2.setEditable(false);
			}
		});
		rdbAdministrador.setBounds(292, 25, 149, 23);
		pnlTipo.add(rdbAdministrador);
		
		rdbSecretaria = new JRadioButton("Secretaria");
		rdbSecretaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbDoctor.setSelected(false);
				rdbAdministrador.setSelected(false);
				especialidad2.setEnabled(false);
				especialidad2.setEditable(false);
				
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
						Persona perso= null;
						String codigo=  codigo2.getText();
						String cedula= cedula2.getText();
						String nombre= nombre2.getText();
						String telefono= telefono2.getText();
						String direccion= direccion2.getText();
						
						if (rdbDoctor.isSelected()) {
							String especialidad= especialidad2.getText();
							if(rdMujer.isSelected()) {
							perso = new Doctor(codigo, cedula, nombre, telefono, direccion, 'd', 'm', especialidad);
							}
							if(rdHombre.isSelected()) {
								perso = new Doctor(codigo, cedula, nombre, telefono, direccion, 'd', 'h', especialidad);	
							}
						}
						if(rdbSecretaria.isSelected()) {
							if(rdMujer.isSelected()) {
							perso = new Secretaria(codigo, cedula, nombre, telefono, direccion, 's','m');
							}
							if(rdHombre.isSelected()) {
								perso = new Secretaria(codigo, cedula, nombre, telefono, direccion, 's','h');
							}
						}
						if(rdbAdministrador.isSelected()) {
							if(rdMujer.isSelected()) {
								perso = new Administrador(codigo, cedula, nombre, telefono, direccion, 'a','m');
							}
							if(rdHombre.isSelected()) {
								perso = new Administrador(codigo, cedula, nombre, telefono, direccion, 'a','h');
							}
						}
						
						if(!rdbDoctor.isSelected() && !rdbSecretaria.isSelected() && !rdbAdministrador.isSelected() ) {
							JOptionPane.showMessageDialog(null, "debes seleccionar un tipo", "error", JOptionPane.ERROR_MESSAGE);
						}
						Clinica.getInstance().insertarPersona(perso);
						if(rdbDoctor.isSelected() || rdbSecretaria.isSelected() || rdbAdministrador.isSelected()) {
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
		codigo2.setText("");
		nombre2.setText("");
		cedula2.setText("");
		direccion2.setText("");
		telefono2.setText("");
		rdMujer.setSelected(false);
		rdHombre.setSelected(false);
		if(rdbDoctor.isSelected()) {
			especialidad2.setText("");
		}
		
	}
}
