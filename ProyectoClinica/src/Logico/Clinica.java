package Logico;

import java.util.ArrayList;





public class Clinica {

	private ArrayList<Viviendas> misViviendas;
	private ArrayList<Persona> misPersonas;
	private ArrayList<Cita> misCitas;
	private ArrayList<Enfermedad> misEnfermedades;
	private ArrayList<Vacuna> misVacunas;
	private static Clinica clini = null;
	public static int GeneradorCodeCita = 1;
	public static int GeneradorCodePersona = 1;
	
	public static Clinica getInstance() {
		if(clini == null)
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
	
	public void insertarPersona(Persona persona) {
        misPersonas.add(persona);
        GeneradorCodePersona++;
    }
	
	public void insertarCita(Cita cita) {
        misCitas.add(cita);
        GeneradorCodeCita++;
    }
	
	public Persona buscarPacienteByCedula(String cedPaciente) {
	    Persona aux = null;
	    int ind = 0;
	    boolean encontrado = false;

	    while (ind < misPersonas.size() && !encontrado) {
	        if (misPersonas.get(ind).getCedula().equalsIgnoreCase(cedPaciente) && misPersonas.get(ind).getTipo() == 'p') {
	            aux = misPersonas.get(ind);
	            encontrado = true;
	        }
	        ind++;
	    }
	    return aux;
	}

	
	
}
