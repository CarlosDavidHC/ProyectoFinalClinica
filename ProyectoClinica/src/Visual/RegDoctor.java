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

public class RegDoctor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField codigo2;
	private JTextField nombre2;
	private JTextField direccion2;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegDoctor dialog = new RegDoctor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegDoctor() {
		setTitle("Registrar Doctor");
		setBounds(100, 100, 515, 311);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 475, 207);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		codigo2 = new JTextField();
		codigo2.setBounds(78, 12, 91, 20);
		panel_2.add(codigo2);
		codigo2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo:");
		lblNewLabel_2.setBounds(10, 13, 56, 18);
		panel_2.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(189, 11, 89, 23);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre:");
		lblNewLabel_4.setBounds(10, 64, 56, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo:");
		lblNewLabel_5.setBounds(10, 105, 33, 14);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_6.setBounds(242, 64, 66, 14);
		panel_2.add(lblNewLabel_6);
		
		nombre2 = new JTextField();
		nombre2.setBounds(78, 60, 132, 20);
		panel_2.add(nombre2);
		nombre2.setColumns(10);
		
		direccion2 = new JTextField();
		direccion2.setBounds(78, 149, 242, 40);
		panel_2.add(direccion2);
		direccion2.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Mujer");
		rdbtnNewRadioButton.setBounds(78, 101, 71, 23);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Hombre");
		rdbtnNewRadioButton_1.setBounds(153, 101, 81, 23);
		panel_2.add(rdbtnNewRadioButton_1);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 148, 66, 14);
		panel_2.add(lblDireccin);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(331, 61, 132, 20);
		panel_2.add(textField);
		
		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setBounds(242, 105, 82, 14);
		panel_2.add(lblEspecialidad);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(331, 102, 132, 20);
		panel_2.add(textField_1);
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
