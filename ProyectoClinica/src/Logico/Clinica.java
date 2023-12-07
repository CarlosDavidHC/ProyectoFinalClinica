package Logico;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Clinica {

	private ArrayList<Viviendas> misViviendas;
	private ArrayList<Persona> misPersonas;
	private ArrayList<Cita> misCitas;
	private ArrayList<Enfermedad> misEnfermedades;
	private ArrayList<Vacuna> misVacunas;
	private ArrayList<HistorialClinico> misHistoriales;
	private static Clinica clini = null;
	public static int GeneradorCodeCita = 1;
	public static int GeneradorCodePaciente = 1;
	public static int GeneradorCodeDoctor = 1;
	public static int GeneradorCodeSecretaria = 1;
	public static int GeneradorCodeAdmin = 1;
	public static int GeneradorEnfermedad = 1;
	public static int GeneradorVacuna = 1;
	public static int GeneradorCodeHistorial = 1;
	public static int GeneradorCodeVivienda = 1;

	public static Clinica getInstance() {
		if (clini == null)
			clini = new Clinica();
		return clini;
	}

	public Clinica() {
		super();
		this.misViviendas = new ArrayList<>();
		this.misPersonas = new ArrayList<>();
		this.misCitas = new ArrayList<>();
		this.misEnfermedades = new ArrayList<>();
		this.misVacunas = new ArrayList<>();
		this.misHistoriales = new ArrayList<>();

		cargarPacientes();
		cargarDoctores();
		cargarSecretarias();
		cargarAdministradores();
		cargarViviendas();
		cargarCitas();
		cargarHistoriales();
		cargarEnfermedad();
		cargarVacuna();
	}

	public ArrayList<Viviendas> getMisViviendas() {
		return misViviendas;
	}

	public void setMisViviendas(ArrayList<Viviendas> misViviendas) {
		this.misViviendas = misViviendas;
	}

	public ArrayList<Persona> getmisPersonas() {
		return misPersonas;
	}

	public void setmisPersonas(ArrayList<Persona> misPersonas) {
		this.misPersonas = misPersonas;
	}

	public ArrayList<Cita> getMisCitas() {
		return misCitas;
	}

	public void setMisCitas(ArrayList<Cita> misCitas) {
		this.misCitas = misCitas;
	}

	public ArrayList<Enfermedad> getMisEnfermedades() {
		return misEnfermedades;
	}

	public void setMisEnfermedades(ArrayList<Enfermedad> misEnfermedades) {
		this.misEnfermedades = misEnfermedades;
	}

	public ArrayList<Vacuna> getMisVacunas() {
		return misVacunas;
	}

	public void setMisVacunas(ArrayList<Vacuna> misVacunas) {
		this.misVacunas = misVacunas;
	}

	public ArrayList<HistorialClinico> getMisHistoriales() {
		return misHistoriales;
	}

	public void setMisHistoriales(ArrayList<HistorialClinico> misHistoriales) {
		this.misHistoriales = misHistoriales;
	}

	public void insertarPersona(Persona persona) {
		misPersonas.add(persona);
		GeneradorCodePaciente++;
		guardarPacientes();
	}

	public void insertarDoctor(Persona persona) {
		misPersonas.add(persona);
		GeneradorCodeDoctor++;
		guardarDoctores();
	}

	public void insertarSecre(Persona persona) {
		misPersonas.add(persona);
		GeneradorCodeSecretaria++;
		guardarSecretarias();
	}

	public void insertarAdmin(Persona persona) {
		misPersonas.add(persona);
		GeneradorCodeAdmin++;
		guardarAdministradores();
	}

	public void insertarEnfermedad(Enfermedad Enfer) {
		misEnfermedades.add(Enfer);
		GeneradorEnfermedad++;
		guardarEnfermedad();
	}

	public void insertarvacuna(Vacuna vacun) {
		misVacunas.add(vacun);
		GeneradorVacuna++;
		guardarVacuna();
	}

	public void insertarCita(Cita cita) {
		misCitas.add(cita);
		GeneradorCodeCita++;
		guardarCitas();
	}

	public void eliminarCita(Cita cita) {
		misCitas.remove(cita);
	}

	public void eliminarDoctor(Doctor doc) {
		if (doc instanceof Doctor) {
			misPersonas.remove(doc);
		}
	}

	public Enfermedad buscaEnfermedad(String nombre) {
		Enfermedad enfer = null;
		int count = 0;
		boolean encontrado = false;

		while (count < misEnfermedades.size() && !encontrado) {
			if (misEnfermedades.get(count).getNombre().equalsIgnoreCase(nombre)) {
				enfer = misEnfermedades.get(count);
				encontrado = true;
			}
			count++;
		}
		return enfer;
	}

	public Cita buscarUnaCita(String cita) {
		int i = 0;
		Cita ci = null;
		boolean encontrado = false;

		while (i < misCitas.size() && !encontrado) {
			if (misCitas.get(i).getCodigoCita().equalsIgnoreCase(cita)) {
				ci = misCitas.get(i);
				encontrado = true;
			}
			i++;
		}
		return ci;
	}

	public void insertarHistorial(HistorialClinico histo) {
		misHistoriales.add(histo);
		GeneradorCodeHistorial++;
		guardarHistoriales();
	}

	public void insertarVivienda(Viviendas vivi) {
		misViviendas.add(vivi);
		GeneradorCodeVivienda++;
		guardarViviendas();
	}

	public Persona buscarPacienteByCedula(String cedPaciente) {
		Persona aux = null;
		int ind = 0;
		boolean encontrado = false;

		while (ind < misPersonas.size() && !encontrado) {
			if (misPersonas.get(ind).getCedula().equalsIgnoreCase(cedPaciente)
					&& misPersonas.get(ind).getTipo() == 'p') {
				aux = misPersonas.get(ind);
				encontrado = true;
			}
			ind++;
		}
		return aux;
	}

	public Doctor buscarDoctorByCodigo(String codigo) {
		Doctor doc = null;
		int i = 0;
		boolean encontrar = false;

		while (i < misPersonas.size() && !encontrar) {
			if (misPersonas.get(i).getCedula().equalsIgnoreCase(codigo)) {
				if (misPersonas.get(i) instanceof Doctor) {
					doc = (Doctor) misPersonas.get(i);
					encontrar = true;
				}
			}
			i++;
		}
		if (doc != null) {
			return doc;
		} else {
			return null;
		}
	}

	public Secretaria buscarSecretariaByCodigo(String codigo) {
		Secretaria secre = null;
		int i = 0;
		boolean encontrar = false;

		while (i < misPersonas.size() && !encontrar) {
			if (misPersonas.get(i).getCedula().equalsIgnoreCase(codigo)) {
				if (misPersonas.get(i) instanceof Secretaria) {
					secre = (Secretaria) misPersonas.get(i);
					encontrar = true;
				}
			}
			i++;
		}
		if (secre != null) {
			return secre;
		} else {
			return null;
		}
	}

	public Administrador buscarAdministradorByCodigo(String codigo) {
		Administrador admin = null;
		int i = 0;
		boolean encontrar = false;

		while (i < misPersonas.size() && !encontrar) {
			if (misPersonas.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				if (misPersonas.get(i) instanceof Administrador) {
					admin = (Administrador) misPersonas.get(i);
					encontrar = true;
				}
			}
			i++;
		}
		if (admin != null) {
			return admin;
		} else {
			return null;
		}
	}

	public void guardarPacientes() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pacientes.dat"))) {
			ArrayList<Paciente> pacientes = new ArrayList<>();
			for (Persona persona : misPersonas) {
				if (persona instanceof Paciente) {
					pacientes.add((Paciente) persona);
				}
			}
			out.writeObject(pacientes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cargarPacientes() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("pacientes.dat"))) {
			ArrayList<Paciente> pacientes = (ArrayList<Paciente>) in.readObject();
			misPersonas.addAll(pacientes);

			for (Paciente paciente : pacientes) {
				// Extraer la parte numérica del código
				String codigo = paciente.getCodigo().substring(2);

				try {
					int codigoNumerico = Integer.parseInt(codigo);
					if (codigoNumerico >= GeneradorCodePaciente) {
						GeneradorCodePaciente = codigoNumerico + 1;
					}
				} catch (NumberFormatException e) {
					// Manejar la excepción de formato de número
					System.out.println("Error al convertir el código a entero: " + paciente.getCodigo());
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// El archivo no existe, puedes crearlo aquí si es necesario
			System.out.println("El archivo pacientes.dat no existe. Creándolo...");
			guardarPacientes(); // Agrega este método para crear el archivo secretarias.dat
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void guardarDoctores() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("doctores.dat"))) {
			ArrayList<Doctor> doctores = new ArrayList<>();
			for (Persona persona : misPersonas) {
				if (persona instanceof Doctor) {
					doctores.add((Doctor) persona);
				}
			}
			out.writeObject(doctores);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cargarDoctores() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("doctores.dat"))) {
			ArrayList<Doctor> doctores = (ArrayList<Doctor>) in.readObject();
			misPersonas.addAll(doctores);

			for (Doctor doctor : doctores) {
				// Extraer la parte numérica del código
				String codigo = doctor.getCodigo().substring(2);

				try {
					int codigoNumerico = Integer.parseInt(codigo);
					if (codigoNumerico >= GeneradorCodeDoctor) {
						GeneradorCodeDoctor = codigoNumerico + 1;
					}
				} catch (NumberFormatException e) {
					// Manejar la excepción de formato de número
					System.out.println("Error al convertir el código a entero: " + doctor.getCodigo());
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// El archivo no existe, puedes crearlo aquí si es necesario
			System.out.println("El archivo doctores.dat no existe. Creándolo...");
			guardarSecretarias(); // Agrega este método para crear el archivo secretarias.dat
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void guardarSecretarias() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("secretarias.dat"))) {
			ArrayList<Secretaria> secretarias = new ArrayList<>();
			for (Persona persona : misPersonas) {
				if (persona instanceof Secretaria) {
					secretarias.add((Secretaria) persona);
				}
			}
			out.writeObject(secretarias);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cargarSecretarias() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("secretarias.dat"))) {
			ArrayList<Secretaria> secretarias = (ArrayList<Secretaria>) in.readObject();
			misPersonas.addAll(secretarias);

			for (Secretaria secre : secretarias) {
				// Extraer la parte numérica del código
				String codigo = secre.getCodigo().substring(2);

				try {
					int codigoNumerico = Integer.parseInt(codigo);
					if (codigoNumerico >= GeneradorCodeSecretaria) {
						GeneradorCodeSecretaria = codigoNumerico + 1;
					}
				} catch (NumberFormatException e) {
					// Manejar la excepción de formato de número
					System.out.println("Error al convertir el código a entero: " + secre.getCodigo());
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// El archivo no existe, puedes crearlo aquí si es necesario
			System.out.println("El archivo secretarias.dat no existe. Creándolo...");
			guardarAdministradores(); // Agrega este método para crear el archivo secretarias.dat
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void guardarAdministradores() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("administradores.dat"))) {
			ArrayList<Administrador> administradores = new ArrayList<>();
			for (Persona persona : misPersonas) {
				if (persona instanceof Administrador) {
					administradores.add((Administrador) persona);
				}
			}
			out.writeObject(administradores);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cargarAdministradores() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("administradores.dat"))) {
			ArrayList<Administrador> administradores = (ArrayList<Administrador>) in.readObject();
			misPersonas.addAll(administradores);

			for (Administrador admin : administradores) {
				// Extraer la parte numérica del código
				String codigo = admin.getCodigo().substring(2);

				try {
					int codigoNumerico = Integer.parseInt(codigo);
					if (codigoNumerico >= GeneradorCodeAdmin) {
						GeneradorCodeAdmin = codigoNumerico + 1;
					}
				} catch (NumberFormatException e) {
					// Manejar la excepción de formato de número
					System.out.println("Error al convertir el código a entero: " + admin.getCodigo());
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// El archivo no existe, puedes crearlo aquí si es necesario
			System.out.println("El archivo administradores.dat no existe. Creándolo...");
			guardarAdministradores(); // Agrega este método para crear el archivo secretarias.dat
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void guardarViviendas() {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("viviendas.dat"))) {
			outputStream.writeObject(misViviendas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cargarViviendas() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("viviendas.dat"))) {
			ArrayList<Viviendas> viviendas = (ArrayList<Viviendas>) in.readObject();
			misViviendas.addAll(viviendas);

			for (Viviendas vivienda : viviendas) {
				// Extraer la parte numérica del código
				String codigo = vivienda.getId().substring(2);

				try {
					int codigoNumerico = Integer.parseInt(codigo);
					if (codigoNumerico >= GeneradorCodeVivienda) {
						GeneradorCodeVivienda = codigoNumerico + 1;
					}
				} catch (NumberFormatException e) {
					// Manejar la excepción de formato de número
					System.out.println("Error al convertir el código a entero: " + vivienda.getId());
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// El archivo no existe, puedes crearlo aquí si es necesario
			System.out.println("El archivo viviendas.dat no existe. Creándolo...");
			guardarViviendas(); // Agrega este método para crear el archivo secretarias.dat
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void guardarCitas() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("citas.dat"))) {
			out.writeObject(misCitas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método para cargar las citas desde un archivo
	public void cargarCitas() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("citas.dat"))) {
			ArrayList<Cita> citas = (ArrayList<Cita>) in.readObject();
			misCitas.addAll(citas);

			for (Cita cita : citas) {
				// Extraer la parte numérica del código
				String codigo = cita.getCodigoCita().substring(2);

				try {
					int codigoNumerico = Integer.parseInt(codigo);
					if (codigoNumerico >= GeneradorCodeCita) {
						GeneradorCodeCita = codigoNumerico + 1;
					}
				} catch (NumberFormatException e) {
					// Manejar la excepción de formato de número
					System.out.println("Error al convertir el código a entero: " + cita.getCodigoCita());
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// El archivo no existe, puedes crearlo aquí si es necesario
			System.out.println("El archivo citas.dat no existe. Creándolo...");
			guardarCitas(); // Agrega este método para crear el archivo secretarias.dat
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void guardarHistoriales() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("historiales.dat"))) {
			out.writeObject(misHistoriales);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método para cargar las citas desde un archivo
	public void cargarHistoriales() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("historiales.dat"))) {
			ArrayList<HistorialClinico> historiales = (ArrayList<HistorialClinico>) in.readObject();
			misHistoriales.addAll(historiales);

			for (HistorialClinico historial : historiales) {
				// Extraer la parte numérica del código
				String codigo = historial.getId().substring(2);

				try {
					int codigoNumerico = Integer.parseInt(codigo);
					if (codigoNumerico >= GeneradorCodeHistorial) {
						GeneradorCodeHistorial = codigoNumerico + 1;
					}
				} catch (NumberFormatException e) {
					// Manejar la excepción de formato de número
					System.out.println("Error al convertir el código a entero: " + historial.getId());
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// El archivo no existe, puedes crearlo aquí si es necesario
			System.out.println("El archivo historiales.dat no existe. Creándolo...");
			guardarHistoriales(); // Agrega este método para crear el archivo secretarias.dat
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void guardarEnfermedad() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("enfermedades.dat"))) {
			out.writeObject(misEnfermedades);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método para cargar las citas desde un archivo
	public void cargarEnfermedad() {
	    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("enfermedades.dat"))) {
	        ArrayList<Enfermedad> enfermedades = (ArrayList<Enfermedad>) in.readObject();
	        misEnfermedades.addAll(enfermedades);

	        for (Enfermedad enfermedad : enfermedades) {
	            // Extraer la parte numérica del código
	            String codigo = enfermedad.getCodigoEnfermedad().substring(2);

	            try {
	                int codigoNumerico = Integer.parseInt(codigo);
	                if (codigoNumerico >= GeneradorEnfermedad) {
	                    GeneradorEnfermedad = codigoNumerico + 1;
	                }
	            } catch (NumberFormatException e) {
	                // Manejar la excepción de formato de número
	                System.out.println("Error al convertir el código a entero: " + enfermedad.getCodigoEnfermedad());
	                e.printStackTrace();
	            }
	        }
	    } catch (FileNotFoundException e) {
	        // El archivo no existe, puedes crearlo aquí si es necesario
	        System.out.println("El archivo enfermedades.dat no existe. Creándolo...");
	        guardarEnfermedad();
	    } catch (IOException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}


	public void guardarVacuna() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("vacunas.dat"))) {
			out.writeObject(misVacunas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método para cargar las citas desde un archivo
	public void cargarVacuna() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("vacunas.dat"))) {
			ArrayList<Vacuna> vacunas = (ArrayList<Vacuna>) in.readObject();
			misVacunas.addAll(vacunas);

			for (Vacuna vacuna : vacunas) {
				// Extraer la parte numérica del código
				String codigo = vacuna.getCodigo().substring(2);

				try {
					int codigoNumerico = Integer.parseInt(codigo);
					if (codigoNumerico >= GeneradorVacuna) {
						GeneradorVacuna = codigoNumerico + 1;
					}
				} catch (NumberFormatException e) {
					// Manejar la excepción de formato de número
					System.out.println("Error al convertir el código a entero: " + vacuna.getCodigo());
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// El archivo no existe, puedes crearlo aquí si es necesario
			System.out.println("El archivo vacunas.dat no existe. Creándolo...");
			guardarVacuna(); // Agrega este método para crear el archivo secretarias.dat
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
