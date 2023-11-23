package Logico;

public class Doctor extends Persona {

	private String area;
	private String especialidad;

	public Doctor(String nombre, String cedula, String telefono, String direccion, String area, String especialidad) {
		super(nombre, cedula, telefono, direccion);

		this.area = area;
		this.especialidad = especialidad;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}
