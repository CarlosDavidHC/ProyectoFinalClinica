package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Cita;
import Logico.Clinica;
import Logico.Consulta;
import Logico.Doctor;
import Logico.Persona;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaConsultas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;
	private JButton cancelButton;
	private JButton okButton;
	private Consulta consulta = null;

	public static void main(String[] args) {
		try {
			ListaConsultas dialog = new ListaConsultas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ListaConsultas() {
		setModal(true);
		setTitle("Listado de las citas");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 414, 206);
			contentPanel.add(scrollPane);
			{
				String[] header = { "Código", "Fecha", "Paciente", "Doctor", "Num. Enfermedades", "Num. Vacunas",
						"Atendido" };
				model = new DefaultTableModel();
				model.setColumnIdentifiers(header);
				table = new JTable();
				table.setModel(model);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		loadConsulta();
	}

	public static void loadConsulta() {
	    model.setRowCount(0);

	    for (Consulta consulta : Clinica.getInstance().getMisConsultas()) {
	        if (consulta.getAtendido() == 'c' || consulta.getAtendido() == 'o') {
	            row = new Object[model.getColumnCount()];

	            row[0] = consulta.getCodigoConsult();
	            row[1] = consulta.getFecha();
	            row[2] = consulta.getPaciente().getNombre();
	            row[3] = consulta.getDoctor().getNombre();
	            row[4] = consulta.getEnfermedad().size();
	            row[5] = consulta.getVacuna().size();
	            row[6] = consulta.getAtendido();

	            model.addRow(row);
	        }
	    }
	}


}
