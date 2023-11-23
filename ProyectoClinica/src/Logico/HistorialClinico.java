package Logico;

import java.util.ArrayList;

public class HistorialClinico {

	private String id;
	private ArrayList<Persona> laPersona;
	private String condicion;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Persona> getLaPersona() {
		return laPersona;
	}

	public void setLaPersona(ArrayList<Persona> laPersona) {
		this.laPersona = laPersona;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

}
