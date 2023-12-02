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
import javax.swing.JScrollPane;
import javax.swing.JList;

public class RegCita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField codigo2;
	private JTextField textField_1;
	private JTextField nombre2;
	private JTextField telefono2;
	private JTextField direccion2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegCita dialog = new RegCita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCita() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Seleccionado");
		lblNewLabel_1.setBounds(425, 208, 89, 16);
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(264, 130, 242, 40);
		panel_2.add(comboBox);
		
		codigo2 = new JTextField();
		codigo2.setBounds(88, 11, 96, 20);
		panel_2.add(codigo2);
		codigo2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo:");
		lblNewLabel_2.setBounds(10, 11, 56, 20);
		panel_2.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(198, 10, 89, 23);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha:");
		lblNewLabel_3.setBounds(299, 14, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(357, 11, 86, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre:");
		lblNewLabel_4.setBounds(10, 59, 56, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo:");
		lblNewLabel_5.setBounds(264, 59, 33, 14);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telefono:");
		lblNewLabel_6.setBounds(10, 98, 66, 14);
		panel_2.add(lblNewLabel_6);
		
		nombre2 = new JTextField();
		nombre2.setBounds(88, 56, 164, 20);
		panel_2.add(nombre2);
		nombre2.setColumns(10);
		
		telefono2 = new JTextField();
		telefono2.setBounds(88, 95, 164, 20);
		panel_2.add(telefono2);
		telefono2.setColumns(10);
		
		direccion2 = new JTextField();
		direccion2.setBounds(264, 130, 242, 40);
		panel_2.add(direccion2);
		direccion2.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Mujer");
		rdbtnNewRadioButton.setBounds(299, 55, 66, 23);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Hombre");
		rdbtnNewRadioButton_1.setBounds(369, 55, 109, 23);
		panel_2.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Nueva direcci\u00F3n");
		rdbtnNewRadioButton_2.setBounds(264, 98, 119, 23);
		panel_2.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Direcci\u00F3n existente");
		rdbtnNewRadioButton_3.setBounds(387, 98, 145, 23);
		panel_2.add(rdbtnNewRadioButton_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(374, 237, 236, 171);
		contentPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
