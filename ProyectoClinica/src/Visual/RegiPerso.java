package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegiPerso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombre1;
	private JTextField cedula1;
	private JTextField telefono1;
	private JTextField dirrecion1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegiPerso dialog = new RegiPerso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegiPerso() {
		setBounds(100, 100, 450, 366);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "informacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 414, 122);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("nombre :");
		lblNewLabel.setBounds(10, 22, 58, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("cedula :");
		lblNewLabel_1.setBounds(10, 62, 58, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("telefono :");
		lblNewLabel_2.setBounds(10, 97, 58, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("direccion :");
		lblNewLabel_3.setBounds(240, 22, 58, 14);
		panel.add(lblNewLabel_3);
		
		nombre1 = new JTextField();
		nombre1.setBounds(61, 19, 86, 20);
		panel.add(nombre1);
		nombre1.setColumns(10);
		
		cedula1 = new JTextField();
		cedula1.setBounds(61, 59, 86, 20);
		panel.add(cedula1);
		cedula1.setColumns(10);
		
		telefono1 = new JTextField();
		telefono1.setBounds(61, 94, 86, 20);
		panel.add(telefono1);
		telefono1.setColumns(10);
		
		dirrecion1 = new JTextField();
		dirrecion1.setBounds(305, 19, 86, 20);
		panel.add(dirrecion1);
		dirrecion1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 144, 414, 33);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("paciente");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(16, 7, 109, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("doctor");
		rdbtnNewRadioButton_1.setBounds(233, 7, 109, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 188, 414, 95);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Enfermedad :");
		lblNewLabel_4.setBounds(10, 24, 78, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tratamiento :");
		lblNewLabel_5.setBounds(10, 70, 78, 14);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("habitacion :");
		lblNewLabel_6.setBounds(243, 24, 65, 14);
		panel_2.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(82, 21, 86, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(82, 67, 86, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(305, 21, 86, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
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
