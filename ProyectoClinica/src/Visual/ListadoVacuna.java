package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.glass.events.MouseEvent;

import Logico.Clinica;
import Logico.Paciente;
import Logico.Persona;
import Logico.Vacuna;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoVacuna extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton cancelButton;
	private static DefaultTableModel model;
	private Object rowData[];

	public static void main(String[] args) {
		try {
			ListadoVacuna dialog = new ListadoVacuna();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ListadoVacuna() {
		setModal(true);
		setTitle("Listado de Vacunas");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 217);
		contentPanel.add(scrollPane);
		{
			String[] header = { "Código", "Nombre", "Trata" };
			model = new DefaultTableModel();
			model.setColumnIdentifiers(header);
			table = new JTable();

			table.setModel(model);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(model);
			scrollPane.setViewportView(table);
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadVacuna();
	}

	private void loadVacuna() {
		model.setRowCount(0);

		for (Vacuna vacun : Clinica.getInstance().getMisVacunas()) {

			rowData = new Object[model.getColumnCount()];

			rowData[0] = vacun.getCodigo();
			rowData[1] = vacun.getNombre();
			rowData[2] = vacun.getEnfermedad().getNombre();

			model.addRow(rowData);
		}
	}
}
