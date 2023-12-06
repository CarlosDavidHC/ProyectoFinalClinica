package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Clinica;
import Logico.Enfermedad;
import Logico.Vacuna;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RegVacuna extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombre1;
	private JTextField codigo1;
	private JComboBox comboBox1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegVacuna dialog = new RegVacuna();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegVacuna() {
		setTitle("Registrar Vacuna");
		setBounds(100, 100, 355, 215);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(144, 11, 55, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			nombre1 = new JTextField();
			nombre1.setBounds(211, 8, 110, 20);
			contentPanel.add(nombre1);
			nombre1.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Enfermedad:");
			lblNewLabel_1.setBounds(10, 55, 74, 14);
			contentPanel.add(lblNewLabel_1);
		}

		JLabel lblNewLabel_2 = new JLabel("C\u00F3digo:");
		lblNewLabel_2.setBounds(10, 10, 46, 17);
		contentPanel.add(lblNewLabel_2);

		codigo1 = new JTextField();
		codigo1.setBounds(68, 8, 64, 20);
		contentPanel.add(codigo1);
		codigo1.setColumns(10);

		comboBox1 = new JComboBox();
		comboBox1.setBounds(96, 51, 117, 22);
		contentPanel.add(comboBox1);
		{
			ArrayList<Enfermedad> enfer = Clinica.getInstance().getMisEnfermedades();
			for (Enfermedad enfermedad : enfer) {
			    comboBox1.addItem(enfermedad.getNombre());
			}
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String selectedEnfermedad = (String) comboBox1.getSelectedItem();
						Enfermedad enfermedades= Clinica.getInstance().buscaEnfermedad(selectedEnfermedad);
						
						Vacuna vacun= new Vacuna(nombre1.getText(), codigo1.getText(), enfermedades);
						Clinica.getInstance().insertarvacuna(vacun);
						clear();
						JOptionPane.showMessageDialog(null, "exito", "Advertencia",
								JOptionPane.WARNING_MESSAGE);

					}
				});
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
	public void clear() {
		nombre1.setText("");
        codigo1.setText("");
        comboBox1.setSelectedIndex(0);
	}
}
