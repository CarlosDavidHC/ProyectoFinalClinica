package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Administrador;
import Logico.Clinica;
import Logico.Doctor;
import Logico.Persona;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ListaAdministrador extends JDialog {

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
			ListaAdministrador dialog = new ListaAdministrador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaAdministrador() {
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
			String[] header = {"Código", "Nombre", "Telefono","direccion"};
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
		loadAdmin();
	}
	public static void loadAdmin() {
        model.setRowCount(0);
        row = new Object[model.getColumnCount()];
        for (Persona admin: Clinica.getInstance().getmisPersonas()) {
        	if(admin instanceof Administrador) {
            row[0] = admin.getCodigo();
            row[1] = admin.getNombre();
            row[2] = admin.getTelefono();
            row[3] = admin.getDireccion();
            model.addRow(row);
        	}
        }
    }
}
