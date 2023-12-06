package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
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
		setBounds(100, 100, 524, 679);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Paciente:");
		lblNewLabel.setBounds(12, 117, 64, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Doctor:");
		lblNewLabel_1.setBounds(12, 171, 46, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Enfermedad:");
		lblNewLabel_2.setBounds(12, 213, 76, 14);
		contentPanel.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(123, 117, 346, 20);
		contentPanel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(123, 168, 346, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(123, 213, 110, 20);
		contentPanel.add(comboBox);

		JLabel lblNewLabel_4 = new JLabel("Vacuna:");
		lblNewLabel_4.setBounds(287, 216, 64, 14);
		contentPanel.add(lblNewLabel_4);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(363, 213, 106, 20);
		contentPanel.add(comboBox_1);

		JLabel lblNewLabel_5 = new JLabel("Historial cl\u00EDnico:");
		lblNewLabel_5.setBounds(12, 414, 100, 14);
		contentPanel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Cita:");
		lblNewLabel_6.setBounds(12, 70, 46, 14);
		contentPanel.add(lblNewLabel_6);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(123, 70, 110, 20);
		contentPanel.add(comboBox_2);

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
		textField_3.setBounds(127, 23, 106, 20);
		contentPanel.add(textField_3);

		JLabel lblAtendido = new JLabel("Diagnostico:");
		lblAtendido.setBounds(224, 567, 76, 19);
		contentPanel.add(lblAtendido);

		JRadioButton rdbtnCurado = new JRadioButton("Curado");
		rdbtnCurado.setBounds(309, 565, 76, 23);
		contentPanel.add(rdbtnCurado);

		JRadioButton rdbtnObservacin = new JRadioButton("Observaci\u00F3n");
		rdbtnObservacin.setBounds(389, 565, 109, 23);
		contentPanel.add(rdbtnObservacin);

		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(136, 246, 97, 25);
		contentPanel.add(btnNewButton);

		JLabel lblLista = new JLabel("Lista:");
		lblLista.setBounds(12, 251, 76, 14);
		contentPanel.add(lblLista);

		JLabel label = new JLabel("Lista:");
		label.setBounds(287, 251, 76, 14);
		contentPanel.add(label);

		JButton button = new JButton("Agregar");
		button.setBounds(373, 246, 97, 25);
		contentPanel.add(button);

		JPanel panel = new JPanel();
		panel.setBounds(12, 284, 221, 117);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		JList list = new JList();
		scrollPane.setViewportView(list);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(287, 284, 207, 117);
		contentPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);

		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(123, 414, 279, 140);
		contentPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_2.add(scrollPane_2, BorderLayout.CENTER);

		JList list_2 = new JList();
		scrollPane_2.setViewportView(list_2);
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
