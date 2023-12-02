package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Enfermedad extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Enfermedad dialog = new Enfermedad();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Enfermedad() {
		setBounds(100, 100, 355, 303);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(185, 11, 55, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBounds(235, 8, 86, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Descripci\u00F3n");
			lblNewLabel_1.setBounds(10, 55, 74, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(10, 80, 302, 137);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		
		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo:");
		lblNewLabel_2.setBounds(10, 11, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(54, 8, 86, 20);
		contentPanel.add(textField_2);
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
