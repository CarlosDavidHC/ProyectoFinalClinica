package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class regVivienda extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtHabitacion;
	private JTextField txtPiso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			regVivienda dialog = new regVivienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public regVivienda() {
		setBounds(100, 100, 479, 470);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(5, 5, 447, 125);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblId = new JLabel("ID:");
			lblId.setBounds(12, 27, 31, 16);
			panel.add(lblId);
			
			txtId = new JTextField();
			txtId.setBounds(97, 24, 116, 22);
			panel.add(txtId);
			txtId.setColumns(10);
			
			JLabel lblHabitacion = new JLabel("Habitaci\u00F3n:");
			lblHabitacion.setBounds(12, 62, 73, 16);
			panel.add(lblHabitacion);
			
			txtHabitacion = new JTextField();
			txtHabitacion.setColumns(10);
			txtHabitacion.setBounds(97, 59, 116, 22);
			panel.add(txtHabitacion);
			
			JLabel lblPiso = new JLabel("Piso:");
			lblPiso.setBounds(277, 24, 31, 16);
			panel.add(lblPiso);
			
			txtPiso = new JTextField();
			txtPiso.setColumns(10);
			txtPiso.setBounds(320, 21, 116, 22);
			panel.add(txtPiso);
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 165, 440, 210);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 42, 158, 155);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setBounds(12, 13, 56, 16);
		panel.add(lblPacientes);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(270, 42, 158, 155);
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		JLabel lblVivienda = new JLabel("Vivienda:");
		lblVivienda.setBounds(270, 13, 56, 16);
		panel.add(lblVivienda);
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
