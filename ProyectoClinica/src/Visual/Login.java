package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Control;
import Logico.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream clinica;
				FileOutputStream clinica2;
				ObjectInputStream clinicaRead;
				ObjectOutputStream clinicaWrite;
				try {
					clinica = new FileInputStream("clinica.dat");
					clinicaRead = new ObjectInputStream(clinica);
					Control temp = (Control) clinicaRead.readObject();
					Control.setControl(temp);
					clinica.close();
					clinicaRead.close();
				} catch (FileNotFoundException e) {
					try {
						clinica2 = new FileOutputStream("clinica.dat");
						clinicaWrite = new ObjectOutputStream(clinica2);
						User aux = new User("Administrador", "Admin", "Admin");
						Control.getInstance().regUser(aux);
						clinicaWrite.writeObject(Control.getInstance());
						clinica2.close();
						clinicaWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
					}
				} catch (IOException e) {

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setTitle("Inicio de Sesi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(281, 104, 48, 14);
		panel.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setBounds(281, 163, 70, 14);
		panel.add(lblContrasea);

		txtUsuario = new JTextField();
		txtUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginUser();
			}
		});
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuario.setBounds(281, 129, 191, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);

        JButton btnLogin = new JButton("Acceder");
        ImageIcon icon = new ImageIcon(Login.class.getResource("/Imagess/usuario.png"));
        btnLogin.setIcon(new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginUser();
            }
        });
        btnLogin.setBounds(281, 237, 116, 47);
        panel.add(btnLogin);

		JLabel lblClinica = new JLabel("Inicie Sesi\u00F3n");
		lblClinica.setHorizontalAlignment(SwingConstants.CENTER);
		lblClinica.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblClinica.setBounds(279, 55, 191, 20);
		panel.add(lblClinica);

		txtPassword = new JPasswordField();
		txtPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginUser();
			}
		});
		txtPassword.setBounds(281, 193, 191, 20);
		panel.add(txtPassword);
		
        JLabel lblNewLabel = new JLabel("");
        ImageIcon imageIcon = new ImageIcon(Login.class.getResource("/Imagess/cruzRoja.jpg"));
        lblNewLabel.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(575, 371, Image.SCALE_SMOOTH)));
        lblNewLabel.setBounds(0, 0, 559, 297);
        panel.add(lblNewLabel);
        lblNewLabel.setLayout(new BorderLayout());
	}

	private void loginUser() {
		String username = txtUsuario.getText();
		String password = new String(txtPassword.getPassword());

		if (Control.getInstance().confirmLogin(username, password)) {
			Principal frame = new Principal();
			dispose();
			frame.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(Login.this, "Usuario o contraseña incorrectos", "Error de inicio de sesión",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
