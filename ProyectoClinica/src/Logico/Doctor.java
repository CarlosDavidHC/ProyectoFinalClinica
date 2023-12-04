package Logico;

public class Doctor extends Persona {

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

}
