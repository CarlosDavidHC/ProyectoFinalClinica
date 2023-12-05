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
import Logico.Doctor;
import Logico.Persona;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaCitas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
    private static Object[] row;
    private JButton cancelButton;
    private JButton okButton;
    private Cita cita= null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaCitas dialog = new ListaCitas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaCitas() {
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
				String[] header = {"Código", "Persona", "Doctor","Fecha"};
		        model = new DefaultTableModel();
		        model.setColumnIdentifiers(header);
		        table = new JTable();
		        table.addMouseListener(new MouseAdapter() {
		        	public void mouseClicked(MouseEvent e) {
						   int index = table.getSelectedRow();
						   if(index>=0){
							  cancelButton.setEnabled(true);
							  okButton.setEnabled(true);
							  cita= Clinica.getInstance().buscarUnaCita(table.getValueAt(index, 0).toString());
						   }
		        	}
				});
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
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("eliminar");
				//cancelButton.addActionListener(new ActionListener() {
					/*public void actionPerformed(ActionEvent e) {
						int Option = JOptionPane.showConfirmDialog(null, "Seguro desea eliminar la cita con código: "+cita.getCodigoCita(), "Eliminar", JOptionPane.OK_CANCEL_OPTION);
					    if(Option == JOptionPane.OK_OPTION){
					    	Clinica.getInstance().eliminarCita(cita);
					    	loadCitas();
					    	cancelButton.setEnabled(false);
					    	okButton.setEnabled(false);
					    }
					}*/
				//});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadCitas();
	} 
	public static void loadCitas() {
        model.setRowCount(0);
        
        for (Cita citas : Clinica.getInstance().getMisCitas()) {
            row = new Object[model.getColumnCount()];
            
            row[0] = citas.getCodigoCita();
            row[1] = citas.getPersona().getNombre();
            row[2] = citas.getDoctor().getNombre();
            row[3]= citas.getFechaCita();
            model.addRow(row);
        	
        }
    }


}
