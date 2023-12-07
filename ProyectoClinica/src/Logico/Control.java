package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Control implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<User> misUsers;
	private static Control control;
	private static User loginUser;

	private Control() {
		misUsers = new ArrayList<>();
	}

	public static Control getInstance() {
		if (control == null) {
			control = new Control();
		}
		return control;
	}

	public ArrayList<User> getMisUsers() {
		return misUsers;
	}

	public void setMisUsers(ArrayList<User> misUsers) {
		this.misUsers = misUsers;
	}

	public static Control getControl() {
		return control;
	}

	public static void setControl(Control control) {
		Control.control = control;
	}

	public static User getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(User loginUser) {
		Control.loginUser = loginUser;
	}

	public void regUser(User user) {
		misUsers.add(user);

	}

	public boolean confirmLogin(String text, String text2) {
		boolean login = false;
		String lowercaseText = text.toLowerCase();
		String lowercaseText2 = text2.toLowerCase();
		for (User user : misUsers) {
			if (user.getUserName().toLowerCase().equals(lowercaseText) && user.getPass().equals(lowercaseText2)) {
				loginUser = user;
				login = true;
			}
		}
		return login;
	}

	public void regUserAndPass(String tipo, String nombre, String contrasena) {
		String userName = getInitials(nombre);
		User newUser = new User(tipo, userName, contrasena);
		regUser(newUser);
	}

	private String getInitials(String name) {
		String[] words = name.split("\\s+");
		StringBuilder initials = new StringBuilder();
		for (String word : words) {
			if (!word.isEmpty()) {
				initials.append(word.charAt(0));
			}
		}
		return initials.toString().toLowerCase();
	}

}
