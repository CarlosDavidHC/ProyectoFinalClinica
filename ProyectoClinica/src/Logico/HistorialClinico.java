package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class HistorialClinico implements Serializable {

	private String id;
	private Paciente miPaciente;
	private ArrayList<Cita> misCitas;
	private ArrayList<Consulta> misConsultas;
	private ArrayList<Enfermedad> misEnfermedades;
	private ArrayList<Vacuna> misVacunas;

	public HistorialClinico(String id, Paciente miPaciente, ArrayList<Cita> misCitas, ArrayList<Consulta> misConsultas,
			ArrayList<Enfermedad> misEnfermedades, ArrayList<Vacuna> misVacunas) {
		super();
		this.id = id;
		this.miPaciente = miPaciente;
		this.misCitas = misCitas;
		this.misConsultas = misConsultas;
		this.misEnfermedades = misEnfermedades;
		this.misVacunas = misVacunas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Paciente getMiPaciente() {
		return miPaciente;
	}

	public void setMiPaciente(Paciente miPaciente) {
		this.miPaciente = miPaciente;
	}

	public ArrayList<Cita> getMisCitas() {
		return misCitas;
	}

	public void setMisCitas(ArrayList<Cita> misCitas) {
		this.misCitas = misCitas;
	}

	public ArrayList<Consulta> getMisConsultas() {
		return misConsultas;
	}

	public void setMisConsultas(ArrayList<Consulta> misConsultas) {
		this.misConsultas = misConsultas;
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
