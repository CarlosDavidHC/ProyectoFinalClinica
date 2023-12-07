package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Clinica;
import Logico.Enfermedad;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegEnfermedad extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JButton cancelButton;
	private JButton BtnGuardar;

	public static void main(String[] args) {
		try {
			RegEnfermedad dialog = new RegEnfermedad();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public RegEnfermedad() {
		setTitle("Registrar Enfermedad");
		setBounds(100, 100, 355, 303);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(10, 16, 55, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(77, 13, 244, 20);
			contentPanel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Descripci\u00F3n");
			lblNewLabel_1.setBounds(10, 55, 74, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtDescripcion = new JTextField();
			txtDescripcion.setBounds(10, 80, 311, 137);
			contentPanel.add(txtDescripcion);
			txtDescripcion.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				BtnGuardar = new JButton("Guardar");
				BtnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Enfermedad enfer = null;
						String nombre = txtNombre.getText();
						String descripcion = txtDescripcion.getText();

						enfer = new Enfermedad("E-" + Clinica.GeneradorEnfermedad, nombre, descripcion);
						Clinica.getInstance().insertarEnfermedad(enfer);
						JOptionPane.showMessageDialog(null, "Enfermedad registrada con éxito", "Información",
								JOptionPane.INFORMATION_MESSAGE);

						Clear();
					}
				});
				BtnGuardar.setActionCommand("OK");
				buttonPane.add(BtnGuardar);
				getRootPane().setDefaultButton(BtnGuardar);
			}
			{
				cancelButton = new JButton("Cancel");
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

	private void Clear() {
		txtNombre.setText("");
		txtDescripcion.setText("");
	}
}
