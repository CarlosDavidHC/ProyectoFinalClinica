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

public class Cita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField nombre2;
	private JTextField sexo2;
	private JTextField telefono2;
	private JTable table;
	private JTable table_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cita dialog = new Cita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cita() {
		setBounds(100, 100, 494, 429);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha:");
		lblNewLabel_3.setBounds(284, 13, 56, 16);
		contentPanel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(350, 10, 95, 22);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo:");
		lblNewLabel_2.setBounds(12, 13, 56, 16);
		contentPanel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(57, 13, 95, 22);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Doctor");
		lblNewLabel.setBounds(284, 174, 56, 16);
		contentPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 201, 154, 97);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 154, 97);
		panel.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Paciente");
		lblNewLabel_1.setBounds(12, 174, 56, 16);
		contentPanel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(291, 201, 154, 97);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(0, 0, 154, 97);
		panel_1.add(table_1);
		
		JLabel lblNewLabel_4 = new JLabel("nombre :");
		lblNewLabel_4.setBounds(12, 77, 56, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("telefono :");
		lblNewLabel_5.setBounds(269, 77, 66, 14);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("sexo :");
		lblNewLabel_6.setBounds(22, 128, 46, 14);
		contentPanel.add(lblNewLabel_6);
		
		nombre2 = new JTextField();
		nombre2.setBounds(80, 74, 86, 20);
		contentPanel.add(nombre2);
		nombre2.setColumns(10);
		
		sexo2 = new JTextField();
		sexo2.setBounds(80, 125, 86, 20);
		contentPanel.add(sexo2);
		sexo2.setColumns(10);
		
		telefono2 = new JTextField();
		telefono2.setBounds(350, 74, 95, 20);
		contentPanel.add(telefono2);
		telefono2.setColumns(10);
		
		JButton btnNewButton = new JButton("buscar");
		btnNewButton.setBounds(162, 10, 89, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(">>");
		btnNewButton_1.setBounds(176, 211, 89, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<<");
		btnNewButton_2.setBounds(176, 261, 89, 23);
		contentPanel.add(btnNewButton_2);
		
		JLabel lblNewLabel_7 = new JLabel("direccion :");
		lblNewLabel_7.setBounds(269, 128, 66, 14);
		contentPanel.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(350, 125, 95, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
