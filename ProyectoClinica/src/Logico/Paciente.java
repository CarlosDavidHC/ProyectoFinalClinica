package Logico;

public class Paciente extends Persona {

	private String enfermedad;
	private String tratamiento;
	private String habitacion;

	
	public Paciente(String nombre, String codigo, String telefono, String direccion, char tipo, char sexo,
			String enfermedad, String tratamiento, String habitacion) {
		super(nombre, codigo, telefono, direccion, tipo, sexo);
		this.enfermedad = enfermedad;
		this.tratamiento = tratamiento;
		this.habitacion = habitacion;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public String getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}
}
