package Logico;

import java.util.Date;

public class Cita {

	private String codigoCita;
	private Date fechaCita;
	private Persona persona;
	private Doctor doctor;
	private char estado;
	
	public Cita(String codigoCita, Date fechaCita, Persona persona, Doctor doctor, char estado) {
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
	public Date getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(Date fechaCita) {
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
