package Logico;

import java.util.ArrayList;

public class Clinica {

	private ArrayList<Viviendas> misViviendas;
	private ArrayList<Persona> misPersonas;
	private ArrayList<Cita> misCitas;
	private ArrayList<Enfermedad> misEnfermedades;
	private ArrayList<Vacuna> misVacunas;

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

	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}

	public void setMisPersonas(ArrayList<Persona> misPersonas) {
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

}
