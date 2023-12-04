package Logico;

import java.util.ArrayList;

public class Viviendas {

	private String id;
	private String direccion;
	private ArrayList<Persona> personaHospedada;

	public Viviendas(String id, String direccion, ArrayList<Persona> personaHospedada) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.personaHospedada = personaHospedada;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Persona> getPersonaHospedada() {
		return personaHospedada;
	}

	public void setPersonaHospedada(ArrayList<Persona> personaHospedada) {
		this.personaHospedada = personaHospedada;
	}

	public String toString() {
		return getDireccion();
	}

}