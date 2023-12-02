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
	private JTextField Area1;
	private JTextField especialidad1;

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
		
		JRadioButton rdbDoctor = new JRadioButton("doctor");
		rdbDoctor.setBounds(6, 7, 109, 23);
		panel_1.add(rdbDoctor);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Doctor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 188, 414, 95);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Area :");
		lblNewLabel_7.setBounds(10, 24, 78, 14);
		panel_3.add(lblNewLabel_7);
		
		Area1 = new JTextField();
		Area1.setText("");
		Area1.setBounds(82, 21, 86, 20);
		panel_3.add(Area1);
		Area1.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Especialidad :");
		lblNewLabel_8.setBounds(243, 24, 65, 14);
		panel_3.add(lblNewLabel_8);
		
		especialidad1 = new JTextField();
		especialidad1.setBounds(305, 21, 86, 20);
		panel_3.add(especialidad1);
		especialidad1.setColumns(10);
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
