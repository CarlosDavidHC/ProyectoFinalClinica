package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class RegConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;

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

	/**
	 * Create the dialog.
	 */
	public RegConsulta() {
		setTitle("Consulta");
		setBounds(100, 100, 524, 463);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paciente:");
		lblNewLabel.setBounds(12, 117, 64, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Doctor:");
		lblNewLabel_1.setBounds(287, 117, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enfermedad:");
		lblNewLabel_2.setBounds(12, 160, 76, 14);
		contentPanel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(123, 117, 110, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(363, 117, 106, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(123, 160, 110, 20);
		contentPanel.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Vacuna:");
		lblNewLabel_4.setBounds(287, 163, 64, 14);
		contentPanel.add(lblNewLabel_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(363, 160, 106, 20);
		contentPanel.add(comboBox_1);
		
		JLabel lblNewLabel_5 = new JLabel("Historial cl\u00EDnico:");
		lblNewLabel_5.setBounds(12, 213, 100, 14);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cita:");
		lblNewLabel_6.setBounds(12, 70, 46, 14);
		contentPanel.add(lblNewLabel_6);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(123, 70, 110, 20);
		contentPanel.add(comboBox_2);
		
		table = new JTable();
		table.setBounds(123, 213, 279, 140);
		contentPanel.add(table);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(287, 70, 64, 14);
		contentPanel.add(lblFecha);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(363, 67, 106, 20);
		contentPanel.add(textField_2);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(12, 26, 64, 14);
		contentPanel.add(lblCdigo);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(88, 23, 106, 20);
		contentPanel.add(textField_3);
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
