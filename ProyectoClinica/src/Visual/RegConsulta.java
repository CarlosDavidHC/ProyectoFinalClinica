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
		setBounds(100, 100, 524, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paciente:");
		lblNewLabel.setBounds(10, 70, 64, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Doctor:");
		lblNewLabel_1.setBounds(285, 70, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enfermedad:");
		lblNewLabel_2.setBounds(10, 113, 76, 14);
		contentPanel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(121, 70, 110, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(361, 70, 106, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(121, 113, 110, 20);
		contentPanel.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Vacuna:");
		lblNewLabel_4.setBounds(285, 116, 64, 14);
		contentPanel.add(lblNewLabel_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(361, 113, 106, 20);
		contentPanel.add(comboBox_1);
		
		JLabel lblNewLabel_5 = new JLabel("Historial cl\u00EDnico:");
		lblNewLabel_5.setBounds(10, 166, 100, 14);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cita:");
		lblNewLabel_6.setBounds(10, 23, 46, 14);
		contentPanel.add(lblNewLabel_6);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(121, 23, 110, 20);
		contentPanel.add(comboBox_2);
		
		table = new JTable();
		table.setBounds(121, 166, 279, 140);
		contentPanel.add(table);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(285, 23, 64, 14);
		contentPanel.add(lblFecha);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(361, 20, 106, 20);
		contentPanel.add(textField_2);
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
