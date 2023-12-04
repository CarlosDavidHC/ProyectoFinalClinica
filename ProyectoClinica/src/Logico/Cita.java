package Logico;

import java.time.LocalDate;


public class Cita {

	private String codigoCita;
	private LocalDate fechaCita;
	private Persona persona;
	private Doctor doctor;
	private char estado; // a = atendido ; p = pendiente.

	public Cita(String codigoCita, LocalDate fechaCita, Persona persona, Doctor doctor, char estado) {
		super();
		this.codigoCita = codigoCita;
		this.fechaCita = fechaCita;
		this.persona = persona;
		this.doctor = doctor;
		this.estado = estado;
	}

	public String getCodigoCita() {
		return codigoCita;
	}

	public void setCodigoCita(String codigoCita) {
		this.codigoCita = codigoCita;
	}

	public LocalDate getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDate fechaCita) {
		this.fechaCita = fechaCita;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

}
