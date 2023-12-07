package Logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Consulta implements Serializable {

	private Paciente paciente;
	private String CodigoConsult;
	private Doctor doctor;
	private char atendido; // c = curado ; o = observación
	private ArrayList<Enfermedad> enfermedad;
	private ArrayList<Vacuna> vacuna;
	private HistorialClinico histoClinico;
	private Date fecha;

	public Consulta(Paciente paciente, String codigoConsult, Doctor doctor, char atendido,
			ArrayList<Enfermedad> enfermedad, ArrayList<Vacuna> vacuna, HistorialClinico histoClinico, Date fecha) {
		super();
		this.paciente = paciente;
		CodigoConsult = codigoConsult;
		this.doctor = doctor;
		this.atendido = atendido;
		this.enfermedad = enfermedad;
		this.vacuna = vacuna;
		this.histoClinico = histoClinico;
		this.fecha = fecha;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getCodigoConsult() {
		return CodigoConsult;
	}

	public void setCodigoConsult(String codigoConsult) {
		CodigoConsult = codigoConsult;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public char getAtendido() {
		return atendido;
	}

	public void setAtendido(char atendido) {
		this.atendido = atendido;
	}

	public ArrayList<Enfermedad> getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(ArrayList<Enfermedad> enfermedad) {
		this.enfermedad = enfermedad;
	}

	public ArrayList<Vacuna> getVacuna() {
		return vacuna;
	}

	public void setVacuna(ArrayList<Vacuna> vacuna) {
		this.vacuna = vacuna;
	}

	public HistorialClinico getHistoClinico() {
		return histoClinico;
	}

	public void setHistoClinico(HistorialClinico histoClinico) {
		this.histoClinico = histoClinico;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}