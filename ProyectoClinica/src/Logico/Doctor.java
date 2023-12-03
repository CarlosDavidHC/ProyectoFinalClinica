package Logico;

public class Doctor extends Persona {

	private String especialidad;

	public Doctor(String nombre, String codigo, String telefono, String direccion, char tipo, char sexo,
			String especialidad) {
		super(nombre, codigo, telefono, direccion, tipo, sexo);
		this.especialidad = especialidad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}
