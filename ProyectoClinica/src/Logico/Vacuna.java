package Logico;

import java.util.ArrayList;

public class Vacuna {

	private String nombre;
	private String codigo;
	private ArrayList<Enfermedad> enfermedad;
	public Vacuna(String nombre, String codigo, ArrayList<Enfermedad> enfermedad) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.enfermedad = enfermedad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public ArrayList<Enfermedad> getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(ArrayList<Enfermedad> enfermedad) {
		this.enfermedad = enfermedad;
	}

	
}
