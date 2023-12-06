package Logico;

import java.io.Serializable;

public class Doctor extends Persona implements Serializable {

	private String especialidad;

	public Doctor(String codigo, String cedula, String nombre, String telefono, String direccion, char tipo, char sexo,
			String especialidad) {
		super(codigo, cedula, nombre, telefono, direccion, tipo, sexo);
		this.especialidad = especialidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public String toString() {
	    return nombre;
	}

}
