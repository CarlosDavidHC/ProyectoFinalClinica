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
	public static int GeneradorCodePersona = 1;
	public static int GeneradorEnfermedad = 1;
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
	    cargarViviendas();
	    cargarCitas();
	    cargarHistoriales();
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
	    GeneradorCodePersona++;
	    guardarPacientes();
	}
	
	public void insertarEnfermedad(Enfermedad Enfer) {
		misEnfermedades.add(Enfer);
		GeneradorEnfermedad++;
	}

	public void insertarCita(Cita cita) {
		misCitas.add(cita);
		GeneradorCodeCita++;
	}
	
	public void insertarvacuna(Vacuna vacun) {
		misVacunas.add(vacun);
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
		Enfermedad enfer= null;
		int count =0;
		boolean encontrado = false;
		
		while(count < misEnfermedades.size() && !encontrado) {
			if(misEnfermedades.get(count).getNombre().equalsIgnoreCase(nombre)) {
				enfer= misEnfermedades.get(count);
				encontrado= true;
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
	}

	public void insertarVivienda(Viviendas vivi) {
		misViviendas.add(vivi);
		GeneradorCodeHistorial++;
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
		if(doc!=null) {
			return doc;
		}else {
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
		if(secre!= null) {
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
		if(admin!= null) {
		return admin;
		} else {
			return null;
		}
	}
	
	
    // Método para guardar pacientes en un archivo
    public void guardarPacientes() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pacientes.dat"))) {
            out.writeObject(misPersonas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar pacientes desde un archivo
    @SuppressWarnings("unchecked")
    public void cargarPacientes() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("pacientes.dat"))) {
            misPersonas = (ArrayList<Persona>) in.readObject();
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
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("viviendas.dat"))) {
            misViviendas = (ArrayList<Viviendas>) inputStream.readObject();
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
    @SuppressWarnings("unchecked")
    public void cargarCitas() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("citas.dat"))) {
        	misCitas = (ArrayList<Cita>) inputStream.readObject();
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
    @SuppressWarnings("unchecked")
    public void cargarHistoriales() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("historiales.dat"))) {
        	misHistoriales = (ArrayList<HistorialClinico>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
}

