package Logico;

import java.util.ArrayList;

public class Viviendas {

	private String id;
	private String piso;
	private String numHabitacion;
	private ArrayList<Persona> personaHospedada;

	public Viviendas(String id, String piso, String numHabitacion, ArrayList<Persona> personaHospedada) {
		super();
		this.id = id;
		this.piso = piso;
		this.numHabitacion = numHabitacion;
		this.personaHospedada = personaHospedada;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(String numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public ArrayList<Persona> getPersonaHospedada() {
		return personaHospedada;
	}

	public void setPersonaHospedada(ArrayList<Persona> personaHospedada) {
		this.personaHospedada = personaHospedada;
	}

}
