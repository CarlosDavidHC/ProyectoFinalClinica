package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class RegUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField codigo2;
	private JTextField nombre2;
	private JTextField direccion2;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;

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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(100, 19, 132, 20);
		pnldoctor.add(textField);
		
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(99, 102, 132, 20);
		panel_2.add(textField_1);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(181, 13, 56, 18);
		panel_2.add(lblCdula);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(249, 12, 214, 20);
		panel_2.add(textField_2);
		
		JLabel label_1 = new JLabel("Sexo:");
		label_1.setBounds(249, 103, 33, 14);
		panel_2.add(label_1);
		
		JRadioButton radioButton_1 = new JRadioButton("Mujer");
		radioButton_1.setBounds(317, 99, 71, 23);
		panel_2.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("Hombre");
		radioButton_2.setBounds(392, 99, 81, 23);
		panel_2.add(radioButton_2);
		
		JPanel pnlTipo = new JPanel();
		pnlTipo.setLayout(null);
		pnlTipo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Usuario:",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlTipo.setBounds(10, 226, 475, 68);
		contentPanel.add(pnlTipo);
		
		JRadioButton rdbtnDoctor = new JRadioButton("Doctor");
		rdbtnDoctor.setSelected(true);
		rdbtnDoctor.setBounds(8, 25, 135, 23);
		pnlTipo.add(rdbtnDoctor);
		
		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setBounds(292, 25, 149, 23);
		pnlTipo.add(rdbtnAdministrador);
		
		JRadioButton radioButton = new JRadioButton("Secretaria");
		radioButton.setBounds(163, 24, 118, 23);
		pnlTipo.add(radioButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
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
}
