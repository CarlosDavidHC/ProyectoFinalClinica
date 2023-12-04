package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Clinica;
import Logico.Doctor;
import Logico.Persona;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaD extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
    private static Object[] row;
    private JButton cancelButton;
    private JButton okButton;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaD dialog = new ListaD();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaD() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 414, 206);
			contentPanel.add(scrollPane);
			{String[] header = {"Código", "Nombre", "Especialidad"};
		        model = new DefaultTableModel();
		        model.setColumnIdentifiers(header);
		        table = new JTable();
		        /*table.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		                int index = table.getSelectedRow();
		                if (index >= 0) {
		                    cancelButton.setEnabled(true);
		                    okButton.setEnabled(true);
		                    doctor = Clinica.getInstance().buscarDoctorByCodigo(table.getValueAt(index, 0).toString());
		                }
		            }
		        });*/
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
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option = JOptionPane.showConfirmDialog(null, "Seguro desea eliminar el doctor con código: " + doctor.getCodigo(), "Eliminar", JOptionPane.OK_CANCEL_OPTION);
			            if (option == JOptionPane.OK_OPTION) {
			            	 /*Clinica.getInstance().eliminarPersona(doctor);
			                 loadDoctores();
			                 cancelButton.setEnabled(false);
			                 okButton.setEnabled(false);*/
			            }
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	  public static void loadDoctores() {
	        model.setRowCount(0);
	        row = new Object[model.getColumnCount()];
	        for (Persona doctor : Clinica.getInstance().getMisPersonas()) {
	            row[0] = doctor.getCodigo();
	            row[1] = doctor.getNombre();
	            row[2] = (doctor instanceof Doctor) ? ((Doctor) doctor).getEspecialidad() : "";
	            model.addRow(row);
	        }
	    }

}
