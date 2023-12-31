package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Clinica;
import Logico.Paciente;
import Logico.Persona;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoPaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private Object rowData[];

	public static void main(String[] args) {
		try {
			ListadoPaciente dialog = new ListadoPaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ListadoPaciente() {
		setModal(true);
		setTitle("Listado de Pacientes");
		setBounds(100, 100, 578, 481);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				model = new DefaultTableModel();
				String[] headers = { "C�digo", "C�dula", "Nombre", "Tel�fono", "Direcci�n", "Sexo" };
				model.setColumnIdentifiers(headers);
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarDatosPacientes(0);
	}

	private void cargarDatosPacientes(int index) {
		model.setRowCount(0);

		for (Persona persona : Clinica.getInstance().getmisPersonas()) {
			if (persona instanceof Paciente) {
				rowData = new Object[model.getColumnCount()];

				rowData[0] = persona.getCodigo();
				rowData[1] = persona.getCedula();
				rowData[2] = persona.getNombre();
				rowData[3] = persona.getTelefono();
				rowData[4] = persona.getDireccion();
				rowData[5] = persona.getSexo();

				model.addRow(rowData);
			}
		}
	}
}