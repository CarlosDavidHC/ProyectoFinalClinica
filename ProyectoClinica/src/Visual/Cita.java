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
	private JTable table;
	private JTable table_1;
	private JTextField codigo2;
	private JTextField textField_1;
	private JTextField nombre2;
	private JTextField sexo2;
	private JTextField telefono2;
	private JTextField direccion2;

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
		
		JLabel lblNewLabel = new JLabel("Doctor");
		lblNewLabel.setBounds(12, 174, 56, 16);
		contentPanel.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 201, 154, 97);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 154, 97);
		panel.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("seleccionado");
		lblNewLabel_1.setBounds(291, 174, 89, 16);
		contentPanel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(291, 201, 154, 97);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(0, 0, 154, 97);
		panel_1.add(table_1);
		
		JButton btnNewButton_1 = new JButton(">>");
		btnNewButton_1.setBounds(176, 211, 89, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<<");
		btnNewButton_2.setBounds(176, 261, 89, 23);
		contentPanel.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 458, 146);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		codigo2 = new JTextField();
		codigo2.setBounds(88, 11, 86, 20);
		panel_2.add(codigo2);
		codigo2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo :");
		lblNewLabel_2.setBounds(10, 14, 56, 14);
		panel_2.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("buscar");
		btnNewButton.setBounds(184, 10, 89, 23);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("fecha");
		lblNewLabel_3.setBounds(305, 14, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(351, 11, 86, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre :");
		lblNewLabel_4.setBounds(10, 66, 56, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Sexo :");
		lblNewLabel_5.setBounds(10, 109, 56, 14);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telefono:");
		lblNewLabel_6.setBounds(263, 66, 66, 14);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Direccion :");
		lblNewLabel_7.setBounds(263, 109, 66, 14);
		panel_2.add(lblNewLabel_7);
		
		nombre2 = new JTextField();
		nombre2.setBounds(88, 63, 86, 20);
		panel_2.add(nombre2);
		nombre2.setColumns(10);
		
		sexo2 = new JTextField();
		sexo2.setBounds(88, 106, 86, 20);
		panel_2.add(sexo2);
		sexo2.setColumns(10);
		
		telefono2 = new JTextField();
		telefono2.setBounds(351, 63, 86, 20);
		panel_2.add(telefono2);
		telefono2.setColumns(10);
		
		direccion2 = new JTextField();
		direccion2.setBounds(351, 106, 86, 20);
		panel_2.add(direccion2);
		direccion2.setColumns(10);
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
