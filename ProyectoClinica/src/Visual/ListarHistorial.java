package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Cita;
import Logico.Clinica;
import Logico.HistorialClinico;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarHistorial extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private Object rowData[];

	public static void main(String[] args) {
		try {
			ListarHistorial dialog = new ListarHistorial();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ListarHistorial() {
		setModal(true);
		setTitle("Listado de Historiales");
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
				String[] headers = { "Código", "Paciente", "Núm. Citas", "Núm. Consultas", "Núm. Enfermedades",
						"Núm. Vacunas" };
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

		for (HistorialClinico histo : Clinica.getInstance().getMisHistoriales()) {
			rowData = new Object[model.getColumnCount()];

			rowData[0] = histo.getId();
			rowData[1] = histo.getMiPaciente().getNombre();

			int numCitas = 0;
			int numConsultas = 0;
			for (Cita cita : histo.getMisCitas()) {
				if (cita.getPersona().equals(histo.getMiPaciente())) {
					numCitas++;
					if (cita.getEstado() == 'a') {
						numConsultas++;
					}
				}
			}
			rowData[2] = numCitas;
			rowData[3] = numConsultas;
			rowData[4] = histo.getMisEnfermedades().size();
			rowData[5] = histo.getMisVacunas().size();

			model.addRow(rowData);
		}
	}

}