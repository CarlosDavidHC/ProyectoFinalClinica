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

public class Consulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Consulta dialog = new Consulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Consulta() {
		setTitle("Consulta");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paciente :");
		lblNewLabel.setBounds(10, 22, 64, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Doctor :");
		lblNewLabel_1.setBounds(279, 22, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enfermedad :");
		lblNewLabel_2.setBounds(10, 123, 76, 14);
		contentPanel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(70, 19, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(335, 19, 86, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo :");
		lblNewLabel_3.setBounds(10, 66, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(70, 63, 86, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(91, 120, 65, 20);
		contentPanel.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("vacuna :");
		lblNewLabel_4.setBounds(279, 123, 46, 14);
		contentPanel.add(lblNewLabel_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(335, 120, 86, 20);
		contentPanel.add(comboBox_1);
		
		JLabel lblNewLabel_5 = new JLabel("historial clinica :");
		lblNewLabel_5.setBounds(10, 175, 100, 14);
		contentPanel.add(lblNewLabel_5);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(120, 175, 167, 42);
		contentPanel.add(textPane);
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
